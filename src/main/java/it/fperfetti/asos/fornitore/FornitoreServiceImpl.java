/*
 * JBoss, Home of Professional Open Source
 * Copyright 2012, Red Hat, Inc. and/or its affiliates, and individual
 * contributors by the @authors tag. See the copyright.txt in the 
 * distribution for a full listing of individual contributors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,  
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package it.fperfetti.asos.fornitore;

import it.fperfetti.asos.fornitore.model.*;
import it.fperfetti.asos.fornitore.util.HibernateUtil;
import it.fperfetti.asos.fornitore.util.ReservationCleaner;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

import javax.jws.WebService;

import org.hibernate.*;

/**
 * The implementation of the Fornitore JAX-WS Web Service.
 *
 * Root User: adminWDrgCKU
 * Root Password: PaQp6Auj2kwa
 * Database Name: fornitore
 * 
 */

@WebService(serviceName = "FornitoreService", portName = "Fornitore", name = "Fornitore", endpointInterface = "it.fperfetti.asos.fornitore.FornitoreService", targetNamespace = "http://fornitore-fabioperfetti.rhcloud.com/jboss-as-helloworld-ws/FornitoreService")
public class FornitoreServiceImpl implements FornitoreService {

	private final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
	final ScheduledFuture<?> cleanerHandle;
	
	public FornitoreServiceImpl(){
		ReservationCleaner cleaner = ReservationCleaner.getInstance();
		cleanerHandle = scheduler.scheduleAtFixedRate(cleaner, 10, 5*60, TimeUnit.SECONDS);		
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Event> getEvents(){
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		List<Event> events = new ArrayList<Event>();
		try {
			tx = session.beginTransaction();		
			events =  session.createQuery("from Event as event").list();
			tx.commit();
		}
		catch (Exception e) {
			if (tx != null) tx.rollback();
			e.printStackTrace();
		}
		finally {
			session.close();
		}
		return events;
	}

	@Override
	public Event getEvent(Long idEvent) {		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		Event event = new Event();
		try {
			tx = session.beginTransaction();		
			event = (Event) session.get(Event.class, idEvent);
			tx.commit();
		}
		catch (Exception e) {
			if (tx != null) tx.rollback();
			e.printStackTrace();
		}
		finally {
			session.close();
		}
		return event;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Category> getCategories() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		List<Category> categories = new ArrayList<Category>();
		try {
			tx = session.beginTransaction();		
			categories =  session.createQuery(
					"from Category as cat").list();
			tx.commit();
		}
		catch (Exception e) {
			if (tx != null) tx.rollback();
			e.printStackTrace();
		}
		finally {
			session.close();
		}
		return categories;		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Event> getEventsByCategory(Long idCat) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		Category cat = (Category) session.get(Category.class, idCat);
		List<Event> events = new ArrayList<Event>();
		try {
			tx = session.beginTransaction();		
			events =  session.createQuery(
					"from Event as event where event.category = ?")
					.setEntity(0, cat)
					.list();
			tx.commit();
		}
		catch (Exception e) {
			if (tx != null) tx.rollback();
			e.printStackTrace();
		}
		finally {
			session.close();
		}
		return events;
	}
	
	@Override
	public Long prebook(Event[] events, int[] quantities, String vendor){
		Long preOrderId = new Long(-1);
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			Order order = new Order();
			order.setTotal(calculateAmount(events, quantities));
			order.setVendor(vendor);
			order.setConfirmated(false);
			order.setDate(new Date());

			int i = 0;
			for(Event e: events){	
				session.update(e);
				e.setAvailability(e.getAvailability()-quantities[i]);
				Detail det = new Detail();
				det.setEvent(e);
				det.setQuantity(quantities[i]);
				det.setOrder(order);
				session.persist(det);
				order.addDetail(det);
				i++;
			}
			session.persist(order);
			tx.commit();
			preOrderId = order.getId();
		}
		catch (Exception e) {
			if (tx != null) tx.rollback();
			e.printStackTrace();
		}
		finally {
			session.close();
		}
		return preOrderId;
	}

	@Override
	public Boolean book(Long idOrder) {		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		Boolean ret = false;
		try {
			tx = session.beginTransaction();
			Order order = (Order) session.get(Order.class, idOrder);
			if(order==null){
				new Exception("Order not valid");
			} 
			else if(order.getConfimated()){
				new Exception("Order already confirmated");
			}
			else if (!order.isValidOrder()){
				/* Sessione scaduta, le quantità verranno ripristinate dal processo batch al più breve */
				new Exception("Session Expired");
			}
			else {
				order.setConfirmated(true);
				session.save(order);
				tx.commit();
				ret = true;
			}
		}
		catch (Exception e) {
			if (tx != null) tx.rollback();
			e.printStackTrace();
		}
		finally {
			session.close();
		}
		return ret;
	}	
	
	private Double calculateAmount(Event[] events, int[] quantities){
		Double tot = 0.0;
		int i = 0;
		for(Event e : events){
			tot += e.getPrice()*quantities[i]; 
			i++;
		}
		return tot;
	}
}

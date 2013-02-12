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
package org.jboss.as.quickstarts.wshelloworld;

import java.util.List;
import javax.jws.WebService;

import org.hibernate.*;
import org.jboss.as.quickstarts.wshelloworld.model.*;
import org.jboss.as.quickstarts.wshelloworld.util.HibernateUtil;

/**
 * The implementation of the Fornitore JAX-WS Web Service.
 *
 * Root User: adminWDrgCKU
 * Root Password: PaQp6Auj2kwa
 * Database Name: fornitore@WebService(serviceName = "FornitoreService", portName = "Fornitore", name = "Fornitore", endpointInterface = "org.jboss.as.quickstarts.wshelloworld.FornitoreService", targetNamespace = "http://fornitore-fabioperfetti.rhcloud.com/jboss-as-helloworld-ws/FornitoreService")
 */
@WebService(serviceName = "FornitoreService", portName = "Fornitore", name = "Fornitore", endpointInterface = "org.jboss.as.quickstarts.wshelloworld.FornitoreService", targetNamespace = "http://fornitore-fabioperfetti.rhcloud.com/jboss-as-helloworld-ws/FornitoreService")
public class FornitoreServiceImpl implements FornitoreService {
	
	@Override
	public List<Event> getEvents(){
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        @SuppressWarnings("unchecked")
		List<Event> events =  session.createQuery(
        	    "from Event as event").list();
        session.getTransaction().commit();
        return events;
	}
	
	@Override
	public Event getEvent(Integer idEvent) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		Event event = (Event) session.load(Event.class, idEvent);
		session.getTransaction().commit();
		return event;
	}

	@Override
	public List<Category> getCategories() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
        @SuppressWarnings("unchecked")
		List<Category> categories =  session.createQuery(
        	    "from Category as cat").list();
        session.getTransaction().commit();
        return categories;
	}
	
	@Override
	public List<Event> getEventsByCategory(Integer idCat) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		Category cat = (Category) session.load(Category.class, idCat);
		
        @SuppressWarnings("unchecked")
		List<Event> events =  session.createQuery(
        	    "from Event as event where event.category = ?")
        	    .setEntity(0, cat)
        	    .list();
        session.getTransaction().commit();		
        return events;
	}

	@Override
	public Boolean buy(Order order) {		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		Boolean ret = false;
		try {
		    tx = session.beginTransaction();
		    
		    for(Event e: order.getEvents()){
		    	e.setAvailability(e.getAvailability()-1);
		    }
		    session.save(order);
			session.getTransaction().commit();
		    tx.commit();
		    ret = true;
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
}

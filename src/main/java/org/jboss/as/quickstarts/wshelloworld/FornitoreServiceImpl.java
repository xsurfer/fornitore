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

import java.util.ArrayList;
import java.util.List;

import javax.jws.WebService;

import org.hibernate.*;
import org.jboss.as.quickstarts.wshelloworld.model.*;
import org.jboss.as.quickstarts.wshelloworld.util.HibernateUtil;

/**
 * The implementation of the HelloWorld JAX-WS Web Service.
 * 
 * @author lnewson@redhat.com
 */

//fornitore-fabioperfetti.rhcloud.com
@WebService(serviceName = "FornitoreService", portName = "Fornitore", name = "Fornitore", endpointInterface = "org.jboss.as.quickstarts.wshelloworld.FornitoreService", targetNamespace = "http://fornitore-fabioperfetti.rhcloud.com/jboss-as-helloworld-ws/FornitoreService")
public class FornitoreServiceImpl implements FornitoreService {

	//private ArrayList<Event> events = new ArrayList<Event>();
	//private ArrayList<Category> categories = new ArrayList<Category>();
		
	@Override
	public List<Event> getEvents(){
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        @SuppressWarnings("unchecked")
		List<Event> events =  session.createQuery(
        	    "from Event as event").list();
        System.out.println("A:");
        for(Event e : events ){
			System.out.println("Che palle: " + e.getTitle() );
		}
        
        System.out.println("B:");
        session.getTransaction().commit();
        for(Event e : events ){
			System.out.println("Che palle: " + e.getTitle() );
		}
        
        System.out.println("C:");
        session.close();
        for(Event e : events ){
			System.out.println("Che palle: " + e.getTitle() );
		}
        return events;
/*		session.beginTransaction();
		
		Category music = new Category("music", "Concerti");
		
		session.save( music );		
		session.save( new Event("Max G in concert", "Max Gazze", "Bella", "Roma", music, 50, 22.0) );
		session.save( new Event("Muse in concert", "Muse", "Bella", "Roma", music, 50, 30.0) );
	
		session.getTransaction().commit();


		for(Object e : session.createCriteria(Event.class).list() ){
			Event ev = (Event) e;
			System.out.println("Che palle: " + ev.getTitle() );
		}
		session.close();
*/
		
	}
	
	@Override
	public Event getEvent(Integer idEvent) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		Event event = (Event) session.load(Event.class, idEvent);
		session.getTransaction().commit();
		session.close();
		return event;
	}

	@Override
	public List<Category> getCategories() {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
        @SuppressWarnings("unchecked")
		List<Category> categories =  session.createQuery(
        	    "from Category as cat").list();
        session.getTransaction().commit();
        session.close();
        return categories;
	}

	@Override
	public List<Event> getEventsByCategory(Integer idCat) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		Category cat = (Category) session.load(Category.class, idCat);
		
        @SuppressWarnings("unchecked")
		List<Event> events =  session.createQuery(
        	    "from Event as event where event.category = ?")
        	    .setEntity(0, cat)
        	    .list();
        session.getTransaction().commit();
        session.close();
		
        return events;
	}
}

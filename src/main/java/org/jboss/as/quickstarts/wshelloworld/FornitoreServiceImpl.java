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

	private ArrayList<Event> events = new ArrayList<Event>();
	private ArrayList<Category> categories = new ArrayList<Category>();
	
	
	{
		Category music = new Category("music", "Concerti");
		Category soccer = new Category("soccer", "Calcio");
		Category museum = new Category("museum", "Musei");
		
		categories.add(music);
		categories.add(soccer);
		categories.add(museum);
		
		events.add(new Event(events.size(), "Max G in concert", "Max Gazze", "Bella", "Roma", music, 50, 22.0));
		events.add(new Event(events.size(), "Muse in concert", "Muse", "Bella", "Roma", music, 50, 30.0));
		events.add(new Event(events.size(), "Gianna Nannona", "Gianna Nannini", "Bella", "Roma", music, 50, 15.0));
		events.add(new Event(events.size(), "Mimma", "Mina", "Bella", "Roma", music, 50, 20.0));
		events.add(new Event(events.size(), "Juve-Roma", "Juventus Stadium", "Sfida", "Torino", soccer, 50, 33.0));
		events.add(new Event(events.size(), "Milan-Lecce", "San Siro", "Sfida", "Milano", soccer, 50, 20.0));
	}
		
	@Override
	public ArrayList<Event> getEvents(){
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();

		session.beginTransaction();
		session.save( new Event(events.size(), "Max G in concert", "Max Gazze", "Bella", "Roma", 50, 22.0) );
		session.save( new Event(events.size(), "Max Ga in concert", "Max Gazze", "Bella", "Roma", 50, 22.0) );
		//session.save( new Event( "A follow up event", new Date() ) );
		session.getTransaction().commit();
		
		for(Object e : session.createCriteria(Event.class).list() ){
			Event ev = (Event) e;
			System.out.println("Che palle: " + ev.getTitle() );
		}
		session.close();

		return events;
	}
	
	@Override
	public Event getEvent(Integer idEvent) {
		return events.get(idEvent);
	}

	@Override
	public ArrayList<Category> getCategories() {
		return categories;
	}

	@Override
	public ArrayList<Event> getEventsByCategory(String name) {
		ArrayList<Event> ret = new ArrayList<Event>();
		for(Event e : events){
			if(e.getCategory().getName().equals(name)){
				ret.add(e);
			}
		}
		return ret;
	}
}

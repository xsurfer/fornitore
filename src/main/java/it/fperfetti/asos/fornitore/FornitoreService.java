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

import it.fperfetti.asos.fornitore.model.Category;
import it.fperfetti.asos.fornitore.model.Event;
import it.fperfetti.asos.fornitore.model.Order;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebService;


/**
 * A simple example of how to setup a JAX-WS Web Service. It can say hello to everyone or to someone in particular.
 * 
 * @author lnewson@redhat.com
 */

@WebService(targetNamespace = "http://fornitore-fabioperfetti.rhcloud.com/jboss-as-helloworld-ws/FornitoreService")
public interface FornitoreService {

	@WebMethod
    public List<Category> getCategories();
	
	@WebMethod
    public Event getEvent(Long idEvent);
	
	@WebMethod
    public List<Event> getEvents();
	
	@WebMethod
    public List<Event> getEventsByCategory(Long idCat);
	
	@WebMethod
	public Long prebook(Event[] events, int[] quantities, String vendor);	
	
	@WebMethod
	public Boolean book(Long idOrder);	
}

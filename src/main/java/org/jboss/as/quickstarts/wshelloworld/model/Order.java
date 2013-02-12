package org.jboss.as.quickstarts.wshelloworld.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "ORDERS")
public class Order {

	@Id @GeneratedValue
	private Long id;
	public Long getId() { return id; }
	public void setId(Long id) { this.id = id; }

	@OneToMany
	public List<Event> getEvents() { return events; }
	public void addEvent(Event event) { events.add(event); }
	private List<Event> events = new ArrayList<Event>();

	@Temporal(TemporalType.DATE) @NotNull @Column(updatable=false)
	public Date getDate() { return date; }
	public void setDate(Date date) { this.date = date; }
	private Date date;
}

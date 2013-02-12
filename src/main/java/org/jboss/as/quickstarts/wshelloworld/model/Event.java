package org.jboss.as.quickstarts.wshelloworld.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;


@Entity
@Table(name = "EVENTS")
public class Event {
	
	@Id @GeneratedValue(generator="increment")
	private Long id;
	public Long getId() { return id; }
	public void setId(Long id) { this.id = id; }
	
	@Column(name = "TITLE")
	private String title;
	
	@Column(name = "AUTHOR")
	private String authore;
	
	@Column(name = "DESCRIPTION")
	private String description;
	
	@Column(name = "LOCATION")
	private String location;
	
	@ManyToOne
	private Category category;
	
	@Column(name = "AVAILABILITY")
	private Integer availability;
	
	@Column(name = "PRICE")
	private Double price;
	
	public Event() {
	}
	
	public Event(String title, String authore, String description,
			String location, Category category, Integer availability, Double price) {
		super();
		this.title = title;
		this.authore = authore;
		this.description = description;
		this.location = location;
		this.category = category;
		this.availability = availability;
		this.price = price;
	}
		
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthore() {
		return authore;
	}
	public void setAuthore(String authore) {
		this.authore = authore;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public Integer getAvailability() {
		return availability;
	}

	public void setAvailability(Integer availability) {
		this.availability = availability;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}
	

}

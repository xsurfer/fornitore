package it.fperfetti.asos.fornitore.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "EVENTS")
public class Event {
	
	@Id @GeneratedValue
	private Long id;
	public Long getId() { return id; }
	public void setId(Long id) { this.id = id; }
	
	@Column(name = "TITLE")
	private String title;
	public String getTitle() { return title; }
	public void setTitle(String title) { this.title = title; }

	@Column(name = "AUTHOR")
	private String author;
	public String getAuthor() { return author; }
	public void setAuthor(String author) { this.author = author; }
	
	@Column(name = "DESCRIPTION")
	private String description;
	public String getDescription() { return description; }
	public void setDescription(String description) { this.description = description; }
	
	@Column(name = "LOCATION")
	private String location;
	public String getLocation() { return location; }
	public void setLocation(String location) { this.location = location; }

	@ManyToOne
	private Category category;
	public Category getCategory() { return category; }
	public void setCategory(Category category) { this.category = category; }

	@Column(name = "AVAILABILITY")
	private Integer availability;
	public Integer getAvailability() { return availability; }
	public void setAvailability(Integer availability) throws Exception { 
		if(availability>=0) 
			this.availability = availability;
		else 
			throw new Exception("Not enough tickets");
	}

	@Column(name = "PRICE")
	private Double price;
	public Double getPrice() { return price; }
	public void setPrice(Double price) { this.price = price; }
	
	public Event() { }
	
	public Event(String title, String authore, String description,
			String location, Category category, Integer availability, Double price) {
		super();
		this.title = title;
		this.author = authore;
		this.description = description;
		this.location = location;
		this.category = category;
		this.availability = availability;
		this.price = price;
	}

}

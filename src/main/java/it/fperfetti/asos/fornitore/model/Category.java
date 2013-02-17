package it.fperfetti.asos.fornitore.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Proxy;

@Entity
@Table(name = "CATEGORY")
@Proxy(lazy=false)
public class Category {

	@Id @GeneratedValue
	private Long id;
	public Long getId(){ return id; }
	public void setId(Long _id){ id=_id; }
	
	@Column(name = "NAME")
	private String name;
	public String getName() { return name; }
	public void setName(String name) { this.name = name; }
	
	@Column(name = "DESCRIPTION")
	private String description;
	public String getDescription() { return description; }
	public void setDescription(String description) { this.description = description; }
	
	public Category() {}
	
	public Category(String name, String description) {
		super();
		this.setName(name);
		this.setDescription(description);
	}
}

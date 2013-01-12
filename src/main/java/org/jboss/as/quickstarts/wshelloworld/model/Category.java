package org.jboss.as.quickstarts.wshelloworld.model;

public class Category {

	private String name;
	private String description;

	public Category() {
	}

	
	public Category(String name, String description) {
		super();
		this.setName(name);
		this.setDescription(description);
	}
	
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}

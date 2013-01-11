package org.jboss.as.quickstarts.wshelloworld;

public class Event {
	
	private String title;
	private String authore;
	private String description;
	private String location;
	
	public Event() {
	}
	
	public Event(String title, String authore, String description,
			String location) {
		super();
		this.title = title;
		this.authore = authore;
		this.description = description;
		this.location = location;
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
	

}

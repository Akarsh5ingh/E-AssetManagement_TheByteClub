package com.codefury.easset.models;

import java.time.LocalDateTime;


public class Assest extends Entity{
	private String category;
	private String description;
	private LocalDateTime dateAdded;
	private boolean isAvailable;
	
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public Assest() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Assest(long userId, String userName) {
		super(userId, userName);
		// TODO Auto-generated constructor stub
	}
	public Assest(long userId, String userName, String category, String description, LocalDateTime dateAdded,
			boolean isAvailable) {
		super(userId, userName);
		this.category = category;
		this.description = description;
		this.dateAdded = dateAdded;
		this.isAvailable = isAvailable;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public LocalDateTime getDateAdded() {
		return dateAdded;
	}
	public void setDateAdded(LocalDateTime dateAdded) {
		this.dateAdded = dateAdded;
	}
	public boolean isAvailable() {
		return isAvailable;
	}
	public void setAvailable(boolean isAvailable) {
		this.isAvailable = isAvailable;
	}
	
	
	

}

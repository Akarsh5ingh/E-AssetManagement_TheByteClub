package com.codefury.easset.models;

public class Entity {
	private long userId;
	private String userName;
	public Entity(long userId, String userName) {
		super();
		this.userId = userId;
		this.userName = userName;
	}
	public Entity() {
		super();
		// TODO Auto-generated constructor stub
	}
	public long getUserId() {
		return userId;
	}
	public void setUserId(long userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	} 
	

}

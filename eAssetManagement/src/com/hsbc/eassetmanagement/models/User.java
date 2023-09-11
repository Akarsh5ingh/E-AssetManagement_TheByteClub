package com.hsbc.eassetmanagement.models;

public class User {
//	private long uniqueId;
	private String name;
	private String telephone;
	private String email;
	private String userId;
	private String password;
	
	public User( String name, String telephone, String email, String userId, String password) {
		super();
		this.name = name;
		this.telephone = telephone;
		this.email = email;
		this.userId = userId;
		this.password = password;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public String getUserId() {
		return userId;
	}
	
	
}

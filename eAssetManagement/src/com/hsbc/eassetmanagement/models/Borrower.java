package com.hsbc.eassetmanagement.models;

public class Borrower extends User{
	private boolean isBanned;
	
	public Borrower(long uniqueId, String name, String telephone, String email, String userId, String password, boolean isBanned) {
		super(uniqueId, name, telephone, email, userId, password);
		this.isBanned=false;
	}

}

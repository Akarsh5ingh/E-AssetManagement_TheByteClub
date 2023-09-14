package com.codefury.eassetmanagement.models;

public class Borrower extends User{
	private boolean isBanned;

	public Borrower(String name, String telephone, String email, String userId, String password) {
		super(name, telephone, email, userId, password);
		this.isBanned=false;
	}

}

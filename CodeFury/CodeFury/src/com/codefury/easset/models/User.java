package com.codefury.easset.models;

import java.util.List;

public class User extends Entity{
	
	private Role role;
	private long telephone;
	private String eMail;
	private String password;
	//private List<String> loginCreds;
	
	public Role getRole() {
		return role;
	}
	public User(long userId, String userName, Role role, long telephone, String eMail, String password) {
		super(userId, userName);
		this.role = role;
		this.telephone = telephone;
		this.eMail = eMail;
		this.password = password;
	}
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public User(long userId, String userName) {
		super(userId, userName);
		// TODO Auto-generated constructor stub
	}
	public void setRole(Role role) {
		this.role = role;
	}
	public long getTelephone() {
		return telephone;
	}
	public void setTelephone(long telephone) {
		this.telephone = telephone;
	}
	public String geteMail() {
		return eMail;
	}
	public void seteMail(String eMail) {
		this.eMail = eMail;
	}
	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	

}

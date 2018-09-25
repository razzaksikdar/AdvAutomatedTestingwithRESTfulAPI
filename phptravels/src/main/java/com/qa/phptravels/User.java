package com.qa.phptravels;

public class User {
	
	private String email;
	private String password;
	private String name;
 
	public User(String email, String password, String name) {
		this.email   = email;
		this.password = password;
		this.name     = name;
		
	}
 
	public String email() {
		return email;
	}
 
	public String password() {
		return password;
	}
 
	public String name() {
		return name;
	}
 
}

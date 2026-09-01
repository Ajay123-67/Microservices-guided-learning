package com.example.demo.model;

public class User {
	
	private int id;
	private String name;
	private String email;
	
	public User() {
		
	}
	
	public User(int id,String Name,String Email) {
		this.id=id;
		this.name=Name;
		this.email=Email;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		email = email;
	}
	

}

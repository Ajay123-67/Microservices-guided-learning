package com.example.demo.dto;

public class UserResponse {
	
	private int id;
	private String name;
	private String email;
	
	public UserResponse() {
		
	}

	public UserResponse(int id, String name, String email) {
		super();
		this.id = id;
		name = name;
		email = email;
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

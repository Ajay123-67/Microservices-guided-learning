package com.example.demo.dto;

public class UserResponse {
	private int id;
	private String Name;
	private String Email;
	
	public UserResponse() {
		
	}
	
	public UserResponse(int id,String Name,String Email) {
		this.id=id;
		this.Name=Name;
		this.Email=Email;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}
	
	

}

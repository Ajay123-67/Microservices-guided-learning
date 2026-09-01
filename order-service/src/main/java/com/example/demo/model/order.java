package com.example.demo.model;

public class order {
	
	private int  id;
	private int userId;
	private String ProductName;
	private int quality;
	private double price;
	
	public order() {
		
	}
	public order(int id, int userId, String productName, int quality, double price) {
		super();
		this.id = id;
		this.userId = userId;
		ProductName = productName;
		this.quality = quality;
		this.price = price;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getProductName() {
		return ProductName;
	}
	public void setProductName(String productName) {
		ProductName = productName;
	}
	public int getQuality() {
		return quality;
	}
	public void setQuality(int quality) {
		this.quality = quality;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	
	
	
	
	

}

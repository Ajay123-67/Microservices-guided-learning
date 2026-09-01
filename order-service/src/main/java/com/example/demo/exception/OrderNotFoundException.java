package com.example.demo.exception;

public class OrderNotFoundException extends RuntimeException {
	public OrderNotFoundException(String Message) {
		super(Message);
		
	}

}

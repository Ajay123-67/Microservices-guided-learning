package com.example.demo.exception;

public class PaymentServiceUnavailableException  extends RuntimeException{
	public PaymentServiceUnavailableException(String message) {
        super(message);
    }

}

package com.example.demo.dto;

public class CreateOrderResponse {

    private int orderId;
    private String status;

    public CreateOrderResponse(int orderId, String status) {
        this.orderId = orderId;
        this.status = status;
    }

    public int getOrderId() {
        return orderId;
    }

    public String getStatus() {
        return status;
    }
}

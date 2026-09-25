package com.example.demo.dto;

import jakarta.validation.constraints.Positive;

public class OrderItemRequest {

    @Positive(message = "productId must be greater than 0")
    private int productId;

    @Positive(message = "quantity must be greater than 0")
    private int quantity;

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
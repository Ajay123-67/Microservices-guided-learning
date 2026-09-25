package com.example.demo.service;

import com.example.demo.dto.CreateOrderRequest;
import com.example.demo.dto.CreateOrderResponse;
import com.example.demo.dto.OrderResponse;

public interface OrderService {
	
	OrderResponse getOrderById(int id);
	CreateOrderResponse createOrder(CreateOrderRequest request);

}

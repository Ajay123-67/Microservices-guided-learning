package com.example.demo.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.OrderResponse;
import com.example.demo.service.OrderService;

@RestController
@RequestMapping("/order")
public class OrderController {
	
	private final OrderService orderService;
	public OrderController(OrderService orderService) {
		this.orderService=orderService;
	}
	
	@GetMapping("/{id}")
	
	public ResponseEntity<OrderResponse> getOrderById(@PathVariable int id){
		OrderResponse order=orderService.getOrderById(id);
		return ResponseEntity.ok(order);
		
	}
	

}

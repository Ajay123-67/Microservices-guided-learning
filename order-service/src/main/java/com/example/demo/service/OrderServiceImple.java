package com.example.demo.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.example.demo.client.UserClient;
import com.example.demo.dto.OrderResponse;
import com.example.demo.dto.UserResponse;
import com.example.demo.exception.OrderNotFoundException;
import com.example.demo.model.order;

@Service
public class OrderServiceImple implements OrderService {
	
	private final UserClient userClient;
	
	private final Map<Integer,order> orders=new HashMap<>();
	public OrderServiceImple(UserClient userClient) {
		this.userClient=userClient;
		
		orders.put(101, new order(101,1,"laptop",1,55000));
		orders.put(102, new order(102,2,"Mobiles",4,130000));
		orders.put(103, new order(103,3,"Buds",2,30000));
		orders.put(104, new order(104,1,"Electronics",1,50000));
	}
	

	@Override
	public OrderResponse getOrderById(int id) {
		order order=orders.get(id);
		if(order==null) {
			throw new OrderNotFoundException("order not found with id:"+id);
		}
		
		UserResponse user=userClient.getUserById(order.getUserId());
		return new OrderResponse(
				order.getId(),
				order.getUserId(),
				order.getProductName(),
				order.getQuality(),
				order.getPrice(),
				user);
	}
	
	 

}

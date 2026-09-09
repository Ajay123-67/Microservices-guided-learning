package com.example.demo.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.example.demo.client.PaymentClient;
import com.example.demo.client.UserClient;
import com.example.demo.dto.OrderResponse;
import com.example.demo.dto.UserResponse;
import com.example.demo.exception.OrderNotFoundException;
import com.example.demo.model.Order;

@Service
public class OrderServiceImple implements OrderService {

    private final UserClient userClient;
    private final PaymentClient paymentClient;

    private final Map<Integer, Order> orders = new HashMap<>();

    public OrderServiceImple(
            UserClient userClient,
            PaymentClient paymentClient) {

        this.userClient = userClient;
        this.paymentClient = paymentClient;

        orders.put(101, new Order(101, 1, "laptop", 1, 55000));
        orders.put(102, new Order(102, 2, "Mobiles", 4, 130000));
        orders.put(103, new Order(103, 3, "Buds", 2, 30000));
        orders.put(104, new Order(104, 1, "Electronics", 1, 50000));
    }

    @Override
    public OrderResponse getOrderById(int id) {

        Order order = orders.get(id);

        if (order == null) {
            throw new OrderNotFoundException(
                    "order not found with id: " + id);
        }

        // Call User Service
        UserResponse user =
                userClient.getUserById(order.getUserId());

        // Call Payment Service
        String paymentResponse =
                paymentClient.makePayment();

        System.out.println("Payment Response: " + paymentResponse);

        return new OrderResponse(
                order.getId(),
                order.getUserId(),
                order.getProductName(),
                order.getQuality(),
                order.getPrice(),
                user);
    }
}
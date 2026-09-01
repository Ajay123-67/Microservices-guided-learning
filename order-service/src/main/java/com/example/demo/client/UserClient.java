package com.example.demo.client;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;

import com.example.demo.dto.UserResponse;

@Component
public class UserClient {
	
	private final RestClient restclient;
	public UserClient(RestClient.Builder builder) {
		this.restclient=builder.baseUrl("http://localhost:8081").build();
		
	}
	
	public UserResponse getUserById(int userId) {
		return restclient.get().uri("/users/{id}",userId).retrieve().body(UserResponse.class);
	}
	

}

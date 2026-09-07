package com.example.demo.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.UserResponse;
import com.example.demo.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {
	
	private final UserService userservice;
	
	public UserController(UserService userservice) {
		this.userservice=userservice;
	}
	
	
	@GetMapping("/{id}")
	public ResponseEntity<UserResponse>getUserById(@PathVariable int id){
		UserResponse user=userservice.getUserById(id);
		return ResponseEntity.ok(user);
	}

}

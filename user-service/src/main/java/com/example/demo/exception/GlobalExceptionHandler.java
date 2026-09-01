package com.example.demo.exception;

import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

public class GlobalExceptionHandler {
	
	@ExceptionHandler(UserNotFoundException.class)
	public ResponseEntity<Map<String,Object>> handleUserNotFound(UserNotFoundException exception){
		Map<String,Object> error=new  LinkedHashMap<>();
		error.put("timestamp", LocalDateTime.now());
		error.put("status", 404);
		error.put("error", "Not Found");
		error.put("message", exception.getMessage());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
		
	}
	

}

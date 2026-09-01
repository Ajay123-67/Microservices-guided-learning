package com.example.demo.exception;

import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
	@ExceptionHandler(OrderNotFoundException.class)
	
	public ResponseEntity<Map<String,Object>> handleOrderNotFound(OrderNotFoundException exception){
		
		Map<String,Object> error=new LinkedHashMap<>();
		
		error.put("timestamp", LocalDateTime.now());
		error.put("status", 404);
		error.put("error", "Not found");
		error.put("message", exception.getMessage());
		
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
		
	}

}

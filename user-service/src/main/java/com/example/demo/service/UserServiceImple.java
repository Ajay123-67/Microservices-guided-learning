package com.example.demo.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.example.demo.dto.UserResponse;
import com.example.demo.exception.UserNotFoundException;
import com.example.demo.model.User;


@Service
public class UserServiceImple implements UserService {
	private final Map<Integer ,User> users=new HashMap<>();
	
    public UserServiceImple() {
    	users.put(1, new User(1,"Ajay","ajay@gmail.com"));
    	users.put(2, new User(2,"ravi","ravi@gmail.com"));
    	users.put(3, new User(3,"gopi","gopi@gmail.com"));
    }
	

	@Override
	public UserResponse getUserById(int id) {
		User user=users.get(id);
		
		if(user==null) {
			throw new UserNotFoundException("user not found with id:"+id);
		}
		return new UserResponse(
				user.getId(),
				user.getName(),
				user.getEmail()
				);
	}

}

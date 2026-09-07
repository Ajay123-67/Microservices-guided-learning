package com.example.demo.client;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestClient;

import com.example.demo.dto.UserResponse;
import com.example.demo.exception.UserNotFoundException;
import com.example.demo.exception.UserServiceUnavailableException;

@Component
public class UserClient {

    private final RestClient restClient;

    public UserClient(
            RestClient.Builder builder,
            @Value("${user.service.url}") String userServiceUrl) {

        this.restClient = builder
                .baseUrl(userServiceUrl)
                .build();
    }

    public UserResponse getUserById(int userId) {

        try {

            return restClient.get()
                    .uri("/users/{id}", userId)
                    .retrieve()
                    .onStatus(
                            status -> status.value() == 404,
                            (request, response) -> {
                                throw new UserNotFoundException(
                                        "User with id " + userId + " not found");
                            }
                    )
                    .onStatus(
                            status -> status.is5xxServerError(),
                            (request, response) -> {
                                throw new UserServiceUnavailableException(
                                        "User Service encountered an internal error.");
                            }
                    )
                    .body(UserResponse.class);

        } catch (ResourceAccessException ex) {

            throw new UserServiceUnavailableException(
                    "User Service is currently unavailable. Please try again later."
            );
        }
    }
}
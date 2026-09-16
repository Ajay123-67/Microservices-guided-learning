package com.example.demo.client;

import java.net.URI;
import java.util.List;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Component;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestClient;

import com.example.demo.dto.UserResponse;
import com.example.demo.exception.UserNotFoundException;
import com.example.demo.exception.UserServiceUnavailableException;

@Component
public class UserClient {

    private final RestClient restClient;
    private final DiscoveryClient discoveryClient;

    public UserClient(
            RestClient.Builder builder,
            DiscoveryClient discoveryClient) {

        this.restClient = builder.build();
        this.discoveryClient = discoveryClient;
    }

    public UserResponse getUserById(int userId) {

        try {

            List<ServiceInstance> instances =
                    discoveryClient.getInstances("USER_SERVICE");

            if (instances == null || instances.isEmpty()) {
                throw new UserServiceUnavailableException(
                        "USER_SERVICE is not available in Eureka.");
            }

            ServiceInstance instance = instances.get(0);

            URI userServiceUri = instance.getUri();

            return restClient.get()
                    .uri(userServiceUri + "/users/{id}", userId)
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
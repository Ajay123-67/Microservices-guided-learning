package com.example.demo.client;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestClient;

import com.example.demo.exception.PaymentServiceUnavailableException;

import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Retryable;
import org.springframework.resilience.annotation.CircuitBreaker;

@Component
public class PaymentClient {

    private final RestClient restClient;

    public PaymentClient(
            RestClient.Builder builder,
            @Value("${payment.service.url}") String paymentServiceUrl) {

        this.restClient = builder
                .baseUrl(paymentServiceUrl)
                .build();
    }

    @Retryable(
            retryFor = PaymentServiceUnavailableException.class,
            maxAttempts = 3,
            backoff = @Backoff(delay = 1000)
    )
    
    @CircuitBreaker(
            id = "paymentService",
            failureThreshold = 3,
            openDuration = 10000,
            fallbackMethod = "paymentFallback"
    )
    @Retryable(
            includes = PaymentServiceUnavailableException.class,
            maxRetries = 2,
            delay = 1000
    )
    public String makePayment() {

        try {

            return restClient.post()
                    .uri("/payments")
                    .retrieve()
                    .onStatus(
                            status -> status.is5xxServerError(),
                            (request, response) -> {
                                throw new PaymentServiceUnavailableException(
                                        "Payment Service encountered an internal error."
                                );
                            }
                    )
                    .body(String.class);

        } catch (ResourceAccessException ex) {

            throw new PaymentServiceUnavailableException(
                    "Payment Service is currently unavailable. Please try again later."
            );
        }
    }
    public String paymentFallback(Exception ex) {
        return "Payment service is temporarily unavailable. Please try again later.";
    }
}
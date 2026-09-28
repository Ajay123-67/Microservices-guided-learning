package com.example.payment.controller;

import com.example.payment.entity.Payment;
import com.example.payment.service.PaymentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@RestController
@RequestMapping("/payments")
public class PaymentController {

    private final PaymentService paymentService;

    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @GetMapping("/health")
    public ResponseEntity<String> health() {
        return ResponseEntity.ok("Payment Service is running");
    }

    @PostMapping
    public ResponseEntity<Payment> makePayment(
            @RequestParam Long orderId,
            @RequestParam BigDecimal amount) {

        Payment payment = paymentService.makePayment(orderId, amount);

        return ResponseEntity.ok(payment);
    }
}
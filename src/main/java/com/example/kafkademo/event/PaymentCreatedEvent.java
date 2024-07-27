package com.example.kafkademo.event;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PaymentCreatedEvent {
    private String paymentId;
    private BigDecimal sum;
    private String createdAt;
    private String orderId;
    private String userId;
}

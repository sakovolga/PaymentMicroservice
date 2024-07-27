package com.example.kafkademo.service.impl;

import com.example.kafkademo.dto.PaymentDto;
import com.example.kafkademo.event.PaymentCreatedEvent;
import com.example.kafkademo.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;

import java.util.UUID;
import java.util.concurrent.ExecutionException;

@Service
public class PaymentServiceImpl implements PaymentService {

    @Autowired
    KafkaTemplate<String, PaymentCreatedEvent> kafkaTemplate;

    @Override
    public String create(PaymentDto paymentDto) throws ExecutionException, InterruptedException {
        String paymentId = UUID.randomUUID().toString();
        PaymentCreatedEvent paymentCreatedEvent = new PaymentCreatedEvent(
                paymentId,
                paymentDto.getSum(),
                paymentDto.getCreatedAt(),
                paymentDto.getOrderId(),
                paymentDto.getUserId()
        );

        SendResult<String, PaymentCreatedEvent> result = kafkaTemplate
                .send("payment-created-event-topic", paymentId, paymentCreatedEvent).get();

        System.out.println("Topic " + result.getRecordMetadata().topic());
        System.out.println("Partition " + result.getRecordMetadata().partition());
        System.out.println("Offset " + result.getRecordMetadata().offset());
        System.out.println("Timestamp " + result.getRecordMetadata().timestamp());

        System.out.println("PaymentId: " + paymentId);
        return paymentId;
    }
}

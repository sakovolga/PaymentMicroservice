package com.example.kafkademo.service;

import com.example.kafkademo.dto.PaymentDto;

import java.util.concurrent.ExecutionException;

public interface PaymentService {
    String create(PaymentDto paymentDto) throws ExecutionException, InterruptedException;
}

package com.example.clinic.auth.service;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumerService {

    @KafkaListener(topics = "all-notifications", groupId = "example-group")
    public void consume(String message) {
        System.out.println("Получил сообщение: " + message);
    }
}
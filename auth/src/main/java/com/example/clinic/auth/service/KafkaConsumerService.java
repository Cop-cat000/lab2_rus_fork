package com.example.clinic.auth.service;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumerService {

    @KafkaListener(topics = "all-notifications", groupId = "${spring.kafka.consumer.group-id}")
    public void consumeAllNotifications(String message) {
        System.out.println("Received from all-notifications: " + message);
    }

    @KafkaListener(topics = "authorization", groupId = "${spring.kafka.consumer.group-id}")
    public void consumeAuthorization(String message) {
        System.out.println("Received from authorization: " + message);
    }
}

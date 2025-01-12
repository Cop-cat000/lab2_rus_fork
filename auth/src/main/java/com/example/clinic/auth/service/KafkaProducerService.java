package com.example.clinic.auth.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaProducerService {


    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    private static final String ALL_NOTIFICATIONS_TOPIC = "all-notifications";
    private static final String AUTHORIZATION_TOPIC = "authorization";

    public void sendMessageToAllNotifications(String message) {
        kafkaTemplate.send(ALL_NOTIFICATIONS_TOPIC, message);
        System.out.println("ЗАЕБИСЬ ЗАРАБОТАЛИ ВСЕ УВЕДОМЛЕНИЯ");
    }

    public void sendMessageToAuthorization(String message) {
        kafkaTemplate.send(AUTHORIZATION_TOPIC, message);
        System.out.println("ЗАЕБИСЬ ЗАРАБОТАЛО УВЕДОМЛЕНИЕ АВТОРИЗАЦИИ");


    }
}

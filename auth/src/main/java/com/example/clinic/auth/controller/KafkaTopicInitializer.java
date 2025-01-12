package com.example.clinic.auth.controller;

import com.example.clinic.auth.service.KafkaTopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class KafkaTopicInitializer implements CommandLineRunner {

    @Autowired
    private KafkaTopicService kafkaTopicService;

    @Override
    public void run(String... args) throws Exception {
        kafkaTopicService.createTopic("all-notifications", 1, (short) 1);
        kafkaTopicService.createTopic("authorization", 1, (short) 1);
    }
}

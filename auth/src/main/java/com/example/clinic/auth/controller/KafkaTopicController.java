package com.example.clinic.auth.controller;

import com.example.clinic.auth.service.KafkaTopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/kafka") // Общий префикс для Kafka API
public class KafkaTopicController implements CommandLineRunner {

    private final KafkaTopicService kafkaTopicService;

    @Autowired
    public KafkaTopicController(KafkaTopicService kafkaTopicService) {
        this.kafkaTopicService = kafkaTopicService;
    }

    // Метод для создания топиков через REST API
    @PostMapping("/create-topic")
    public String createTopic(
            @RequestParam String topicName,
            @RequestParam int partitions,
            @RequestParam short replicationFactor
    ) {
        kafkaTopicService.createTopic(topicName, partitions, replicationFactor);
        return "Topic " + topicName + " created successfully";
    }

    // Метод для создания стандартных топиков при запуске приложения
    @Override
    public void run(String... args) throws Exception {
        kafkaTopicService.createTopic("all-notifications", 3, (short) 3);
        kafkaTopicService.createTopic("authorization", 3, (short) 3);
        System.out.println("Default Kafka topics created");
    }
}
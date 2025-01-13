package com.example.clinic.patient.controller;

import com.example.clinic.patient.service.KafkaTopicPatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/kafka") // Общий префикс для Kafka API
public class KafkaTopicPatientController implements CommandLineRunner {

    private final KafkaTopicPatientService kafkaTopicPatientService;

    @Autowired
    public KafkaTopicPatientController(KafkaTopicPatientService kafkaTopicPatientService) {
        this.kafkaTopicPatientService = kafkaTopicPatientService;
    }

    // Метод для создания топиков через REST API
    @PostMapping("/create-topic")
    public String createTopic(
            @RequestParam String topicName,
            @RequestParam int partitions,
            @RequestParam short replicationFactor
    ) {
        kafkaTopicPatientService.createPatientTopic(topicName, partitions, replicationFactor);
        return "Topic " + topicName + " created successfully";
    }

    // Метод для создания стандартных топиков при запуске приложения
    @Override
    public void run(String... args) throws Exception {

        kafkaTopicPatientService.createPatientTopic("patient-notifications", 3, (short) 3);
        System.out.println("Default Kafka topics created");
    }
}
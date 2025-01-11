package com.example.clinic.auth.controller;

import com.example.clinic.auth.service.KafkaTopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class KafkaTopicController {

    @Autowired
    private KafkaTopicService kafkaTopicService;

    @GetMapping("/create-topic")
    public String createTopic(@RequestParam String topicName, @RequestParam int partitions, @RequestParam short replicationFactor) {
        kafkaTopicService.createTopic(topicName, partitions, replicationFactor);
        return "Topic created successfully";
    }
}
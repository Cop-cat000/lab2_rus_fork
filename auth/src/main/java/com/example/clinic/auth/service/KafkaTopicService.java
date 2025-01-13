package com.example.clinic.auth.service;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.kafka.core.KafkaAdmin;
import org.springframework.stereotype.Service;

@Service
public class KafkaTopicService {

    private final KafkaAdmin kafkaAdmin;

    public KafkaTopicService(KafkaAdmin kafkaAdmin) {
        this.kafkaAdmin = kafkaAdmin;
    }

    public void createTopic(String topicName, int partitions, short replicationFactor) {
        NewTopic topic = new NewTopic(topicName, partitions, replicationFactor);
        kafkaAdmin.createOrModifyTopics(topic);
        System.out.println("Topic created: " + topicName);
    }
}
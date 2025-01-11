package com.example.clinic.auth.service;

import org.apache.kafka.clients.admin.AdminClient;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaAdmin;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class KafkaTopicService {

    @Autowired
    private KafkaAdmin kafkaAdmin;

    public void createTopic(String topicName, int partitions, short replicationFactor) {
        AdminClient adminClient = AdminClient.create(kafkaAdmin.getConfigurationProperties());
        NewTopic topic = new NewTopic(topicName, partitions, replicationFactor);
        adminClient.createTopics(Collections.singletonList(topic));
        adminClient.close();
    }
}
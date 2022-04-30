package com.example.lab8.kafka;


import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaTopConfig {

    @Bean
    public NewTopic topic1() {
        return TopicBuilder.name("alua").build();
    }
}

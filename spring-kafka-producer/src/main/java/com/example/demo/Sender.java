package com.example.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;


public class Sender {

    @Autowired
    private KafkaTemplate<String, Coffee> kafkaTemplate;

    public void send(Coffee coffee) {
        kafkaTemplate.send("batch-coffee", coffee);
    }
}

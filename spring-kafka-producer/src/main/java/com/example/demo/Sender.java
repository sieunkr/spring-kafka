package com.example.demo;

import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class Sender {

    private final KafkaTemplate<String, String> kafkaTemplate;
    private final KafkaTemplate<String, Coffee> coffeeKafkaTemplate;

    void sendMessage(String message){
        kafkaTemplate.send("coffee", message);
    }

    void sendCoffee(Coffee coffee) {
        coffeeKafkaTemplate.send("batch-coffee", coffee);
    }
}
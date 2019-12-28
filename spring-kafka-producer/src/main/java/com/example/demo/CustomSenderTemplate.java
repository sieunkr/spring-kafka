package com.example.demo;

import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CustomSenderTemplate {

    private final KafkaTemplate<String, String> kafkaTemplate;
    private final KafkaTemplate<String, CoffeeDTO> coffeeDTOKafkaTemplate;

    void sendCoffee(String message){
        kafkaTemplate.send("coffee", message);
    }

    void sendCoffeeDTO(CoffeeDTO coffee) {
        coffeeDTOKafkaTemplate.send("coffee-dto", coffee);
    }
}
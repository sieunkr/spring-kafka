package com.example.demo;


import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.util.List;

@Slf4j
@Component
public class Consumer {

    @KafkaListener(topics = "coffee")
    public void consume(String payload) {
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        log.info(payload);
    }


    @KafkaListener(topics = "coffee-dto", containerFactory = "coffeeDTOKafkaListenerContainerFactory")
    public void consumeDto(List<CoffeeDTO> payload) {
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        log.info(String.valueOf(payload.size()));
    }

}
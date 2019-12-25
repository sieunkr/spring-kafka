package com.example.demo;


import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;

import java.util.List;

@Slf4j
public class BatchReceiver {

    @KafkaListener(topics = "batch-coffee")
    public void receive(List<String> payload) {
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        log.info(String.valueOf(payload.size()));
    }
}
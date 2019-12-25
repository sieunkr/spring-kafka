package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.core.KafkaTemplate;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {

    @Autowired
    private KafkaTemplate kafkaTemplate;

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        //kafkaTemplate.send("coffee", "latte11");

        //kafkaTemplate.send("batch-coffee", "test01");

        for(int i = 0; i < 500; i++){
            kafkaTemplate.send("batch-coffee", Coffee.builder().name("coffee."+i).price(900).build());
        }


    }
}

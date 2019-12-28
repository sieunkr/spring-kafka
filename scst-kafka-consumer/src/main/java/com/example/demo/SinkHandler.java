package com.example.demo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.function.Consumer;

@Slf4j
@Component
public class SinkHandler {

    @Bean
    Consumer<List<CoffeeDTO>> functionInput(){
        return r -> {
            //System.out.println("abc");
            log.info(String.valueOf(r.size()));
        };
    }

}

package com.example.demo;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.stream.IntStream;

@RestController
@RequestMapping("/producer")
@RequiredArgsConstructor
public class HomeController {

    private final CustomSenderTemplate customSenderTemplate;

    @GetMapping("/one-message")
    public String oneMessage(){
        customSenderTemplate.sendCoffee("one-message");
        return "ok";
    }

    @GetMapping("/batch-message")
    public String batchMessage(){

        //1~1000 까지 int 스트림
        IntStream.rangeClosed(1, 1000).forEach(i -> {
            customSenderTemplate.sendCoffee("message:" + i);
        });

        return "ok";
    }


    @GetMapping("/batch-dto")
    public String batchCoffeeDTO(){

        IntStream.rangeClosed(1, 100).forEach(i -> {
            customSenderTemplate.sendCoffeeDTO(CoffeeDTO.builder().name("coffeeDTO:" + i).price(1000).build());
        });

        return "ok";
    }
}
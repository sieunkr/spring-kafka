package com.example.demo;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CoffeeDTO {
    private String name;
    private Integer price;
}
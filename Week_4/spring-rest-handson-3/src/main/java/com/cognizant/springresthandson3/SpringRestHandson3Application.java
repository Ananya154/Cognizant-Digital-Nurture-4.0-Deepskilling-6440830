package com.cognizant.springresthandson3;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@ImportResource("classpath:employee.xml")  
public class SpringRestHandson3Application {
    public static void main(String[] args) {
        SpringApplication.run(SpringRestHandson3Application.class, args);
    }
}


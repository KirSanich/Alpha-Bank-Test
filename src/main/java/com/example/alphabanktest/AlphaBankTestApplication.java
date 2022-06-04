package com.example.alphabanktest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class AlphaBankTestApplication {
    public static void main(String[] args) {
        SpringApplication.run(AlphaBankTestApplication.class, args);
    }

}

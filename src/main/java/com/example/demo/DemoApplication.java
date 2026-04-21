package com.example.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import com.example.demo.service.ApiService;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    // ✅ Runs after app starts (NO circular dependency)
    @Bean
    public CommandLineRunner run(ApiService apiService) {
        return args -> {
            apiService.startFlow();
        };
    }

    // ✅ Only one RestTemplate bean
    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
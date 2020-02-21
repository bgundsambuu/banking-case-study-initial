package com.example.banking.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@org.springframework.context.annotation.Configuration
public class Configuration {
    private RestTemplate restTemplate;
    @Bean
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }

}

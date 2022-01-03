package com.dragonlin.hanashopapi.configs;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class BeanConfig {
    @Bean
    RestTemplate restTemplate() {
        return new RestTemplate();
    }
    @Bean
    ModelMapper mapper(){
        return new ModelMapper();
    }
}

package com.gradle.gradle;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.gradle.gradle.repository")
public class FeedBackApplication {

    public static void main(String[] args) {
        SpringApplication.run(FeedBackApplication.class, args);
    }

//    @Bean
//    ObjectMapper objectMapper() {
//        ObjectMapper objectMapper = new ObjectMapper();
//        objectMapper.findAndRegisterModules();
//        return objectMapper;
//    }
}

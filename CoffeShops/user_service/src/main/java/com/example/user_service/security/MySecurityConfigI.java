package com.example.user_service.security;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.password.PasswordEncoder;

public interface MySecurityConfigI {
    @Bean
    PasswordEncoder passwordEncoder();

    void configure(HttpSecurity httpSecurity) throws Exception;
}

package com.sist.secure.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity
@Configuration
public class SecurityJavaConfig {
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
        

        return http.build();
    }


}

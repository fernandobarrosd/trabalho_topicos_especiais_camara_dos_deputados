package com.fernando.api.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class SpringSecurityConfig {
    @Bean
    SecurityFilterChain configSecurityFilterChain(HttpSecurity httpSecurity) throws Exception {
        return httpSecurity
        .csrf(AbstractHttpConfigurer::disable)
        .cors(AbstractHttpConfigurer::disable)
        .authorizeHttpRequests(authorize -> authorize
        .requestMatchers(new AntPathRequestMatcher("/auth/**")).permitAll()
        .anyRequest().authenticated())
        .build();
    }
}

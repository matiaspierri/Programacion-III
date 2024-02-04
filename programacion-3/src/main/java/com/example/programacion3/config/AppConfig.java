package com.example.programacion3.config;

import com.example.programacion3.repository.UserRepository;
import com.example.programacion3.service.UserService;
import com.example.programacion3.service.UserServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class AppConfig {


    @Bean
    @Primary
    public UserService createUserService(){

        return new UserServiceImpl();
    }

}
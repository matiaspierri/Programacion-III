package com.programacionIII.tp.config;

import com.programacionIII.tp.repositories.IUserRepository;
import com.programacionIII.tp.repositories.UserRepositoryImpl;
import com.programacionIII.tp.services.IUserService;
import com.programacionIII.tp.services.UserServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public IUserService createUserService(){
        return new UserServiceImpl();
    }

    @Bean
    public IUserRepository createUserRepository(){ return new UserRepositoryImpl(); }
}

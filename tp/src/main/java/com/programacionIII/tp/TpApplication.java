package com.programacionIII.tp;

import com.programacionIII.tp.models.User;
import org.apache.commons.lang3.math.Fraction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.apache.commons.lang3.*;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.util.ArrayList;
import java.util.List;
import com.programacionIII.tp.repositories.RoleRepository;
import com.programacionIII.tp.models.Role;
import com.programacionIII.tp.repositories.UserRepositoryImpl;

@SpringBootApplication
public class TpApplication {


	public static void main(String[] args) {
		SpringApplication.run(TpApplication.class, args);
	}

}

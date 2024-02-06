package com.example.programacion3;

import com.example.programacion3.models.Role;
import com.example.programacion3.models.User;
import com.example.programacion3.services.interfaces.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Programacion3Application {

	public static void main(String[] args) {
		SpringApplication.run(Programacion3Application.class, args);
	}

	@Bean
	CommandLineRunner run(@Autowired IUserService userService) {
		return args -> {
			// Create roles and users
			Role admin = new Role("ADMIN");
			Role user = new Role("USER");
			userService.createRole(admin);
			userService.createRole(user);
			User userAdmin = userService.createUser(new User("admin", "admin", admin));
			User user1 = userService.createUser(new User("user1", "user1", user));
			User user2 = userService.createUser(new User("user2", "user2", user));
			User user3 = userService.createUser(new User("user3", "user3", user));
			User user4 = userService.createUser(new User("user4", "user4", user));
		};
	}
}

package com.example.programacion3;

import com.example.programacion3.models.Image;
import com.example.programacion3.models.Post;
import com.example.programacion3.models.Role;
import com.example.programacion3.models.User;
import com.example.programacion3.services.interfaces.IImageService;
import com.example.programacion3.services.interfaces.IPostService;
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
	CommandLineRunner run(@Autowired IUserService userService, @Autowired IPostService postService, @Autowired IImageService imageService) {
		return args -> {

			// Create roles
			Role admin = new Role("ADMIN");
			Role user = new Role("USER");
			userService.createRole(admin);
			userService.createRole(user);

			// Create users
			User userAdmin = userService.createUser(new User("admin", "admin", "admin@gmail.com", admin, null, null));
			User user1 = userService.createUser(new User("user1", "user1", "user1@gmail.com", user, null, null));
			User user2 = userService.createUser(new User("user2", "user2", "user2@gmail.com", user, null, null));
			User user3 = userService.createUser(new User("user3", "user3", "user3@gmail.com", user, null, null));
			User user4 = userService.createUser(new User("user4", "user4", "user4@gmail.com", user, null, null));

			// Add friends
			userService.addFriend(user1, user2);
			userService.addFriend(user1, user3);
			userService.addFriend(user1, user4);
			userService.addFriend(user2, user3);
			userService.addFriend(user2, user4);
			userService.addFriend(user3, user4);

			// Add posts
			Post post1 = postService.createPost("Post1", user1);
			Image image1 = imageService.createImage("Image1", "https://www.google.com", post1);
			Image image2 = imageService.createImage("Image2", "https://www.google.com", post1);
			Image image3 = imageService.createImage("Image3", "https://www.google.com", post1);
			Post post2 = postService.createPost("Post2", user2);
			Image image4 = imageService.createImage("Image4", "https://www.google.com", post2);
			Image image5 = imageService.createImage("Image5", "https://www.google.com", post2);
			Image image6 = imageService.createImage("Image6", "https://www.google.com", post2);
			Post post3 = postService.createPost("Post3", user3);
			Image image7 = imageService.createImage("Image7", "https://www.google.com", post3);
			Image image8 = imageService.createImage("Image8", "https://www.google.com", post3);
			Image image9 = imageService.createImage("Image9", "https://www.google.com", post3);
			Post post4 = postService.createPost("Post4", user4);
			Image image10 = imageService.createImage("Image10", "https://www.google.com", post4);
			Image image11 = imageService.createImage("Image11", "https://www.google.com", post4);
			Image image12 = imageService.createImage("Image12", "https://www.google.com", post4);
			

		};
	}
}

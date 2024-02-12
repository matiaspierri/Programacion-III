package com.example.programacion3;

import com.example.programacion3.models.Image;
import com.example.programacion3.models.Post;
import com.example.programacion3.models.Role;
import com.example.programacion3.models.User;
import com.example.programacion3.services.interfaces.ICommentService;
import com.example.programacion3.services.interfaces.IImageService;
import com.example.programacion3.services.interfaces.IPostService;
import com.example.programacion3.services.interfaces.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Random;

@SpringBootApplication
public class Programacion3Application {

	public static void main(String[] args) {
		SpringApplication.run(Programacion3Application.class, args);
	}

	@Bean
	CommandLineRunner run(@Autowired IUserService userService, @Autowired IPostService postService, @Autowired IImageService imageService, @Autowired ICommentService commentService) {
		return args -> {

			// Create roles
			Role admin = new Role("ADMIN");
			Role user = new Role("USER");
			userService.createRole(admin);
			userService.createRole(user);

			// Create users
			User userAdmin = userService.createUser(new User("admin", "admin", "admin@gmail.com", admin));
			User user1 = userService.createUser(new User("user1", "user1", "user1@gmail.com", user));
			User user2 = userService.createUser(new User("user2", "user2", "user2@gmail.com", user));
			User user3 = userService.createUser(new User("user3", "user3", "user3@gmail.com", user));
			User user4 = userService.createUser(new User("user4", "user4", "user4@gmail.com", user));
			User user5 = userService.createUser(new User("user5", "user5", "user5@gmail.com", user));

			// Add friends
			userService.addFriend(user1.getId(), user2.getId());
			userService.addFriend(user1.getId(), user3.getId());
			userService.addFriend(user1.getId(), user4.getId());
			userService.addFriend(user2.getId(), user3.getId());
			userService.addFriend(user2.getId(), user4.getId());
			userService.addFriend(user3.getId(), user4.getId());

			// Add posts
			Post post1 = postService.createPost("Post1", "Post1 Content", user1);
			Post post2 = postService.createPost("Post2", "Post2 Content", user2);
			Post post3 = postService.createPost("Post3", "Post3 Content", user1);
			Post post4 = postService.createPost("Post4", "Post4 Content", user2);
			Post post5 = postService.createPost("Post5", "Post5 Content", user1);
			Post post6 = postService.createPost("Post6", "Post6 Content", user2);
			Post post7 = postService.createPost("Post7", "Post7 Content", user1);
			Post post8 = postService.createPost("Post8", "Post8 Content", user2);

			// Add images
			for(int i = 0; i < 10; i++){
				imageService.createImage(post1);
				imageService.createImage(post2);
				imageService.createImage(post3);
				imageService.createImage(post4);
				imageService.createImage(post5);
				imageService.createImage(post6);
				imageService.createImage(post7);
				imageService.createImage(post8);
			}

			// Add comments
			commentService.createComment("Comment1", user1, post1);
			commentService.createComment("Comment2", user2, post1);
			commentService.createComment("Comment3", user3, post1);
			commentService.createComment("Comment4", user4, post1);
			commentService.createComment("Comment5", user1, post2);
			commentService.createComment("Comment6", user2, post2);
			commentService.createComment("Comment7", user3, post2);
			commentService.createComment("Comment8", user4, post2);
			commentService.createComment("Comment9", user1, post3);
			commentService.createComment("Comment10", user2, post3);
			commentService.createComment("Comment11", user3, post3);
			commentService.createComment("Comment12", user4, post3);
			commentService.createComment("Comment13", user1, post4);
			commentService.createComment("Comment14", user2, post4);
			commentService.createComment("Comment15", user3, post4);
			commentService.createComment("Comment16", user4, post4);

		};
	}
}

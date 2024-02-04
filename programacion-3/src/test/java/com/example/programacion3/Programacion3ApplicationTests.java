package com.example.programacion3;

import com.example.programacion3.repository.ImageRepository;
import com.example.programacion3.repository.PostRepository;
import com.example.programacion3.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DataAccessException;
import com.example.programacion3.model.User;
import com.example.programacion3.model.Post;
import com.example.programacion3.model.Image;

@SpringBootTest
class Programacion3ApplicationTests {

	@Test
	void contextLoads() {
	}

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private PostRepository postRepository;

	@Autowired
	private ImageRepository imageRepository;

	@Test
	void testConnection() {
		try {
			userRepository.count(); // Simple call to test the connection
		} catch (DataAccessException e) {
			assert false : "Database connection failed";
		}
	}

	@Test
	void createUser() {
		User user = new User(
			"username",
			"password",
			"email",
			null,
			null
		);
		userRepository.save(user);
	}

	@Test
	void deleteUser() {
		User user = new User(
			"username",
			"password",
			"email",
			null,
			null
		);
		userRepository.save(user);
		userRepository.delete(user);
	}


	// Test association between Post and User
	@Test
	void testPostUserAssociation() {
		User user = new User(
			"username",
			"password",
			"email",
			null,
			null
		);
		userRepository.save(user);
		// Create a post
		Post post = new Post(
			"description_TEST",
			user,
			null
		);

		postRepository.save(post);

		Post savedPost = postRepository.findById(post.getId()).get();

		assert savedPost.getUser().getId().equals(user.getId());
	}

	// Test friends association
	@Test
	void testFriendsAssociation() {

		// Create two users
		User user1 = new User(
			"username3",
			"password1",
			"email1",
			null,
			null
		);
		userRepository.save(user1);

		User user2 = new User(
			"username4",
			"password2",
			"email2",
			null,
			null
		);
		userRepository.save(user2);

		// Add user2 to user1's friends
		user1.getFriends().add(user2);

		userRepository.save(user1);

	}

	// Test posts association with images
	@Test
	void testPostImagesAssociation() {
		User user = new User(
			"username",
			"password",
			"email",
			null,
			null
		);
		userRepository.save(user);
		// Create a post
		Post post = new Post(
			"description_TEST",
			user,
			null
		);

		postRepository.save(post);

		// Create an image
		Image image = new Image(
			"title",
			"url",
			post
		);
		imageRepository.save(image);

		// Add the image to the post
		post.getImages().add(image);

		// Save the post
		postRepository.save(post);

		// Get the post from the database
		Post savedPost = postRepository.findById(post.getId()).get();


	}

}

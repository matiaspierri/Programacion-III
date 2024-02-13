package com.example.programacion3;

import com.example.programacion3.dto.Image.ImageDTO;
import com.example.programacion3.models.Image;
import com.example.programacion3.models.Post;
import com.example.programacion3.models.Role;
import com.example.programacion3.models.User;
import com.example.programacion3.services.interfaces.ICommentService;
import com.example.programacion3.services.interfaces.IImageService;
import com.example.programacion3.services.interfaces.IPostService;
import com.example.programacion3.services.interfaces.IUserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Set;

@SpringBootTest
class Programacion3ApplicationTests {

	@Autowired
	private ICommentService commentService;

	@Autowired
	private IImageService imageService;

	@Autowired
	private IPostService postService;

	@Autowired
	private IUserService userService;

	@Test
	void createRoles() {
		Role admin = userService.createRole(new Role("ADMIN_TEST"));
		Role user = userService.createRole(new Role("USER_TEST"));

		assert admin != null;
		assert user != null;
	}

	@Test
	void createUsers() {
		Role admin = userService.createRole(new Role("ADMIN_TEST"));
		Role user = userService.createRole(new Role("USER_TEST"));

		User userAdmin = userService.createUser(new User("adminTest", "adminTest", "adminTest@gmail.com", admin));
		User userTest1 = userService.createUser(new User("userTest1", "userTest1", "userTest1@gmail.com", user));

		assert userAdmin != null;
		assert userTest1 != null;
		assert userAdmin.getRole().getName().equals("ADMIN_TEST");
		assert userTest1.getRole().getName().equals("USER_TEST");
		assert userAdmin.getUsername().equals("adminTest");
		assert userTest1.getUsername().equals("userTest1");
		assert userAdmin.getEmail().equals("adminTest@gmail.com");
		assert userTest1.getEmail().equals("userTest1@gmail.com");
	}

	@Test
	void addPosts() {
		Role user = userService.createRole(new Role("USER_TEST"));
		User userTest1 = userService.createUser(new User("userTest1", "userTest1", "userTest1@gmail.com", user));
		Post post1 = postService.createPost("Post1", "Post1 Content", userTest1);

		assert post1 != null;
		assert post1.getTitle().equals("Post1");
		assert post1.getContent().equals("Post1 Content");
		assert post1.getUser().equals(userTest1);
		Post postAdded = postService.getPostById(post1.getId());
		assert postAdded != null;
		assert postAdded.getTitle().equals("Post1");
		assert postAdded.getContent().equals("Post1 Content");
		assert postAdded.getUser().getUsername().equals("userTest1");
		assert postAdded.getUser().getEmail().equals("userTest1@gmail.com");

	}

	@Test
	void updatePosts() {
		Role user = userService.createRole(new Role("USER_TEST"));
		User userTest1 = userService.createUser(new User("userTest1", "userTest1", "userTest1@gmail.com", user));
		Post post1 = postService.createPost("Post1", "Post1 Content", userTest1);

		postService.updatePost(post1.getId(), "Post1 Updated", "Post1 Content Updated", new ArrayList<ImageDTO>());

		assert postService.getPostById(post1.getId()).getTitle().equals("Post1 Updated");
		assert postService.getPostById(post1.getId()).getContent().equals("Post1 Content Updated");
	}

	@Test
	void deletePosts() {
		Role user = userService.createRole(new Role("USER_TEST"));
		User userTest1 = userService.createUser(new User("userTest1", "userTest1", "userTest1@gmail.com", user));
		Post post1 = postService.createPost("Post1", "Post1 Content", userTest1);

		postService.deletePost(post1.getId());

		assert postService.getPostById(post1.getId()) == null;
	}

	@Test
	void addComments() {
		Role user = userService.createRole(new Role("USER_TEST"));
		User userTest1 = userService.createUser(new User("userTest1", "userTest1", "userTest1@gmail.com", user));
		Post post1 = postService.createPost("Post1", "Post1 Content", userTest1);
		commentService.createComment("Comment1", userTest1, post1);

		assert postService.getPostById(post1.getId()).getComments().size() == 1;
		assert postService.getPostById(post1.getId()).getComments().get(0).getText().equals("Comment1");
	}

	@Test
	void deleteUsers() {
		Role user = userService.createRole(new Role("USER_TEST"));
		User userTest1 = userService.createUser(new User("userTest1", "userTest1", "userTest1@gmail.com", user));
		User userTest2 = userService.createUser(new User("userTest2", "userTest2", "userTest2@gmail.com", user));

		userService.deleteUser(userTest1.getId());
		userService.deleteUser(userTest2.getId());

		assert userService.getUserInfo(userTest1.getId()) == null;
		assert userService.getUserInfo(userTest2.getId()) == null;
	}
}
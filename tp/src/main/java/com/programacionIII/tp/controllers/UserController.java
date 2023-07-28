package com.programacionIII.tp.controllers;

import com.programacionIII.tp.repositories.UserRepositoryImpl;
import com.programacionIII.tp.services.IUserService;
import com.programacionIII.tp.services.PostServiceImpl;
import com.programacionIII.tp.services.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import com.programacionIII.tp.models.*;
import org.springframework.stereotype.Controller;



@RestController
@RequestMapping(value = "/api/user")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class UserController {
    @Autowired
    private UserServiceImpl userService;

    @Autowired
    private PostServiceImpl postService;


    public UserController() {

    }
    @PostMapping("/create")
    public User createUser(@RequestBody User user) {

        // print password
        System.out.println("Password: " + user.getPassword());
        return userService.createUser(user);
    }

    @GetMapping(path="/hello-world")
    public String HelloWorld()
    {


        // Create user
        Role role = new Role("role");

        this.userService.createRole(role);

        User user1 = new User("name1","123",role);
        User user2 = new User("dummy2","123",role);
        User user3 = new User("dummy3","123",role);
        User user4 = new User("dummy4","123",role);
        User user5 = new User("dummy5","123",role);

        this.userService.createUser(user1);
        this.userService.createUser(user2);
        this.userService.createUser(user3);
        this.userService.createUser(user4);
        this.userService.createUser(user5);


        Post post1 = new Post("https://picsum.photos/id/221/200/300","Lorem ipsum lorem",user1);
        Post post2 = new Post("https://picsum.photos/id/222/200/301","Lorem ipsum lorem",user1);
        Post post3 = new Post("https://picsum.photos/id/223/200/302","Lorem ipsum lorem",user1);

        this.postService.createPost(post1);
        this.postService.createPost(post2);
        this.postService.createPost(post3);

        post1 = new Post("https://picsum.photos/id/236/200/303","Lorem ipsum lorem",user2);
        post2 = new Post("https://picsum.photos/id/235/200/304","Lorem ipsum lorem",user2);
        post3 = new Post("https://picsum.photos/id/234/200/305","Lorem ipsum lorem",user2);

        this.postService.createPost(post1);
        this.postService.createPost(post2);
        this.postService.createPost(post3);

        post1 = new Post("https://picsum.photos/id/238/200/307","Lorem ipsum lorem",user3);
        post2 = new Post("https://picsum.photos/id/239/200/308","Lorem ipsum lorem",user3);
        post3 = new Post("https://picsum.photos/id/240/200/309","Lorem ipsum lorem",user3);

        this.postService.createPost(post1);
        this.postService.createPost(post2);
        this.postService.createPost(post3);

        post1 = new Post("https://picsum.photos/id/250/200/307","Lorem ipsum lorem",user3);
        post2 = new Post("https://picsum.photos/id/251/200/308","Lorem ipsum lorem",user3);
        post3 = new Post("https://picsum.photos/id/252/200/309","Lorem ipsum lorem",user3);

        this.postService.createPost(post1);
        this.postService.createPost(post2);
        this.postService.createPost(post3);

        post1 = new Post("https://picsum.photos/id/101/200/307","Lorem ipsum lorem",user4);
        post2 = new Post("https://picsum.photos/id/102/200/308","Lorem ipsum lorem",user4);
        post3 = new Post("https://picsum.photos/id/103/200/309","Lorem ipsum lorem",user4);

        this.postService.createPost(post1);
        this.postService.createPost(post2);
        this.postService.createPost(post3);

        post1 = new Post("https://picsum.photos/id/95/200/307","Lorem ipsum lorem",user5);
        post2 = new Post("https://picsum.photos/id/94/200/308","Lorem ipsum lorem",user5);
        post3 = new Post("https://picsum.photos/id/93/200/309","Lorem ipsum lorem",user5);

        this.postService.createPost(post1);
        this.postService.createPost(post2);
        this.postService.createPost(post3);


        return "Hello World";
    }

    @GetMapping(path = "/all")
    public List<User> getAllUsers() {
        return this.userService.allUsers();
    }


    @GetMapping(path = "/authenticatedinfo")
    public Authentication info() {
        return SecurityContextHolder.getContext().getAuthentication();
    }

    @GetMapping(path = "")
    public User getUserInfo() {
        return this.userService.getUserInfo();
    }

}

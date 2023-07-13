package com.programacionIII.tp.controllers;

import com.programacionIII.tp.repositories.UserRepositoryImpl;
import com.programacionIII.tp.services.IUserService;
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
import com.programacionIII.tp.services.*;



@RestController
@RequestMapping(value = "/api/post")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class PostController {


    @Autowired
    private PostServiceImpl postService;

    public PostController() {

    }
    @PostMapping("/create")
    public Post createUser(@RequestBody Post post) {

        return postService.createPost(post);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping(path = "/all")
    public List<Post> getAllPosts() {
        return this.postService.allPosts();
    }




}

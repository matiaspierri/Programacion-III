package com.example.programacion3.controllers;

import com.example.programacion3.dto.Post.PostDTO;
import com.example.programacion3.models.Post;
import com.example.programacion3.services.interfaces.IPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/post")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class PostController {
    @Autowired private IPostService postService;

    @PostMapping(value = "")
    public Post createPost(@RequestBody PostDTO post){
        return this.postService.createPost(post.getDescription(), post.getImages());
    }
}

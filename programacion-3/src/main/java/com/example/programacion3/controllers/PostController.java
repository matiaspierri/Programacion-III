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
        return this.postService.createPost(post.getTitle(), post.getContent(), post.getImages());
    }

    @GetMapping(value = "/public")
    public Iterable<Post> getPosts(){
        return this.postService.getPosts();
    }

    @GetMapping(value = "/public/{id}")
    public Post getPostById(@PathVariable Long id){
        return this.postService.getPostById(id);
    }

    @GetMapping(value = "/user")
    public Iterable<Post> getPostsByUser(){
        return this.postService.getPostsByUser();
    }

    @DeleteMapping(value = "/{id}")
    public void deletePost(@PathVariable Long id){
        this.postService.deletePost(id);
    }

    @PutMapping(value = "/{id}")
    public Post updatePost(@PathVariable Long id, @RequestBody PostDTO post){
        return this.postService.updatePost(id, post.getTitle(), post.getContent(), post.getImages());
    }
}

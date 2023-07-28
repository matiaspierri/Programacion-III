package com.programacionIII.tp.controllers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import com.programacionIII.tp.services.*;
import com.programacionIII.tp.models.*;


@RestController
@RequestMapping(value = "/api/post")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class PostController {

    @Autowired
    private PostServiceImpl postService;

    public PostController() {}

    @PostMapping("/create")
    public Post createPost(@RequestBody Post post) {
        return postService.createPost(post);
    }


    @CrossOrigin(origins = "*")
    @DeleteMapping(path = "/")
    public Post deletePost(@RequestBody Post post) {
        return postService.deletePost(post);
    }

    @CrossOrigin(origins = "*")
    @GetMapping(path = "/all")
    public List<Post> getAllPosts() {
        return this.postService.allPosts();
    }

}

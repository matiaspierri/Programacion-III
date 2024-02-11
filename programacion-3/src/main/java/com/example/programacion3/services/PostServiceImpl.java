package com.example.programacion3.services;


import com.example.programacion3.dto.Image.ImageDTO;
import com.example.programacion3.models.Image;
import com.example.programacion3.models.Post;
import com.example.programacion3.models.User;
import com.example.programacion3.repositories.PostRepository;
import com.example.programacion3.services.interfaces.IPostService;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PostServiceImpl implements IPostService {
    @Autowired
    private PostRepository postRepository;

    @Autowired
    private UserServiceImpl userService;

    @Override
    @Transactional
    public Post createPost(Post post) {
        return this.postRepository.save(post);
    }

    @Override
    @Transactional
    public Post createPost(String title, String description, User user) {
        return this.postRepository.save(new Post(title, description, user));
    }

    @Override
    @Transactional
    public Post createPost(String title, String description, List<ImageDTO> images) {
        User user = userService.getUserInfo();
        Post post = new Post(title, description, user);
        images.forEach(imageDTO -> post.addImage(new Image(imageDTO.getTitle(), imageDTO.getUrl(), post)));
        return this.postRepository.save(post);
    }

    @Override
    @Transactional(readOnly = true)
    public Post getPostById(Long id) {
        Post post = this.postRepository.findById(id).orElse(null);
        return post;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Post> getPostsByUser(User user) {
        return this.postRepository.findByUser(user);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Post> getPostsByFriends(User user) {
        List<Post> posts = new ArrayList<>();
        user.getFriends().forEach(friend -> posts.addAll(this.postRepository.findByUser(friend)));
        return posts;
    }

    @Override
    @Transactional
    public Post addImageToPost(Post post, Image image) {
        post.addImage(image);
        return this.postRepository.save(post);
    }

    @Override
    @Transactional
    public Post removeImageFromPost(Post post, Image image) {
        post.removeImage(image);
        return this.postRepository.save(post);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Post> getPosts() {
        List<Post> posts = new ArrayList<>();
        this.postRepository.findAll().forEach(posts::add);
        return posts;
    }
}

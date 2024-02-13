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

    @Autowired
    private ImageServiceImpl imageService;

    @Override
    @Transactional
    public Post createPost(Post post) {
        return this.postRepository.save(post);
    }

    @Override
    @Transactional
    public Post createPost(String title, String content, User user) {
        return this.postRepository.save(new Post(title, content, user));
    }

    @Override
    @Transactional
    public Post createPost(String title, String content, List<ImageDTO> images) {
        User user = userService.getUserInfo();
        Post post = new Post(title, content, user);
        images.forEach(imageDTO -> post.addImage(new Image(imageDTO.getTitle(), imageDTO.getUrl(), post)));
        return this.postRepository.save(post);
    }

    @Override
    @Transactional(readOnly = true)
    public Post getPostById(Long id) {
        Post post = this.postRepository.findById(id).orElse(null);
        post.getComments().sort((c1, c2) -> c2.getCreatedAt().compareTo(c1.getCreatedAt()));
        return post;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Post> getPostsByUser(User user) {
        return this.postRepository.findByUserOrderByCreatedAtDesc(user);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Post> getPostsByUser() {
        User user = userService.getUserInfo();
        return this.postRepository.findByUserOrderByCreatedAtDesc(user);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Post> getPostsByFriends(User user) {
        List<Post> posts = new ArrayList<>();
        user.getFriends().forEach(friend -> posts.addAll(this.postRepository.findByUserOrderByCreatedAtDesc(friend)));
        posts.sort((p1, p2) -> p2.getCreatedAt().compareTo(p1.getCreatedAt()));
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
        return this.postRepository.findAllByOrderByCreatedAtDesc();
    }

    @Override
    @Transactional
    public void deletePost(Long id) {
        this.postRepository.deleteById(id);
    }

    @Override
    @Transactional
    public Post updatePost(Long id, String title, String content, List<ImageDTO> images) {
        Post post = this.getPostById(id);
        post.setTitle(title);
        post.setContent(content);
        this.imageService.deleteImagesByPost(post);
        images.forEach(imageDTO -> this.imageService.createImage(imageDTO.getTitle(), imageDTO.getUrl(), post));
        return this.postRepository.save(post);
    }
}

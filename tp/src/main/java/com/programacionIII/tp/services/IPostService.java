package com.programacionIII.tp.services;


import com.programacionIII.tp.models.Post;
import com.programacionIII.tp.models.User;

import java.util.List;
import java.util.Optional;

public interface IPostService {

    public Post createPost(String imagePath,String description, User user);

    public Post updatePost(Post post, String imagePath,String description);

    public void deletePost(Post post);

    public Optional<Post> findByUser(User user);
    public Optional<Post> findByDescription(String description);

    public Optional<Post> findById(Long id);

    public List<Post> allPosts();
}

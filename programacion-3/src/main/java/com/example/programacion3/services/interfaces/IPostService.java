package com.example.programacion3.services.interfaces;

import com.example.programacion3.models.Image;
import com.example.programacion3.models.Post;
import com.example.programacion3.models.User;

import java.util.List;

public interface IPostService {
    Post createPost(Post post);
    Post createPost(String description, User user);
    Post getPostById(Long id);
    List<Post> getPostsByUser(User user);
    List<Post> getPostsByFriends(User user);
    Post addImageToPost(Post post, Image image);
    Post removeImageFromPost(Post post, Image image);

}

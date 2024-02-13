package com.example.programacion3.services.interfaces;

import com.example.programacion3.dto.Image.ImageDTO;
import com.example.programacion3.models.Image;
import com.example.programacion3.models.Post;
import com.example.programacion3.models.User;

import java.util.List;

public interface IPostService {
    Post createPost(Post post);
    Post createPost(String title, String content, User user);
    Post createPost(String title, String content, List<ImageDTO> images);
    Post getPostById(Long id);
    List<Post> getPostsByUser(User user);
    List<Post> getPostsByUser();
    List<Post> getPostsByFriends(User user);
    List<Post> getPostsByFriends();
    Post addImageToPost(Post post, Image image);
    Post removeImageFromPost(Post post, Image image);
    List<Post> getPosts();
    void deletePost(Long id);
    Post updatePost(Long id, String title, String content, List<ImageDTO> images);
}

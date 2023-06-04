package com.programacionIII.tp.services;


import com.programacionIII.tp.models.Post;

import java.util.List;

public interface IPostService {

    public Post createPost(String content, Long userId);

    public List<Post> findByUserId(Long userId);

    public List<Post> allPosts();
}

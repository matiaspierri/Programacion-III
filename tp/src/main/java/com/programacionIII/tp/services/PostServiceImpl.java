package com.programacionIII.tp.services;

import com.programacionIII.tp.models.Post;
import com.programacionIII.tp.models.User;
import com.programacionIII.tp.repositories.PostRepositoryImpl;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



import java.util.List;
import java.util.Optional;

@Service
public class PostServiceImpl implements IPostService{

    @Autowired
    private PostRepositoryImpl postRepository;

    @Override
    @Transactional
    public Post createPost(String imagePath, String description, User user) {
        Post post = new Post(imagePath, description, user);
        Post savedPost = postRepository.save(post);

        return savedPost;
    }

    @Override
    @Transactional
    public Post updatePost(Post post, String imagePath, String description) {
        Post postToModify = postRepository.findById(post.getId()).get();

        postToModify.setImagePath(imagePath);
        postToModify.setDescription(description);

        Post updatedPost = postRepository.save(postToModify);

        return updatedPost;
    }


    @Override
    @Transactional
    public void deletePost(Post post) {
        postRepository.delete(post);
    }

    @Override
    @Transactional
    public Optional<Post> findByDescription(String description) {
        return postRepository.findByDescription(description);
    }

    @Override
    @Transactional
    public Optional<Post> findByUser(User user) {
        return postRepository.findByUser(user);
    }



    @Override
    @Transactional
    public Optional<Post> findById(Long id) {
        return postRepository.findById(id);
    }

    @Override
    public List<Post> allPosts() {
        return (List<Post>) postRepository.findAll();
    }

}

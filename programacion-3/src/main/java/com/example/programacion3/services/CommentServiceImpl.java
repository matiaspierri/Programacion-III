package com.example.programacion3.services;

import com.example.programacion3.models.Comment;
import com.example.programacion3.models.Post;
import com.example.programacion3.models.User;
import com.example.programacion3.repositories.CommentRepository;
import com.example.programacion3.services.interfaces.ICommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;

@Service
public class CommentServiceImpl implements ICommentService {
    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private UserServiceImpl userService;

    @Autowired
    private PostServiceImpl postService;

    @Override
    @Transactional
    public Comment createComment(Comment comment) {
        return commentRepository.save(comment);
    }

    @Override
    @Transactional
    public Comment createComment(String text, User user, Post post) {
        return commentRepository.save(new Comment(text, user, post));
    }

    @Override
    @Transactional
    public Comment createComment(String text, Long postId){
        User user = userService.getUserInfo();
        Post post = postService.getPostById(postId);
        return commentRepository.save(new Comment(text, user, post));
    }

    @Override
    @Transactional(readOnly = true)
    public ArrayList<Comment> getCommentsByPostId(Long postId) {
        return commentRepository.findCommentsByPostIdOrderByCreatedAt(postId);
    }
}

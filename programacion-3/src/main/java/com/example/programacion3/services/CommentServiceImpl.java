package com.example.programacion3.services;

import com.example.programacion3.models.Comment;
import com.example.programacion3.models.Post;
import com.example.programacion3.models.User;
import com.example.programacion3.repositories.CommentRepository;
import com.example.programacion3.services.interfaces.ICommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CommentServiceImpl implements ICommentService {
    @Autowired
    private CommentRepository commentRepository;


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
}

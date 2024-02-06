package com.example.programacion3.services.interfaces;

import com.example.programacion3.models.Comment;
import com.example.programacion3.models.Post;
import com.example.programacion3.models.User;

public interface ICommentService {
    Comment createComment(Comment comment);
    Comment createComment(String text, User user, Post post);
}

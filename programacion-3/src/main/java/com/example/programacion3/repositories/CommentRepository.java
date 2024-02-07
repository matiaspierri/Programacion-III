package com.example.programacion3.repositories;

import com.example.programacion3.models.Comment;
import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;

public interface CommentRepository extends CrudRepository<Comment, Long> {
    public ArrayList<Comment> findCommentsByPostIdOrderByCreatedAt(Long postId);
}
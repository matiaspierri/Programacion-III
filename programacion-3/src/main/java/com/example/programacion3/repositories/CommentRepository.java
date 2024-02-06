package com.example.programacion3.repositories;

import com.example.programacion3.models.Comment;
import org.springframework.data.repository.CrudRepository;

public interface CommentRepository extends CrudRepository<Comment, Long> {
}
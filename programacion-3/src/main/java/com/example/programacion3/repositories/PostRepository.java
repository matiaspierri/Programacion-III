package com.example.programacion3.repositories;

import com.example.programacion3.models.Post;
import com.example.programacion3.models.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PostRepository extends CrudRepository<Post, Long> {
    List<Post> findByUserOrderByCreatedAtDesc(User user);
    List<Post> findAllByOrderByCreatedAtDesc();
}
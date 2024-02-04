package com.example.programacion3.repository;


import com.example.programacion3.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {
    // Here, you can define custom query methods if needed.
    // For example, finding Posts by User:
    List<Post> findByUserId(Long userId);

}
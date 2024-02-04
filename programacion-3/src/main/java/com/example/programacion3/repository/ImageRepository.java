package com.example.programacion3.repository;

import com.example.programacion3.model.Image;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ImageRepository extends JpaRepository<Image, Long> {

    // Example custom query method to find images by post id
    List<Image> findByPostId(Long postId);

    // Additional custom query methods can be defined here as needed
}
package com.example.programacion3.repositories;

import com.example.programacion3.models.Image;
import com.example.programacion3.models.Post;
import com.example.programacion3.models.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ImageRepository extends CrudRepository<Image, Long> {
    void deleteAllByPost(Post post);
}
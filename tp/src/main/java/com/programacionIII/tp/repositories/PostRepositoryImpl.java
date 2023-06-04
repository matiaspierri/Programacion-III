package com.programacionIII.tp.repositories;

import com.programacionIII.tp.models.Post;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.util.List;


@Repository
public interface PostRepositoryImpl  extends CrudRepository<Post, Long> {

    List<Post> findById(Long id);

    List<Post> findAll();


}

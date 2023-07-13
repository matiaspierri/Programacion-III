package com.programacionIII.tp.repositories;

import com.programacionIII.tp.models.Post;
import com.programacionIII.tp.models.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;


@Repository
public interface PostRepositoryImpl  extends CrudRepository<Post, Long> {

    Optional<Post> findById(Long id);
    Optional<Post> findByDescription(String description);

    Optional<Post> findByUser(User user);

    List<Post> findAll();


}

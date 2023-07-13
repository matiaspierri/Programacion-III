package com.programacionIII.tp.repositories;

import com.programacionIII.tp.models.User;
import jakarta.transaction.Transactional;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


public interface UserRepositoryImpl extends CrudRepository<User, Long> {

    Optional<User> findByUsername(String username);

    List<User> findAll();

}

package com.example.programacion3.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

import com.example.programacion3.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    // Finds a user by username. Useful for authentication, checking if a user exists, etc.
    Optional<User> findByUsername(String username);

    // Additional custom queries can be defined here
}
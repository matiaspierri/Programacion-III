package com.example.programacion3.service;

import com.example.programacion3.model.Role;
import com.example.programacion3.model.User;

import java.util.Optional;

public interface UserService {
    User saveUser(User user);
    Optional<User> findByUsername(String username);
    Optional<User> findById(Long id);
    void deleteUser(Long id);
    String authenticate(String username, String password);



    User createUser(User user);
    Role createRole(Role role);
    User getUserInfo();
}
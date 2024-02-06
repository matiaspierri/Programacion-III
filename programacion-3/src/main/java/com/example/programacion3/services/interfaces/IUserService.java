package com.example.programacion3.services.interfaces;


import com.example.programacion3.models.Role;
import com.example.programacion3.models.User;

import java.util.ArrayList;

public interface IUserService {
    User createUser(User user);
    User createUser(String username, String password, String role);
    Role createRole(Role role);
    boolean checkUserById(Long id);
    String authenticate(String username, String password);
    User getUserInfo();
    ArrayList<User> getAllEmployees();
    User updateUser(Long id, String username, String password, String role);
    void deleteUser(Long id);
}
package com.example.programacion3.services.interfaces;


import com.example.programacion3.models.Role;
import com.example.programacion3.models.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public interface IUserService {
    User createUser(User user);
    Role createRole(Role role);
    boolean checkUserById(Long id);
    String authenticate(String username, String password);
    User getUserInfo();
    User getUserInfo(Long id);
    Set<User> getFriends();
    Set<User> getFriends(Long id);
    User addFriend(Long id);
    User addFriend(Long userId, Long friendId);
    User removeFriend(Long id);
    User removeFriend(Long userId, Long friendId);
    String register(String username, String password, String email);
    User getByUsername(String username);
    User addFriend(String username);
    void deleteUser(Long id);
    List<User> getUsers();
    User update(String username, String email);
}
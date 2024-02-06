package com.example.programacion3.services.interfaces;


import com.example.programacion3.models.Role;
import com.example.programacion3.models.User;

import java.util.ArrayList;
import java.util.List;

public interface IUserService {
    User createUser(User user);
    Role createRole(Role role);
    boolean checkUserById(Long id);
    String authenticate(String username, String password);
    User getUserInfo();
    List<User> getFriends(User user);
    User addFriend(User user, User friend);
    User removeFriend(User user, User friend);
}
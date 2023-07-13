package com.programacionIII.tp.services;
import com.programacionIII.tp.models.User;
import java.util.List;
import java.util.Optional;
import com.programacionIII.tp.models.Role;


public interface IUserService {


    Optional<User> findByUsername(String username);
    List<User> allUsers();

    User createUser(User user);
    Role createRole(Role role);
    boolean checkUserById(Long id);
    String authenticate(String username, String password);
    User getUserInfo();
}


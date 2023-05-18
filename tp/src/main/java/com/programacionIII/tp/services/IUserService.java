package com.programacionIII.tp.services;
import com.programacionIII.tp.models.User;
import java.util.List;



public interface IUserService {
    public User createUser(String firstname, String lastname, String username, String phone, List<Integer> friendsIds);
    User findByUsername(String username);
}


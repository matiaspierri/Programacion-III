package com.programacionIII.tp.services;

import com.programacionIII.tp.models.User;
import com.programacionIII.tp.repositories.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements IUserService{

    @Autowired
    private IUserRepository userRepository;


    @Override
    public User createUser(String firstname, String lastname, String username, String phone, List<Integer> friendsIds) {
        User user = new User(firstname, lastname, username, phone, friendsIds);

        User savedUser = userRepository.saveUser(user);

        return savedUser;


    }


}

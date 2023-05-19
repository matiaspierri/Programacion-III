package com.programacionIII.tp.services;

import com.programacionIII.tp.models.User;
import com.programacionIII.tp.repositories.UserRepositoryImpl;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



import java.util.List;

@Service
public class UserServiceImpl implements IUserService{

    @Autowired
    private UserRepositoryImpl userRepository;

    @Override
    @Transactional
    public List<User> findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public User createUser(String firstname, String lastname, String username, String phone, List<Integer> friendsIds) {
        User user = new User(firstname, lastname, username, phone, friendsIds);
        User savedUser = userRepository.save(user);
        return savedUser;
    }

    @Override
    @Transactional()
    public List<User> allUsers() {
        return (List<User>) userRepository.findAll();
    }




}

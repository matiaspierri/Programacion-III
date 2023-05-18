package com.programacionIII.tp.controllers;

import com.programacionIII.tp.services.IUserService;
import com.programacionIII.tp.services.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import com.programacionIII.tp.models.*;
import org.springframework.stereotype.Controller;

@Controller
public class UserController {
    @Autowired
    private IUserService userService;

    public User createUser(String firstname, String lastname, String username, String phone, List<Integer> friendsIds) {
        return userService.createUser(firstname, lastname, username, phone, friendsIds);
    }







}

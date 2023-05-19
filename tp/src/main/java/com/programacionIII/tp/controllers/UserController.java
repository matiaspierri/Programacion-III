package com.programacionIII.tp.controllers;

import com.programacionIII.tp.services.IUserService;
import com.programacionIII.tp.services.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import com.programacionIII.tp.models.*;
import org.springframework.stereotype.Controller;



@RestController
@RequestMapping(value = "/api/user")
@CrossOrigin(
        origins = "*",
        methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE}
)

public class UserController {
    @Autowired
    private UserServiceImpl userService;


    public UserController() {

    }
    @PostMapping("/create")
    public User createUser(@RequestBody User user) {
        return userService.createUser(user.getFirstname(), user.getLastname(), user.getUsername(), user.getPhone(), user.getFriendsIds());
    }

    @GetMapping(path="/hello-world")
    public String HelloWorld(){
        return "Hello World";
    }

    @GetMapping(path = "/all")
    public List<User> getAllUsers() {
        return this.userService.allUsers();
    }

}

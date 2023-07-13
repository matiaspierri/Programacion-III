package com.programacionIII.tp.controllers;

import com.programacionIII.tp.repositories.UserRepositoryImpl;
import com.programacionIII.tp.services.IUserService;
import com.programacionIII.tp.services.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import com.programacionIII.tp.models.*;
import org.springframework.stereotype.Controller;



@RestController
@RequestMapping(value = "/api/user")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class UserController {
    @Autowired
    private UserServiceImpl userService;


    public UserController() {

    }
    @PostMapping("/create")
    public User createUser(@RequestBody User user) {

        // print password
        System.out.println("Password: " + user.getPassword());
        return userService.createUser(user);
    }

    @GetMapping(path="/hello-world")
    public String HelloWorld()

    {


        Role role = new Role("ROLE_USER");

        Role savedRole = userService.createRole(role);

        User user = new User("name1","123",savedRole);

        User userCreated = userService.createUser(user);

        return "Hello World";
    }

    @GetMapping(path = "/all")
    public List<User> getAllUsers() {
        return this.userService.allUsers();
    }


    @GetMapping(path = "/authenticatedinfo")
    public Authentication info() {
        return SecurityContextHolder.getContext().getAuthentication();
    }

    @GetMapping(path = "")
    public User getUserInfo() {
        return this.userService.getUserInfo();
    }

}

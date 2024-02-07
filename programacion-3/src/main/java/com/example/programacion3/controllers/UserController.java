package com.example.programacion3.controllers;

import com.example.programacion3.models.User;
import com.example.programacion3.services.interfaces.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/user")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class UserController {

    @Autowired
    private IUserService userService;

    @GetMapping(path = "/authenticatedinfo")
    public Authentication info() {
        return SecurityContextHolder.getContext().getAuthentication();
    }

    @GetMapping(path = "")
    public User getUserInfo() {
        return this.userService.getUserInfo();
    }

    @GetMapping(path = "/friends")
    public Iterable<User> getFriends() {
        return this.userService.getFriends();
    }

    @PostMapping(path = "/addfriend/{id}")
    public User addFriend(@PathVariable Long id) {
        return this.userService.addFriend(id);
    }

    @DeleteMapping(path = "/removefriend/{id}")
    public User removeFriend(@PathVariable Long id) {
        return this.userService.removeFriend(id);
    }
}

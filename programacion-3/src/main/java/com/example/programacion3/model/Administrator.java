package com.example.programacion3.model;

import jakarta.persistence.*;

import java.util.List;
@Entity
public class Administrator extends User {
    // Additional fields and methods specific to administrators
    private Boolean canModifyUsers;
    private Boolean canDeletePosts;


public Administrator(Long id, String username, String password, String email, List<Post> posts, List<User> friends, Boolean canModifyUsers, Boolean canDeletePosts) {
        super(id, username, password, email, posts, friends);
        this.canModifyUsers = canModifyUsers;
        this.canDeletePosts = canDeletePosts;
    }


}
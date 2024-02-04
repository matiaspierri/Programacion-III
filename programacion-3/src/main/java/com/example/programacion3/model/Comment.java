package com.example.programacion3.model;

import jakarta.persistence.*;

import java.util.List;
@Entity
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String text;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "post_id")
    private Post post;

    // Constructor, getters, and setters
    public Comment(Long id, String text, User user, Post post) {
        this.id = id;
        this.text = text;
        this.user = user;
        this.post = post;
    }
}
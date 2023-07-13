package com.programacionIII.tp.models;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Gallery {

    @Id
    @Column(name = "id_gallery")
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @OneToMany
    @JoinColumn(nullable = true)
    private List<Post> posts;

    @OneToOne
    @JoinColumn(nullable = false)
    private User user;

    private String name;

    public Gallery(){}



    public Gallery(User user, String name){
        this.posts = new ArrayList<>();
        this.user = user;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // Append post to list
    public void addPost(Post post){
        this.posts.add(post);
    }

    // Remove post from list
    public void deletePost(Post post){
        this.posts.remove(post);
    }

    // Get all posts
    public List<Post> getPosts(){
        return this.posts;
    }


}

package com.programacionIII.tp.models;

public class Gallery {

    private List<Post> posts;

    private User user;

    public Gallery(User user){
        this.posts = new ArrayList<>();
        this.user = user;
    }

}

package com.programacionIII.tp.models;

import java.util.ArrayList;
import java.util.List;

public class Gallery {

    private List<Post> posts;

    private User user;

    public Gallery(User user){
        this.posts = new ArrayList<>();
        this.user = user;
    }

}

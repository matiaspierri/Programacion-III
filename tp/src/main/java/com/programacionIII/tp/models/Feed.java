package com.programacionIII.tp.models;

import java.util.ArrayList;
import java.util.List;

public class Feed {
    private List<Post> posts;

    private Feed feed;

    private Feed(){
        this.posts = new ArrayList<>();
    }

    public static Feed createFeed(){
        if(this.feed == null){
            this.feed = new Feed();
        } else {
            throw new Exception("Feed already exists");
        }
    }

    public void addPost(Post post){
        this.posts.add(post);
    }

    public void deletePost(Post post){
        this.posts.remove(post);
    }

}

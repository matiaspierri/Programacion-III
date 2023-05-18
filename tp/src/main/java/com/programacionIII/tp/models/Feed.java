package com.programacionIII.tp.models;

import java.util.ArrayList;
import java.util.List;

public class Feed {
    private List<Post> posts;

    private static Feed feed;

    private Feed(){
        this.posts = new ArrayList<>();
    }

    public static Feed createFeed(){
        if(feed == null){
            feed = new Feed();
        }
        return feed;
    }

    public void addPost(Post post){
        this.posts.add(post);
    }

    public void deletePost(Post post){
        this.posts.remove(post);
    }

}

package com.programacionIII.tp.models;
import java.util.List;



public class Post {


    private String imagePath;
    private String description;
    private int likeCount;
    private List<String> recomendations;

    // generate constructor
    public Post(String imagePath, String description, int likeCount, List<String> recomendations) {
        this.imagePath = imagePath;
        this.description = description;
        this.likeCount = likeCount;
        this.recomendations = recomendations;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getLikeCount() {
        return likeCount;
    }

    public void setLikeCount(int likeCount) {
        this.likeCount = likeCount;
    }

    public List<String> getRecomendations() {
        return recomendations;
    }

    public void setRecomendations(List<String> recomendations) {
        this.recomendations = recomendations;
    }
}

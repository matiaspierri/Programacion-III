package com.programacionIII.tp.models;
import jakarta.persistence.*;

import java.util.List;



@Entity
public class Post {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @Column
    private String imagePath;
    @Column
    private String description;
    @Column
    private int likeCount;
    @Transient
    private List<String> recomendations;

    @ManyToOne(cascade = {CascadeType.MERGE})
    private User user;

    // generate constructor
    public Post(String imagePath, String description, int likeCount) {
        this.imagePath = imagePath;
        this.description = description;
        this.likeCount = likeCount;
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

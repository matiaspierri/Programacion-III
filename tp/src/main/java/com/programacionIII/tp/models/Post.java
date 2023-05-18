package com.programacionIII.tp.models;
import jakarta.persistence.*;

import java.util.List;



@Entity
public class Post {
    @Id
    @Column(name = "id_post")
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    private String imagePath;
    private String description;
    private int likeCount;
    private List<String> recomendations;

    @ManyToOne(cascade = {CascadeType.MERGE})
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

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

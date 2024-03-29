package com.example.programacion3.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "posts")
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_post")
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String content;

    @ManyToOne
    @JoinColumn(name = "id_user", nullable = false)
    private User user;

    @OneToMany(mappedBy = "post", cascade = {CascadeType.PERSIST, CascadeType.REMOVE}, fetch = FetchType.LAZY)
    private List<Image> images = new ArrayList<>();

    @OnDelete(action = OnDeleteAction.CASCADE)
    @OneToMany(mappedBy = "post", cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
    private List<Comment> comments = new ArrayList<>();

    @CreationTimestamp
    private LocalDateTime createdAt;

    public Post() {
    }

    public Post(String title, String content, User user) {
        this.title = title;
        this.content = content;
        this.user = user;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public Long getId(){
        return this.id;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getTitle(){
        return this.title;
    }
    public void setContent(String content) {
        this.content = content;
    }
    public String getContent(){
        return this.content;
    }
    public void setUser(User user) {
        this.user = user;
    }
    public User getUser(){
        return this.user;
    }
    public void setImages(List<Image> images) {
        this.images = images;
    }
    public List<Image> getImages(){
        return this.images;
    }
    public void addImage(Image image){
        this.images.add(image);
    }
    public void removeImage(Image image){
        this.images.remove(image);
    }
    public void clearImages(){
        this.images.clear();
    }
    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }
    public List<Comment> getComments(){
        return this.comments;
    }
    public LocalDateTime getCreatedAt(){
        return this.createdAt;
    }
}

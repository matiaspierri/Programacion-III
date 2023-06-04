package com.programacionIII.tp.models;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column()
    private Long id;
    @Column
    private String firstname;
    @Column
    private String lastname;
    @Column
    private String username;
    @Column
    private String phone;

    private List<Integer> friendsIds;

    @OneToMany(mappedBy = "user", cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
    private List<Post> posts;


    @OneToMany(mappedBy = "user", cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
    private List<Gallery> galleries;


    public User(){}
    public User(String firstname, String lastname, String username, String phone, List<Integer> friendsIds){
        this.firstname=firstname;
        this.lastname=lastname;
        this.username=username;
        this.phone=phone;
        this.friendsIds=friendsIds;
    }




    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public List<Integer> getFriendsIds() {
        return friendsIds;
    }

    public void setFriendsIds(List<Integer> friendsIds) {
        this.friendsIds = friendsIds;
    }
}

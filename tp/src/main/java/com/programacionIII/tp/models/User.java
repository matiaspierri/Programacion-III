package com.programacionIII.tp.models;

import java.util.List;

public class User {


    private String firstname;
    private String lastname;
    private String username;
    private String phone;
    private List<Integer> friendsIds;

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

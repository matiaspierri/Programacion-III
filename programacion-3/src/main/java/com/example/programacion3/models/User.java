package com.example.programacion3.models;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "users")
public class User implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_user")
    private Long id;

    @Column(length = 100, nullable = false)
    private String username;

    @Column(length = 100, nullable = false)
    @JsonIgnore
    private String password;

    @Column(length = 100, nullable = false)
    private String email;

    @ManyToOne(fetch = FetchType.EAGER,cascade = {})
    @JoinColumn(name = "id_role", nullable = false)
    private Role role;

    @OneToMany(mappedBy = "user", cascade = {CascadeType.PERSIST, CascadeType.REMOVE}, fetch = FetchType.LAZY)
    private List<Post> posts = new ArrayList<>();

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "friends",
            joinColumns = @JoinColumn(name = "id_user"),
            inverseJoinColumns = @JoinColumn(name = "id_friend")
    )
    private List<User> friends = new ArrayList<>();

    public User() {
    }

    public User(String username, String password, String email,  Role role, List<Post> posts, List<User> friends) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.posts = Objects.requireNonNullElseGet(posts, ArrayList::new);
        this.friends = Objects.requireNonNullElseGet(friends, ArrayList::new);
        this.role = role;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority(role.getName()));
        return authorities;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

public void setEmail(String email) {
        this.email = email;
    }

public List<Post> getPosts() {
        return posts;
    }

public void setPosts(List<Post> posts) {
        this.posts = posts;
    }

public List<User> getFriends() {
        return friends;
    }

public void setFriends(List<User> friends) {
        this.friends = friends;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}

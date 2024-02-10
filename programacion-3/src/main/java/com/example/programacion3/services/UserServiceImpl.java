package com.example.programacion3.services;

import com.example.programacion3.authentication.JwtUtilities;
import com.example.programacion3.models.Role;
import com.example.programacion3.models.User;
import com.example.programacion3.repositories.RoleRepository;
import com.example.programacion3.repositories.UserRepository;
import com.example.programacion3.services.interfaces.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private JwtUtilities jwtUtilities;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private AuthenticationManager authenticationManager ;

    @Override
    public User createUser(User user) {
        String password = user.getPassword();
        user.setPassword(passwordEncoder.encode(password));
        return this.userRepository.save(user);
    }

    @Override
    public Role createRole(Role role) {
        return this.roleRepository.save(role);
    }

    @Override
    public boolean checkUserById(Long id) {
        return this.userRepository.existsById(id);
    }

    @Override
    public String authenticate(String username, String password) {
        User user = this.userRepository.findByUsername(username).orElse(null);
        if (user == null) { return null; }
        if (!passwordEncoder.matches(password, user.getPassword())) { return null; }
        return jwtUtilities.generateToken(user.getUsername(), user.getId(), user.getRole().getName());
    }

    @Override
    public User getUserInfo() {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        return this.userRepository.findByUsername(username).orElse(null);
    }

    @Override
    @Transactional(readOnly = true)
    public Set<User> getFriends(){
        User user = this.getUserInfo();
        return user.getFriends();
    }

    @Override
    @Transactional
    public User addFriend(Long id){
        User user = this.getUserInfo();
        return this.addFriend(user.getId(), id);
    }
    @Override
    @Transactional
    public User addFriend(Long userId, Long friendId){
        if(userId.equals(friendId)) { return null; } // Can't add yourself as a friend
        User user = this.userRepository.findById(userId).orElse(null);
        User friend = this.userRepository.findById(friendId).orElse(null);
        if (user == null || friend == null) { return null; }
        user.addFriend(friend);
        return this.userRepository.save(user);
    }

    @Override
    @Transactional
    public User addFriend(String username){
        User user = this.getUserInfo();
        if(username.equals(user.getUsername())) { return null; } // Can't add yourself as a friend
        User friend = this.userRepository.findByUsername(username).orElse(null);
        if (friend == null) { return null; }
        user.addFriend(friend);
        return this.userRepository.save(user);
    }

    @Override
    @Transactional
    public User removeFriend(Long id){
        User user = this.getUserInfo();
        return this.removeFriend(user.getId(), id);
    }
    @Override
    @Transactional
    public User removeFriend(Long userId, Long friendId){
        User user = this.userRepository.findById(userId).orElse(null);
        User friend = this.userRepository.findById(friendId).orElse(null);
        if (user == null || friend == null) { return null; }
        user.removeFriend(friend);
        return this.userRepository.save(user);
    }

    @Override
    @Transactional
    public String register(String username, String password, String email) {
        Role userRole = this.roleRepository.findByName("USER").orElse(null);
        if (userRole == null) { return null; }
        if(this.userRepository.existsByUsername(username)) { return null; }
        User user = new User(username, password, email, userRole);
        this.createUser(user);
        return this.authenticate(username, password);
    }

    @Override
    public User getByUsername(String username) {
        return this.userRepository.findByUsername(username).orElse(null);
    }


}

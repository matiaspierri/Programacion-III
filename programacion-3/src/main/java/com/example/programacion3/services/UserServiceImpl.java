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

import java.util.ArrayList;
import java.util.List;

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
    public List<User> getFriends(User user){
        return user.getFriends();
    }
    @Override
    public User addFriend(User user, User friend){
        user.getFriends().add(friend);
        return this.userRepository.save(user);
    }
    @Override
    public User removeFriend(User user, User friend){
        user.getFriends().remove(friend);
        return this.userRepository.save(user);
    }
}

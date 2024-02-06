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
    public User createUser(String username, String password, String role) {
        User user = new User();
        user.setUsername(username);
        user.setPassword(passwordEncoder.encode(password));
        user.setRole(this.roleRepository.findByName(role).orElse(null));
        if(user.getRole() == null) {
            this.roleRepository.save(new Role(role));
            user.setRole(this.roleRepository.findByName(role).orElse(null));
        }
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
    public ArrayList<User> getAllEmployees() {
        return this.userRepository.findAllByRole_Name("EMPLOYEE");
    }

    @Override
    public User updateUser(Long id, String username, String password, String role) {
        User user = this.userRepository.findById(id).orElse(null);
        if(user == null) { return null; }
        user.setUsername(username);
        user.setPassword(passwordEncoder.encode(password));
        user.setRole(this.roleRepository.findByName(role).orElse(null));
        return this.userRepository.save(user);
    }

    @Override
    public void deleteUser(Long id) {
        this.userRepository.deleteById(id);
    }

}

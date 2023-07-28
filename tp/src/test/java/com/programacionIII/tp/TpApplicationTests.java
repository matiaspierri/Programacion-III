package com.programacionIII.tp;

import com.programacionIII.tp.models.Post;
import com.programacionIII.tp.repositories.RoleRepository;
import com.programacionIII.tp.repositories.UserRepositoryImpl;
import com.programacionIII.tp.services.IPostService;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.programacionIII.tp.services.IUserService;
import com.programacionIII.tp.models.User;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import com.programacionIII.tp.models.Role;


@SpringBootTest
@ExtendWith(SpringExtension.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class TpApplicationTests {

    @Autowired
    private IUserService userService;

    @Autowired
    private IPostService postService;

    @Autowired
    private UserRepositoryImpl userRepository;

    @Autowired
    private RoleRepository roleRepository;

    // Test to create user
    @Test
    void createUser() {
        Role role = new Role("ROLE_USER");


        roleRepository.save(role);

        User user = new User("name1","123",role);

        //User userCreated = userService.createUser(user);
        User saved = userRepository.save(user);

        saved.setPassword("1234");

        assert (saved.getUsername() == "name1");

        assert (saved.getPassword().equals("1234"));
    }

    // Test to find user by username
    @Test
    void findUserByUsername() {

        Role role = new Role("ROLE_USER");


        roleRepository.save(role);

        User user = new User("name1","123",role);

        User saved = userRepository.save(user);

        User userFound = userRepository.findByUsername("name1").get();

        assert(Objects.equals(userFound.getUsername(), "name1"));


    }


}



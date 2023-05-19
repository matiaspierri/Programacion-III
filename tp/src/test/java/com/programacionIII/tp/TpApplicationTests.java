package com.programacionIII.tp;

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



@SpringBootTest
@ExtendWith(SpringExtension.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class TpApplicationTests {

    @Autowired
    private IUserService userService;


    @Test
    void testCreateUser() {
        userService.createUser("Juan", "Perez", "juanperez", "12345678", null);
        User user = userService.findByUsername("juanperez").get(0);

        assert(user.getFirstname().equals("Juan"));
    }

    @Test
    void allUsers() {
        List<User> users = userService.allUsers();
        assert (users.size() > 0);
    }


}



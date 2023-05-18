package com.programacionIII.tp;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.programacionIII.tp.services.IUserService;
import com.programacionIII.tp.models.User;

@SpringBootTest

class TpApplicationTests {

    @Autowired
    private IUserService userService;

    @BeforeAll
    void beforeAll() {
        userService.createUser("Juan", "Perez", "juanperez", "12345678", null);
    }

    @Test
    void contextLoads() {
        //userService.createUser("Juan", "Perez", "juanperez", "12345678", null);
        //User user = userService.findByUsername("juanperez");
        assert(true);
    }

}



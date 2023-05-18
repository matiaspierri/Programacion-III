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



@SpringBootTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class TpApplicationTests {

    @Autowired
    private IUserService userService;

//    @BeforeAll
//    void beforeAll() {
//        userService.createUser("Juan", "Perez", "juanperez", "12345678", null);
//    }
//
    @Test
    void contextLoads() {
        //userService.createUser("Juan", "Perez", "juanperez", "12345678", null);
        //User user = userService.findByUsername("juanperez");
        assert(true);
    }

}



package com.example.programacion3;

import com.example.programacion3.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DataAccessException;

@SpringBootTest
class Programacion3ApplicationTests {

	@Test
	void contextLoads() {
	}

	@Autowired
	private UserRepository userRepository;

	@Test
	void testConnection() {
		try {
			userRepository.count(); // Simple call to test the connection
		} catch (DataAccessException e) {
			assert false : "Database connection failed";
		}
	}

}

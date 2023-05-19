package com.programacionIII.tp;

import org.apache.commons.lang3.math.Fraction;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.apache.commons.lang3.*;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
@SpringBootApplication
public class TpApplication {

	public static void main(String[] args) {
		SpringApplication.run(TpApplication.class, args);
	}

}

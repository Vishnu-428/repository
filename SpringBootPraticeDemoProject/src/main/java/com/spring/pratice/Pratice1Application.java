package com.spring.pratice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan("com.spring.pratice.*")
public class Pratice1Application {

	public static void main(String[] args) {
		SpringApplication.run(Pratice1Application.class, args);
	}

}

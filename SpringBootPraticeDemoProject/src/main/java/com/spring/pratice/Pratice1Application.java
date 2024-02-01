package com.spring.pratice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class Pratice1Application {

	public static void main(String[] args) {
		SpringApplication.run(Pratice1Application.class, args);
	}

}

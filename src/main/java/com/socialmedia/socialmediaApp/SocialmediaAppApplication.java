package com.socialmedia.socialmediaApp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
public class SocialmediaAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(SocialmediaAppApplication.class, args);
	}

}

package com.learn.resourceserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;

@SpringBootApplication

public class ResourceserverApplication {

	public static void main(String[] args) {

		SpringApplication.run(ResourceserverApplication.class, args);
		System.out.println("resource");
	}

}

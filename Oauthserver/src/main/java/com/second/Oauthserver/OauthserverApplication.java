package com.second.Oauthserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class OauthserverApplication {

	public static void main(String[] args) {

		SpringApplication.run(OauthserverApplication.class, args);
		System.out.println("authorization server");
	}

}

package com.second.Oauthserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@SpringBootApplication
public class OauthserverApplication {

	public static void main(String[] args) {

		SpringApplication.run(OauthserverApplication.class, args);
		System.out.println("authorization server");
        //R apply(T t);
		List<String> list = Arrays.asList("rushikesh", "abhi", "kishan", "sachin");
		Map<Integer, List<String>> collect = list.stream().collect(Collectors.groupingBy(name -> name.length()));
		System.out.println(collect);
	}

}

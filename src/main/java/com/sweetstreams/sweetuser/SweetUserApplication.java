package com.sweetstreams.sweetuser;

import com.github.javafaker.Faker;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.function.Supplier;

@SpringBootApplication
public class SweetUserApplication {

	public static void main(String[] args) {
		SpringApplication.run(SweetUserApplication.class, args);
	}

	private Faker faker = new Faker();

	@Bean
	Supplier<User> newUser(){
		return () -> {
			User user = new User(faker.internet().uuid(), faker.internet().emailAddress());

			return user;
		};
	}
	public record User(String uid, String emailAddress){

	}
}

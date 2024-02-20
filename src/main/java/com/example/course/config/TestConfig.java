package com.example.course.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.example.course.entities.User;
import com.example.course.repositories.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner{

	@Autowired
	private UserRepository repository;
	
	@Override
	public void run(String... args) throws Exception {
		User u1 = new User(null, "maria", "maria@gmail.com", "47988210669");
		User u2 = new User(null, "joao", "joao@gmail.com", "47987654321");
		
		repository.saveAll(Arrays.asList(u1, u2));
		
	}

	
	
	
}

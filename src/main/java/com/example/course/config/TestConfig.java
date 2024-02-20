package com.example.course.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.example.course.entities.Category;
import com.example.course.entities.Order;
import com.example.course.entities.User;
import com.example.course.entities.enums.OrderStatus;
import com.example.course.repositories.CategoryRepository;
import com.example.course.repositories.OrderRepository;
import com.example.course.repositories.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner{

	@Autowired
	private UserRepository repository;
	
	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	
	@Override
	public void run(String... args) throws Exception {
		

		Category cat1 = new Category(null, "Electronics");
		Category cat2 = new Category(null, "Books");
		Category cat3 = new Category(null, "Computers");
		
		User u1 = new User(null, "maria", "maria@gmail.com", "47988210669");
		User u2 = new User(null, "joao", "joao@gmail.com", "47987654321");
		
		Order o1 = new Order(null, Instant.parse("2024-01-20T19:53:07Z"), OrderStatus.PAID,  u1);
		Order o2 = new Order(null, Instant.parse("2024-02-21T03:42:10Z"),OrderStatus.WAITING_PAIMENT, u2);
		Order o3 = new Order(null, Instant.parse("2024-02-22T15:21:22Z"), OrderStatus.WAITING_PAIMENT, u1);
		
		categoryRepository.saveAll(Arrays.asList(cat1, cat2, cat3));
		repository.saveAll(Arrays.asList(u1, u2));
		orderRepository.saveAll(Arrays.asList(o1, o2, o3));
		
	}

	
	
	
}

package com.example.course.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.course.entities.Order;
import com.example.course.repositories.OrderRepository;

@Service
public class OrderService {

	@Autowired
	private OrderRepository oRepository;
	
	
	public List<Order> findAll(){
		return oRepository.findAll();
		
	}
	
	public Order findById(Long id) {
		Optional<Order> obj = oRepository.findById(id);
		return obj.get();
	}
	
}

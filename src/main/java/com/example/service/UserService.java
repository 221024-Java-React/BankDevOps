package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.models.User;
import com.example.repository.UserRepository;


@Service
@Transactional
public class UserService {
	
	@Autowired
	private UserRepository ur;
	
	public User createUser(User u) {
		return ur.save(u);
	}
	
	public User getUserByEmail(String email) {
		return ur.findByEmail(email).orElseThrow();
	}
	
	public User getUserById(int id) {
		return ur.findById(id).orElseThrow();
	}

}

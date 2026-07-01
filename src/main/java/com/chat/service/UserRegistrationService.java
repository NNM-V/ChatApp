package com.chat.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.chat.controller.form.UserRegistrationForm;
import com.chat.repository.UserRepository;
import com.chat.repository.entity.UserRegistration;

@Service
public class UserRegistrationService {
	
	@Autowired
	private UserRepository repo;
	@Autowired
	PasswordEncoder passwordEncoder;
	
	//save 
	public void addUser(UserRegistrationForm form) {
		UserRegistration entity = new UserRegistration();
		entity.setUserEmail(form.getUserEmail());
		entity.setUserName(form.getUserName());
		entity.setPassword(passwordEncoder.encode(form.getPassword()));
		entity.setBirthday(form.getBirthday());
		entity.setRole("USER");
		
		repo.save(entity); 
	}
}

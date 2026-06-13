package com.chat.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chat.controller.form.SignUpForm;
import com.chat.repository.SignUpRepository;
import com.chat.repository.entity.User;

@Service
public class SignUpService {
	
	@Autowired
	private SignUpRepository repo;
	
	//Read operation
	public List<User> fetchUserList(){
		return repo.findAll();
	}
	
	//save 
	public void addUser(SignUpForm form) {
		User entity = new User();
		entity.setUserEmail(form.getUserEmail());
		entity.setUserName(form.getUserName());
		entity.setPassword(form.getPassword());
		entity.setBirthday(form.getBirthday());
		
		repo.save(entity); 
	}
}

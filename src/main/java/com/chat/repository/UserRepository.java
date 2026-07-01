package com.chat.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.chat.repository.entity.UserRegistration;

@Repository
public interface UserRepository extends JpaRepository<UserRegistration,Long>{
	//Find user on SQL from username
	UserRegistration findByUserName(String userName);
	//Check if user exists on database from Email
	boolean existsByUserEmail(String userName);
	//Check if user exists on database from username
	boolean existsByUserName(String userName);
}

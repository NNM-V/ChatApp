package com.chat.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.chat.repository.entity.User;

@Repository
public interface SignUpRepository extends JpaRepository<User,Long>{
	
	//Check if userId and password exists in the databa
	boolean existsByUserEmail(String userEmail);
	User findByUserEmail(String userEmail);
}

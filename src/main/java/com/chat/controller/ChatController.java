package com.chat.controller;

import java.security.Principal;
import java.text.SimpleDateFormat;
import java.util.Date;

import jakarta.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.GetMapping;

import com.chat.repository.SignUpRepository;
import com.chat.repository.entity.User;
import com.chat.service.dto.ChatMessage;
import com.chat.service.dto.OutputMessage;

public class ChatController {
	@Autowired
	SimpMessagingTemplate simpleMessagingTemplate;
	@Autowired
	SignUpRepository repo;
	
	@GetMapping("/chat")
	public String chat(HttpSession session) {
		//Get userId saved in session
		Long userId = (Long) session.getAttribute("userId");
		//Return to login page if userId does not exists in session and mypage was called
		if(userId == null) {
			return "login";
		}
		
		return "chat";
	}
	
	@MessageMapping("/hello")
	public void sendMessage(@Payload ChatMessage msg, Principal sender, 
							@Header("SessionId") String SessionId, HttpSession session) throws Exception{
		Long userId = (Long) session.getAttribute("userId");
		User user = repo.findById(userId).orElse(null);
		
		Long receiverId = (Long) session.getAttribute("receiverId");
		User receiver = repo.findById(receiverId).orElse(null);
		
		OutputMessage out = new OutputMessage(user.getUserName(), msg.getText(), new SimpleDateFormat("HH:mm").format(new Date()));
		
		new SimpleDateFormat("HH:mm").format(new Date()); 
		simpleMessagingTemplate.convertAndSendToUser(receiver.getUserName(), "/user/queue/specific-user", out);
	}
}
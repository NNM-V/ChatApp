package com.chat.controller;

import java.security.Principal;

import jakarta.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.chat.repository.UserRepository;
import com.chat.service.dto.ChatMessage;
import com.chat.service.dto.OutputMessage;

@Controller
public class ChatController {
	@Autowired
	SimpMessagingTemplate simpleMessagingTemplate;
	@Autowired
	UserRepository repo;
	@Autowired
	HttpSession session;

	@GetMapping("/chat")
	public String chat(Model model) {
		//Get sender information from username the SpringSecurity holds
		String senderName = SecurityContextHolder.getContext().getAuthentication().getName();
		System.out.println("chat user:" + senderName);
		//Set sendername to html
		model.addAttribute("userName", senderName);
		//Get receivername from session data
		String receiverName = (String)session.getAttribute("receiverName");
		//Set recievername to html
		model.addAttribute("receiverName", receiverName);
		
		return "chat";
	}
	
	@MessageMapping("/chat")
	public void sendMessage(Principal principal, @Payload ChatMessage msg) throws Exception{
		//Get sender information from user data the SpringSecurity holds
		msg.setSender(principal.getName());
		//Set sender and message to DTO
		OutputMessage out = new OutputMessage(msg.getSender(), msg.getText());
		System.out.println("sender: " + msg.getSender() + " text : " + msg.getText());	
		System.out.println("receiver: " + msg.getReceiver());
		//Direct to reciever
		simpleMessagingTemplate.convertAndSendToUser(msg.getReceiver(), "/queue/chat", out);
	}
	
	@PostMapping("/returntomypage")
	public String postReturnToMyPage(Model model) {
		//Redirect to mypage if back button is pressed
		return "redirect:/mypage";
		
	}
}
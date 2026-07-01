package com.chat.controller;

import jakarta.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.chat.controller.form.ReceiverForm;
import com.chat.repository.UserRepository;
import com.chat.repository.entity.UserRegistration;

@Controller
public class MyPageController {
	@Autowired
	private UserRepository repo;
	
	private String getUserName() {
		//Get username through authentication information that Spring securty holds	
		return SecurityContextHolder.getContext().getAuthentication().getName();
	}
	
	@GetMapping("/mypage")
	public String getMyPage(Model model) {
		//Set user
		String userName = getUserName();
		System.out.println("mypage user:" + userName);
		
		//Set username to html
		model.addAttribute("userName", userName);
		
		return "mypage";
	}
	
	@PostMapping("/mypage")
	public String postMyPage(ReceiverForm form, RedirectAttributes redirect, HttpSession session) {
		//Set user
		String userName = getUserName();

		//Get receiver's name from user input and find matching user from database
		String receiverName = form.getReceiverName();
		UserRegistration receiver = repo.findByUserName(receiverName);
		//Show message if receiver does not exists on database
		if(receiver == null) {
			redirect.addFlashAttribute("receiverNotFound",true);
			return "redirect:/mypage";
		}
		
		//Show error message if user inputs userID of themselves
		if(receiverName.equals(userName)) {
			redirect.addFlashAttribute("sameUser",true);
			return "redirect:/mypage";
		}
	
		//Show reciver's name on screen
		redirect.addFlashAttribute("receiverName", receiverName);
		//save receiver's name to session
		session.setAttribute("receiverName", receiverName);
		
		return "redirect:/mypage";
	}
	
	@PostMapping("/chat")
	public String postChat(){
		//Redirect to chat page if "talk" button is pressed 
		return "redirect:/chat";
	}
}
 
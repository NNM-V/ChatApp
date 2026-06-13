package com.chat.controller;

import jakarta.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.chat.controller.form.LoginForm;
import com.chat.repository.SignUpRepository;
import com.chat.repository.entity.User;

@Controller
public class LoginController {
	@Autowired
	SignUpRepository repo;
	
	@GetMapping("/login")
	public String getLogin() {
		return "login";
	}
	
	@PostMapping("/login")
	public String postLogin(LoginForm form, RedirectAttributes redirect, HttpSession session) {
		//Get matching data from users table
		User user = repo.findByUserEmail(form.getUserEmail());
		if (user == null) {
			redirect.addFlashAttribute("userNotFound", true);
			return "redirect:/login";
		}
			
		//Show error message if password does not match userID
		if(!user.getPassword().equals(form.getPassword())) {
			redirect.addFlashAttribute("passwordNotMatching",true);
			return "redirect:/login";
		}
		
		//Save userID and username to session and transit to mypage
		session.setAttribute("userId", user.getId());
		
		return "redirect:/mypage";
	}
}

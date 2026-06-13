package com.chat.controller;

import jakarta.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.chat.controller.form.ReceiverForm;
import com.chat.repository.SignUpRepository;
import com.chat.repository.entity.User;

@Controller
public class MyPageController {

	@Autowired
	private SignUpRepository repo;
	
	@GetMapping("/mypage")
	public String getMyPage(HttpSession session, Model model) {
		//Get userId saved in session
		Long userId = (Long) session.getAttribute("userId");
		//Return to login page if userId does not exists in session and mypage was called
		if(userId == null) {
			session.invalidate();
			return "redirect:/login";
		}
		
		User user = repo.findById(userId).orElse(null);
		model.addAttribute("userName",user.getUserName());
		session.setAttribute("userName",user.getUserName());
		
		return "mypage";
	}
	
	@PostMapping("/mypage")
	public String postMyPage(ReceiverForm form, HttpSession session, RedirectAttributes redirect, Model model) {
		//Get correspondentId from user input
		String receiverEmail = form.getReceiverEmail();
		//Get correspondent name from correspondent Email
		User receiver = repo.findByUserEmail(receiverEmail);
		
		//Show message if correspondent does not exists
		if(receiver == null) {
			redirect.addFlashAttribute("receiverNotFound",true);
			return "redirect:/mypage";
		}
		
		//Get userId saved in session
		Long userId = (Long) session.getAttribute("userId");
		User user = repo.findById(userId).orElse(null);
		String userEmail = user.getUserEmail();
		
		//Show error message if user inputs userID of themselves
		if(receiverEmail.equals(userEmail)) {
			redirect.addFlashAttribute("sameUser",true);
			return "redirect:/mypage";
		}
	
		model.addAttribute("receiverName", receiver.getUserName());
		session.setAttribute("receiverId", receiver.getId());
		session.setAttribute("receiverName", receiver.getUserName());
		
		return "mypage";
	}
	
	@PostMapping("/chat")
	public String chat(HttpSession session){
		return "chat";
	}
	
	@PostMapping("/logout")
	public String logout(HttpSession session){
		//Delete session and redirect to login
		session.invalidate();
		return "redirect:/login";
	}
}
 
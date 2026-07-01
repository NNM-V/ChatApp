package com.chat.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.chat.controller.form.GroupOrder;
import com.chat.controller.form.UserRegistrationForm;
import com.chat.repository.UserRepository;
import com.chat.service.UserRegistrationService;
	
@Controller
public class UserRegistrationController {
	@Autowired
	private UserRegistrationService service;
	@Autowired
	private UserRepository repo;
	
	@GetMapping("/userregistration")
	public String getUserRegistration(@ModelAttribute UserRegistrationForm form, Model model) {		
		return "userregistration";
	}
		
	@PostMapping("/userregistration")
	public String postSignUp(@ModelAttribute @Validated(GroupOrder.class) UserRegistrationForm form, BindingResult bindingResult, RedirectAttributes redirect, Model model) {
		//Check valitate of user input and show message if error
		if(bindingResult.hasErrors()) {
			return getUserRegistration(form,model);
		}
		
		if(repo.existsByUserEmail(form.getUserEmail()) == true){
			redirect.addFlashAttribute("userEmailExists",true);
			return "redirect:/userregistration";
		}
		if(repo.existsByUserName(form.getUserName()) == true){
			redirect.addFlashAttribute("userNameExists",true);
			return "redirect:/userregistration";
		}

		//Add user input to users table and redirect to login 
		service.addUser(form);
		return "redirect:/login";
	}
}

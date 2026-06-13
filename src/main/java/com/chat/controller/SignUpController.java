package com.chat.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.chat.controller.form.GroupOrder;
import com.chat.controller.form.SignUpForm;
import com.chat.service.SignUpService;
	
@Controller
public class SignUpController {
	@Autowired
	private SignUpService service;
	
	@GetMapping("/signup")
	public String getSignUp(@ModelAttribute SignUpForm form, Model model) {		
		return "signup";
	}
		
	@PostMapping("/signup")
	public String postSignUp(@ModelAttribute @Validated(GroupOrder.class) SignUpForm form,
												BindingResult bindingResult, Model model) {
		//Check valitate of user input and show message if error
		if(bindingResult.hasErrors()) {
			return getSignUp(form,model);
		}			
		//Add user input to users table and redirect to login 
		service.addUser(form);
		return "redirect:/login";
	}
}

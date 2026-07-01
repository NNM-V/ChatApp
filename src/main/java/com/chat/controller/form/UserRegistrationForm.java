package com.chat.controller.form;

import java.util.Date;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class UserRegistrationForm {
	@NotBlank(groups=ValidGroup1.class)
	@Email(groups=ValidGroup2.class)
	private String userEmail;
	
	@NotBlank(groups=ValidGroup1.class)
	private String userName;
	
	@NotBlank(groups=ValidGroup1.class)
	@Pattern(regexp="^(?=.*[A-Z])(?=.*[.?/#!-])[a-zA-Z0-9.?/#!-]{6,12}$", groups=ValidGroup2.class)
	private String password;
	
	@NotNull(groups=ValidGroup1.class)
	@DateTimeFormat(pattern = "yyyy/MM/dd")
	private Date birthday;
}

package com.chat.controller.form;

import java.util.Date;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class SignUpForm {
	@NotBlank(groups=ValidGroup1.class)
	@Email(groups=ValidGroup2.class)
	private String userEmail;
	
	@NotBlank(groups=ValidGroup1.class)
	private String userName;
	
	@NotBlank(groups=ValidGroup1.class)
	@Length(min=4, max=24,groups=ValidGroup2.class)
	@Pattern(regexp="^[a-zA-Z0-9]+$", groups=ValidGroup3.class)
	private String password;
	
	@NotNull(groups=ValidGroup1.class)
	@DateTimeFormat(pattern = "yyyy/MM/dd")
	private Date birthday;
}

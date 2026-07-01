package com.chat.security;

import java.util.Collection;
import java.util.List;

import org.jspecify.annotations.Nullable;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.chat.repository.entity.UserRegistration;

public class MyUserDetails implements UserDetails{
	private final UserRegistration user;
	
	public MyUserDetails(UserRegistration user) {
        this.user = user;
    }
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO 自動生成されたメソッド・スタブ
		return List.of(new SimpleGrantedAuthority(user.getRole()));
	}

	@Override
	public @Nullable String getPassword() {
		// TODO 自動生成されたメソッド・スタブ
		return user.getPassword();
	}

	@Override
	public String getUsername() {
		// TODO 自動生成されたメソッド・スタブ
		return user.getUserName();
	}
}

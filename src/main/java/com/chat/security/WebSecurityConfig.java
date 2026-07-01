package com.chat.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {
	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	UserDetailsService userDetailsService() {
		return new UserDetailsServiceImpl();
	}
	
	@Bean
	SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
		http.authorizeHttpRequests((authorize)->authorize.requestMatchers("/", "/userregistration","/error/**","/ws/**","/style/**")
				.permitAll()
				.requestMatchers("/admin/**").hasRole("ADMIN")
				.anyRequest().authenticated()
			)
			.csrf(csrf -> csrf
                .ignoringRequestMatchers("/ws/**") 
            )
			.formLogin((form) -> form
				.loginPage("/login").permitAll()
				.defaultSuccessUrl("/mypage")
				.usernameParameter("userName")
                .passwordParameter("password")
             )
			.logout(logout -> logout                   // [追加] ログアウト設定
	                .logoutUrl("/logout")                  // [追加] ログアウトを処理するURLを指定
	                .logoutSuccessUrl("/login?logout")     // [追加] ログアウト成功時のリダイレクト先を指定
	                .invalidateHttpSession(true)           // [追加] ログアウト時にセッションを無効にする
	                .deleteCookies("JSESSIONID")
	          );
		return http.build();
	}	
}

package com.example.demo.security;

import org.springframework.context.annotation.Bean;

//import org.springframework.context.annotation.Configuration;
//
//@Configuration
@EnableWebSecurity
public class SecurityConfig {

	@Bean
	public SecurityFilterChain securityFilterChain(Httpsecurity http) throws Exception {
		
		http
			.authorizeRequests()
				.antMatchers("/login", "/register").permitAll()

	}

}

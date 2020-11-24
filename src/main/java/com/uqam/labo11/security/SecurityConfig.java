package com.uqam.labo11.security;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers("/login*").permitAll()

				.antMatchers("/perform_login*").permitAll().and().formLogin().loginPage("/login")
				.and()
				.authorizeRequests().antMatchers("/admin**").hasAnyRole("ROLE_ADMIN");
	}
}

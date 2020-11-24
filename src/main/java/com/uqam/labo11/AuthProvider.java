package com.uqam.labo11;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.uqam.labo11.model.AppDAO;
import com.uqam.labo11.model.User;

public class AuthProvider implements AuthenticationProvider {
	boolean shouldAuthenticateAgainstThirdPartySystem = true;

	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		String username = authentication.getName();
		String password = authentication.getCredentials().toString();
		AppDAO appDAO = new AppDAO();

		User user = appDAO.getUser(username);
		if (user != null && user.getPassword().equals(password)) {
			final List<GrantedAuthority> gA = new ArrayList<>();
			gA.add(new SimpleGrantedAuthority(user.getRole()));
			final UserDetails u = new org.springframework.security.core.userdetails.User(user.getUsername(), password,
					gA);
			final Authentication auth = new UsernamePasswordAuthenticationToken(u, password, gA);

			return auth;

		}

		return null;
	}

	@Override
	public boolean supports(Class<?> authentication) {

		return authentication.equals(UsernamePasswordAuthenticationToken.class);

	}

}

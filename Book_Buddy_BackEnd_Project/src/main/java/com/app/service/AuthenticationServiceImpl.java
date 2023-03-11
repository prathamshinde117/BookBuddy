package com.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import com.app.entities.User;
import com.app.security.UserPrinciple;
import com.app.security.jwt.JwtProvider;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {

	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private JwtProvider jwtProvider;
	
	
	@Override
	public User signInAndRetunJWT(User signInRequest)
	{
		Authentication  authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(signInRequest.getUsername(), signInRequest.getPassword())
				
				);
		
		UserPrinciple userPrinciple = (UserPrinciple)authentication.getPrincipal();
		String jwt = jwtProvider.generateToken(userPrinciple);
		User signInUser= userPrinciple.getUser();
		signInUser.setToken(jwt);
		
		
		return signInUser;
	}


	
	
}

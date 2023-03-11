package com.app.security.jwt;

import javax.servlet.http.HttpServletRequest;

import org.springframework.security.core.Authentication;

import com.app.security.UserPrinciple;

public interface JwtProvider {

	String generateToken(UserPrinciple auth);

	Authentication getAuthentication(HttpServletRequest request);

	boolean isTokenValid(HttpServletRequest request);

	
}

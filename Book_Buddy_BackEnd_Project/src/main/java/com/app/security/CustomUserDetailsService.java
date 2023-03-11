package com.app.security;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.app.entities.User;
import com.app.service.UserService;
import com.app.utils.SecurityUtils;

@Service
public class CustomUserDetailsService implements UserDetailsService {

	@Autowired
	private UserService userservice;
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		User user= userservice.findUserByName(username)
				.orElseThrow(()-> new UsernameNotFoundException(username));
		
		
		Set<GrantedAuthority> authorities= Set.of(SecurityUtils.convertToAuthority(user.getRole().name()));
		return UserPrinciple.builder()
				.user(user)
				.id(user.getId())
				.username(user.getName())
				.password(user.getPassword())
				.authorities(authorities)
				.build();
	}

	
}

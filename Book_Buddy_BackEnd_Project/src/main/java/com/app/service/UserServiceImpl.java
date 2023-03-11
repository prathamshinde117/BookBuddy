package com.app.service;

import java.time.LocalDate;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.app.entities.Role;
import com.app.entities.User;
import com.app.repository.UserRepository;

@Service
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder) {
		this.userRepository=userRepository;
		this.passwordEncoder=passwordEncoder;
	}

	@Override
	public User saveUser(User user) {
		user.setPassword(passwordEncoder.encode(user.getPassword()) );
		user.setRole(Role.USER);
		user.setCreateTime(LocalDate.now());
		return userRepository.save(user);
	}

	@Override
	public Optional<User> findUserByName(String username){
		return userRepository.findUserByName(username);
	}
	
	@Override
	
	public void changeRole(Role newRole, String username) {
		userRepository.updateUserRole(username, newRole);
	}

}

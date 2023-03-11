package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.entities.Role;
import com.app.security.UserPrinciple;
import com.app.service.UserService;

@RestController
@CrossOrigin("http://localhost:3000")
@RequestMapping("api/user")
public class UserController {

	@Autowired
	public UserService userService;
	
	@PutMapping("change/{role}") //api/user/change/{role}
	public ResponseEntity<?>changeRole(@AuthenticationPrincipal UserPrinciple userPrinciple, @PathVariable Role role){
		userService.changeRole(role, userPrinciple.getUsername());
		return ResponseEntity.ok(true);
	}
	
}

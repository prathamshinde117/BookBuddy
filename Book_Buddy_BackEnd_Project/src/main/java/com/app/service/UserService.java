package com.app.service;

import java.util.Optional;

import com.app.entities.Role;
import com.app.entities.User;

public interface UserService {

	User saveUser(User user);
	Optional<User> findUserByName(String username);
    void changeRole(Role newRole, String username);
}

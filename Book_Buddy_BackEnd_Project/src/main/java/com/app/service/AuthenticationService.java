package com.app.service;

import com.app.entities.User;

public interface AuthenticationService {

	User signInAndRetunJWT(User signInRequest);
	
	
}

package com.paweljarosz.security.services;

import com.paweljarosz.security.user.User;

public interface UserService {

	public User findByEmail(String email);
	
	public User findByUsername(String username);
	
}

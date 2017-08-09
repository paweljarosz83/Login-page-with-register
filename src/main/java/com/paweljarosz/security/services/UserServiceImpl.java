package com.paweljarosz.security.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.paweljarosz.security.repos.UserRepository;
import com.paweljarosz.security.user.User;
import com.paweljarosz.security.user.UserDetailsImpl;

@Service
public class UserServiceImpl implements UserService, UserDetailsService {

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		User user = findByUsername(username);
		System.out.println("user "+ user +" username "+username);
		if(user==null){
			System.out.println("null user");
			throw new UsernameNotFoundException(username+" not found!");
		}
		return new UserDetailsImpl(user);
	}

	
	
	@Override
	public User findByEmail(String email) {
		return userRepository.findByEmail(email);
	}
	
	@Override
	public User findByUsername(String username) {
		return userRepository.findByUsername(username);
	}
}

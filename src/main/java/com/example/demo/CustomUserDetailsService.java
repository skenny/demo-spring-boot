package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.example.demo.model.User;
import com.example.demo.repositories.UserRepository;

@Component
public class CustomUserDetailsService implements UserDetailsService {

	@Autowired private UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User ourUser = userRepository.findByUsername(username);
		
		if (ourUser == null) {
			throw new UsernameNotFoundException("Unknown username: " + username);
		}
		
		return new org.springframework.security.core.userdetails.User(
			ourUser.getUsername(),
			ourUser.getPassword(),
			ourUser.isEnabled(),
			true,
			true,
			true,
			ourUser.getRoles()
		);
	}

}

package com.hoanganh.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailsService implements UserDetailsService {
	
	@Autowired
	private UserServiceImpl UserServiceImpl;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		com.hoanganh.model.User User = UserServiceImpl.getUserByUserName(username);

		if (User == null) {
			throw new UsernameNotFoundException("No user found with userName: " + username);
		}

		boolean enabled = true;
		boolean accountNonExpired = true;
		boolean credentialsNonExpired = true;
		boolean accountNonLocked = true;
		
		System.out.println("Detail User");
		System.out.println(new User(username, User.getPassword(), enabled, accountNonExpired, credentialsNonExpired,
				accountNonLocked, User.getAuthorities()));

		return new User(username, User.getPassword(), enabled, accountNonExpired, credentialsNonExpired,
				accountNonLocked, User.getAuthorities());
	
	}
}

package com.example.demo.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.demo.userlogin.UserPrincipal;
import com.example.demo.userlogin.Users;
import com.example.demo.userlogin.repository.UserLoginRepository;


@Service
public class MyUserDeatilsService implements UserDetailsService{
	
	@Autowired
	private UserLoginRepository loginRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		 Users users=loginRepository.findByUsername(username);
		 
		 if(users==null) {
			 throw new UsernameNotFoundException( "User Is Not Found");
		 }
		return new UserPrincipal(users);
	}

}

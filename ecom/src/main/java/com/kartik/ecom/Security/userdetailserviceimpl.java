package com.kartik.ecom.Security;

import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.kartik.ecom.model.User;
import com.kartik.ecom.respotary.UserRepository;

@Service

public class userdetailserviceimpl implements UserDetailsService {
	
	@Autowired
	private UserRepository userrepo;

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		
		User user = userrepo.findbyemail(email);
		
		if (user == null) {
			throw new UsernameNotFoundException("User not Found by Email "+email);
		}
		
		return org.springframework.security.core.userdetails.User.builder()
				.username(user.getEmail())
				.password(user.getPassword())
				.authorities(Collections.emptyList())
				.build();
	}

}

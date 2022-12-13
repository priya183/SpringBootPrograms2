package com.security;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
@Service
public class UserService implements UserDetailsService {
	
	@Autowired
	UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		
		Optional<UserModel> userDto = userRepository.findByUserName(userName);
		userDto.orElseThrow(()->new UsernameNotFoundException("No User found :"+userName));
		return userDto.map(MyUserDetails::new).get();
		//S new MyUserDetails(userDto);
	}

}

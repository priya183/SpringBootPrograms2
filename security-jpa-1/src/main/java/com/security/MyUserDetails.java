package com.security;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class MyUserDetails implements UserDetails {
	
	private String userName;
	private String passward;
	private boolean active;
	private List<GrantedAuthority> authories;
	
	public MyUserDetails(UserModel userDto) {
		this.userName = userDto.getUserName();
		this.passward = userDto.getPassward();
		this.active = userDto.isActive();
		this.authories = Arrays.stream(userDto.getRoles().split(",")).map(SimpleGrantedAuthority::new).collect(Collectors.toList());
	}

	public MyUserDetails(Optional<UserModel> userDto) {
		// TODO Auto-generated constructor stub
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return authories;
	}

	@Override
	public String getPassword() {
		return passward;
	}

	@Override
	public String getUsername() {
		return userName;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

}

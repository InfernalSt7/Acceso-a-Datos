package com.ciclismo1.service.impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.ciclismo1.entity.User_Role;
import com.ciclismo1.repository.UserRepository;

@Service("userService")
public class UserService implements UserDetailsService{
	
	private User buildUser(com.ciclismo1.entity.User user,
		List<GrantedAuthority> authorities) {
	return new User(user.getUsername(),user.getPassword(),user.isEnabled(),true,true,true,authorities);
	}
	
	private List<GrantedAuthority> buildAuthorities(Set<User_Role> userRoles){
		Set<GrantedAuthority> auths = new HashSet<GrantedAuthority>();
		
		for(User_Role user_Role: userRoles) {
			auths.add(new SimpleGrantedAuthority(user_Role.getRole()));
		}
		
		return new ArrayList<GrantedAuthority>(auths);
	}

	@Autowired
	@Qualifier("userRepository")
	private UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		com.ciclismo1.entity.User user = userRepository.findByUsername(username);
		List<GrantedAuthority> authorities = buildAuthorities(user.getUser_Role());	
		return buildUser(user, authorities);
	}
}

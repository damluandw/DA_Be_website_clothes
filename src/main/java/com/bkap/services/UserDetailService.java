package com.bkap.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


import com.bkap.entities.Users;
import com.bkap.entitysecurity.UserDetail;
import com.bkap.reponsitories.UserResponsitory;

@Service
public class UserDetailService implements UserDetailsService {
	@Autowired
	private UserResponsitory userRes;

	// mình muốn tìm theo id user nên ko dùng load cho name
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Users users = userRes.findByName(username);
		// TODO Auto-generated method stub
		if (users == null) {
			throw new UsernameNotFoundException(username);
		}
		return new UserDetail(users);
	}

	public UserDetails loadUserById(Integer id) throws UsernameNotFoundException {
		Users users = null;
		users = userRes.findById(id).orElse(users);

		if (users == null) {
			throw new UsernameNotFoundException(Integer.toString(id));
		}
		return new UserDetail(users);
	}
}

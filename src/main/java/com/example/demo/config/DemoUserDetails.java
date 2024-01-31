package com.example.demo.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.demo.model.DemoUser;
import com.example.demo.repository.DemoUserRepository;

@Service
public class DemoUserDetails implements UserDetailsService{

    @Autowired
    DemoUserRepository demoUserRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        String userName = null;
		String password = null;

        List<GrantedAuthority> authorities = null;
		List<DemoUser> demoUser = demoUserRepository.findDemoUserByEmail(email);

        if(demoUser.size() == 0) {
			throw new UsernameNotFoundException("User details not found for the user : " + email);
		} else {
			userName = demoUser.get(0).getEmail();
			password = demoUser.get(0).getPassword();
			authorities = new ArrayList<>();
			authorities.add(new SimpleGrantedAuthority(demoUser.get(0).getRole()));
		}
		return new User(userName, password, authorities);
    }

    

}

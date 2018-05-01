package com.example.service;

import com.example.domain.User;
import com.example.repository.UserRepositoryWithJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class LoginUserDetailsService implements UserDetailsService{
    @Autowired
    UserRepositoryWithJPA userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.getOne(username);
        if (user==null) {
            throw new UsernameNotFoundException("the requested user is not find");
        }
        return new LoginUserDetails(user);
    }
}

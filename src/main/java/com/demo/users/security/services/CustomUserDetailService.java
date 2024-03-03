package com.demo.users.security.services;

import com.demo.users.models.User;
import com.demo.users.repositories.UserRepository;
import com.demo.users.security.models.CustomUserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomUserDetailService implements UserDetailsService {


    private UserRepository userRepository;


    public CustomUserDetailService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> optionalUser = userRepository.findByEmail(username);
        if (optionalUser.isEmpty()){
            throw new UsernameNotFoundException("Email " + username + " is not found");
        }
        CustomUserDetails customUserDetails = new CustomUserDetails(optionalUser.get());
        return customUserDetails;
    }
}
package com.asign.taskm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.asign.taskm.entity.User;
import com.asign.taskm.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService{
    
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserRepository userRepository;

    @Override
    public User createUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword())); 

        return userRepository.save(user);
    }
    
}

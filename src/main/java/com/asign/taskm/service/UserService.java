package com.asign.taskm.service;

import org.springframework.stereotype.Service;

import com.asign.taskm.entity.User;

@Service
public interface UserService {
    User createUser(User user);
    User getUserByUsername(String username);
}

package com.asign.taskm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.asign.taskm.entity.User;
import com.asign.taskm.service.UserService;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/auth/users")
    public User createUser(@RequestBody User user) {
        System.out.println("aaawa");
        return userService.createUser(user);
    }

}

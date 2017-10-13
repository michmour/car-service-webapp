package com.carservice.carservice.controllers;

import com.carservice.carservice.models.User;
import com.carservice.carservice.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

public class UserController {


    @Autowired
    private UserService userService;


    @GetMapping("/user")
    public List<User> getAllNotes() {
        return userService.findAll();
    }
}

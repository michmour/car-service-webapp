package com.carservice.carservice.controllers;

import com.carservice.carservice.models.User;
import com.carservice.carservice.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class UserController {


    @Autowired
    private UserService userService;


    @GetMapping("/user")
    public List<User> getAllUsers() {
        return userService.findAll();
    }

    @PostMapping("/user")
    public User createUser(@Valid @RequestBody User user) {
        return userService.save(user);
    }
}

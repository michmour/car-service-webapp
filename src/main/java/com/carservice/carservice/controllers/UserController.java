package com.carservice.carservice.controllers;

import com.carservice.carservice.models.User;
import com.carservice.carservice.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class UserController {


    @Autowired
    private UserService userService;


    @GetMapping("/users")
    public List<User> findAll() {
        return userService.findAll();
    }

    @PostMapping("/users")
    public void add(@RequestBody User user) {

    }

//    @GetMapping("/get/{id}")
//    public @ResponseBody ResponseEntity<String>
//    findById(@PathVariable String id) {
//        return new ResponseEntity<String>("GET Response : "
//                + id, HttpStatus.OK);
//    }

    @GetMapping("/users/{id}")
    public List<User> findById(@PathVariable(value = "id") Long userid) {


        return  userService.findOne(userid);
//        if(user == null) {
//            return ResponseEntity.notFound().build();
//        }
//        return ResponseEntity.ok().body(user);
    }
}

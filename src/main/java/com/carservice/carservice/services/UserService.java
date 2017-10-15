package com.carservice.carservice.services;

import com.carservice.carservice.models.User;

import java.util.List;

public interface UserService {


    List<User> findAll();

    List<User> findOne(long userid);

    User save(User user);
}

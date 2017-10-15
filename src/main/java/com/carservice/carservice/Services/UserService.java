package com.carservice.carservice.Services;

import com.carservice.carservice.Domain.User;

import java.util.List;

public interface UserService {


    List<User> findAll();

    List<User> findOne(long userid);

    void save(User user);
}

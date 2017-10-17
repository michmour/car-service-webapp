package com.carservice.carservice.Services;

import com.carservice.carservice.Domain.User;

import java.util.List;

public interface UserService {


    List<User> findAll();

    List<User> findOne(long userid);

    String findNameById(Long userid);

    String findSurnameById(Long userid);

    String findEmailById(Long userid);

    String findPasswordById(Long userid);

    String findSsnById(Long userid);

    String findAddressById(Long userid);

    String deleteById(Long userid);

    void save(User user);
}

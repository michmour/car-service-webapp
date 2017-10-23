package com.carservice.carservice.Services;

import com.carservice.carservice.Domain.User;
import org.springframework.security.core.AuthenticationException;

import java.util.List;

public interface UserService {


    List<User> findAll();

    User findOne(Long userid);


    //LOGIN-LOGOUT

    User login(String email, String password) throws AuthenticationException;

    void logout(String email) throws Exception;

    //LOGIN-LOGOUT

    void delete(User user);

    void save(User user);
}

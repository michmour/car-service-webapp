package com.carservice.carservice.services;

import com.carservice.carservice.models.User;
import com.carservice.carservice.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public class UserServiceImpl {


    @Service
    @Transactional
    public class BookServiceImpl implements UserService {

        @Autowired
        private UserRepository userRepository;


        @Override
        public List<User> findAll() {
            return userRepository.findAll();
        }

        @Override
        public void save(User user) {
            userRepository.save(user);
        }
    }
}

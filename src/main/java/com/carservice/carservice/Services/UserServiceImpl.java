package com.carservice.carservice.Services;

import com.carservice.carservice.Domain.User;
import com.carservice.carservice.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
    @Transactional
    public class UserServiceImpl implements UserService {

        @Autowired
        private UserRepository userRepository;


        @Override
        public List<User> findAll() {
            return userRepository.findAll();
        }

        @Override
        public List<User> findOne(long userid){ return userRepository.findOne(userid);}

        @Override
        public void save(User user) {
            userRepository.save(user);
        }
    }


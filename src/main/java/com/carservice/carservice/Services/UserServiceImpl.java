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
        public User findOne(Long userid){ return userRepository.findOne(userid);}

        @Override
        public String findNameById (Long userid){ return userRepository.findNameById(userid);}

        @Override
        public String findSurnameById(Long userid){ return userRepository.findSurnameById(userid);}

        @Override
        public String findEmailById(Long userid){ return userRepository.findEmailById(userid);}

        @Override
        public String findPasswordById(Long userid){ return userRepository.findPasswordById(userid);}

        @Override
        public String findSsnById(Long userid){ return userRepository.findSsnById(userid);}

        @Override
        public String findAddressById(Long userid){ return userRepository.findAddressById(userid);}

        @Override
        public void delete(User user){  userRepository.delete(user);}

        @Override
        public void save(User user) {
            userRepository.save(user);
        }
    }


package com.carservice.carservice.Services;

import com.carservice.carservice.Domain.User;
import com.carservice.carservice.Exceptions.InvalidCredentialsException;
import com.carservice.carservice.Repositories.UserRepository;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.List;
import java.util.Set;


    @Service
    @Transactional
    public class UserServiceImpl implements UserService {
    private final static org.slf4j.Logger LOG = LoggerFactory.getLogger(UserServiceImpl.class);
    private Set<String> loggedInUsers = new HashSet<>();

        @Autowired
        private UserRepository userRepository;

        @Override
        public User findUserByEmail(String email){return userRepository.findUserByEmail(email);}
        @Override
        public List<User> findAll() {
            return userRepository.findAll();
        }

        @Override
        public List<User> findNameById() {
            return userRepository.findNameById();
        }

        @Override
        public User findOne(Long userid){ return userRepository.findOne(userid);}

        @Override
        public User findUserRepairs(Long userid) {
            return userRepository.findOne(userid);
        }


    //LOGIN-LOGOUT

    @Override
    public User login(String email, String password) throws AuthenticationException {

        User retrievedUser = userRepository.findByEmailAndPassword(email, password);
        if (retrievedUser == null) {
            throw new InvalidCredentialsException("User not found!");
        }

        loggedInUsers.add(email);
        return retrievedUser;
    }

    @Override
    public void logout(String username) {
        loggedInUsers.remove(username);
    }

    //LOGIN-LOGOUT

        @Override
        public void delete(User user){  userRepository.delete(user);}

        @Override
        public void save(User user) {
            userRepository.save(user);
        }

    }
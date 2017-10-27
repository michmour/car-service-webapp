package com.carservice.carservice.Repositories;

import com.carservice.carservice.Domain.User;
import com.carservice.carservice.Domain.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


    @Repository
    public interface UserRepository extends JpaRepository<User, Long> {



        User findUserByEmail(String email);

        User findByEmailAndPassword(String email, String password);

        List<User> findAll();

        List<User> findByEmailStartingWith(String email);

        List<User> findBySsnStartingWith(String ssn);


        void delete(User user);

    }


package com.carservice.carservice.Repositories;

import com.carservice.carservice.Domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


    @Repository

   // @RepositoryRestResource(collectionResourceRel = "user", path = "user")

    public interface UserRepository extends JpaRepository<User, Long> {

       // List<User> findByLastName(@Param("name") String name);

       // List<User> findAll();

        User findUserByEmail(String email);


        User findByEmailAndPassword(String email, String password);

        @Query("SELECT name FROM User WHERE userid = :userid")
        String findNameById(@Param("userid") Long userid);

        @Query("SELECT surname FROM User WHERE userid = :userid")
        String findSurnameById(@Param("userid") Long userid);

        @Query("SELECT email FROM User WHERE userid = :userid")
        String findEmailById(@Param("userid") Long userid);

        @Query("SELECT password FROM User WHERE userid = :userid")
        String findPasswordById(@Param("userid") Long userid);

        @Query("SELECT ssn FROM User WHERE userid = :userid")
        String findSsnById(@Param("userid") Long userid);

        @Query("SELECT address FROM User WHERE userid = :userid")
        String findAddressById(@Param("userid") Long userid);

        void delete(User user);

    }


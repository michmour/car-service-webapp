package com.carservice.carservice.Repositories;

import com.carservice.carservice.Domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


    @Repository

   // @RepositoryRestResource(collectionResourceRel = "user", path = "user")

    public interface UserRepository extends JpaRepository<User, Long> {

       // List<User> findByLastName(@Param("name") String name);

        List<User> findAll();

        List<User> findOne(long userid);


        User save(User user);
    }


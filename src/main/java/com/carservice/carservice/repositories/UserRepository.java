package com.carservice.carservice.repositories;

import com.carservice.carservice.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import javax.jws.soap.SOAPBinding;
import java.util.List;


  //  @Repository
   @RepositoryRestResource(collectionResourceRel = "user", path = "user")
    public interface UserRepository extends JpaRepository<User, Long> {

       // List<User> findByLastName(@Param("name") String name);

        List<User> findAll();


        User save(User user);
    }


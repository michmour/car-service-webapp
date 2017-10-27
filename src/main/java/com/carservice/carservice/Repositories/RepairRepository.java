package com.carservice.carservice.Repositories;

import com.carservice.carservice.Domain.Repair;
import com.carservice.carservice.Domain.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface RepairRepository extends JpaRepository<Repair, Long> {

    List<Repair> findAll();


    @Query("SELECT userelid FROM Repair WHERE serviceid = :serviceid")
    User findOneUserId(@Param("serviceid")long serviceid);


    List<Repair> findByUserelid_SsnStartingWith(String ssn);



}
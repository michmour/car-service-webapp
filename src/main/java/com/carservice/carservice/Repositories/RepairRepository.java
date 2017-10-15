package com.carservice.carservice.Repositories;

import com.carservice.carservice.Domain.Repair;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
//@RepositoryRestResource(collectionResourceRel = "repair", path = "repair")
public interface RepairRepository extends JpaRepository<Repair, Long> {

    List<Repair> findAll();

   // List<Repair> findOne(@Param("serviceid")long serviceid);

    Repair save(Repair repair);

}
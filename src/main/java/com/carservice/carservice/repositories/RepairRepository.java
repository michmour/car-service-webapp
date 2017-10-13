package com.carservice.carservice.repositories;

import com.carservice.carservice.models.Repair;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource(collectionResourceRel = "repair", path = "repair")
public interface RepairRepository extends JpaRepository<Repair, Long> {

    List<Repair> findAll();

   // List<Repair> findOne(@Param("serviceid")long serviceid);

    Repair save(Repair repair);

}
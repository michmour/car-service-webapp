package com.carservice.carservice.repositories;

import com.carservice.carservice.models.Service;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ServiceRepository extends JpaRepository<Service, Long> {

    List<Service> findAll();

    List<Service> findOne(@Param("serviceid")long serviceid);

    Service save(Service service);

}
package com.carservice.carservice.Repositories;

import com.carservice.carservice.Domain.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface VehicleRepository extends JpaRepository<Vehicle,Long> {

    List<Vehicle> findAll();

    // List<Repair> findOne(@Param("serviceid")long serviceid);

    Vehicle save(Vehicle vehicle);

}

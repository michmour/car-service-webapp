package com.carservice.carservice.Repositories;

import com.carservice.carservice.Domain.User;
import com.carservice.carservice.Domain.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface VehicleRepository extends JpaRepository<Vehicle,Long> {



    List<Vehicle> findAll();

    List<Vehicle> findByUserelid_SsnStartingWith(String ssn);

    List<Vehicle> findByPlatenumberStartingWith(String platenumber);

    @Query("SELECT userelid FROM Vehicle WHERE vehicleid = :vehicleid")
    User findOneUserId(@Param("vehicleid")Long vehicleid);

}

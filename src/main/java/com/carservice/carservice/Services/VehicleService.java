package com.carservice.carservice.Services;

import com.carservice.carservice.Domain.User;
import com.carservice.carservice.Domain.Vehicle;

import java.util.List;

public interface VehicleService {

    List<Vehicle> findAll();

    Vehicle findOne(Long userid);

    void delete(Vehicle user);

    void save(Vehicle user);
    
    User findOneUserId(Long vehicleid);



}

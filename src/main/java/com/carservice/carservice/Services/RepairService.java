package com.carservice.carservice.Services;

import com.carservice.carservice.Domain.Repair;
import com.carservice.carservice.Domain.User;

import java.util.List;

public interface RepairService {


    List<Repair> findAll();

    User findOneUserId(Long serviceid);

    Repair findOne(Long serviceid);

    void delete(Repair user);

    void save(Repair repair);
}

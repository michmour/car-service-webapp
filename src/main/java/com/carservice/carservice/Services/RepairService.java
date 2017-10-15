package com.carservice.carservice.Services;

import com.carservice.carservice.Domain.Repair;

import java.util.List;

public interface RepairService {


    List<Repair> findAll();

    void save(Repair repair);
}

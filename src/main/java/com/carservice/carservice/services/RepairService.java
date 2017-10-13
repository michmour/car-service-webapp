package com.carservice.carservice.services;

import com.carservice.carservice.models.Repair;
import com.carservice.carservice.models.User;

import javax.xml.ws.Service;
import java.util.List;

public interface RepairService {


    List<Repair> findAll();

    Repair save(Repair repair);
}

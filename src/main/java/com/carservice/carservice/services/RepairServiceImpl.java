package com.carservice.carservice.services;

import com.carservice.carservice.models.Repair;
import com.carservice.carservice.repositories.RepairRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;




@Service
@Transactional
public class RepairServiceImpl implements RepairService {

    @Autowired
    private RepairRepository repairRepository;


    @Override
    public List<Repair> findAll() {
        return repairRepository.findAll();
    }

    @Override
    public Repair save(Repair repair) { return
            repairRepository.save(repair);
    }
}


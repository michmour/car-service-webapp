package com.carservice.carservice.Services;

import com.carservice.carservice.Domain.Repair;
import com.carservice.carservice.Repositories.RepairRepository;
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
    public void save(Repair repair) {
            repairRepository.save(repair);
    }
}


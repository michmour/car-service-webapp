package com.carservice.carservice.Services;

import com.carservice.carservice.Domain.Repair;
import com.carservice.carservice.Domain.User;
import com.carservice.carservice.Repositories.RepairRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;




@Service
@Transactional
public class RepairServiceImpl implements RepairService {

    @Autowired
    private RepairRepository repairRepository;

    @Override
    public User findOneUserId(Long serviceid){return repairRepository.findOneUserId(serviceid);}

    @Override
    public Repair findOne(Long serviceid){return repairRepository.findOne(serviceid);}

    @Override
    public List<Repair> findAll() {
        return repairRepository.findAll();
    }

    @Override
    public List<Repair> searchAll() {
        return repairRepository.findAll();
    }

    @Override
    public List<Repair> searchRepairsBySsn(String ssn) {
        return repairRepository.findByUserelid_SsnStartingWith(ssn);
    }

    @Override
    public Page<Repair> getTenRepairs() {
        PageRequest request =
                new PageRequest(0, 9, Sort.Direction.ASC, "servicedate");
        return repairRepository.findAll(request);
    }

    @Override
    public void delete(Repair repair){repairRepository.delete(repair);}

    @Override
    public void save(Repair repair) {
            repairRepository.save(repair);
    }

}


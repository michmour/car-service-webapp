package com.carservice.carservice.Services;

import com.carservice.carservice.Domain.Repair;
import com.carservice.carservice.Domain.User;
import org.springframework.data.domain.Page;
import java.util.List;

public interface RepairService {


    Page<Repair> getTenRepairs();

    User findOneUserId(Long serviceid);

    List<Repair> findAll();

    List<Repair> searchAll();

    Repair findOne(Long serviceid);

    List<Repair> searchRepairsBySsn(String ssn);

    void delete(Repair user);

    void save(Repair repair);
}

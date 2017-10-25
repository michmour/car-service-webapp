package com.carservice.carservice.Services;

import com.carservice.carservice.Domain.Repair;
import com.carservice.carservice.Domain.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface RepairService {


    Page<Repair> getTenRepairs();

    User findOneUserId(Long serviceid);

    List<Repair> findAll();

    Repair findOne(Long serviceid);

    void delete(Repair user);

    void save(Repair repair);
}

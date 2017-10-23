package com.carservice.carservice.Services;

import com.carservice.carservice.Domain.Vehicle;
import com.carservice.carservice.Repositories.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class VehicleServiceImpl implements VehicleService {


        @Autowired
        private VehicleRepository vehicleRepository;


        @Override
        public List<Vehicle> findAll() {
            return vehicleRepository.findAll();
        }

        @Override
        public Vehicle findOne(Long userid){ return vehicleRepository.findOne(userid);}


        @Override
        public void delete(Vehicle user){  vehicleRepository.delete(user);}

        @Override
        public void save(Vehicle user) {
            vehicleRepository.save(user);
        }


}

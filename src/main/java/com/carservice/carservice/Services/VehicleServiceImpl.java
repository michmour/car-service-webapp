package com.carservice.carservice.Services;

import com.carservice.carservice.Domain.Repair;
import com.carservice.carservice.Domain.User;
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
        public User findOneUserId(Long vehicleid){return vehicleRepository.findOneUserId(vehicleid);}

        @Override
        public List<Vehicle> findAll() {
            return vehicleRepository.findAll();
        }

        @Override
        public Vehicle findOne(Long userid){ return vehicleRepository.findOne(userid);}


        @Override
        public List<Vehicle> searchPlate(String platenumber) {
                return vehicleRepository.findByPlatenumberStartingWith(platenumber);
        }

        @Override
        public List<Vehicle> searchVehicleByPlate(String ssn) {
                return vehicleRepository.findByUserelid_SsnStartingWith(ssn);
        }

        @Override
        public void delete(Vehicle user){  vehicleRepository.delete(user);}

        @Override
        public void save(Vehicle user) {
            vehicleRepository.save(user);
        }


}

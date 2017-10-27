package com.carservice.carservice.Controllers;

import com.carservice.carservice.Domain.Repair;
import com.carservice.carservice.Domain.User;
import com.carservice.carservice.Domain.Vehicle;
import com.carservice.carservice.Services.RepairService;
import com.carservice.carservice.Services.UserService;
import com.carservice.carservice.Services.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
public class SearchController {


    @Autowired
    private UserService userService;

    @Autowired
    private RepairService repairService;

    @Autowired
    private VehicleService vehicleService;




    @GetMapping(value="/admin/search/users",params = "owneremail")
    public ResponseEntity<List<User>> getUserByEmail(@RequestParam("owneremail") String owneremail) {
        List searchUserEmail = userService.searchByEmail(owneremail);
        if (searchUserEmail==null) {
            return new ResponseEntity<>(searchUserEmail, HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(searchUserEmail, HttpStatus.OK);
    }

    @GetMapping(value="/admin/search/users",params = "ownerssn")
    public ResponseEntity<List<User>> getUserBySsn(@RequestParam("ownerssn") String ownerssn) {
        List searchUserSsn = userService.searchBySsn(ownerssn);
        if (searchUserSsn==null) {
            return new ResponseEntity<>(searchUserSsn, HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(searchUserSsn, HttpStatus.OK);
    }



    @GetMapping(value="/admin/search/repairs",params = "repairssn")
    public ResponseEntity<List<Repair>> getRepairSsn(@RequestParam("repairssn") String repairssn) {
        List<Repair> searchRepairSsn = repairService.searchRepairsBySsn(repairssn);

        if (searchRepairSsn==null) {
            return new ResponseEntity<>(searchRepairSsn, HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(searchRepairSsn, HttpStatus.OK);
    }

    @GetMapping(value="/admin/search/vehicles",params = "vehicleplate")
    public ResponseEntity<List<Vehicle>> getVehiclePlate(@RequestParam("vehicleplate") String vehicleplate) {
        List<Vehicle> searchVehiclePlate = vehicleService.searchPlate(vehicleplate);

        if (searchVehiclePlate==null) {
            return new ResponseEntity<>(searchVehiclePlate, HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(searchVehiclePlate, HttpStatus.OK);
    }

    @GetMapping(value="/admin/search/vehicles",params = "vehiclessn")
    public ResponseEntity<List<Vehicle>> getVehicleSsn(@RequestParam("vehiclessn") String vehiclessn) {
        List<Vehicle> searchVehicleSsn = vehicleService.searchVehicleByPlate(vehiclessn);

        if (searchVehicleSsn==null) {
            return new ResponseEntity<>(searchVehicleSsn, HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(searchVehicleSsn, HttpStatus.OK);
    }

}

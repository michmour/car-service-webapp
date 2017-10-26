package com.carservice.carservice.Controllers;

import com.carservice.carservice.Domain.Repair;
import com.carservice.carservice.Domain.User;
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


    @GetMapping("/admin/search/users")
    public ResponseEntity<List<User>> getUsers() {
        List<User> searchUserList = userService.searchAll();
        return new ResponseEntity<>(searchUserList, HttpStatus.OK);
    }

    @GetMapping("/admin/search/repairs")
    public ResponseEntity<List<Repair>> getRepairs() {
        List<Repair> searchRepairList = repairService.searchAll();
        return new ResponseEntity<>(searchRepairList, HttpStatus.OK);
    }

//    @GetMapping(value="/admin/search/users", produces = "application/json")
//    public List<User> getAllUsers(Model model){
//
//       //  model.addAttribute("usersList",userService.findNameById());
//
//
//        return userService.findNameById();
//    }



//    @GetMapping("/admin/repairs/search?")
//    public ResponseEntity<List<Repair>> search(@RequestParam("from") @DateTimeFormat(pattern="yyyy-MM-dd") Date fromDate) {
//
//        return new ResponseEntity<>(repairService.findAll(), HttpStatus.OK);
//        //Content goes here
//
//    }
}

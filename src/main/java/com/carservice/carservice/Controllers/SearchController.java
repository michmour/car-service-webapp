package com.carservice.carservice.Controllers;

import com.carservice.carservice.Domain.Repair;
import com.carservice.carservice.Domain.User;
import com.carservice.carservice.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;


@RestController
public class SearchController {


    @Autowired
    private UserService userService;




    @GetMapping(value="/admin/search/users", produces = "application/json")
    public List<User> getAllUsers(Model model){

       //  model.addAttribute("usersList",userService.findNameById());


        return userService.findNameById();
    }



//    @GetMapping("/admin/repairs/search?")
//    public ResponseEntity<List<Repair>> search(@RequestParam("from") @DateTimeFormat(pattern="yyyy-MM-dd") Date fromDate) {
//
//        return new ResponseEntity<>(repairService.findAll(), HttpStatus.OK);
//        //Content goes here
//
//    }
}

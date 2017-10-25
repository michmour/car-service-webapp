package com.carservice.carservice.Controllers;

import com.carservice.carservice.Domain.User;
import com.carservice.carservice.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class SearchController {


    @Autowired
    private UserService userService;


    @GetMapping("/admin/search/users")
    public ResponseEntity<List<User>> getBooks() {
        List<User> searchList = userService.searchAll();
        return new ResponseEntity<>(searchList, HttpStatus.OK);
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

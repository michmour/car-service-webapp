package com.carservice.carservice.Converters;

import com.carservice.carservice.Domain.User;
import com.carservice.carservice.Models.UserForm;


public class UserConverter {

    public static User buildUserObject(UserForm userForm) {
        User user = new User();
        if(userForm.getUserid()!=null) {
            user.setUserid(userForm.getUserid());
        }
        user.setName(userForm.getName());
        user.setPassword(userForm.getPassword());
        user.setEmail(userForm.getEmail());
        user.setSurname(userForm.getSurname());
        user.setSsn(userForm.getSsn());
        user.setAddress(userForm.getAddress());
        user.setServicescollection(userForm.getServicescollection());
        user.setVehiclescollection(userForm.getVehiclescollection());
        user.setUsertype(userForm.getUsertype());

        return user;
    }
}
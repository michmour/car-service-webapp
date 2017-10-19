package com.carservice.carservice.Converters;

import com.carservice.carservice.Domain.User;
import com.carservice.carservice.Models.RegistrationForm;


public class UserConverter {

    public static User buildUserObject(RegistrationForm registrationForm ) {
        User user = new User();
        if(registrationForm.getUserid()!=null) {
            user.setUserid(registrationForm.getUserid());
        }
        user.setName(registrationForm.getName());
        user.setPassword(registrationForm.getPassword());
        user.setEmail(registrationForm.getEmail());
        user.setSurname(registrationForm.getSurname());
        user.setSsn(registrationForm.getSsn());
        user.setAddress(registrationForm.getAddress());
        user.setServicescollection(registrationForm.getServicescollection());
        user.setUsertype(registrationForm.getUsertype());
        return user;
    }
}
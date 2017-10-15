package com.carservice.carservice.converters;

import com.carservice.carservice.models.User;
import com.carservice.carservice.forms.RegistrationForm;


public class UserConverter {

    public static User buildUserObject(RegistrationForm registrationForm) {
        User user = new User();
        user.setName(registrationForm.getName());
        user.setPassword(registrationForm.getPassword());
        user.setEmail(registrationForm.getEmail());
        user.setSurname(registrationForm.getSurname());
        user.setSsn(registrationForm.getSsn());
        user.setAddress(registrationForm.getAddress());
        return user;
    }
}
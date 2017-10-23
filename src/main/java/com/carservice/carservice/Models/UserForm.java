package com.carservice.carservice.Models;

import com.carservice.carservice.Domain.Repair;
import com.carservice.carservice.Domain.User;
import com.carservice.carservice.Domain.Vehicle;
import org.hibernate.collection.internal.PersistentBag;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

public class UserForm {



    private static final String ADDRESS_PATTERN = "^[a-zA-Z0-9]*$";

    private static final String PASSWORD_PATTERN = "^[a-zA-Z0-9@#$%^&]*$";

    private static final String CHARACTERS_PATTERN = "^[a-zA-Z ]*$";

    private static final String MAIL_PATTERN = "[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{1,63}$";

    private static final int PASSWORD_MINSIZE = 6;

    private String usertype;
    private String ssn;
    private String address;

    @Pattern(regexp = CHARACTERS_PATTERN, message = "{register.name.invalid}")
    private String name;

    @Pattern(regexp = CHARACTERS_PATTERN, message = "{register.surname.invalid}")
    private String surname;

    @NotNull(message = "{register.password.null}")
    @Pattern(regexp = PASSWORD_PATTERN, message = "{register.password.invalid}")
    @Size(min = PASSWORD_MINSIZE, message = "{register.password.size}")
    private String password;

    private Long userid;

    @Pattern(regexp = MAIL_PATTERN, message = "{register.email.invalid}")
    private String email;

    private List<Repair> servicescollection;

    private List<Vehicle> vehiclescollection;



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getSsn() {
        return ssn;
    }

    public void setSsn(String ssn) {
        this.ssn = ssn;
    }

    public String getUsertype() {
        return usertype;
    }

    public void setUsertype(String usertype) {
        this.usertype = usertype;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Long getUserid() {
        return userid;
    }

    public void setUserid(Long userid) {
        this.userid = userid;
    }

    public List<Repair> getServicescollection(){
        if (servicescollection == null) {
            return new ArrayList<>();
        }
        return servicescollection;
    }

    public void setServicescollection(List<Repair> servicescollection) {
        this.servicescollection = servicescollection;
    }

    public List<Vehicle> getVehiclescollection() {
        if (vehiclescollection == null) {
            return new ArrayList<>();
        }
        return vehiclescollection;
    }

    public void setVehiclescollection(List<Vehicle> vehiclescollection) {
        this.vehiclescollection = vehiclescollection;
    }
}

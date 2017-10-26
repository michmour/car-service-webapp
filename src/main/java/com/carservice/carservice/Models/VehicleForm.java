package com.carservice.carservice.Models;

import com.carservice.carservice.Domain.User;
import com.carservice.carservice.Domain.VehicleBrands;

import javax.validation.constraints.Pattern;


public class VehicleForm {

    private static final String PLATE_PATTERN = "([A-Z]{3})-\\d{4}";

    @Pattern(regexp = PLATE_PATTERN, message = "{register.number.invalid}")
    private String platenumber;

    private VehicleBrands vehiclemodel;
    private String year;
    private String colour;
    private User userelid;
    private Long vehicleid;


    public String getPlatenumber() {
        return platenumber;
    }

    public void setPlatenumber(String platenumber) {
        this.platenumber = platenumber;
    }

    public VehicleBrands getVehiclemodel() {
        return vehiclemodel;
    }

    public void setVehiclemodel(VehicleBrands vehiclemodel) {
        this.vehiclemodel = vehiclemodel;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    public User getUserelid() {
        return userelid;
    }

    public void setUserelid(User userelid) {
        this.userelid = userelid;
    }

    public Long getVehicleid() {
        return vehicleid;
    }

    public void setVehicleid(Long vehicleid) {
        this.vehicleid = vehicleid;
    }
}

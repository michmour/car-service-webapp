package com.carservice.carservice.Converters;

import com.carservice.carservice.Domain.Vehicle;
import com.carservice.carservice.Models.VehicleForm;

public class VehicleConverter {


    public static Vehicle buildVehicleObject(VehicleForm vehicleForm) {
        Vehicle repair = new Vehicle();
        if(vehicleForm.getVehicleid()!=null) {
            repair.setVehicleid(vehicleForm.getVehicleid());
        }
        repair.setColour(vehicleForm.getColour());
        repair.setPlatenumber(vehicleForm.getPlatenumber());
        repair.setVehiclemodel(vehicleForm.getVehiclemodel());
        repair.setYear(vehicleForm.getYear());
        repair.setUserelid(vehicleForm.getUserelid());

        return repair;
    }
}

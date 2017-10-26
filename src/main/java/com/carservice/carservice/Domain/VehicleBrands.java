package com.carservice.carservice.Domain;

public enum VehicleBrands {


                ALFA_ROMEO("Alfa_Romeo"),
                NISSAN("Nissan"),
                TOYOTA("Toyota"),
                VW("Volkswagen"),
                MERCEDES("Mercedes"),
                MAZDA("Mazda"),
                OPEL("Opel");

                private String vehicleBrands;

    VehicleBrands(String vehicleBrands) {
        this.vehicleBrands = vehicleBrands;
    }

    public String getVehiclebrands() {
        return vehicleBrands;
    }

    public void setVehiclebrands(String vehiclebrands) {
        this.vehicleBrands = vehiclebrands;
    }
}

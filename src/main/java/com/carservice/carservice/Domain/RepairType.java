package com.carservice.carservice.Domain;

public enum RepairType {


            SMALL("Small"),
            BIG("Big");


    private String repairType;

    RepairType(String repairType) {
        this.repairType = repairType;
    }

    public String getRepairType() {
        return repairType;
    }

    public void setRepairType(String repairType) {
        this.repairType = repairType;
    }
}

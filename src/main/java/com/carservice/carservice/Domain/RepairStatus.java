package com.carservice.carservice.Domain;


public enum RepairStatus {


            PENDING("Pending"),
            IN_PROGRESS("In Progress"),
            COMPLETED("Completed");


    private String repairStatus;

    RepairStatus(String repairStatus) {
        this.repairStatus = repairStatus;
    }

    public String getRepairStatus() {
        return repairStatus;
    }

    public void setRepairStatus(String repairStatus) {
        this.repairStatus = repairStatus;
    }
}

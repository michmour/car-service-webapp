package com.carservice.carservice.Converters;

import com.carservice.carservice.Domain.Repair;
import com.carservice.carservice.Models.RepairForm;

public class RepairConverter {

    public static Repair buildRepairObject(RepairForm repairForm) {
        Repair repair = new Repair();
        if(repairForm.getServiceid()!=null) {
            repair.setServiceid(repairForm.getServiceid());
        }
        repair.setServicedate(repairForm.getServicedate());
        repair.setStatus(repairForm.getStatus());
        repair.setServicecost(repairForm.getServicecost());
        repair.setType(repairForm.getType());
        repair.setDetails(repairForm.getDetails());
        repair.setUserelid(repairForm.getUserelid());

        return repair;
    }
}
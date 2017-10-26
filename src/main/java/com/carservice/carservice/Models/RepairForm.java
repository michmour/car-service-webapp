package com.carservice.carservice.Models;

import com.carservice.carservice.Domain.Repair;
import com.carservice.carservice.Domain.RepairStatus;
import com.carservice.carservice.Domain.RepairType;
import com.carservice.carservice.Domain.User;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;
import java.util.List;



public class RepairForm {


    private static final String NUMBERS_PATTERN = "^[0-9]*$";


    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private LocalDateTime servicedate;
    private RepairStatus status;

    private int servicecost;

    private RepairType type;
    private String details;
    private User userelid;
    private Long serviceid;

    public LocalDateTime getServicedate() {
        return servicedate;
    }

    public void setServicedate(LocalDateTime servicedate) {
        this.servicedate = servicedate;
    }

    public RepairStatus getStatus() {
        return status;
    }

    public void setStatus(RepairStatus status) {
        this.status = status;
    }

    public int getServicecost() {
        return servicecost;
    }

    public void setServicecost(int servicecost) {
        this.servicecost = servicecost;
    }

    public RepairType getType() {
        return type;
    }

    public void setType(RepairType type) {
        this.type = type;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public User getUserelid() {
        return userelid;
    }

    public void setUserelid(User userelid) {
        this.userelid = userelid;
    }

    public Long getServiceid() {
        return serviceid;
    }

    public void setServiceid(Long serviceid) {
        this.serviceid = serviceid;
    }
}

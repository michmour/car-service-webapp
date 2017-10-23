package com.carservice.carservice.Models;

import com.carservice.carservice.Domain.Repair;
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
    private String status;

    private int servicecost;

    private String type;
    private String details;
    private User userelid;
    private Long serviceid;

    public LocalDateTime getServicedate() {
        return servicedate;
    }

    public void setServicedate(LocalDateTime servicedate) {
        this.servicedate = servicedate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getServicecost() {
        return servicecost;
    }

    public void setServicecost(int servicecost) {
        this.servicecost = servicecost;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
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

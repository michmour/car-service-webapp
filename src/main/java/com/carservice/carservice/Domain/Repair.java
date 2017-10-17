package com.carservice.carservice.Domain;


import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import javax.validation.constraints.Digits;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;

@Entity
@Table(name="repair")
public class Repair implements Serializable {

    @Id
    @Column(name = "serviceid", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long serviceid;

    @Column(name = "servicedate")
    private java.sql.Timestamp servicedate;


    @Column(name = "status")
    private int status;

    @Column(name = "type")
    private int type;

    @Digits(integer=10, fraction=2)
    @Column(name = "servicecost")
    private String servicecost;

    @Column(name = "details")
    private String details;

    @Column(name = "createdAt",nullable = false, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @CreatedDate
    private Date createdAt;

    @Column(name = "updatedAt",nullable = false, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @LastModifiedDate
    private Date updatedAt;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="userRelid",referencedColumnName= "userid")
    private User userRelid;

//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (!(o instanceof Repair)) return false;
//
//        return serviceid != null && serviceid.equals(((Repair) o).serviceid);
//    }
//
//    @Override
//    public int hashCode() {
//        return getUserRelid().hashCode();
//    }

    public Repair() {

    }


//        @OneToMany(mappedBy="userid",targetEntity= Vehicle.class)
//        private Set<Vehicle> vehiclescollection;



    public Repair(long serviceid, Timestamp servicedate, int status, int type, String servicecost, String details, Date createdAt, Date updatedAt, User userRelid) {
        this.serviceid = serviceid;
        this.servicedate = servicedate;
        this.status = status;
        this.type = type;
        this.servicecost = servicecost;
        this.details = details;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.userRelid = userRelid;
    }

    public long getServiceid() {
        return serviceid;
    }

    public void setServiceid(long serviceid) {
        this.serviceid = serviceid;
    }

    public Timestamp getServicedate() {
        return servicedate;
    }

    public void setServicedate(Timestamp servicedate) {
        this.servicedate = servicedate;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getServicecost() {
        return servicecost;
    }

    public void setServicecost(String servicecost) {
        this.servicecost = servicecost;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public User getUserRelid() {
        return userRelid;
    }

    public void setUserRelid(User userid) {
        this.userRelid = userid;
    }
}
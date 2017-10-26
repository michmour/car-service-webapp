package com.carservice.carservice.Domain;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name="vehicle")
@EntityListeners(AuditingEntityListener.class)
public class Vehicle implements Serializable {

    @Id
    @Column(name = "vehicleid", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long vehicleid;


    @Column(name = "platenumber", unique=true)
    private String platenumber;

    @Enumerated(EnumType.STRING)
    @Column(name = "vehiclemodel")
    private VehicleBrands vehiclemodel;


    @Column(name = "year")
    private String year;

    @Column(name = "colour")
    private String colour;

    @Column(name = "createdAt", nullable = false, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @CreatedDate
    private Date createdAt;

    @Column(name = "updatedAt", nullable = false, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @LastModifiedDate
    private Date updatedAt;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "userelid", referencedColumnName = "userid")
    private User userelid;

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

    public Vehicle() {

    }

    public Vehicle(Long vehicleid, String platenumber, VehicleBrands vehiclemodel, String year, String colour, Date createdAt, Date updatedAt, User userelid) {
        this.vehicleid = vehicleid;
        this.platenumber = platenumber;
        this.vehiclemodel = vehiclemodel;
        this.year = year;
        this.colour = colour;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.userelid = userelid;
    }

    public Long getVehicleid() {
        return vehicleid;
    }

    public void setVehicleid(Long vehicleid) {
        this.vehicleid = vehicleid;
    }

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

    public User getUserelid() {
        return userelid;
    }

    public void setUserelid(User userelid) {
        this.userelid = userelid;
    }
}
package com.carservice.carservice.models;


import javax.persistence.*;
import javax.validation.constraints.Digits;
import java.io.Serializable;
import java.sql.Timestamp;

@Entity
@Table(name="services")
public class Service implements Serializable {

    @Id
    @Column(name = "serviceid", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long serviceid;

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

    @ManyToOne(optional=false)
    @JoinColumn(name="userid",referencedColumnName= "userid")
    private User userid;

    public Service() {

    }


//        @OneToMany(mappedBy="userid",targetEntity= Vehicle.class)
//        private Set<Vehicle> vehiclescollection;



    public Service(long serviceid, Timestamp servicedate, int status, int type, String servicecost, String details, User userid) {
        this.serviceid = serviceid;
        this.servicedate = servicedate;
        this.status = status;
        this.type = type;
        this.servicecost = servicecost;
        this.details = details;
        this.userid = userid;
    }
}
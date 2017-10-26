package com.carservice.carservice.Domain;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;


import javax.persistence.*;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Future;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Table(name="repair")
@EntityListeners(AuditingEntityListener.class)
public class Repair implements Serializable {

    @Id
    @Column(name = "serviceid", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long serviceid;


    @JsonFormat(pattern = "dd/MM/yyyy KK:mm a")
    @Column(name = "servicedate")
    private LocalDateTime servicedate;

    @JsonIgnore
    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private RepairStatus status;

    @Enumerated(EnumType.STRING)
    @Column(name = "type")
    private RepairType type;

    //@Digits(integer=10, fraction=2)
    @JsonIgnore
    @Column(name = "servicecost")
    private int servicecost;

    @JsonIgnore
    @Column(name = "details")
    private String details;

    @JsonIgnore
    @Column(name = "createdAt",nullable = false, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @CreatedDate
    private Date createdAt;

    @JsonIgnore
    @Column(name = "updatedAt",nullable = false, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @LastModifiedDate
    private Date updatedAt;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="userelid",referencedColumnName= "userid")
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

    public Repair() {

    }


//        @OneToMany(mappedBy="userid",targetEntity= Vehicle.class)
//        private Set<Vehicle> vehiclescollection;



    public Repair(Long serviceid, LocalDateTime servicedate, RepairStatus status, RepairType type, int servicecost, String details, Date createdAt, Date updatedAt, User userelid) {
        this.serviceid = serviceid;
        this.servicedate = servicedate;
        this.status = status;
        this.type = type;
        this.servicecost = servicecost;
        this.details = details;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.userelid = userelid;
    }

    public Long getServiceid() {
        return serviceid;
    }

    public void setServiceid(Long serviceid) {
        this.serviceid = serviceid;
    }

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

    public RepairType getType() {
        return type;
    }

    public void setType(RepairType type) {
        this.type = type;
    }

    public int getServicecost() {
        return servicecost;
    }

    public void setServicecost(int servicecost) {
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

    public User getUserelid() {
        return userelid;
    }

    public void setUserelid(User userelid) {
        this.userelid = userelid;
    }



}
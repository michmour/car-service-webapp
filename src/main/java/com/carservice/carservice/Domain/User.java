package com.carservice.carservice.Domain;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Set;

    @Entity
    @Table(name="user")
    @EntityListeners(AuditingEntityListener.class)
    public class User implements Serializable {

        @Id
        @Column(name = "userid", nullable = false)
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long userid;

        @Column(name = "ssn", unique=true)
        private String ssn;

        @Column(name = "name")
        private String name;


        @Column(name = "surname")
        private String surname;

        @Column(name = "address")
        private String address;

        @Column(name = "email", unique=true)
        private String email;

        @JsonIgnore
        @Column(name = "password")
        private String password;

        @JsonIgnore
        @Column(name = "usertype")
        private String usertype;

        @JsonIgnore
        @Column(name = "createdAt",nullable = false, updatable = false)
        @Temporal(TemporalType.TIMESTAMP)
        @CreatedDate
        private Date createdAt;

        @JsonIgnore
        @Column(name = "updatedAt", nullable = false)
        @Temporal(TemporalType.TIMESTAMP)
        @LastModifiedDate
        private Date updatedAt;

        @JsonIgnore
        @OneToMany(cascade={CascadeType.REMOVE}, mappedBy="userelid",orphanRemoval = true)
        private List<Repair>servicescollection;

        @JsonIgnore
        @OneToMany(cascade={CascadeType.REMOVE}, mappedBy="userelid",orphanRemoval = true)
        private List<Vehicle>vehiclescollection;

//        public void addServicesCollection(Repair servicecollection) {
//            servicescollection.add(servicecollection);
//            servicecollection.setUserelid(this);
//        }
//
//        public void removeServicesCollection(Repair servicecollection) {
//            servicescollection.remove(servicecollection);
//            servicecollection.setUserelid(null);
//        }

        public User() {

        }

        public User(Long userid, String ssn, String name, String surname, String address, String email, String password, String usertype, Date createdAt, Date updatedAt, List<Repair> servicescollection,List<Vehicle> vehiclescollection) {
            this.userid = userid;
            this.ssn = ssn;
            this.name = name;
            this.surname = surname;
            this.address = address;
            this.email = email;
            this.password = password;
            this.usertype = usertype;
            this.createdAt = createdAt;
            this.updatedAt = updatedAt;
            this.servicescollection = servicescollection;
            this.vehiclescollection = vehiclescollection;
        }



//        @OneToMany(mappedBy="userid",targetEntity= Vehicle.class)
//        private Set<Vehicle> vehiclescollection;




    public Long getUserid() {
            return userid;
        }

        public void setUserid(Long userid) {
            this.userid = userid;
        }

        public String getSsn() {
            return ssn;
        }

        public void setSsn(String ssn) {
            this.ssn = ssn;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getSurname() {
            return surname;
        }

        public void setSurname(String surname) {
            this.surname = surname;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public String getUsertype() {
            return usertype;
        }

        public void setUsertype(String usertype) {
            this.usertype = usertype;
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

        public List<Repair> getServicescollection() {
            return servicescollection;
        }

        public void setServicescollection(List<Repair> servicescollection) {
            this.servicescollection = servicescollection;
        }

        public List<Vehicle> getVehiclescollection() {
            return vehiclescollection;
        }

        public void setVehiclescollection(List<Vehicle> vehiclescollection) {
            this.vehiclescollection = vehiclescollection;
        }

        //        public void setServicescollection(List<Repair> servicescollection) {
//            if (this.servicescollection == null) {
//                this.servicescollection = servicescollection;
//            } else {
//                this.servicescollection.retainAll(servicescollection);
//                this.servicescollection.addAll(servicescollection);
//            }
//        }
//        @Override
//        public String toString() {
//            String result = String.format(
//                    "Category[id=%d, name='%s']%n",
//                    userid, name);
//            if (servicescollection != null) {
//                for(Repair servicecollection : servicescollection) {
//                    result += String.format(
//                            "Service[id=%d, details='%s']%n",
//                            servicecollection.getServiceid(), servicecollection.getDetails());
//                }
//            }
//
//            return result;
//        }
    }

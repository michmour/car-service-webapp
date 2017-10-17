package com.carservice.carservice.Domain;


import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Set;

    @Entity
    @Table(name="user")
    @EntityListeners(AuditingEntityListener.class)
    public class User implements Serializable {

        @Id
        @Column(name = "userid", nullable = false)
        @GeneratedValue(strategy = GenerationType.AUTO)
        private long userid;

        @Column(name = "ssn")
        private String ssn;

        @Column(name = "name")
        private String name;

        @Column(name = "surname")
        private String surname;

        @Column(name = "address")
        private String address;

        @Column(name = "email")
        private String email;

        @Column(name = "password")
        private String password;

        @Column(name = "usertype")
        private int usertype;

        @Column(name = "createdAt",nullable = false, updatable = false)
        @Temporal(TemporalType.TIMESTAMP)
        @CreatedDate
        private Date createdAt;

        @Column(name = "updatedAt", nullable = false)
        @Temporal(TemporalType.TIMESTAMP)
        @LastModifiedDate
        private Date updatedAt;

        @OneToMany(cascade = CascadeType.ALL,mappedBy="userid",orphanRemoval = true,targetEntity= Repair.class)
        private Set<Repair>servicescollection;

        public User() {

        }

        public User(long userid, String ssn, String name, String surname, String address, String email, String password, int usertype, Date createdAt, Date updatedAt, Set<Repair> servicescollection) {
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
        }



//        @OneToMany(mappedBy="userid",targetEntity= Vehicle.class)
//        private Set<Vehicle> vehiclescollection;




    public long getUserid() {
            return userid;
        }

        public void setUserid(long userid) {
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

        public int getUsertype() {
            return usertype;
        }

        public void setUsertype(int usertype) {
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

        public Set<Repair> getServicescollection() {
            return servicescollection;
        }

        public void setServicescollection(Set<Repair> servicescollection) {
            this.servicescollection = servicescollection;
        }
    }

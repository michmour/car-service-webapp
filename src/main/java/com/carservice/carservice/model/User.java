package com.carservice.carservice.model;


import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
    @Table(name="user")
    public class User implements Serializable {

        @Id
        @Column(name = "userid", nullable = false)
        @GeneratedValue(strategy = GenerationType.AUTO)
        private long userid;

        @Column(name = "ssn")
        private int ssn;

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


        public User() {

        }

        public User(long userid, int ssn, String name, String surname, String address, String email, String password, int usertype, User order) {
            this.userid = userid;
            this.ssn = ssn;
            this.name = name;
            this.surname = surname;
            this.address = address;
            this.email = email;
            this.password = password;
            this.usertype = usertype;
        }


//        @OneToMany(mappedBy="userid",targetEntity= Vehicle.class)
//        private Set<Vehicle> vehiclescollection;

        @OneToMany(mappedBy="userid",targetEntity= Service.class)
        private Set<Service>servicescollection;


    public long getUserid() {
            return userid;
        }

        public void setUserid(long userid) {
            this.userid = userid;
        }

        public int getSsn() {
            return ssn;
        }

        public void setSsn(int ssn) {
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

    }

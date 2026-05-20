package com.example.banking.entity;

import jakarta.persistence.*;


@Table(name = "addresses")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    private String street;
    private String city;
    private long pinCode;
    private String state;
    private String country;

    public Address(Long id, String street, String city, long pinCode, String state, String country) {
        this.id = id;
        this.street = street;
        this.city = city;
        this.pinCode = pinCode;
        this.state = state;
        this.country = country;
    }

    public Address(String street, String city, String state, long pin, String country) {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public long getPinCode() {
        return pinCode;
    }

    public void setPinCode(long pinCode) {
        this.pinCode = pinCode;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}

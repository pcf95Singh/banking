package com.example.banking.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;


@Table(name = "addresses")
@Schema(description = "Customer address")
public class Address {

    private String addressLine1;
    private String addressLine2;
    private String city;
    private long pinCode;
    private String state;
    private String country;

    public Address(String addressLine1, String addressLine2, String city, long pinCode, String state, String country) {
        this.addressLine1 = addressLine1;
        this.addressLine2 = addressLine2;
        this.city = city;
        this.pinCode = pinCode;
        this.state = state;
        this.country = country;
    }
    public Address(){}

    public Address(String addressLine1, String addressLine2, String city, String state, long pin, String country) {
    }

    public String getAddressLine1() {
        return addressLine1;
    }

    public void setAddressLine1(String addressLine1) {
        this.addressLine1 = addressLine1;
    }

    public String getAddressLine2() {
        return addressLine2;
    }

    public void setAddressLine2(String addressLine2) {
        this.addressLine2 = addressLine2;
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

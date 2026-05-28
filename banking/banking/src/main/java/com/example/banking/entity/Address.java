package com.example.banking.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import jakarta.validation.constraints.Pattern;

@Entity
@Table(name = "addresses")
@Schema(description = "Customer address stored in a separate table")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String addressLine1;
    private String addressLine2;
    private String city;

    @Schema(description = "Postal code", example = "400001")
    @Pattern(regexp = "^[0-9]{6}$", message = "Pincode must be exactly 6 digits")
    private String pinCode;

    private String state;
    private String country;

    // Bi-directional relationship mapping back to the owner
    @OneToOne
    @JoinColumn(name = "user_id") // Creates a 'user_id' foreign key column inside the 'addresses' table
    private UserProfile userProfile;

    // Standard Default Constructor
    public Address() {}

    // Master Constructor
    public Address(String addressLine1, String addressLine2, String city, String pinCode, String state, String country) {
        this.addressLine1 = addressLine1;
        this.addressLine2 = addressLine2;
        this.city = city;
        this.pinCode = pinCode;
        this.state = state;
        this.country = country;
    }

    // Getters and Setters for all fields (including id and userProfile)
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getAddressLine1() { return addressLine1; }
    public void setAddressLine1(String addressLine1) { this.addressLine1 = addressLine1; }

    public String getAddressLine2() { return addressLine2; }
    public void setAddressLine2(String addressLine2) { this.addressLine2 = addressLine2; }

    public String getCity() { return city; }
    public void setCity(String city) { this.city = city; }

    public String getPinCode() { return pinCode; }
    public void setPinCode(String pinCode) { this.pinCode = pinCode; }

    public String getState() { return state; }
    public void setState(String state) { this.state = state; }

    public String getCountry() { return country; }
    public void setCountry(String country) { this.country = country; }

    public void setUserProfile(UserProfile userProfile) { this.userProfile = userProfile; }
}
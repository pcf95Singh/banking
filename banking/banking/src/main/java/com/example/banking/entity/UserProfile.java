package com.example.banking.entity;

import com.example.banking.entity.converter.AddressConverter;
import com.example.banking.entity.converter.FullNameConverter;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "user_information")
public class UserProfile {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @Convert(converter = FullNameConverter.class)
    @Column(name = "customer_name", nullable = false)
    private FullName customerName;

    @Convert(converter = AddressConverter.class)
    @Column(name = "customer_address", nullable = false)
    private Address customerAddress;

    @Email( message = "Invalid email format")
    @Column(name = "email_id", nullable = false)
    private String emailId;

    @Size(max = 10, message = "Invalid mobile number")
    @Column(name = "contact_number", unique = true, nullable = false)
    private String mobileNumber;

    @Pattern(regexp = "^[A-Z]{5}[0-9]{4}[A-Z]{1}$", message = "Invalid pan number")
    @Column(name = "pan_number", nullable = false)
    private String panNumber;

    @Size(max = 12, message = "Invalid Aadhaar Number")
    @Column(name = "aadhaar_number", nullable = false)
    private String aadhaarNumber;

    public UserProfile() {
    }

    public UserProfile(Long id, FullName customerName, Address customerAddress, String emailId, String mobileNumber, String panNumber, String aadhaarNumber) {
        this.id = id;
        this.customerName = customerName;
        this.customerAddress = customerAddress;
        this.emailId = emailId;
        this.mobileNumber = mobileNumber;
        this.panNumber = panNumber;
        this.aadhaarNumber = aadhaarNumber;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public FullName getCustomerName() {
        return customerName;
    }

    public void setCustomerName(FullName customerName) {
        this.customerName = customerName;
    }

    public Address getCustomerAddress() {
        return customerAddress;
    }

    public void setCustomerAddress(Address customerAddress) {
        this.customerAddress = customerAddress;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getPanNumber() {
        return panNumber;
    }

    public void setPanNumber(String panNumber) {
        this.panNumber = panNumber;
    }

    public String getAadhaarNumber() {
        return aadhaarNumber;
    }

    public void setAadhaarNumber(String aadhaarNumber) {
        this.aadhaarNumber = aadhaarNumber;
    }
}

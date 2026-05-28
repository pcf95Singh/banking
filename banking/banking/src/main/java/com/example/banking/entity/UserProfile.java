package com.example.banking.entity;

import com.example.banking.entity.converter.FullNameConverter;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;
import io.swagger.v3.oas.annotations.media.Schema;

@Entity
@Table(name = "user_information")
public class UserProfile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Convert(converter = FullNameConverter.class)
    @Column(name = "customer_name", nullable = false)
    @Valid
    private FullName customerName;

    @OneToOne(mappedBy = "userProfile", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @Valid
    private Address customerAddress;

    @Email( message = "Invalid email format")
    @Schema(description = "Customer email address", example = "krishna@gmail.com")
    @Column(name = "email_id", nullable = false)
    private String emailId;

    @Schema(description = "10 digit mobile number", example = "9876543210")
    @Pattern(regexp = "^[0-9]{10}$", message = "Invalid mobile number")
    @Column(name = "contact_number", unique = true, nullable = false)
    private String mobileNumber;

    @Schema(description = "PAN card number", example = "ABCDE1234F")
    @Pattern(regexp = "^[A-Z]{5}[0-9]{4}[A-Z]{1}$")
    @Column(name = "pan_number", nullable = false)
    private String panNumber;

    @Schema(description = "12 digit Aadhaar number", example = "123456789012")
    @Pattern(regexp = "^[0-9]{12}$")
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

    public void setCustomerAddress(Address address) {
        this.customerAddress = address;
        if (address != null){
            address.setUserProfile(this);
        }
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

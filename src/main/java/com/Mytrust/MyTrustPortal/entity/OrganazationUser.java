package com.Mytrust.MyTrustPortal.entity;


import org.json.JSONObject;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.sql.Blob;
import java.util.Arrays;

@Entity
@Table(name = "onboarding_application")
public class OrganazationUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "application_id")
    String applicationId;

    @Column(name = "name")
    String name;



    @Column(name = "email")
    String email;


    @Column(name = "tax_no")
    String taxNo;

    @Column(name = "mobile_no")
    String mobileNo;

    @Column(name = "landline")
    String landline;


    @Column(name = "address")
    String address;

    @Column(name = "pin_code")
    String pinCode;
    @Column(name = "country")
    String country;

    @Column(name = "created_at")
    String createdAt;


    @Column(name = "updated_at")
    String updatedAt;

    @Column(name = "status")
    String status;

    @Column(name = "expire_date")
    String expireDate;

    @Column(name = "subscriber_suid")
    String subscriberSuid;

    @Lob
    @Column(name = "organazation_logo")
    byte[] organazationLogo;



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getApplicationId() {
        return applicationId;
    }

    public void setApplicationId(String applicationId) {
        this.applicationId = applicationId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTaxNo() {
        return taxNo;
    }

    public void setTaxNo(String taxNo) {
        this.taxNo = taxNo;
    }

    public String getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    public String getLandline() {
        return landline;
    }

    public void setLandline(String landline) {
        this.landline = landline;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPinCode() {
        return pinCode;
    }

    public void setPinCode(String pinCode) {
        this.pinCode = pinCode;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getExpireDate() {
        return expireDate;
    }

    public void setExpireDate(String expireDate) {
        this.expireDate = expireDate;
    }

    public String getSubscriberSuid() {
        return subscriberSuid;
    }

    public void setSubscriberSuid(String subscriberSuid) {
        this.subscriberSuid = subscriberSuid;
    }

    public byte[] getOrganazationLogo() {
        return organazationLogo;
    }

    public void setOrganazationLogo(byte[] organazationLogo) {
        this.organazationLogo = organazationLogo;
    }

    @Override
    public String toString() {
        return "OrganazationUser{" +
                "id=" + id +
                ", applicationId='" + applicationId + '\'' +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", taxNo='" + taxNo + '\'' +
                ", mobileNo='" + mobileNo + '\'' +
                ", landline='" + landline + '\'' +
                ", address='" + address + '\'' +
                ", pinCode='" + pinCode + '\'' +
                ", country='" + country + '\'' +
                ", createdAt='" + createdAt + '\'' +
                ", updatedAt='" + updatedAt + '\'' +
                ", status='" + status + '\'' +
                ", expireDate='" + expireDate + '\'' +
                ", subscriberSuid='" + subscriberSuid + '\'' +
                ", organazationLogo=" + Arrays.toString(organazationLogo) +
                '}';
    }
}

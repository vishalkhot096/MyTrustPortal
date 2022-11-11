package com.Mytrust.MyTrustPortal.dto;


import java.util.Arrays;

public class OrganazationRegDTO {
    int id;
    String applicationId;
    String name;
    String email;
    String taxNo;
    String mobileNo;
    String landline;
    String address;
    String pinCode;
    String country;
    String createdAt;
    String updatedAt;
    String status;
    String expireDate;
    String subscriberSuid;
//    String organizationsLogo;

    byte[] organizationsLogo;




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

    public byte[] getOrganizationsLogo() {
        return organizationsLogo;
    }

    public void setOrganizationsLogo(byte[] organizationsLogo) {
        this.organizationsLogo = organizationsLogo;
    }

    @Override
    public String toString() {
        return "OrganazationRegDTO{" +
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
                ", organizationsLogo=" + Arrays.toString(organizationsLogo) +
                '}';
    }
}

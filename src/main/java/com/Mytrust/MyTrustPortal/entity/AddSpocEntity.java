package com.Mytrust.MyTrustPortal.entity;

import javax.persistence.*;

@Entity
@Table(name = "spoc_user")
public class AddSpocEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int spocId;

    @Column(name = "application_id")
    String applicationId;

    @Column(name = "spoc_Name")
    String spocName;

    @Column(name = "spocOffice_email")
    String spocOfficeEmail;

    @Column(name = "spocMyTrust_email")
    String spocMyTrustEmail;

    @Column(name = "spocMobile_number")
    String spocMobileNumber;

    public int getSpocId() {
        return spocId;
    }

    public void setSpocId(int spocId) {
        this.spocId = spocId;
    }

    public String getApplicationId() {
        return applicationId;
    }

    public void setApplicationId(String applicationId) {
        this.applicationId = applicationId;
    }

    public String getSpocName() {
        return spocName;
    }

    public void setSpocName(String spocName) {
        this.spocName = spocName;
    }

    public String getSpocOfficeEmail() {
        return spocOfficeEmail;
    }

    public void setSpocOfficeEmail(String spocOfficeEmail) {
        this.spocOfficeEmail = spocOfficeEmail;
    }

    public String getSpocMyTrustEmail() {
        return spocMyTrustEmail;
    }

    public void setSpocMyTrustEmail(String spocMyTrustEmail) {
        this.spocMyTrustEmail = spocMyTrustEmail;
    }

    public String getSpocMobileNumber() {
        return spocMobileNumber;
    }

    public void setSpocMobileNumber(String spocMobileNumber) {
        this.spocMobileNumber = spocMobileNumber;
    }

    @Override
    public String toString() {
        return "AddSpocEntity{" +
                "spocId=" + spocId +
                ", applicationId='" + applicationId + '\'' +
                ", spocName='" + spocName + '\'' +
                ", spocOfficeEmail='" + spocOfficeEmail + '\'' +
                ", spocMyTrustEmail='" + spocMyTrustEmail + '\'' +
                ", spocMobileNumber='" + spocMobileNumber + '\'' +
                '}';
    }
}

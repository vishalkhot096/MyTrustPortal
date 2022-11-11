package com.Mytrust.MyTrustPortal.dto;

public class AddSpocUserDTO {

     private String applicationId;

     private String spocName;

     private String spocOfficeEmail;

     private String spocMyTrustEmail;

     private String spocMobileNumber;

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
        return "AddSpocUserDTO{" +
                "applicationId='" + applicationId + '\'' +
                ", spocName='" + spocName + '\'' +
                ", spocOfficeEmail='" + spocOfficeEmail + '\'' +
                ", spocMyTrustEmail='" + spocMyTrustEmail + '\'' +
                ", spocMobileNumber='" + spocMobileNumber + '\'' +
                '}';
    }
}

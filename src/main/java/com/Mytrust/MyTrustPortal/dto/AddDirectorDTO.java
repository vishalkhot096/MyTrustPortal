package com.Mytrust.MyTrustPortal.dto;

public class AddDirectorDTO {

    private String applicationId;

    private String directorName;

    private String officeEmail;

    private String mytrustEmail;

    private String mobileNumber;

    public String getApplicationId() {
        return applicationId;
    }

    public void setApplicationId(String applicationId) {
        this.applicationId = applicationId;
    }

    public String getDirectorName() {
        return directorName;
    }

    public void setDirectorName(String directorName) {
        this.directorName = directorName;
    }

    public String getOfficeEmail() {
        return officeEmail;
    }

    public void setOfficeEmail(String officeEmail) {
        this.officeEmail = officeEmail;
    }

    public String getMytrustEmail() {
        return mytrustEmail;
    }

    public void setMytrustEmail(String mytrustEmail) {
        this.mytrustEmail = mytrustEmail;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    @Override
    public String toString() {
        return "AddDirectorDTO{" +
                "applicationId='" + applicationId + '\'' +
                ", directorName='" + directorName + '\'' +
                ", officeEmail='" + officeEmail + '\'' +
                ", mytrustEmail='" + mytrustEmail + '\'' +
                ", mobileNumber='" + mobileNumber + '\'' +
                '}';
    }
}

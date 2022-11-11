package com.Mytrust.MyTrustPortal.restController;

public class UserInfo {
    //String username;
    String email;
    String gender;
    String name;
    String suid;
    String birthdate;
    String phone;
    String id_document_type;
    String id_document_number;
    String loa;
    String country;
    String idToken;

    String applicationID;

    public UserInfo() {
    }

//    public String getUsername() {
//        return username;
//    }
//
//    public void setUsername(String username) {
//        this.username = username;
//    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSuid() {
        return suid;
    }

    public void setSuid(String suid) {
        this.suid = suid;
    }

    public String getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(String birthdate) {
        this.birthdate = birthdate;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getId_document_type() {
        return id_document_type;
    }

    public void setId_document_type(String id_document_type) {
        this.id_document_type = id_document_type;
    }

    public String getId_document_number() {
        return id_document_number;
    }

    public void setId_document_number(String id_document_number) {
        this.id_document_number = id_document_number;
    }

    public String getLoa() {
        return loa;
    }

    public void setLoa(String loa) {
        this.loa = loa;
    }

    public String getIdToken() {
        return idToken;
    }

    public void setIdToken(String idToken) {
        this.idToken = idToken;
    }

    public String getApplicationID() {
        return applicationID;
    }

    public void setApplicationID(String applicationID) {
        this.applicationID = applicationID;
    }

    @Override
    public String toString() {
        return "UserInfo{" +
                "email='" + email + '\'' +
                ", gender='" + gender + '\'' +
                ", name='" + name + '\'' +
                ", suid='" + suid + '\'' +
                ", birthdate='" + birthdate + '\'' +
                ", phone='" + phone + '\'' +
                ", id_document_type='" + id_document_type + '\'' +
                ", id_document_number='" + id_document_number + '\'' +
                ", loa='" + loa + '\'' +
                ", country='" + country + '\'' +
                ", idToken='" + idToken + '\'' +
                ", applicationID='" + applicationID + '\'' +
                '}';
    }
}

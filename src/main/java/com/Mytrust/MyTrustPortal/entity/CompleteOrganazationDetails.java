package com.Mytrust.MyTrustPortal.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Arrays;

@Entity
@Table(name = "complete_organazations_details")
public class CompleteOrganazationDetails {

    @Id
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



    @Column(name = "pin_code")
    String pinCode;
    @Column(name = "country")
    String country;


    @Column(name = "tax_letter")
    byte[] texLetter;

    @Column(name = "incorporation_letter")
    byte[] incorporationLetter;

    @Column(name = "additional_doc")
    byte[] additionalDoc;

    @Column(name = "additional_doc2")
    byte[] additionalDoc2;

    @Column(name = "additional_doc3")
    byte[] additionalDoc3;

    @Column(name = "additional_doc_file_name")
    String additionalDocFileName;

    @Column(name = "additional_doc2_file_name")
    String additionalDocFileName2;

    @Column(name = "additional_doc3_file_name")
    String additionalDocFileName3;

    @Column(name = "tax_file_name")
    String taxFileName;

    @Column(name = "incorporation_file_name")
    String incorporationFileName;

    @Column(name = "director_name")
    String director_name;

    @Column(name = "office_email")
    String office_email;

    @Column(name = "mytrust_email")
    String mytrust_email;

    @Column(name = "mobile_number")
    String mobile_number;

    @Column(name = "spoc_Name")
    String spocName;

    @Column(name = "spocOffice_email")
    String spocOfficeEmail;

    @Column(name = "spocMyTrust_email")
    String spocMyTrustEmail;

    @Column(name = "spocMobile_number")
    String spocMobileNumber;

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

    public byte[] getTexLetter() {
        return texLetter;
    }

    public void setTexLetter(byte[] texLetter) {
        this.texLetter = texLetter;
    }

    public byte[] getIncorporationLetter() {
        return incorporationLetter;
    }

    public void setIncorporationLetter(byte[] incorporationLetter) {
        this.incorporationLetter = incorporationLetter;
    }

    public byte[] getAdditionalDoc() {
        return additionalDoc;
    }

    public void setAdditionalDoc(byte[] additionalDoc) {
        this.additionalDoc = additionalDoc;
    }

    public byte[] getAdditionalDoc2() {
        return additionalDoc2;
    }

    public void setAdditionalDoc2(byte[] additionalDoc2) {
        this.additionalDoc2 = additionalDoc2;
    }

    public byte[] getAdditionalDoc3() {
        return additionalDoc3;
    }

    public void setAdditionalDoc3(byte[] additionalDoc3) {
        this.additionalDoc3 = additionalDoc3;
    }

    public String getAdditionalDocFileName() {
        return additionalDocFileName;
    }

    public void setAdditionalDocFileName(String additionalDocFileName) {
        this.additionalDocFileName = additionalDocFileName;
    }

    public String getAdditionalDocFileName2() {
        return additionalDocFileName2;
    }

    public void setAdditionalDocFileName2(String additionalDocFileName2) {
        this.additionalDocFileName2 = additionalDocFileName2;
    }

    public String getAdditionalDocFileName3() {
        return additionalDocFileName3;
    }

    public void setAdditionalDocFileName3(String additionalDocFileName3) {
        this.additionalDocFileName3 = additionalDocFileName3;
    }

    public String getTaxFileName() {
        return taxFileName;
    }

    public void setTaxFileName(String taxFileName) {
        this.taxFileName = taxFileName;
    }

    public String getIncorporationFileName() {
        return incorporationFileName;
    }

    public void setIncorporationFileName(String incorporationFileName) {
        this.incorporationFileName = incorporationFileName;
    }

    public String getDirector_name() {
        return director_name;
    }

    public void setDirector_name(String director_name) {
        this.director_name = director_name;
    }

    public String getOffice_email() {
        return office_email;
    }

    public void setOffice_email(String office_email) {
        this.office_email = office_email;
    }

    public String getMytrust_email() {
        return mytrust_email;
    }

    public void setMytrust_email(String mytrust_email) {
        this.mytrust_email = mytrust_email;
    }

    public String getMobile_number() {
        return mobile_number;
    }

    public void setMobile_number(String mobile_number) {
        this.mobile_number = mobile_number;
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
        return "CompleteOrganazationDetails{" +
                "applicationId='" + applicationId + '\'' +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", taxNo='" + taxNo + '\'' +
                ", mobileNo='" + mobileNo + '\'' +
                ", pinCode='" + pinCode + '\'' +
                ", country='" + country + '\'' +
                ", texLetter=" + Arrays.toString(texLetter) +
                ", incorporationLetter=" + Arrays.toString(incorporationLetter) +
                ", additionalDoc=" + Arrays.toString(additionalDoc) +
                ", additionalDoc2=" + Arrays.toString(additionalDoc2) +
                ", additionalDoc3=" + Arrays.toString(additionalDoc3) +
                ", additionalDocFileName='" + additionalDocFileName + '\'' +
                ", additionalDocFileName2='" + additionalDocFileName2 + '\'' +
                ", additionalDocFileName3='" + additionalDocFileName3 + '\'' +
                ", taxFileName='" + taxFileName + '\'' +
                ", incorporationFileName='" + incorporationFileName + '\'' +
                ", director_name='" + director_name + '\'' +
                ", office_email='" + office_email + '\'' +
                ", mytrust_email='" + mytrust_email + '\'' +
                ", mobile_number='" + mobile_number + '\'' +
                ", spocName='" + spocName + '\'' +
                ", spocOfficeEmail='" + spocOfficeEmail + '\'' +
                ", spocMyTrustEmail='" + spocMyTrustEmail + '\'' +
                ", spocMobileNumber='" + spocMobileNumber + '\'' +
                '}';
    }
}

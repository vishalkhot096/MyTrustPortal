package com.Mytrust.MyTrustPortal.dto;


import java.sql.Blob;
import java.util.Arrays;

public class BoardOfDirDTO {

    String applicationId;
    byte[] taxLetter;
    byte[] incorporationLetter;
    byte[] additionalDoc;

    byte[] additionalDoc2;
    byte[]  additionalDoc3;

    String additionalDocFileName;
    String additionalDocFileName2;
    String additionalDocFileName3;
    String taxFileName;
    String incorporationFileName;


    public String getApplicationId() {
        return applicationId;
    }

    public void setApplicationId(String applicationId) {
        this.applicationId = applicationId;
    }

    public byte[] getTaxLetter() {
        return taxLetter;
    }

    public void setTaxLetter(byte[] taxLetter) {
        this.taxLetter = taxLetter;
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

    @Override
    public String toString() {
        return "BoardOfDirDTO{" +
                "applicationId='" + applicationId + '\'' +
                ", taxLetter=" + Arrays.toString(taxLetter) +
                ", incorporationLetter=" + Arrays.toString(incorporationLetter) +
                ", additionalDoc=" + Arrays.toString(additionalDoc) +
                ", additionalDoc2=" + Arrays.toString(additionalDoc2) +
                ", additionalDoc3=" + Arrays.toString(additionalDoc3) +
                ", additionalDocFileName='" + additionalDocFileName + '\'' +
                ", additionalDocFileName2='" + additionalDocFileName2 + '\'' +
                ", additionalDocFileName3='" + additionalDocFileName3 + '\'' +
                ", taxFileName='" + taxFileName + '\'' +
                ", incorporationFileName='" + incorporationFileName + '\'' +
                '}';
    }
}

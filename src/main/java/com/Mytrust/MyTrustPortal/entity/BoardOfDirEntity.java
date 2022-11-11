package com.Mytrust.MyTrustPortal.entity;

import javax.persistence.*;
import java.sql.Blob;
import java.util.Arrays;

@Entity
@Table(name = "legal_document")
public class BoardOfDirEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int legal_id;

    @Column(name = "application_id")
    String applicationId;

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




    public int getLegal_id() {
        return legal_id;
    }

    public void setLegal_id(int legal_id) {
        this.legal_id = legal_id;
    }

    public String getApplicationId() {
        return applicationId;
    }

    public void setApplicationId(String applicationId) {
        this.applicationId = applicationId;
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

    @Override
    public String toString() {
        return "BoardOfDirEntity{" +
                "legal_id=" + legal_id +
                ", applicationId='" + applicationId + '\'' +
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
                '}';
    }
}

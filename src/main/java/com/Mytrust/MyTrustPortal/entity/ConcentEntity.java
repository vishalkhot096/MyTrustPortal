package com.Mytrust.MyTrustPortal.entity;

import javax.persistence.*;
import java.util.Arrays;

@Entity
@Table(name = "concent")
public class ConcentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int concent_id;

    @Column(name = "application_id")
    String application_id;


    @Lob
    @Column(name = "consent_pdf")
    byte[] consentPdf;

    public int getConcent_id() {
        return concent_id;
    }

    public void setConcent_id(int concent_id) {
        this.concent_id = concent_id;
    }

    public String getApplication_id() {
        return application_id;
    }

    public void setApplication_id(String application_id) {
        this.application_id = application_id;
    }


    public byte[] getConsentPdf() {
        return consentPdf;
    }

    public void setConsentPdf(byte[] consentPdf) {
        this.consentPdf = consentPdf;
    }

    @Override
    public String toString() {
        return "ConcentEntity{" +
                "concent_id=" + concent_id +
                ", application_id='" + application_id + '\'' +
                ", consentPdf=" + Arrays.toString(consentPdf) +
                '}';
    }
}

package com.Mytrust.MyTrustPortal.dto;

import javax.persistence.Column;
import java.util.Arrays;

public class ConcentDto {


    String application_id;
    byte[] consentpdf;

    public String getApplication_id() {
        return application_id;
    }

    public void setApplication_id(String application_id) {
        this.application_id = application_id;
    }
    public byte[] getConsentpdf() {
        return consentpdf;
    }

    public void setConsentpdf(byte[] consentpdf) {
        this.consentpdf = consentpdf;
    }

    @Override
    public String toString() {
        return "ConcentDto{" +
                "application_id='" + application_id + '\'' +
                ", consentpdf=" + Arrays.toString(consentpdf) +
                '}';
    }
}

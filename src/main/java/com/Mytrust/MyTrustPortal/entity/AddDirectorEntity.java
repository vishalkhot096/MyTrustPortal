package com.Mytrust.MyTrustPortal.entity;

import javax.persistence.*;

@Entity
@Table(name = "director_add")
public class AddDirectorEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int director_id;

    @Column(name = "application_id")
    String application_id;

    @Column(name = "director_name")
    String director_name;

    @Column(name = "office_email")
    String office_email;

    @Column(name = "mytrust_email")
    String mytrust_email;

    @Column(name = "mobile_number")
    String mobile_number;

    public int getDirector_id() {
        return director_id;
    }

    public void setDirector_id(int director_id) {
        this.director_id = director_id;
    }

    public String getApplication_id() {
        return application_id;
    }

    public void setApplication_id(String application_id) {
        this.application_id = application_id;
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

    @Override
    public String toString() {
        return "AddDirectorEntity{" +
                "director_id=" + director_id +
                ", application_id='" + application_id + '\'' +
                ", director_name='" + director_name + '\'' +
                ", office_email='" + office_email + '\'' +
                ", mytrust_email='" + mytrust_email + '\'' +
                ", mobile_number='" + mobile_number + '\'' +
                '}';
    }
}

package com.example.reservationservice.models;

import javax.persistence.Entity;
import javax.persistence.*;

@Entity
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "workingact")
    private String workingact;

    @Column(name = "charityact")
    private String charityact;

    @Column(name = "idBox")
    private String idBox;

    public Reservation(long id, String workingact, String charityact, String idBox) {
        this.id = id;
        this.workingact = workingact;
        this.charityact = charityact;
        this.idBox = idBox;
    }

    public Reservation(){}

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getWorkingact() {
        return workingact;
    }

    public void setWorkingact(String workingact) {
        this.workingact = workingact;
    }

    public String getCharityact() {
        return charityact;
    }

    public void setCharityact(String charityact) {
        this.charityact = charityact;
    }

    public String getIdBox() {
        return idBox;
    }

    public void setIdBox(String idBox) {
        this.idBox = idBox;
    }
    @Override
    public String toString() {
        return this.getId() + "-" + this.getWorkingact() + "-" + this.getCharityact() + "-" + this.getIdBox();
    }
}


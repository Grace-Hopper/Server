package com.receticas.models;

import javax.persistence.*;
import java.io.Serializable;

@Entity(name = "steps")
@Table(name = "steps")
public class Step implements Serializable {
    @EmbeddedId
    private PkStep id;

    @Column(name = "time")
    private long timer;

    @Column(name = "information")
    private String information;

    public PkStep getStep() {
        return id;
    }

    public void setStep(PkStep id) {
        this.id = id;
    }

    public long getTime() {
        return timer;
    }

    public void setTime(long timer) {
        this.timer = timer;
    }

    public String getInformation() {
        return information;
    }

    public void setInformation(String information) {
        this.information = information;
    }

}

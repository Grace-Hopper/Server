package com.receticas.models;

import javax.persistence.*;
import java.io.Serializable;
import java.util.*;

@Entity(name = "steps")
@Table(name = "steps")
public class Step implements Serializable {
    @EmbeddedId
    private PkStep id;

    @Column(name = "time")
    private long timer;

    @Column(name = "information")
    private String information;

    @ManyToMany(cascade=CascadeType.ALL)
    @JoinTable(name = "use_4",
           joinColumns = {@JoinColumn(table = "steps",
                                      name = "step", 
                                      referencedColumnName = "step"),
                          @JoinColumn(table = "steps",
                                      name = "recipe",                               
                                      referencedColumnName = "recipe", 
                                      nullable = true)},
           inverseJoinColumns = @JoinColumn(table = "utensils",
                                            name="utensil",
                                            referencedColumnName = "id"))
    private List<Utensil> utensils = new ArrayList();

    @OneToMany(cascade=CascadeType.ALL)    
    private List<IngreStep> steps = new ArrayList();

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

    public List<Utensil> getUtensils() {
        return utensils;
    }

    public List<IngreStep> getIngreSteps() {
        return steps;
    }

}

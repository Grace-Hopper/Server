package com.receticas.models;

import javax.persistence.*;
import java.io.Serializable;
import java.util.*;

@Entity(name = "utensils")
@Table(name = "utensils")
public class Utensil implements Serializable {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long id;

    @Column(name = "name")
    private String name;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
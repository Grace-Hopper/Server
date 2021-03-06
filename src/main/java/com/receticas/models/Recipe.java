package com.receticas.models;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.IndexColumn;

import javax.persistence.*;
import java.io.Serializable;
import java.util.*;

/**
 * =====================================================================================
 * Filename: Recipe.java
 * Version: 1.0
 * Created: 3/24/17
 * Author: JORGE CHATO (651348)
 * =====================================================================================
 */

@Entity(name = "recipes")
@Table(name = "recipes")
public class Recipe implements Serializable {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name = "total_time")
    private long total_time;

    @Column(name = "person")
    private long person;

    @Column(name = "outstanding")
    private int outstanding;

    @Column(columnDefinition = "LONGBLOB", name = "picture")
    @Lob
    private byte[] picture;

    @ManyToOne
    @JoinColumn(name = "user")
    private User user;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "recipe")
    @Fetch(value = FetchMode.SUBSELECT)
    private List<Ingredient> ingredients = new ArrayList();

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "recipe")
    @Fetch(value = FetchMode.SUBSELECT)
    private List<Step> steps = new ArrayList();

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "recipe")
    @Fetch(value = FetchMode.SUBSELECT)
    private List<Utensil> utensils = new ArrayList();

    public List<Utensil> getUtensils() {
        return utensils;
    }

    public void setUtensils(List<Utensil> utensils) {
        this.utensils = utensils;
    }

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

    public long getTotal_time() {
        return total_time;
    }

    public void setTotal_time(long total_time) {
        this.total_time = total_time;
    }

    public long getPerson() {
        return person;
    }

    public void setPerson(long person) {
        this.person = person;
    }

    public int getOutstanding() {
        return outstanding;
    }

    public void setOutstanding(int outstanding) {
        this.outstanding = outstanding;
    }

    public byte[] getPicture() {
        return picture;
    }

    public void setPicture(byte[] picture) {
        this.picture = picture;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Step> getSteps() {
        return steps;
    }

    public void setSteps(List<Step> steps){
      this.steps = steps;
    }

    public List<Ingredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }
}

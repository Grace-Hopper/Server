package com.receticas.models;

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
    private byte[] picture;

    @ManyToOne
    @JoinColumn(name = "user")
    private User user;

    @OneToMany(fetch = FetchType.EAGER,mappedBy = "recipe")
    private List<Step> steps = new ArrayList();

    //@ManyToMany(cascade=CascadeType.ALL)
    //@JoinTable(name="use_1", joinColumns={@JoinColumn(name = "recipe")},
    //inverseJoinColumns={@JoinColumn(name = "utensil")})
	//private List<Utensil> utensils = new ArrayList();

    //@ManyToMany(cascade=CascadeType.ALL)
    //@JoinTable(name="use_2", joinColumns={@JoinColumn(name = "recipe", referencedColumnName = "id")},
    //inverseJoinColumns={@JoinColumn(name = "ingredient", referencedColumnName = "id")})    
    //private List<Ingredient> ingredients = new ArrayList();

    private List<Use_1> ingredients = new ArrayList();

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

    //public List<Utensil> getUtensils() {
    //return utensils;
    //}

    //public void setUtensils(List<Utensil> utensils){
    //this.utensils = utensils;
    //}

    //public List<Ingredient> getIngredients() {
        //return ingredients;
    //}

    //public void setIngredients(List<Ingredient> ingredients){
      //this.ingredients = ingredients;
    //}

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "pk.recipe", cascade=CascadeType.ALL)
    public List<Use_1> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<Use_1> ingredients){
        this.ingredients = ingredients;
    }

    public List<Step> getSteps() {
        return steps;
    }

    public void setSteps(List<Step> steps){
      this.steps = steps;
    }
}

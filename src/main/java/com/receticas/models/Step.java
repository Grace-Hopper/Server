package com.receticas.models;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.io.Serializable;
import java.util.*;

@Entity(name = "steps")
@Table(name = "steps")
public class Step implements Serializable {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long id;

    @Column(name = "step")
    private long step;

    @Column(name = "total_time")
    private long timer;

    @Column(name = "information")
    private String information;

    @Column(name = "recipe")
    private long recipe;

    @Fetch(value = FetchMode.SUBSELECT)
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "step")
    private List<Ingredient> ingredients = new ArrayList();

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "step")
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

    public List<Ingredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }

    public long getStep() {
        return step;
    }
 
    public void setStep(long step) {
        this.step = step;
    }

    public long getRecipe() {
        return recipe;
    }

    public void setRecipe(long recipe) {
        this.recipe = recipe;
    }

    public long getTimer() {
        return timer;
    }

    public void setTimer(long timer) {
        this.timer = timer;
    }

    public String getInformation() {
        return information;
    }

    public void setInformation(String information) {
        this.information = information;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Step)) return false;
        Step that = (Step) o;
        return Objects.equals(getStep(), that.getStep()) &&
                Objects.equals(getRecipe(), that.getRecipe());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getStep(), getRecipe());
    }

}

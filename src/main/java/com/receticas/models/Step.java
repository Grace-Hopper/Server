package com.receticas.models;

import org.eclipse.persistence.annotations.PrimaryKey;

import javax.persistence.*;
import java.io.Serializable;
import java.util.*;

@Entity(name = "steps")
@Table(name = "steps")
public class Step implements Serializable {
    @Id
    @Column(name = "step")
    private long step;

    @Column(name = "time")
    private long timer;

    @Column(name = "information")
    private String information;

    @Id
    @Column(name = "recipe")
    private long recipe;

    //@ManyToMany(cascade=CascadeType.ALL)
    //@JoinTable(name = "use_4",
           //joinColumns = {@JoinColumn(table = "steps",
                                      //name = "step", 
                                      //referencedColumnName = "step"),
                          //@JoinColumn(table = "steps",
                                      //name = "recipe",                               
                                      //referencedColumnName = "recipe", 
                                      //nullable = true)},
           //inverseJoinColumns = @JoinColumn(table = "utensils",
                                            //name = "utensil",
                                            //referencedColumnName = "id"))
    //private List<Utensil> utensils = new ArrayList();

    //@ManyToMany(cascade=CascadeType.ALL)
    //@JoinTable(name = "use_3",
           //joinColumns = {@JoinColumn(table = "steps",
                                      //name = "step", 
                                      //referencedColumnName = "step"),
                          //@JoinColumn(table = "steps",
                                      //name = "recipe",                               
                                      //referencedColumnName = "recipe", 
                                      //nullable = true)},
           //inverseJoinColumns = @JoinColumn(table = "ingredients",
                                            //name = "ingredient",
                                            //referencedColumnName = "id"))    
    //private List<Ingredient> ingredients = new ArrayList();

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

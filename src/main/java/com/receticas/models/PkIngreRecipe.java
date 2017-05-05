package com.receticas.models;

import javax.persistence.*;
import java.io.*;
import java.util.*;

@Embeddable
public class PkIngreRecipe implements Serializable {
 
    @ManyToOne
    @JoinColumn(name = "recipe")
    private Recipe recipe;

    @ManyToOne
    @JoinColumn(name = "ingredient")
    private Ingredient ingredient;
 
    public Recipe getRecipe() {
        return recipe;
    }

    public void setRecipe(Recipe recipe) {
        this.recipe = recipe;
    }

    public Ingredient getIngredient() {
        return ingredient;
    }
 
    public void setIngredient(Ingredient ingredient) {
        this.ingredient = ingredient;
    }
 
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PkIngreRecipe)) return false;
        PkIngreRecipe that = (PkIngreRecipe) o;
        return Objects.equals(getRecipe(), that.getRecipe()) &&
                Objects.equals(getIngredient(), that.getIngredient());
    }
 
    @Override
    public int hashCode() {
        return Objects.hash(getRecipe(), getIngredient());
    }
}
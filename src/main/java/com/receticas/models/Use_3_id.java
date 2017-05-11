package com.receticas.models;

import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;
import java.io.Serializable;

/**
 * =====================================================================================
 * Filename: Use_3_id.java
 * Version: 1.0
 * Created: 5/11/17
 * Author: JORGE CHATO (651348)
 * =====================================================================================
 */
@Embeddable
public class Use_3_id implements Serializable{
    @ManyToOne
    private Step step;
    @ManyToOne
    private Recipe recipe;
    @ManyToOne
    private Ingredient ingredient;

    public Step getStep() {
        return step;
    }

    public void setStep(Step step) {
        this.step = step;
    }

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
}

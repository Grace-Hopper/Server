package com.receticas.models;

import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;
import java.io.Serializable;

/**
 * =====================================================================================
 * Filename: Use_1_id.java
 * Version: 1.0
 * Created: 5/11/17
 * Author: JORGE CHATO (651348)
 * =====================================================================================
 */
@Embeddable
public class Use_1_id implements Serializable{

    @ManyToOne
    private Recipe recipe;
    @ManyToOne
    private Utensil utensil;

    public Recipe getRecipe() {
        return recipe;
    }

    public void setRecipe(Recipe recipe) {
        this.recipe = recipe;
    }

    public Utensil getUtensil() {
        return utensil;
    }

    public void setUtensil(Utensil utensil) {
        this.utensil = utensil;
    }
}

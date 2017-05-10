package com.receticas.models;

import javax.persistence.*;
import java.io.Serializable;
import java.util.*;

@Entity
@Table(name="use_2")
@AssociationOverrides({
	@AssociationOverride(name="pk.recipe",
		joinColumns = @JoinColumn(name ="recipe")),
	@AssociationOverride(name="pk.ingredient",
		joinColumns = @JoinColumn(name="ingredient"))})

public class use_2 implements java.io.Serializable{
	
	@Embeddable
	public class use_2_id implements java.io.Serializable {

		private Recipe recipe;
    	private Ingredient ingredient;

		@ManyToOne
		public Recipe getU_Recipe() {
			return recipe;
		}

		public void setU_Recipe(Recipe recipe) {
			this.recipe = recipe;
		}

		@ManyToOne
		public Ingredient getU_Ingredient() {
			return ingredient;
		}

		public void setU_Ingredient(Ingredient ingredient) {
			this.ingredient = ingredient;
		}
	}


	private use_2_id pk = new use_2_id();


	@EmbeddedId
	public use_2_id getPk(){
		return pk;
	}

	public void setPk(use_2_id pk){
		this.pk=pk;
	}

	@Transient
	public Recipe getRecipe(){
		return getPk().getU_Recipe();
	}

	public void setRecipe(Recipe r){
		getPk().setU_Recipe(r);
	}

	@Transient
	public Ingredient getIngredient(){
		return getPk().getU_Ingredient();
	}

	public void setIngredient(Ingredient i){
		getPk().setU_Ingredient(i);
	}

	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;

		use_2 that = (use_2) o;

		if (getPk() != null ? !getPk().equals(that.getPk())
				: that.getPk() != null)
			return false;

		return true;
	}

	public int hashCode() {
		return (getPk() != null ? getPk().hashCode() : 0);
	}
}
package com.receticas.models;

import javax.persistence.*;
import java.io.Serializable;
import java.util.*;

@Entity
@Table(name="use_1")
@AssociationOverrides({
	@AssociationOverride(name="pk.recipe",
		joinColumns = @JoinColumn(name ="recipe")),
	@AssociationOverride(name="pk.utensil",
		joinColumns = @JoinColumn(name="utensil"))})

public class use_1 implements java.io.Serializable{
	
	@Embeddable
	public class use_1_id implements java.io.Serializable {

		private Recipe recipe;
    	private Utensil utensil;

		@ManyToOne
		public Recipe getU_Recipe() {
			return recipe;
		}

		public void setU_Recipe(Recipe recipe) {
			this.recipe = recipe;
		}

		@ManyToOne
		public Utensil getU_Utensil() {
			return utensil;
		}

		public void setU_Utensil(Utensil utensil) {
			this.utensil = utensil;
		}
	}


	private use_1_id pk = new use_1_id();


	@EmbeddedId
	public use_1_id getPk(){
		return pk;
	}

	public void setPk(use_1_id pk){
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
	public Utensil getUtensil(){
		return getPk().getU_Utensil();
	}

	public void setUtensil(Utensil u){
		getPk().setU_Utensil(u);
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
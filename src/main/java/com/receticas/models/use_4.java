package com.receticas.models;

import javax.persistence.*;
import java.io.Serializable;
import java.util.*;

@Entity
@Table(name="use_4")
@AssociationOverrides({
	@AssociationOverride(name="pk.step",
		joinColumns = @JoinColumn(name ="step")),
	@AssociationOverride(name="pk.recipe",
		joinColumns = @JoinColumn(name="recipe")),
	@AssociationOverride(name="pk.utensil",
		joinColumns = @JoinColumn(name="utensil"))

})

public class use_4 implements java.io.Serializable{
	
	@Embeddable
	public class use_4_id implements java.io.Serializable {

		private Step step;
		private Recipe recipe;
    	private Utensil utensil;

		@ManyToOne
		public Step getU_Step() {
			return step;
		}

		public void setU_Step(Step step) {
			this.step = step;
		}

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


	private use_4_id pk = new use_4_id();

	@EmbeddedId
	public use_4_id getPk(){
		return pk;
	}

	public void setPk(use_4_id pk){
		this.pk=pk;
	}

	@Transient
	public Step getStep(){
		return getPk().getU_Step();
	}

	public void setStep(Step s){
		getPk().setU_Step(s);
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
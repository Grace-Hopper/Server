package com.receticas.models;

import javax.persistence.*;

@Entity
@Table(name="use_3")
@AssociationOverrides({
	@AssociationOverride(name="pk.step",
		joinColumns = @JoinColumn(name ="step")),
	@AssociationOverride(name="pk.recipe",
		joinColumns = @JoinColumn(name="recipe")),
	@AssociationOverride(name="pk.ingredient",
		joinColumns = @JoinColumn(name="ingredient"))

})
public class Use_3 implements java.io.Serializable{
	private Use_3_id pk = new Use_3_id();
	@Column(name = "quantity")
	private String quantity;

	@EmbeddedId
	public Use_3_id getPk(){
		return pk;
	}

	public void setPk(Use_3_id pk){
		this.pk=pk;
	}

	@Transient
	public Step getStep(){
		return getPk().getStep();
	}

	public void setStep(Step s){
		getPk().setStep(s);
	}

	@Transient
	public Recipe getRecipe(){
		return getPk().getRecipe();
	}

	public void setRecipe(Recipe r){
		getPk().setRecipe(r);
	}

	@Transient
	public Ingredient getIngredient(){
		return getPk().getIngredient();
	}

	public void setIngredient(Ingredient i){
		getPk().setIngredient(i);
	}
}
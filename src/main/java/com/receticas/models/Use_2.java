package com.receticas.models;

import javax.persistence.*;

@Entity(name = "use_2")
@Table(name="use_2")
@AssociationOverrides({
	@AssociationOverride(name="pk.recipe",
		joinColumns = @JoinColumn(name ="recipe")),
	@AssociationOverride(name="pk.ingredient",
		joinColumns = @JoinColumn(name="ingredient"))})

public class Use_2 implements java.io.Serializable{
	
	private Use_2_id pk = new Use_2_id();
	@Column(name = "quantity")
	private String quantity;


	@EmbeddedId
	public Use_2_id getPk(){
		return pk;
	}

	public void setPk(Use_2_id pk){
		this.pk=pk;
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

	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;

		Use_2 that = (Use_2) o;

		if (getPk() != null ? !getPk().equals(that.getPk())
				: that.getPk() != null)
			return false;

		return true;
	}

	public int hashCode() {
		return (getPk() != null ? getPk().hashCode() : 0);
	}
}
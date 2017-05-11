package com.receticas.models;

import javax.persistence.*;

@Entity
@Table(name="use_1")
@AssociationOverrides({
		@AssociationOverride(name="pk.recipe",
				joinColumns = @JoinColumn(name ="recipe")),
		@AssociationOverride(name="pk.utensil",
				joinColumns = @JoinColumn(name="utensil"))})
public class Use_1 implements java.io.Serializable{
	
	private Use_1_id pk = new Use_1_id();


	@EmbeddedId
	public Use_1_id getPk(){
		return pk;
	}

	public void setPk(Use_1_id pk){
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
	public Utensil getUtensil(){
		return getPk().getUtensil();
	}

	public void setUtensil(Utensil u){
		getPk().setUtensil(u);
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
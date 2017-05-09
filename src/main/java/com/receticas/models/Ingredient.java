package com.receticas.models;

import javax.persistence.*;
import java.io.Serializable;
import java.util.*;

@Entity(name = "ingredients")
@Table(name = "ingredients")
public class Ingredient implements Serializable {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name = "quantity")
    private String quantity;

    /*@ManyToMany(cascade=CascadeType.ALL)    
    @JoinTable(name="use_2", joinColumns={@JoinColumn(name = "ingredient", referencedColumnName = "id")},
    inverseJoinColumns={@JoinColumn(name = "recipe", referencedColumnName = "id")}) 
    private List<Recipe> recipes = new ArrayList();*/

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

  /*  public List<Recipe> getRecipes() {
        return recipes;
    }

    public void setRecipes(List<Recipe> recipes) {
        this.recipes = recipes;
    }*/

}

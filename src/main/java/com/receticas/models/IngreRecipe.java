package com.receticas.models;

import javax.persistence.*;
import java.io.Serializable;
import java.util.*;

@Entity(name = "use_2")
@Table(name = "use_2")
public class IngreRecipe implements Serializable {
    @EmbeddedId
    private PkIngreRecipe id;

    @Column(name = "quantity")
    private long quantity;

    public PkIngreRecipe getIngreRecipe() {
        return id;
    }

    public void setIngreRecipe(PkIngreRecipe id) {
        this.id = id;
    }

    public long getQuantity() {
        return quantity;
    }

    public void setQuantity(long quantity) {
        this.quantity = quantity;
    }

}

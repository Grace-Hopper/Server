package com.receticas.models;

import javax.persistence.*;
import java.io.Serializable;
import java.util.*;

@Entity(name = "use_3")
@Table(name = "use_3")
public class IngreStep implements Serializable {
    @EmbeddedId
    private PkIngreStep id;

    @Column(name = "quantity")
    private long quantity;

    public PkIngreStep getIngreStep() {
        return id;
    }

    public void setIngreStep(PkIngreStep id) {
        this.id = id;
    }

    public long getQuantity() {
        return quantity;
    }

    public void setQuantity(long quantity) {
        this.quantity = quantity;
    }

}

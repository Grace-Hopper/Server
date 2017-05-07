package com.receticas.models;

import javax.persistence.*;
import java.io.*;
import java.util.*;

@Embeddable
public class IngreQuantity implements Serializable {
	private String name;
	private long quantity;


	public void setIngreName(String name){
		this.name=name;
	}

	public void setIngreQuant(long quantity){
		this.quantity=quantity;
	}

	public String getIngreName(){
		return name;
	}

	public long getQuantity(){
		return quantity;
	}


}
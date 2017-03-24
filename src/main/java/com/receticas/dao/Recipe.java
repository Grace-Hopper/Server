package com.receticas.dao;

import javax.persistence.*;

/**
 * =====================================================================================
 * Filename: Recipe.java
 * Version: 1.0
 * Created: 3/24/17
 * Author: JORGE CHATO (651348)
 * =====================================================================================
 */

@Entity(name = "recipes")
@Table(name = "recipes")
public class Recipe {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name = "total_name")
    private int total_time;

    @ManyToOne
    @JoinColumn(name = "user")
    private User user;

//TODO: constructor and move to models

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

    public int getTotal_time() {
        return total_time;
    }

    public void setTotal_time(int total_time) {
        this.total_time = total_time;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}

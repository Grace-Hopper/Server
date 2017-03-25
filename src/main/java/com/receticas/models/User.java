package com.receticas.models;

import javax.persistence.*;
import java.io.Serializable;

/**
 * =====================================================================================
 * Filename: User.java
 * Version: 1.0
 * Created: 3/24/17
 * Author: JORGE CHATO (651348)
 * =====================================================================================
 */
@Entity(name = "users")
@Table(name = "users")
public class User implements Serializable{
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name = "password")
    private String password;

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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

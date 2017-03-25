package com.receticas.models;

import javax.persistence.*;
import java.util.UUID;

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
public class User {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name = "password")
    private String password;

    @ManyToOne
    @JoinColumn(name = "token")
    private  String token;

    public User(String name, String password, String token) {
        this.name = name;
        this.password = password;
        this.token = token;
    }

    public User(String name, String password) {
        this(name, password, "");
        this.token = generateToken();
    }

    public String generateToken(){
        return UUID.randomUUID().toString().toUpperCase();
    }

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

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}

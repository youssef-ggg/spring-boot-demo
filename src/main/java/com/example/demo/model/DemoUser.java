package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class DemoUser {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String email;
    private String password;
    private String role;

    public DemoUser(long id, String email, String role){
        this.id = id;
        this.email = email;
    }
    public long getId(){
        return this.id;

    }
    public void setId(long id){
        this.id = id;
    }

    public String getEmail(){
        return this.email;

    }
    public void setEmail(String email){
        this.email = email;
    }

    public String getRole(){
        return this.role;

    }
    public void setRole(String role){
        this.role = role;
    }

    public String getPassword(){
        return this.password;

    }
    public void setPassword(String password){
        this.password = password;
    }
}

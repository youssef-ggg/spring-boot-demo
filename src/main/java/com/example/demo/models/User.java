package com.example.demo.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class User {
    @Id
    private long id;
    private String username;

    public User(long id,String username){
        this.id = id;
        this.username = username;
    }
    public long getId(){
        return this.id;

    }
    public void setId(long id){
        this.id = id;
    }

    public String getUsername(){
        return this.username;

    }
    public void setUsername(String username){
        this.username = username;
    }
}

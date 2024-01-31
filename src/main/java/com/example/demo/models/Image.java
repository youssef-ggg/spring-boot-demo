package com.example.demo.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;

@Entity
public class Image {
    @Id
    Long id;
    Long UserId;

    @Lob
    byte[] content;

    String name;
}


package com.example.learnflatfrombackend.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Lesson {

    @Id
    @GeneratedValue
    private  Long id;
    private String module;
    private String title;
    private String url;
    private String description;


}

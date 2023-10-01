package com.example.learnflatfrombackend.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Question {
    @Id
    @GeneratedValue
    private Long id;
    private String module;
    private String questionType;
    private String questionFile;
    private int startIndex;
    private int endIndex;
    private int duration;
    private String questionText;
}

package com.example.learnflatfrombackend.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Answer {

    @Id
    @GeneratedValue
    private Long id;
    private String answerType;
    private String answerText;
    private String answerFile;
    private int answerIndex;
    private String explanation;
    private boolean isCorrect1;
    private boolean isCorrect2;
    private boolean isCorrect3;
    private boolean isCorrect4;

    @ManyToOne
    @JoinColumn
    private Question question;
}

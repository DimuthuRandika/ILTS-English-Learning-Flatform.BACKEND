package com.example.learnflatfrombackend.repository;

import com.example.learnflatfrombackend.entity.Question;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionRepository extends JpaRepository <Question,Long> {
}

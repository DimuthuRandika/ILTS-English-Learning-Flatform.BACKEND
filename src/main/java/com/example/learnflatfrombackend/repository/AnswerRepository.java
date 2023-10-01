package com.example.learnflatfrombackend.repository;

import com.example.learnflatfrombackend.entity.Answer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnswerRepository extends JpaRepository <Answer, Long> {
}

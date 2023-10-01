package com.example.learnflatfrombackend.controller;

import com.example.learnflatfrombackend.entity.Question;
import com.example.learnflatfrombackend.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class QuestionController {

    @Autowired
    private QuestionRepository questionRepository;

    @PostMapping("/question")
    Question newQuestion(@RequestBody Question newQuestion ){
        return questionRepository.save(newQuestion);
    }

    @GetMapping("/questions")
    List<Question> getAllQuestions(){
        return questionRepository.findAll();
    }


}

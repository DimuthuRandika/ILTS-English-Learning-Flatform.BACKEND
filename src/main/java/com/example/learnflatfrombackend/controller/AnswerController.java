package com.example.learnflatfrombackend.controller;

import com.example.learnflatfrombackend.entity.Answer;
import com.example.learnflatfrombackend.exception.AnswerNotFoundException;
import com.example.learnflatfrombackend.repository.AnswerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AnswerController {

    @Autowired
    private AnswerRepository answerRepository;


    @PostMapping("/answer")
    Answer newAnswer(@RequestBody Answer newAnswer ){
        return answerRepository.save(newAnswer);
    }

    @GetMapping("/answers")
    List<Answer> getAllAnswers(){
        return answerRepository.findAll();
    }

    @DeleteMapping("/answer/{answer_id}")
    String deleteAnswer(@PathVariable Long answer_id){
        if (!answerRepository.existsById(answer_id)) {
            throw new AnswerNotFoundException(answer_id);
        }
        answerRepository.deleteById(answer_id);
        return "Answer with id "+answer_id+" has been deleted success";
    }
}

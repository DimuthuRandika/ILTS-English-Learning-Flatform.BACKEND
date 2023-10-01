package com.example.learnflatfrombackend.controller;

import com.example.learnflatfrombackend.entity.Lesson;
import com.example.learnflatfrombackend.exception.LessonNotFoundException;
import com.example.learnflatfrombackend.repository.LessonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class LessonController {

    @Autowired
    private LessonRepository lessonRepository;


    @PostMapping("/lesson")
    Lesson newLesson(@RequestBody Lesson newLesson ){
        return lessonRepository.save(newLesson);
    }

    @GetMapping("/lessons")
    List<Lesson> getAllLessons(){
        return lessonRepository.findAll();
    }

    @PutMapping("/lesson/{id}")
    Lesson updateLesson(@RequestBody Lesson newLesson, @PathVariable Long id){
        return lessonRepository.findById(id)
                .map(lesson -> {
                    lesson.setModule(newLesson.getModule());
                    lesson.setTitle(newLesson.getTitle());
                    lesson.setUrl(newLesson.getUrl());
                    lesson.setDescription(newLesson.getDescription());
                    return lessonRepository.save(lesson);
                }).orElseThrow(()->new LessonNotFoundException(id));
    }

    @DeleteMapping("/lesson/{id}")
    String deleteLesson(@PathVariable Long id){
        if (!lessonRepository.existsById(id)) {
            throw new LessonNotFoundException(id);
        }
        lessonRepository.deleteById(id);
        return "Lesson with id "+id+" has been deleted success";
    }

}

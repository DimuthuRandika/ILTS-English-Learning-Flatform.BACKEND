package com.example.learnflatfrombackend.repository;

import com.example.learnflatfrombackend.entity.Lesson;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LessonRepository extends JpaRepository  <Lesson,Long> {

}

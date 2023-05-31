package com.quiz.quizbackend;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface QuizDB extends JpaRepository<Quiz,Integer>{
    
}

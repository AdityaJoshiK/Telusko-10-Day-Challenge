package com.quiz.quizbackend;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class QuizService {
    
    @Autowired
    QuizDB db;

    public void addQuiz(Quiz q)  {
        db.save(q);
    }

    public List<Quiz> getAllQuizs() {
        return db.findAll();
    }
}

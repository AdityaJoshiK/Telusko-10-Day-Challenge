package com.quiz.quizbackend;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("http://localhost:3000/")
public class QuizController {
    
    @Autowired
    QuizService service;

    @GetMapping("/All")
    public List<Quiz> getAllQuizs(){
        return service.getAllQuizs();
    }

    @PostMapping("/AddQuestion")
    public void addQuiz(@RequestBody Quiz p)
    {
        System.out.println("added");
        service.addQuiz(p);
    }
}

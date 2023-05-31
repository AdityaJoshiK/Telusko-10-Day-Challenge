package com.quiz.quizbackend;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Quiz {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String question;
    private String option1;
    private String option2;
    private String option3;
    private String option4;
    private String technology;

    public Quiz()
    {
        
    }

    public Quiz(String question, String option1, String option2, String option3, String option4, String technology)
    {
        this.question = question;
        this.option1 = option1;
        this.option2 = option2;
        this.option3 = option3;
        this.option4 = option4;
        this.technology = technology;
    }
}

package com.quiz.quizbackend;

import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionRepository extends JpaRepository<Question, Long> {
    // Custom query methods can be added here if needed
}

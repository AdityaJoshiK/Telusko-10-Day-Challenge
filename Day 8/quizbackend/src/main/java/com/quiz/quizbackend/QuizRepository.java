package com.quiz.quizbackend;

import org.springframework.data.jpa.repository.JpaRepository;

public interface QuizRepository extends JpaRepository<Quiz, Long> {
    // Custom query methods can be added here if needed
}

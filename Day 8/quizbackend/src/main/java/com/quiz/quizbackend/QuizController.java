package com.quiz.quizbackend;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import javax.ws.rs.NotFoundException;

@RestController
@CrossOrigin("http://localhost:3000/")
@RequestMapping("/quizzes")
public class QuizController {
    private final QuizRepository quizRepository;

    @Autowired
    public QuizController(QuizRepository quizRepository) {
        this.quizRepository = quizRepository;
    }

    @Autowired
    private QuestionRepository questionRepository;

     // Get all questions
     @GetMapping("/questions")
     public List<Question> getAllQuestions() {
         return questionRepository.findAll();
     }
 
     // Get a question by ID
     @GetMapping("/questions/{id}")
     public Question getQuestionById(@PathVariable Long id) {
         return questionRepository.findById(id).orElseThrow(() -> new NotFoundException("Question not found"));
     }
 
     // Create a new question
     @PostMapping("/questions")
     public Question createQuestion(@RequestBody Question question) {
         return questionRepository.save(question);
     }
 
     // Update a question
     @PutMapping("/questions/{id}")
     public Question updateQuestion(@PathVariable Long id, @RequestBody Question updatedQuestion) {
         Question question = questionRepository.findById(id).orElseThrow(() -> new NotFoundException("Question not found"));
         question.setQuestion(updatedQuestion.getQuestion());
         question.setOption1(updatedQuestion.getOption1());
         question.setOption2(updatedQuestion.getOption2());
         question.setOption3(updatedQuestion.getOption3());
         question.setOption4(updatedQuestion.getOption4());
         question.setTechnology(updatedQuestion.getTechnology());
         return questionRepository.save(question);
     }
 
     // Delete a question
     @DeleteMapping("/questions/{id}")
     public void deleteQuestion(@PathVariable Long id) {
         Question question = questionRepository.findById(id).orElseThrow(() -> new NotFoundException("Question not found"));
         questionRepository.delete(question);
     }
 
     // Get all quizzes
     @GetMapping("/quizzes")
     public List<Quiz> getAllQuizzes() {
         return quizRepository.findAll();
     }
 
     // Get a quiz by ID
     @GetMapping("/quizzes/{id}")
     public Quiz getQuizById(@PathVariable Long id) {
         return quizRepository.findById(id).orElseThrow(() -> new NotFoundException("Quiz not found"));
     }
 
     // Create a new quiz
     @PostMapping("/quizzes")
     public Quiz createQuiz(@RequestBody Quiz quiz) {
         return quizRepository.save(quiz);
     }
 
     // Update a quiz
     @PutMapping("/quizzes/{id}")
     public Quiz updateQuiz(@PathVariable Long id, @RequestBody Quiz updatedQuiz) {
         Quiz quiz = quizRepository.findById(id).orElseThrow(() -> new NotFoundException("Quiz not found"));
         quiz.setName(updatedQuiz.getName());
         quiz.setQuestionIds(updatedQuiz.getQuestionIds());
         return quizRepository.save(quiz);
     }
 
     // Delete a quiz
     @DeleteMapping("/quizzes/{id}")
     public void deleteQuiz(@PathVariable Long id) {
         Quiz quiz = quizRepository.findById(id).orElseThrow(() -> new NotFoundException("Quiz not found"));
         quizRepository.delete(quiz);
     }
 }


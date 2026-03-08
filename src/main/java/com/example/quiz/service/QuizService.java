package com.example.quiz.service;

import com.example.quiz.model.Quiz;
import com.example.quiz.repository.QuizRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class QuizService {
    
    @Autowired
    private QuizRepository quizRepository;
    
    public List<Quiz> tousLesQuiz() {
        return quizRepository.findAll();
    }
    
    public Quiz trouverParId(Long id) {
        Optional<Quiz> quiz = quizRepository.findById(id);
        return quiz.orElse(null);
    }
}
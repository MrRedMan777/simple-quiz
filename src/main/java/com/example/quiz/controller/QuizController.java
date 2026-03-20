// com/example/quiz/controller/QuizController.java
package com.example.quiz.controller;

import com.example.quiz.model.Quiz;
import com.example.quiz.model.Question;
import com.example.quiz.repository.QuizRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/quiz")
public class QuizController {
    
    @Autowired
    private QuizRepository quizRepository;
    
    @GetMapping
    public String listeQuiz(Model model) {
        List<Quiz> quizs = quizRepository.findAll();
        model.addAttribute("quizs", quizs);
        return "quizzes";
    }
    
    @GetMapping("/{id}")
    public String voirQuiz(@PathVariable Long id, Model model) {
        Quiz quiz = quizRepository.findById(id).orElse(null);
        if (quiz == null) {
            return "redirect:/quiz";
        }
        model.addAttribute("quiz", quiz);
        return "quiz";
    }
    
  
@PostMapping("/{id}/repondre")
public String repondreQuiz(@PathVariable Long id, 
                           @RequestParam Map<String, String> toutesReponses, 
                           Model model) {
    
    Quiz quiz = quizRepository.findById(id).orElse(null);
    if (quiz == null) {
        return "redirect:/quiz";
    }
    
    List<Question> questions = quiz.getQuestions();
    Map<Question, Integer> resultats = new HashMap<>();  // ← Important
    int score = 0;
    
    for (Question question : questions) {
        String reponseKey = "reponse_" + question.getId();
        String reponseValue = toutesReponses.get(reponseKey);
        
        if (reponseValue != null && !reponseValue.isEmpty()) {
            int reponseChoisie = Integer.parseInt(reponseValue);
            resultats.put(question, reponseChoisie);
            
            if (reponseChoisie == question.getBonneReponse()) {
                score++;
            }
        } else {
            resultats.put(question, -1); // Pas de réponse
        }
    }
    
    int total = questions.size();
    int pourcentage = total > 0 ? (score * 100) / total : 0;
    
    model.addAttribute("quiz", quiz);
    model.addAttribute("resultats", resultats);  // ← Vérifiez que c'est présent
    model.addAttribute("score", score);
    model.addAttribute("total", total);
    model.addAttribute("pourcentage", pourcentage);
    
    return "resultat";
}
}
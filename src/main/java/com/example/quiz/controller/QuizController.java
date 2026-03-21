package com.example.quiz.controller;

import com.example.quiz.model.Question;
import com.example.quiz.model.Quiz;
import com.example.quiz.service.QuizService;
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
    private QuizService quizService;
    
    @GetMapping
    public String listeQuiz(Model model) {
        model.addAttribute("quizs", quizService.tousLesQuiz());
        return "quizzes";
    }
    
    @GetMapping("/{id}")
    public String voirQuiz(@PathVariable Long id, Model model) {
        Quiz quiz = quizService.trouverParId(id);
        if (quiz == null) {
            return "redirect:/quiz";
        }
        model.addAttribute("quiz", quiz);
        return "quiz";
    }
    
    @PostMapping("/{id}/repondre")
    public String repondreQuiz(@PathVariable Long id, 
                               @RequestParam Map<String, String> reponses, 
                               Model model) {
        
        Quiz quiz = quizService.trouverParId(id);
        if (quiz == null) {
            return "redirect:/quiz";
        }
        
        List<Question> questions = quiz.getQuestions();
        Map<Question, Integer> resultats = new HashMap<>();
        int score = 0;
        
        for (Question question : questions) {
            String reponseKey = "reponse_" + question.getId();
            String reponseValue = reponses.get(reponseKey);
            
            if (reponseValue != null && !reponseValue.isEmpty()) {
                int reponseChoisie = Integer.parseInt(reponseValue);
                resultats.put(question, reponseChoisie);
                if (reponseChoisie == question.getBonneReponse()) {
                    score++;
                }
            } else {
                resultats.put(question, -1);
            }
        }
        
        int total = questions.size();
        int pourcentage = total > 0 ? (score * 100) / total : 0;
        
        model.addAttribute("quiz", quiz);
        model.addAttribute("resultats", resultats);
        model.addAttribute("score", score);
        model.addAttribute("total", total);
        model.addAttribute("pourcentage", pourcentage);
        
        return "resultat";
    }
}
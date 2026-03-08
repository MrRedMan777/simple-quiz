// com/example/quiz/controller/AuthController.java
package com.example.quiz.controller;

import com.example.quiz.model.User;
import com.example.quiz.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class AuthController {
    
    @Autowired
    private UserService userService;
    
    @GetMapping("/connexion")
    public String connexion() {
        return "login";
    }
    
    @GetMapping("/inscription")
    public String inscription(Model model) {
        model.addAttribute("user", new User());
        return "register";
    }
    
    @PostMapping("/inscription")
    public String inscrire(@ModelAttribute User user, Model model) {
        try {
            userService.inscrire(user);
            return "redirect:/connexion?success";
        } catch (Exception e) {
            model.addAttribute("error", "Nom d'utilisateur ou email déjà utilisé");
            return "register";
        }
    }
}
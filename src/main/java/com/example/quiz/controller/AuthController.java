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
        if (userService.existsByUsername(user.getUsername())) {
            model.addAttribute("error", "Nom d'utilisateur déjà utilisé");
            return "register";
        }
        
        if (userService.existsByEmail(user.getEmail())) {
            model.addAttribute("error", "Email déjà utilisé");
            return "register";
        }
        
        userService.inscrire(user);
        return "redirect:/connexion?success";
    }
}
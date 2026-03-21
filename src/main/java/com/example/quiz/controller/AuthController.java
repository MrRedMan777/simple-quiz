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
    public String connexion(@RequestParam(required = false) String error,
                           @RequestParam(required = false) String deconnexion,
                           Model model) {
        if (error != null) {
            model.addAttribute("error", "Nom d'utilisateur ou mot de passe incorrect");
        }
        if (deconnexion != null) {
            model.addAttribute("success", "Vous avez été déconnecté avec succès");
        }
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
            // Validation
            if (user.getUsername() == null || user.getUsername().trim().isEmpty()) {
                model.addAttribute("error", "Le nom d'utilisateur est requis");
                return "register";
            }
            if (user.getEmail() == null || user.getEmail().trim().isEmpty()) {
                model.addAttribute("error", "L'email est requis");
                return "register";
            }
            if (user.getPassword() == null || user.getPassword().length() < 4) {
                model.addAttribute("error", "Le mot de passe doit contenir au moins 4 caractères");
                return "register";
            }
            
            if (userService.existsByUsername(user.getUsername())) {
                model.addAttribute("error", "Nom d'utilisateur déjà utilisé");
                return "register";
            }
            
            if (userService.existsByEmail(user.getEmail())) {
                model.addAttribute("error", "Email déjà utilisé");
                return "register";
            }
            
            userService.inscrire(user);
            System.out.println("✅ Inscription réussie pour : " + user.getUsername());
            return "redirect:/connexion?success=true";
            
        } catch (Exception e) {
            model.addAttribute("error", "Erreur lors de l'inscription : " + e.getMessage());
            return "register";
        }
    }
}
package com.example.quiz.controller;

import com.example.quiz.model.User;
import com.example.quiz.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
public class DebugController {
    
    @Autowired
    private UserService userService;
    
    @GetMapping("/debug/users")
    public String listUsers() {
        List<User> users = userService.tousLesUtilisateurs();
        StringBuilder sb = new StringBuilder("=== UTILISATEURS INSCRITS ===\n");
        sb.append("Total : ").append(users.size()).append("\n\n");
        for (User u : users) {
            sb.append("- ").append(u.getUsername())
              .append(" (").append(u.getEmail()).append(")\n");
        }
        
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null && auth.isAuthenticated()) {
            sb.append("\nUtilisateur connecté : ").append(auth.getName());
        } else {
            sb.append("\nAucun utilisateur connecté");
        }
        
        return sb.toString();
    }
}
package com.example.quiz.service;

import com.example.quiz.model.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    
    private List<User> users = new ArrayList<>();
    private BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
    private Long nextId = 1L;
    
    public User inscrire(User user) {
        user.setId(nextId++);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        users.add(user);
        return user;
    }
    
    public User trouverParUsername(String username) {
        Optional<User> user = users.stream()
            .filter(u -> u.getUsername().equals(username))
            .findFirst();
        return user.orElse(null);
    }
    
    public boolean existsByUsername(String username) {
        return users.stream().anyMatch(u -> u.getUsername().equals(username));
    }
    
    public boolean existsByEmail(String email) {
        return users.stream().anyMatch(u -> u.getEmail().equals(email));
    }
}
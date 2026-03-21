package com.example.quiz.service;

import com.example.quiz.model.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class UserService {
    
    // Utiliser une Map pour un accès plus fiable
    private final ConcurrentHashMap<String, User> usersByUsername = new ConcurrentHashMap<>();
    private final ConcurrentHashMap<String, User> usersByEmail = new ConcurrentHashMap<>();
    private final List<User> users = new ArrayList<>();
    private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
    private Long nextId = 1L;
    
    public User inscrire(User user) {
        // Vérifier si l'utilisateur existe déjà
        if (existsByUsername(user.getUsername())) {
            throw new RuntimeException("Nom d'utilisateur déjà utilisé");
        }
        if (existsByEmail(user.getEmail())) {
            throw new RuntimeException("Email déjà utilisé");
        }
        
        // Créer le nouvel utilisateur
        user.setId(nextId++);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        
        // Stocker dans les différentes structures
        users.add(user);
        usersByUsername.put(user.getUsername(), user);
        usersByEmail.put(user.getEmail(), user);
        
        System.out.println("✅ Nouvel utilisateur inscrit : " + user.getUsername() + " (ID: " + user.getId() + ")");
        System.out.println("📊 Total utilisateurs : " + users.size());
        
        return user;
    }
    
    public User trouverParUsername(String username) {
        User user = usersByUsername.get(username);
        if (user != null) {
            System.out.println("🔍 Utilisateur trouvé : " + username);
        } else {
            System.out.println("❌ Utilisateur non trouvé : " + username);
            System.out.println("📋 Utilisateurs existants : " + usersByUsername.keySet());
        }
        return user;
    }
    
    public boolean existsByUsername(String username) {
        return usersByUsername.containsKey(username);
    }
    
    public boolean existsByEmail(String email) {
        return usersByEmail.containsKey(email);
    }
    
    public List<User> tousLesUtilisateurs() {
        return new ArrayList<>(users);
    }
    
    public void supprimerUtilisateur(String username) {
        User user = usersByUsername.remove(username);
        if (user != null) {
            usersByEmail.remove(user.getEmail());
            users.remove(user);
            System.out.println("🗑️ Utilisateur supprimé : " + username);
        }
    }
}
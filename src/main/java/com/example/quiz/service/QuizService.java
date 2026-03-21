package com.example.quiz.service;

import com.example.quiz.model.Question;
import com.example.quiz.model.Quiz;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class QuizService {
    
    private List<Quiz> quizs = new ArrayList<>();
    private Long nextQuizId = 1L;
    private Long nextQuestionId = 1L;
    
    @PostConstruct
    public void init() {
        // Quiz 1: Culture Générale
        Quiz quiz1 = new Quiz();
        quiz1.setId(nextQuizId++);
        quiz1.setTitre("📚 Culture Générale");
        quiz1.setDescription("Testez vos connaissances en culture générale");
        
        List<Question> questions1 = new ArrayList<>();
        
        Question q1 = new Question();
        q1.setId(nextQuestionId++);
        q1.setTexte("Quelle est la capitale de la France ?");
        q1.setOption1("Lyon");
        q1.setOption2("Marseille");
        q1.setOption3("Paris");
        q1.setOption4("Bordeaux");
        q1.setBonneReponse(3);
        q1.setQuiz(quiz1);
        questions1.add(q1);
        
        Question q2 = new Question();
        q2.setId(nextQuestionId++);
        q2.setTexte("Combien de continents y a-t-il ?");
        q2.setOption1("5");
        q2.setOption2("6");
        q2.setOption3("7");
        q2.setOption4("8");
        q2.setBonneReponse(3);
        q2.setQuiz(quiz1);
        questions1.add(q2);
        
        Question q3 = new Question();
        q3.setId(nextQuestionId++);
        q3.setTexte("Qui a peint la Joconde ?");
        q3.setOption1("Van Gogh");
        q3.setOption2("Picasso");
        q3.setOption3("Léonard de Vinci");
        q3.setOption4("Rembrandt");
        q3.setBonneReponse(3);
        q3.setQuiz(quiz1);
        questions1.add(q3);
        
        quiz1.setQuestions(questions1);
        quizs.add(quiz1);
        
        // Quiz 2: Programmation Java
        Quiz quiz2 = new Quiz();
        quiz2.setId(nextQuizId++);
        quiz2.setTitre("☕ Programmation Java");
        quiz2.setDescription("Quiz pour débutants en Java");
        
        List<Question> questions2 = new ArrayList<>();
        
        Question j1 = new Question();
        j1.setId(nextQuestionId++);
        j1.setTexte("Qu'est-ce que Java ?");
        j1.setOption1("Un langage de programmation");
        j1.setOption2("Une île");
        j1.setOption3("Un café");
        j1.setOption4("Un navigateur");
        j1.setBonneReponse(1);
        j1.setQuiz(quiz2);
        questions2.add(j1);
        
        Question j2 = new Question();
        j2.setId(nextQuestionId++);
        j2.setTexte("Comment afficher du texte en Java ?");
        j2.setOption1("print()");
        j2.setOption2("System.out.println()");
        j2.setOption3("console.log()");
        j2.setOption4("echo()");
        j2.setBonneReponse(2);
        j2.setQuiz(quiz2);
        questions2.add(j2);
        
        Question j3 = new Question();
        j3.setId(nextQuestionId++);
        j3.setTexte("Quel mot-clé pour créer un objet ?");
        j3.setOption1("new");
        j3.setOption2("create");
        j3.setOption3("object");
        j3.setOption4("class");
        j3.setBonneReponse(1);
        j3.setQuiz(quiz2);
        questions2.add(j3);
        
        quiz2.setQuestions(questions2);
        quizs.add(quiz2);
        
        // Quiz 3: Géographie
        Quiz quiz3 = new Quiz();
        quiz3.setId(nextQuizId++);
        quiz3.setTitre("🌍 Géographie");
        quiz3.setDescription("Testez vos connaissances en géographie");
        
        List<Question> questions3 = new ArrayList<>();
        
        Question g1 = new Question();
        g1.setId(nextQuestionId++);
        g1.setTexte("Quel est le plus grand pays du monde ?");
        g1.setOption1("Chine");
        g1.setOption2("États-Unis");
        g1.setOption3("Russie");
        g1.setOption4("Canada");
        g1.setBonneReponse(3);
        g1.setQuiz(quiz3);
        questions3.add(g1);
        
        Question g2 = new Question();
        g2.setId(nextQuestionId++);
        g2.setTexte("Quelle est la capitale du Japon ?");
        g2.setOption1("Osaka");
        g2.setOption2("Kyoto");
        g2.setOption3("Tokyo");
        g2.setOption4("Yokohama");
        g2.setBonneReponse(3);
        g2.setQuiz(quiz3);
        questions3.add(g2);
        
        quiz3.setQuestions(questions3);
        quizs.add(quiz3);
    }
    
    public List<Quiz> tousLesQuiz() {
        return quizs;
    }
    
    public Quiz trouverParId(Long id) {
        Optional<Quiz> quiz = quizs.stream()
            .filter(q -> q.getId().equals(id))
            .findFirst();
        return quiz.orElse(null);
    }
}
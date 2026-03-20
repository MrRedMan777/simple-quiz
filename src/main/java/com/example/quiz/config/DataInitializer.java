// config/DataInitializer.java
package com.example.quiz.config;

import com.example.quiz.model.Question;
import com.example.quiz.model.Quiz;
import com.example.quiz.repository.QuizRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import java.util.Arrays;
import java.util.List;

@Component
public class DataInitializer implements CommandLineRunner {
    
    @Autowired
    private QuizRepository quizRepository;
    
    @Override
    public void run(String... args) throws Exception {
        
        // Vérifier si des quiz existent déjà
        if (quizRepository.count() == 0) {
            System.out.println("=== CRÉATION DES QUIZ ===");
            
            // ===========================================
            // CULTURE GÉNÉRALE
            // ===========================================
            Quiz culture = new Quiz();
            culture.setTitre("📚 Culture Générale");
            culture.setDescription("Testez vos connaissances en culture générale");
            
            List<Question> questionsCulture = Arrays.asList(
                creerQuestion(
                    "Quelle est la capitale de la France ?",
                    "Lyon", "Marseille", "Paris", "Bordeaux",
                    3, culture
                ),
                creerQuestion(
                    "Combien de continents y a-t-il ?",
                    "5", "6", "7", "8",
                    3, culture
                ),
                creerQuestion(
                    "Qui a peint la Joconde ?",
                    "Van Gogh", "Picasso", "Léonard de Vinci", "Rembrandt",
                    3, culture
                ),
                creerQuestion(
                    "En quelle année a eu lieu la Révolution française ?",
                    "1789", "1799", "1776", "1815",
                    1, culture
                ),
                creerQuestion(
                    "Quel est le plus long fleuve de France ?",
                    "La Seine", "Le Rhône", "La Loire", "La Garonne",
                    3, culture
                )
            );
            
            culture.setQuestions(questionsCulture);
            
            // ===========================================
            // PROGRAMMATION JAVA
            // ===========================================
            Quiz java = new Quiz();
            java.setTitre("☕ Programmation Java");
            java.setDescription("Quiz pour débutants en Java");
            
            List<Question> questionsJava = Arrays.asList(
                creerQuestion(
                    "Qu'est-ce que Java ?",
                    "Un langage de programmation", "Une île", "Un café", "Un navigateur",
                    1, java
                ),
                creerQuestion(
                    "Comment afficher du texte en Java ?",
                    "print()", "System.out.println()", "console.log()", "echo()",
                    2, java
                ),
                creerQuestion(
                    "Quel est le mot-clé pour créer un objet ?",
                    "new", "create", "object", "class",
                    1, java
                ),
                creerQuestion(
                    "Que signifie JVM ?",
                    "Java Virtual Machine", "Java Variable Manager", "Java Version Manager", "Java Visual Machine",
                    1, java
                ),
                creerQuestion(
                    "Quel est le type pour les nombres entiers ?",
                    "int", "float", "double", "string",
                    1, java
                )
            );
            
            java.setQuestions(questionsJava);
            
            // ===========================================
            // GÉOGRAPHIE
            // ===========================================
            Quiz geo = new Quiz();
            geo.setTitre("🌍 Géographie");
            geo.setDescription("Testez vos connaissances en géographie");
            
            List<Question> questionsGeo = Arrays.asList(
                creerQuestion(
                    "Quel est le plus grand pays du monde ?",
                    "Chine", "États-Unis", "Russie", "Canada",
                    3, geo
                ),
                creerQuestion(
                    "Quelle est la capitale du Japon ?",
                    "Osaka", "Kyoto", "Tokyo", "Yokohama",
                    3, geo
                ),
                creerQuestion(
                    "Quel est le plus long fleuve du monde ?",
                    "Amazone", "Nil", "Mississippi", "Yangtsé",
                    2, geo
                ),
                creerQuestion(
                    "Quelle est la plus haute montagne du monde ?",
                    "Mont Blanc", "Kilimandjaro", "Everest", "K2",
                    3, geo
                ),
                creerQuestion(
                    "Quel désert est le plus grand ?",
                    "Sahara", "Gobi", "Kalahari", "Atacama",
                    1, geo
                )
            );
            
            geo.setQuestions(questionsGeo);
            
            // ===========================================
            // SCIENCES
            // ===========================================
            Quiz sciences = new Quiz();
            sciences.setTitre("🔬 Sciences");
            sciences.setDescription("Questions sur les sciences");
            
            List<Question> questionsSciences = Arrays.asList(
                creerQuestion(
                    "Quelle planète est la plus proche du Soleil ?",
                    "Vénus", "Mercure", "Terre", "Mars",
                    2, sciences
                ),
                creerQuestion(
                    "Combien d'os a le corps humain ?",
                    "206", "208", "210", "212",
                    1, sciences
                ),
                creerQuestion(
                    "Quel est l'animal le plus rapide ?",
                    "Guépard", "Lion", "Gazelle", "Antilope",
                    1, sciences
                ),
                creerQuestion(
                    "Combien de dents a un adulte ?",
                    "28", "30", "32", "34",
                    3, sciences
                ),
                creerQuestion(
                    "Quel gaz les plantes absorbent-elles ?",
                    "Oxygène", "Azote", "CO2", "Hydrogène",
                    3, sciences
                )
            );
            
            sciences.setQuestions(questionsSciences);
            
            // ===========================================
            // SPORTS
            // ===========================================
            Quiz sports = new Quiz();
            sports.setTitre("⚽ Sports");
            sports.setDescription("Quiz sur le sport");
            
            List<Question> questionsSports = Arrays.asList(
                creerQuestion(
                    "Combien de joueurs au football ?",
                    "10", "11", "12", "13",
                    2, sports
                ),
                creerQuestion(
                    "Qui a gagné la Coupe du Monde 2018 ?",
                    "Allemagne", "Brésil", "France", "Espagne",
                    3, sports
                ),
                creerQuestion(
                    "Combien de joueurs au basket ?",
                    "4", "5", "6", "7",
                    2, sports
                ),
                creerQuestion(
                    "Qui a le plus de Ballons d'Or ?",
                    "Ronaldo", "Messi", "Platini", "Zidane",
                    2, sports
                ),
                creerQuestion(
                    "Quel sport pratique Roger Federer ?",
                    "Football", "Basket", "Tennis", "Golf",
                    3, sports
                )
            );
            
            sports.setQuestions(questionsSports);
            
            // Sauvegarder tous les quiz
            quizRepository.saveAll(Arrays.asList(culture, java, geo, sciences, sports));
            
            System.out.println("✅ Quiz créés avec succès !");
            System.out.println("📊 Nombre de quiz : " + quizRepository.count());
        } else {
            System.out.println("ℹ️ Des quiz existent déjà : " + quizRepository.count());
        }
    }
    
    /**
     * Méthode utilitaire pour créer une question facilement
     */
    private Question creerQuestion(String texte, 
                                   String opt1, String opt2, String opt3, String opt4,
                                   int bonneReponse, Quiz quiz) {
        Question q = new Question();
        q.setTexte(texte);
        q.setOption1(opt1);
        q.setOption2(opt2);
        q.setOption3(opt3);
        q.setOption4(opt4);
        q.setBonneReponse(bonneReponse);
        q.setQuiz(quiz);
        return q;
    }
}
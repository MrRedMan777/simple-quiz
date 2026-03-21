package com.example.quiz.service;

import com.example.quiz.model.Question;
import com.example.quiz.model.Quiz;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class QuizService {
    
    private List<Quiz> quizs = new ArrayList<>();
    private Long nextQuizId = 1L;
    private Long nextQuestionId = 1L;
    
    @PostConstruct
    public void init() {
        // ===========================================
        // QUIZ 1: CULTURE GÉNÉRALE (15 questions)
        // ===========================================
        Quiz quiz1 = new Quiz();
        quiz1.setId(nextQuizId++);
        quiz1.setTitre("📚 Culture Générale");
        quiz1.setDescription("Testez vos connaissances en culture générale - 15 questions");
        
        List<Question> questions1 = new ArrayList<>();
        
        questions1.add(creerQuestion(
            "Quelle est la capitale de la France ?",
            "Lyon", "Marseille", "Paris", "Bordeaux", 3, quiz1));
        
        questions1.add(creerQuestion(
            "Combien de continents y a-t-il ?",
            "5", "6", "7", "8", 3, quiz1));
        
        questions1.add(creerQuestion(
            "Qui a peint la Joconde ?",
            "Van Gogh", "Picasso", "Léonard de Vinci", "Rembrandt", 3, quiz1));
        
        questions1.add(creerQuestion(
            "En quelle année a eu lieu la Révolution française ?",
            "1789", "1799", "1776", "1815", 1, quiz1));
        
        questions1.add(creerQuestion(
            "Quel est le plus long fleuve de France ?",
            "La Seine", "Le Rhône", "La Loire", "La Garonne", 3, quiz1));
        
        questions1.add(creerQuestion(
            "Qui a écrit 'Les Misérables' ?",
            "Victor Hugo", "Émile Zola", "Albert Camus", "Gustave Flaubert", 1, quiz1));
        
        questions1.add(creerQuestion(
            "Quel est le symbole chimique de l'eau ?",
            "CO2", "O2", "H2O", "H2O2", 3, quiz1));
        
        questions1.add(creerQuestion(
            "Qui a dit 'Je pense donc je suis' ?",
            "Platon", "Aristote", "Descartes", "Socrate", 3, quiz1));
        
        questions1.add(creerQuestion(
            "Quelle est la monnaie du Japon ?",
            "Yuan", "Yen", "Won", "Dollar", 2, quiz1));
        
        questions1.add(creerQuestion(
            "Combien de sonnets a écrit Shakespeare ?",
            "100", "154", "200", "50", 2, quiz1));
        
        questions1.add(creerQuestion(
            "Quel est le plus grand désert du monde ?",
            "Sahara", "Gobi", "Antarctique", "Kalahari", 3, quiz1));
        
        questions1.add(creerQuestion(
            "Qui a découvert la pénicilline ?",
            "Marie Curie", "Louis Pasteur", "Alexander Fleming", "Albert Einstein", 3, quiz1));
        
        questions1.add(creerQuestion(
            "Quelle est la plus haute montagne d'Europe ?",
            "Mont Blanc", "Elbrouz", "Matterhorn", "Kilimandjaro", 2, quiz1));
        
        questions1.add(creerQuestion(
            "Quel pays a inventé le papier ?",
            "Égypte", "Grèce", "Chine", "Inde", 3, quiz1));
        
        questions1.add(creerQuestion(
            "Qui a écrit 'Le Petit Prince' ?",
            "Victor Hugo", "Antoine de Saint-Exupéry", "Albert Camus", "Molière", 2, quiz1));
        
        quiz1.setQuestions(questions1);
        quizs.add(quiz1);
        
        // ===========================================
        // QUIZ 2: PROGRAMMATION JAVA (15 questions)
        // ===========================================
        Quiz quiz2 = new Quiz();
        quiz2.setId(nextQuizId++);
        quiz2.setTitre("☕ Programmation Java");
        quiz2.setDescription("Quiz pour débutants et intermédiaires en Java - 15 questions");
        
        List<Question> questions2 = new ArrayList<>();
        
        questions2.add(creerQuestion(
            "Qu'est-ce que Java ?",
            "Un langage de programmation", "Une île", "Un café", "Un navigateur", 1, quiz2));
        
        questions2.add(creerQuestion(
            "Comment afficher du texte en Java ?",
            "print()", "System.out.println()", "console.log()", "echo()", 2, quiz2));
        
        questions2.add(creerQuestion(
            "Quel est le mot-clé pour créer un objet ?",
            "new", "create", "object", "class", 1, quiz2));
        
        questions2.add(creerQuestion(
            "Que signifie JVM ?",
            "Java Virtual Machine", "Java Variable Manager", "Java Version Manager", "Java Visual Machine", 1, quiz2));
        
        questions2.add(creerQuestion(
            "Quel est le type pour les nombres entiers ?",
            "int", "float", "double", "string", 1, quiz2));
        
        questions2.add(creerQuestion(
            "Quelle est la méthode principale en Java ?",
            "start()", "run()", "main()", "init()", 3, quiz2));
        
        questions2.add(creerQuestion(
            "Comment faire un commentaire sur une ligne ?",
            "// commentaire", "<!-- commentaire -->", "# commentaire", "/* commentaire */", 1, quiz2));
        
        questions2.add(creerQuestion(
            "Quelle est la classe de base de toutes les classes ?",
            "Object", "String", "Class", "Main", 1, quiz2));
        
        questions2.add(creerQuestion(
            "Que signifie IDE ?",
            "Integrated Development Environment", "Internet Development Environment", "Integrated Debug Environment", "Interface Development Environment", 1, quiz2));
        
        questions2.add(creerQuestion(
            "Quel framework Java est le plus populaire ?",
            "Spring", "Hibernate", "Struts", "JavaFX", 1, quiz2));
        
        questions2.add(creerQuestion(
            "Quelle est la différence entre == et equals() ?",
            "Comparaison d'objets", "Comparaison de valeurs", "Comparaison de références", "Aucune différence", 3, quiz2));
        
        questions2.add(creerQuestion(
            "Quel est le mot-clé pour hériter d'une classe ?",
            "implements", "extends", "inherits", "super", 2, quiz2));
        
        questions2.add(creerQuestion(
            "Que signifie API ?",
            "Application Programming Interface", "Application Program Interface", "Advanced Programming Interface", "Application Programming Integration", 1, quiz2));
        
        questions2.add(creerQuestion(
            "Quel est le package par défaut importé automatiquement ?",
            "java.util", "java.io", "java.lang", "java.net", 3, quiz2));
        
        questions2.add(creerQuestion(
            "Quelle annotation est utilisée pour un point d'entrée Spring Boot ?",
            "@Controller", "@Service", "@SpringBootApplication", "@Component", 3, quiz2));
        
        quiz2.setQuestions(questions2);
        quizs.add(quiz2);
        
        // ===========================================
        // QUIZ 3: GÉOGRAPHIE (15 questions)
        // ===========================================
        Quiz quiz3 = new Quiz();
        quiz3.setId(nextQuizId++);
        quiz3.setTitre("🌍 Géographie Mondiale");
        quiz3.setDescription("Testez vos connaissances en géographie - 15 questions");
        
        List<Question> questions3 = new ArrayList<>();
        
        questions3.add(creerQuestion(
            "Quel est le plus grand pays du monde ?",
            "Chine", "États-Unis", "Russie", "Canada", 3, quiz3));
        
        questions3.add(creerQuestion(
            "Quel est le plus petit pays du monde ?",
            "Monaco", "Vatican", "Saint-Marin", "Liechtenstein", 2, quiz3));
        
        questions3.add(creerQuestion(
            "Quel est le plus long fleuve du monde ?",
            "Amazone", "Nil", "Mississippi", "Yangtsé", 2, quiz3));
        
        questions3.add(creerQuestion(
            "Quelle est la plus haute montagne du monde ?",
            "Mont Blanc", "Kilimandjaro", "Everest", "K2", 3, quiz3));
        
        questions3.add(creerQuestion(
            "Quelle est la capitale du Japon ?",
            "Osaka", "Kyoto", "Tokyo", "Yokohama", 3, quiz3));
        
        questions3.add(creerQuestion(
            "Quel pays a la plus grande population ?",
            "Inde", "Chine", "États-Unis", "Indonésie", 2, quiz3));
        
        questions3.add(creerQuestion(
            "Quel est le plus grand océan ?",
            "Atlantique", "Indien", "Pacifique", "Arctique", 3, quiz3));
        
        questions3.add(creerQuestion(
            "Quel désert est le plus grand ?",
            "Sahara", "Gobi", "Antarctique", "Arabique", 3, quiz3));
        
        questions3.add(creerQuestion(
            "Quelle est la capitale du Brésil ?",
            "Rio de Janeiro", "São Paulo", "Brasilia", "Salvador", 3, quiz3));
        
        questions3.add(creerQuestion(
            "Quel pays est surnommé 'le pays du soleil levant' ?",
            "Chine", "Corée", "Japon", "Vietnam", 3, quiz3));
        
        questions3.add(creerQuestion(
            "Quelle est la plus grande île du monde ?",
            "Madagascar", "Groenland", "Bornéo", "Australie", 2, quiz3));
        
        questions3.add(creerQuestion(
            "Quel détroit sépare l'Europe de l'Afrique ?",
            "Détroit de Béring", "Détroit de Gibraltar", "Détroit d'Ormuz", "Détroit de Magellan", 2, quiz3));
        
        questions3.add(creerQuestion(
            "Quel pays possède le plus de volcans ?",
            "Japon", "Indonésie", "États-Unis", "Italie", 2, quiz3));
        
        questions3.add(creerQuestion(
            "Quelle est la capitale de l'Australie ?",
            "Sydney", "Melbourne", "Canberra", "Perth", 3, quiz3));
        
        questions3.add(creerQuestion(
            "Quel lac est le plus profond du monde ?",
            "Lac Baïkal", "Lac Tanganyika", "Lac Supérieur", "Lac Victoria", 1, quiz3));
        
        quiz3.setQuestions(questions3);
        quizs.add(quiz3);
        
        // ===========================================
        // QUIZ 4: SCIENCES (15 questions)
        // ===========================================
        Quiz quiz4 = new Quiz();
        quiz4.setId(nextQuizId++);
        quiz4.setTitre("🔬 Sciences et Nature");
        quiz4.setDescription("Questions sur les sciences, la physique et la biologie - 15 questions");
        
        List<Question> questions4 = new ArrayList<>();
        
        questions4.add(creerQuestion(
            "Quelle planète est la plus proche du Soleil ?",
            "Vénus", "Mercure", "Terre", "Mars", 2, quiz4));
        
        questions4.add(creerQuestion(
            "Combien d'os a le corps humain adulte ?",
            "206", "208", "210", "212", 1, quiz4));
        
        questions4.add(creerQuestion(
            "Quel est l'animal le plus rapide sur terre ?",
            "Lion", "Guépard", "Gazelle", "Antilope", 2, quiz4));
        
        questions4.add(creerQuestion(
            "Combien de dents a un adulte ?",
            "28", "30", "32", "34", 3, quiz4));
        
        questions4.add(creerQuestion(
            "Quel gaz les plantes absorbent-elles pour la photosynthèse ?",
            "Oxygène", "Azote", "CO2", "Hydrogène", 3, quiz4));
        
        questions4.add(creerQuestion(
            "Quelle est la vitesse de la lumière ?",
            "300 000 km/s", "150 000 km/s", "1 million km/s", "3 millions km/s", 1, quiz4));
        
        questions4.add(creerQuestion(
            "Combien de chromosomes a un humain ?",
            "23", "44", "46", "48", 3, quiz4));
        
        questions4.add(creerQuestion(
            "Quel est le plus grand organe du corps humain ?",
            "Cœur", "Foie", "Peau", "Poumons", 3, quiz4));
        
        questions4.add(creerQuestion(
            "Quel est le seul mammifère capable de voler ?",
            "Écureuil volant", "Chauve-souris", "Oiseau", "Papillon", 2, quiz4));
        
        questions4.add(creerQuestion(
            "Combien de litres de sang dans le corps humain ?",
            "2-3 L", "4-5 L", "5-6 L", "6-7 L", 3, quiz4));
        
        questions4.add(creerQuestion(
            "Quelle est la formule de l'eau ?",
            "H2O", "CO2", "O2", "NaCl", 1, quiz4));
        
        questions4.add(creerQuestion(
            "Quel scientifique a proposé la théorie de l'évolution ?",
            "Albert Einstein", "Isaac Newton", "Charles Darwin", "Galilée", 3, quiz4));
        
        questions4.add(creerQuestion(
            "Quel est le plus grand organe du corps humain ?",
            "Le cœur", "Le foie", "La peau", "Les poumons", 3, quiz4));
        
        questions4.add(creerQuestion(
            "Quelle est la plus petite particule d'un élément ?",
            "Molécule", "Atome", "Électron", "Proton", 2, quiz4));
        
        questions4.add(creerQuestion(
            "Quel élément a pour symbole 'Au' ?",
            "Argent", "Or", "Aluminium", "Arsenic", 2, quiz4));
        
        quiz4.setQuestions(questions4);
        quizs.add(quiz4);
        
        // ===========================================
        // QUIZ 5: SPORTS (15 questions)
        // ===========================================
        Quiz quiz5 = new Quiz();
        quiz5.setId(nextQuizId++);
        quiz5.setTitre("⚽ Sports et Athlètes");
        quiz5.setDescription("Testez vos connaissances sur le sport - 15 questions");
        
        List<Question> questions5 = new ArrayList<>();
        
        questions5.add(creerQuestion(
            "Combien de joueurs dans une équipe de football ?",
            "10", "11", "12", "13", 2, quiz5));
        
        questions5.add(creerQuestion(
            "Qui a gagné la Coupe du Monde 2018 ?",
            "Allemagne", "Brésil", "France", "Espagne", 3, quiz5));
        
        questions5.add(creerQuestion(
            "Combien de joueurs au basket ?",
            "4", "5", "6", "7", 2, quiz5));
        
        questions5.add(creerQuestion(
            "Qui a le plus de Ballons d'Or ?",
            "Cristiano Ronaldo", "Lionel Messi", "Michel Platini", "Zinedine Zidane", 2, quiz5));
        
        questions5.add(creerQuestion(
            "Quel sport pratique Roger Federer ?",
            "Football", "Basket", "Tennis", "Golf", 3, quiz5));
        
        questions5.add(creerQuestion(
            "Combien de points pour un essai au rugby ?",
            "3", "4", "5", "6", 3, quiz5));
        
        questions5.add(creerQuestion(
            "Quel pays a le plus de médailles olympiques ?",
            "Chine", "Russie", "États-Unis", "Allemagne", 3, quiz5));
        
        questions5.add(creerQuestion(
            "Combien de rounds dans un combat de boxe professionnel ?",
            "10", "12", "15", "8", 2, quiz5));
        
        questions5.add(creerQuestion(
            "Quelle est la distance d'un marathon ?",
            "40 km", "42,195 km", "41 km", "43 km", 2, quiz5));
        
        questions5.add(creerQuestion(
            "Quel pays a inventé le judo ?",
            "Chine", "Corée", "Japon", "Thaïlande", 3, quiz5));
        
        questions5.add(creerQuestion(
            "Qui détient le record du 100m ?",
            "Usain Bolt", "Carl Lewis", "Tyson Gay", "Asafa Powell", 1, quiz5));
        
        questions5.add(creerQuestion(
            "Combien de joueurs dans une équipe de volley ?",
            "5", "6", "7", "8", 2, quiz5));
        
        questions5.add(creerQuestion(
            "Quel sport est surnommé 'le sport roi' ?",
            "Basketball", "Tennis", "Football", "Rugby", 3, quiz5));
        
        questions5.add(creerQuestion(
            "Qui a remporté le plus de Tour de France ?",
            "Lance Armstrong", "Eddy Merckx", "Bernard Hinault", "Jacques Anquetil", 2, quiz5));
        
        questions5.add(creerQuestion(
            "Combien de sets pour gagner un match de tennis ?",
            "2", "3", "2 ou 3", "4", 3, quiz5));
        
        quiz5.setQuestions(questions5);
        quizs.add(quiz5);
        
        // ===========================================
        // QUIZ 6: CINÉMA (15 questions)
        // ===========================================
        Quiz quiz6 = new Quiz();
        quiz6.setId(nextQuizId++);
        quiz6.setTitre("🎬 Cinéma et Films");
        quiz6.setDescription("Testez vos connaissances sur le 7ème art - 15 questions");
        
        List<Question> questions6 = new ArrayList<>();
        
        questions6.add(creerQuestion(
            "Quel film a le plus d'Oscars ?",
            "Titanic", "Ben-Hur", "Le Seigneur des Anneaux", "La La Land", 2, quiz6));
        
        questions6.add(creerQuestion(
            "Qui a joué dans Titanic ?",
            "Brad Pitt", "Tom Hanks", "Leonardo DiCaprio", "Johnny Depp", 3, quiz6));
        
        questions6.add(creerQuestion(
            "Quel est le film le plus rentable de l'histoire ?",
            "Avatar", "Avengers: Endgame", "Titanic", "Star Wars", 1, quiz6));
        
        questions6.add(creerQuestion(
            "Qui a réalisé Star Wars ?",
            "Steven Spielberg", "George Lucas", "James Cameron", "Ridley Scott", 2, quiz6));
        
        questions6.add(creerQuestion(
            "Combien de films Harry Potter ?",
            "7", "8", "9", "10", 2, quiz6));
        
        questions6.add(creerQuestion(
            "Qui a joué James Bond le plus longtemps ?",
            "Sean Connery", "Roger Moore", "Pierce Brosnan", "Daniel Craig", 2, quiz6));
        
        questions6.add(creerQuestion(
            "Quel film a remporté la Palme d'Or 2023 ?",
            "Anatomie d'une chute", "Oppenheimer", "Barbie", "Killers of the Flower Moon", 1, quiz6));
        
        questions6.add(creerQuestion(
            "Qui a réalisé Pulp Fiction ?",
            "Martin Scorsese", "Quentin Tarantino", "Francis Ford Coppola", "Woody Allen", 2, quiz6));
        
        questions6.add(creerQuestion(
            "Dans quel film entend-on 'I'll be back' ?",
            "Rocky", "Rambo", "Terminator", "Predator", 3, quiz6));
        
        questions6.add(creerQuestion(
            "Quel est le premier film d'animation Disney ?",
            "Cendrillon", "Blanche-Neige", "Pinocchio", "Bambi", 2, quiz6));
        
        questions6.add(creerQuestion(
            "Qui a joué dans Le Parrain ?",
            "Al Pacino", "Robert De Niro", "Marlon Brando", "James Caan", 3, quiz6));
        
        questions6.add(creerQuestion(
            "Quel film a gagné l'Oscar du meilleur film en 2020 ?",
            "1917", "Joker", "Parasite", "Once Upon a Time in Hollywood", 3, quiz6));
        
        questions6.add(creerQuestion(
            "Qui est l'acteur le mieux payé de tous les temps ?",
            "Dwayne Johnson", "Robert Downey Jr.", "Tom Cruise", "Will Smith", 1, quiz6));
        
        questions6.add(creerQuestion(
            "Quel film a popularisé le terme 'génial' ?",
            "Back to the Future", "Ghostbusters", "Teenage Mutant Ninja Turtles", "Wayne's World", 4, quiz6));
        
        questions6.add(creerQuestion(
            "Quel réalisateur a fait 'Inception' ?",
            "James Cameron", "Steven Spielberg", "Christopher Nolan", "Ridley Scott", 3, quiz6));
        
        quiz6.setQuestions(questions6);
        quizs.add(quiz6);
        
        // ===========================================
        // QUIZ 7: MUSIQUE (15 questions)
        // ===========================================
        Quiz quiz7 = new Quiz();
        quiz7.setId(nextQuizId++);
        quiz7.setTitre("🎵 Musique et Artistes");
        quiz7.setDescription("Testez vos connaissances musicales - 15 questions");
        
        List<Question> questions7 = new ArrayList<>();
        
        questions7.add(creerQuestion(
            "Quel groupe a chanté 'Bohemian Rhapsody' ?",
            "The Beatles", "Queen", "Led Zeppelin", "Pink Floyd", 2, quiz7));
        
        questions7.add(creerQuestion(
            "Qui est surnommé 'The King of Pop' ?",
            "Elvis Presley", "Michael Jackson", "Prince", "Madonna", 2, quiz7));
        
        questions7.add(creerQuestion(
            "Combien de cordes a une guitare classique ?",
            "4", "5", "6", "7", 3, quiz7));
        
        questions7.add(creerQuestion(
            "Qui a chanté 'Imagine' ?",
            "John Lennon", "Paul McCartney", "George Harrison", "Ringo Starr", 1, quiz7));
        
        questions7.add(creerQuestion(
            "Quel est le single le plus vendu de tous les temps ?",
            "White Christmas", "Candle in the Wind", "We Are the World", "Shape of You", 2, quiz7));
        
        questions7.add(creerQuestion(
            "Qui est la chanteuse la plus vendue ?",
            "Madonna", "Rihanna", "Mariah Carey", "Whitney Houston", 3, quiz7));
        
        questions7.add(creerQuestion(
            "Quel pays a inventé le reggae ?",
            "Cuba", "Brésil", "Jamaïque", "Haïti", 3, quiz7));
        
        questions7.add(creerQuestion(
            "Combien de musiciens dans un quatuor à cordes ?",
            "2", "3", "4", "5", 3, quiz7));
        
        questions7.add(creerQuestion(
            "Qui a composé la 'Symphonie du Nouveau Monde' ?",
            "Beethoven", "Mozart", "Dvořák", "Tchaïkovski", 3, quiz7));
        
        questions7.add(creerQuestion(
            "Quel groupe a chanté 'Stairway to Heaven' ?",
            "Led Zeppelin", "Deep Purple", "Black Sabbath", "The Who", 1, quiz7));
        
        questions7.add(creerQuestion(
            "Qui est le roi du rock 'n' roll ?",
            "Elvis Presley", "Chuck Berry", "Jerry Lee Lewis", "Buddy Holly", 1, quiz7));
        
        questions7.add(creerQuestion(
            "Quelle chanteuse a interprété 'Rolling in the Deep' ?",
            "Beyoncé", "Rihanna", "Adele", "Taylor Swift", 3, quiz7));
        
        questions7.add(creerQuestion(
            "Quel est l'instrument de Miles Davis ?",
            "Saxophone", "Piano", "Trompette", "Contrebasse", 3, quiz7));
        
        questions7.add(creerQuestion(
            "Quel groupe a fait 'Smells Like Teen Spirit' ?",
            "Pearl Jam", "Soundgarden", "Alice in Chains", "Nirvana", 4, quiz7));
        
        questions7.add(creerQuestion(
            "Qui a chanté 'Like a Rolling Stone' ?",
            "Bob Dylan", "Bruce Springsteen", "Neil Young", "Tom Waits", 1, quiz7));
        
        quiz7.setQuestions(questions7);
        quizs.add(quiz7);
        
        // ===========================================
        // QUIZ 8: HISTOIRE (15 questions)
        // ===========================================
        Quiz quiz8 = new Quiz();
        quiz8.setId(nextQuizId++);
        quiz8.setTitre("📜 Grandes Dates de l'Histoire");
        quiz8.setDescription("Testez vos connaissances historiques - 15 questions");
        
        List<Question> questions8 = new ArrayList<>();
        
        questions8.add(creerQuestion(
            "En quelle année Christophe Colomb a découvert l'Amérique ?",
            "1492", "1498", "1500", "1488", 1, quiz8));
        
        questions8.add(creerQuestion(
            "Qui fut le premier empereur romain ?",
            "Jules César", "Auguste", "Néron", "Caligula", 2, quiz8));
        
        questions8.add(creerQuestion(
            "En quelle année le mur de Berlin est tombé ?",
            "1987", "1989", "1991", "1985", 2, quiz8));
        
        questions8.add(creerQuestion(
            "Qui a peint la chapelle Sixtine ?",
            "Léonard de Vinci", "Raphaël", "Michel-Ange", "Donatello", 3, quiz8));
        
        questions8.add(creerQuestion(
            "Qui a écrit l'Iliade ?",
            "Sophocle", "Euripide", "Homère", "Platon", 3, quiz8));
        
        questions8.add(creerQuestion(
            "Quel traité a mis fin à la Première Guerre mondiale ?",
            "Traité de Versailles", "Traité de Paris", "Traité de Rome", "Traité de Berlin", 1, quiz8));
        
        questions8.add(creerQuestion(
            "Qui a été le premier homme à marcher sur la Lune ?",
            "Buzz Aldrin", "Neil Armstrong", "Youri Gagarine", "Alan Shepard", 2, quiz8));
        
        questions8.add(creerQuestion(
            "En quelle année la Révolution française a-t-elle commencé ?",
            "1789", "1799", "1776", "1815", 1, quiz8));
        
        questions8.add(creerQuestion(
            "Quel pharaon est célèbre pour son tombeau ?",
            "Ramsès II", "Toutânkhamon", "Akhenaton", "Kheops", 2, quiz8));
        
        questions8.add(creerQuestion(
            "Qui a découvert la radioactivité ?",
            "Marie Curie", "Pierre Curie", "Henri Becquerel", "Albert Einstein", 3, quiz8));
        
        questions8.add(creerQuestion(
            "Quelle civilisation a inventé l'écriture ?",
            "Égyptiens", "Mésopotamiens", "Chinois", "Grecs", 2, quiz8));
        
        questions8.add(creerQuestion(
            "Qui était Napoléon Bonaparte ?",
            "Roi de France", "Empereur des Français", "Président", "Général romain", 2, quiz8));
        
        questions8.add(creerQuestion(
            "En quelle année la Tour Eiffel a-t-elle été construite ?",
            "1887", "1889", "1891", "1885", 2, quiz8));
        
        questions8.add(creerQuestion(
            "Qui a écrit 'Le Capital' ?",
            "Friedrich Engels", "Karl Marx", "Vladimir Lénine", "Adam Smith", 2, quiz8));
        
        questions8.add(creerQuestion(
            "Quel explorateur a découvert le Canada ?",
            "Jacques Cartier", "Samuel de Champlain", "John Cabot", "James Cook", 1, quiz8));
        
        quiz8.setQuestions(questions8);
        quizs.add(quiz8);
        
        System.out.println("✅ " + quizs.size() + " quiz créés avec succès !");
        for (Quiz q : quizs) {
            System.out.println("   - " + q.getTitre() + " : " + q.getQuestions().size() + " questions");
        }
    }
    
    private Question creerQuestion(String texte, String opt1, String opt2, String opt3, String opt4,
                                   int bonneReponse, Quiz quiz) {
        Question q = new Question();
        q.setId(nextQuestionId++);
        q.setTexte(texte);
        q.setOption1(opt1);
        q.setOption2(opt2);
        q.setOption3(opt3);
        q.setOption4(opt4);
        q.setBonneReponse(bonneReponse);
        q.setQuiz(quiz);
        return q;
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
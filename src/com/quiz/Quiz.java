package com.quiz;

import java.util.*;

public class Quiz {
    private List<Question> questions;
    private int score;

    public Quiz() {
        questions = new ArrayList<>();
        score = 0;
        loadQuestions();
    }

    private void loadQuestions() {
        questions.add(new Question("Which language is used for Android app development?",
                new String[]{"Java", "Python", "C++", "Ruby"}, 0));
        questions.add(new Question("What does JVM stand for?",
                new String[]{"Java Variable Machine", "Java Virtual Machine", "Java Visual Model", "Joint Virtual Method"}, 1));
        questions.add(new Question("Which keyword is used to inherit a class in Java?",
                new String[]{"this", "super", "extends", "import"}, 2));
        questions.add(new Question("Which company developed Java?",
                new String[]{"Microsoft", "Sun Microsystems", "Google", "Oracle"}, 1));
        questions.add(new Question("Which data type is used to store true/false values?",
                new String[]{"int", "boolean", "char", "String"}, 1));
    }

    public void startQuiz() {
        Scanner sc = new Scanner(System.in);
        System.out.println("===== Welcome to the Online Quiz App =====");

        for (int i = 0; i < questions.size(); i++) {
            Question q = questions.get(i);
            System.out.println("\nQuestion " + (i + 1) + ":");
            q.displayQuestion();
            System.out.print("Your Answer (1-4): ");
            int answer = sc.nextInt();

            if (q.checkAnswer(answer)) {
                System.out.println("✅ Correct!");
                score++;
            } else {
                System.out.println("❌ Wrong! Correct answer: " + (q.getCorrectAnswerIndex() + 1)
                        + ". " + q.getCorrectOption());
            }
        }

        System.out.println("\n===== Quiz Finished =====");
        System.out.println("Your Score: " + score + "/" + questions.size());

        if (score == questions.size()) {
            System.out.println("🎉 Excellent! You got all correct!");
        } else if (score >= questions.size() / 2) {
            System.out.println("👍 Good job! You passed.");
        } else {
            System.out.println("😢 Better luck next time!");
        }

        sc.close();
    }
}

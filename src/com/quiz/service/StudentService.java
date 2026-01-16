package com.quiz.service;

import com.quiz.model.Question;

import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class StudentService {

    private final QuestionService questionService = new QuestionService();
    private final Scanner scanner = new Scanner(System.in);

    public void start(String studentName) {

        System.out.print("System:> Press 's' to start the quiz: ");
        String input = scanner.nextLine();

        if (!input.equalsIgnoreCase("s")) {
            return;
        }

        List<Question> questions = questionService.loadQuestions();

        if (questions.size() == 0) {
            System.out.println("System:> No questions available.");
            return;
        }

        int score = 0;
        Random random = new Random();

        for (int i = 0; i < 10; i++) {

            Question q = questions.get(random.nextInt(questions.size()));

            System.out.println("\nSystem:> [Question " + (i + 1) + "] " + q.getQuestion());
            System.out.println("1. " + q.getOption1());
            System.out.println("2. " + q.getOption2());
            System.out.println("3. " + q.getOption3());
            System.out.println("4. " + q.getOption4());

            System.out.print("Student:> ");
            int answer = Integer.parseInt(scanner.nextLine());

            if (answer == q.getAnswerkey()) {
                score++;
            }
        }

        showResult(score);

        System.out.print("System:> Would you like to start again? Press 's' for start or 'q' for quit: ");
        String choice = scanner.nextLine();

        if (choice.equalsIgnoreCase("s")) {
            start(studentName);
        }
    }

    private void showResult(int score) {

        if (score >= 8) {
            System.out.println("Excellent! You have got " + score + " out of 10");
        } else if (score >= 5) {
            System.out.println("Good. You have got " + score + " out of 10");
        } else if (score >= 3) {
            System.out.println("Very poor! You have got " + score + " out of 10");
        } else {
            System.out.println("Very sorry you are failed. You have got " + score + " out of 10");
        }
    }
}

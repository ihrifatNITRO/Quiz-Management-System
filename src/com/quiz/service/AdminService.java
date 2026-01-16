package com.quiz.service;

import com.quiz.model.Question;

import java.util.List;
import java.util.Scanner;

public class AdminService {

    private final QuestionService questionService = new QuestionService();
    private final Scanner scanner = new Scanner(System.in);

    public void start() {

        while (true) {

            System.out.print("System:> Input your question: ");
            String questionText = scanner.nextLine();

            System.out.print("System:> Input option 1: ");
            String op1 = scanner.nextLine();

            System.out.print("System:> Input option 2: ");
            String op2 = scanner.nextLine();

            System.out.print("System:> Input option 3: ");
            String op3 = scanner.nextLine();

            System.out.print("System:> Input option 4: ");
            String op4 = scanner.nextLine();

            System.out.print("System:> What is the answer key? ");
            int answer = Integer.parseInt(scanner.nextLine());

            Question question = new Question(
                    questionText, op1, op2, op3, op4, answer
            );

            List<Question> questions = questionService.loadQuestions();
            questions.add(question);
            questionService.saveQuestions(questions);

            System.out.println("System:> Saved successfully!");

            System.out.print("System:> Do you want to add more questions? (press 's' to start, 'q' to quit): ");
            String choice = scanner.nextLine();

            if (choice.equalsIgnoreCase("q")) {
                break;
            }
        }
    }
}

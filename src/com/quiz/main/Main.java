package com.quiz.main;

import com.quiz.auth.LoginService;
import com.quiz.model.User;
import com.quiz.service.AdminService;
import com.quiz.service.StudentService;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        LoginService loginService = new LoginService();

        System.out.print("System:> Enter your username: ");
        String username = scanner.nextLine();

        System.out.print("System:> Enter password: ");
        String password = scanner.nextLine();

        User user = loginService.authenticate(username, password);

        if (user == null) {
            System.out.println("System:> Invalid username or password.");
            return;
        }

        if (user.getRole().equalsIgnoreCase("admin")) {
            System.out.println("System:> Welcome admin! Please create new questions in the question bank.");
            AdminService adminService = new AdminService();
            adminService.start();
        } else if (user.getRole().equalsIgnoreCase("student")) {
            System.out.println(
                    "System:> Welcome " + user.getUsername() +
                            " to the quiz! We will throw you 10 questions. " +
                            "Each MCQ mark is 1 and no negative marking. " +
                            "Are you ready? Press 's' to start."
            );

            StudentService studentService = new StudentService();
            studentService.start(user.getUsername());
        }
    }
}

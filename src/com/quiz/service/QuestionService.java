package com.quiz.service;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.quiz.model.Question;

import java.io.FileReader;
import java.io.FileWriter;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class QuestionService {

    private final String QUIZ_FILE = "resources/quiz.json";

    public List<Question> loadQuestions() {
        try {
            Gson gson = new Gson();
            Type type = new TypeToken<List<Question>>() {}.getType();
            FileReader reader = new FileReader(QUIZ_FILE);
            return gson.fromJson(reader, type);
        } catch (Exception e) {
            return new ArrayList<>();
        }
    }

    public void saveQuestions(List<Question> questions) {
        try {
            Gson gson = new Gson();
            FileWriter writer = new FileWriter(QUIZ_FILE);
            gson.toJson(questions, writer);
            writer.flush();
            writer.close();
        } catch (Exception e) {
            System.out.println("Failed to save questions.");
        }
    }
}

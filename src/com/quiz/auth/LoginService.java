package com.quiz.auth;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.quiz.model.User;

import java.io.FileReader;
import java.lang.reflect.Type;
import java.util.List;

public class LoginService {

    public User authenticate(String username, String password) {
        try {
            Gson gson = new Gson();

            Type userListType = new TypeToken<List<User>>() {}.getType();
            FileReader reader = new FileReader("resources/users.json");

            List<User> users = gson.fromJson(reader, userListType);

            for (User user : users) {
                if (user.getUsername().equals(username)
                        && user.getPassword().equals(password)) {
                    return user;
                }
            }

        } catch (Exception e) {
            System.out.println("Error reading users.json");
        }

        return null;
    }
}

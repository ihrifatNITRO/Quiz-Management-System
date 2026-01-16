# Quiz Management System 

---

## Project Description

The Quiz Management System is a console-based Java application designed using a role-based approach. The system supports two types of users: Admin and Student. Admin users are responsible for creating and maintaining a question bank of multiple-choice questions (MCQs), while Student users can take quizzes generated from that question bank.

The application uses JSON files for persistent data storage and follows a simple, modular structure to ensure clarity and maintainability.

---

## User Roles and Features

### Admin
- Login using credentials stored in `users.json`
- Add multiple-choice questions (MCQs)
- Each question contains four options and one correct answer key
- Questions are stored persistently in `quiz.json`
- Admin can continue adding questions until choosing to quit
- Minimum requirement: add at least 20 SQA-related questions

### Student
- Login using credentials stored in `users.json`
- Start quiz by pressing `s`
- System randomly selects 10 questions from the question bank
- Each correct answer carries 1 mark
- No negative marking
- Final score and performance message displayed
- Option to restart the quiz or quit

---

## Project Structure

```
src
└── com.quiz
    ├── main
    │   └── Main.java
    ├── auth
    │   └── LoginService.java
    ├── model
    │   ├── User.java
    │   └── Question.java
    └── service
        ├── AdminService.java
        ├── StudentService.java
        └── QuestionService.java

resources
├── users.json
└── quiz.json
```

---

## JSON Files

### users.json

Stores login credentials and roles for admin and student users.

```json
[
  { "username": "admin", "password": "1234", "role": "admin" },
  { "username": "salman", "password": "1234", "role": "student" }
]
```

### quiz.json

Stores all MCQ questions added by the admin.

Example format:

```json
[
  {
    "question": "Which is not part of system testing?",
    "option1": "Regression Testing",
    "option2": "Sanity Testing",
    "option3": "Load Testing",
    "option4": "Unit Testing",
    "answerkey": 4
  }
]
```

---

## Technologies Used

- Java (JDK 8 or higher)
- IntelliJ IDEA Community Edition
- Gson library for JSON parsing
- JSON files for data persistence

---

## How to Run the Project

1. Clone the repository from GitHub
2. Open the project in IntelliJ IDEA Community Edition
3. Add the Gson JAR file to the project libraries
4. Ensure `users.json` and `quiz.json` are inside the `resources` folder
5. Run `Main.java`
6. Login using admin or student credentials

---

## Quiz Rules and Scoring Criteria

- Total Questions: 10
- Marks per Question: 1
- Negative Marking: None

### Result Evaluation

- 8 to 10: Excellent! You have got X out of 10
- 5 to 7: Good. You have got X out of 10
- 3 to 4: Very poor! You have got X out of 10
- 0 to 2: Very sorry you are failed. You have got X out of 10

---

## Demo Video

A recorded video demonstration is included in this repository showing:
- Admin login and adding MCQ questions
- Persistent update of `quiz.json`
- Student login and quiz participation
- Final score and result display

Video Link: https://drive.google.com/file/d/1FQlOLDq7wsRXfgK0O-rT1uxFoVDyDX_m/view?usp=sharing

---

## GitHub Submission Notes

The following folders are excluded using `.gitignore`:
- .idea
- .gradle
- build
- gradle

---


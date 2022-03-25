package com.example.quizapp;

public class Questions {
        private final String[] questions = {"How to pass the data between activities in Android?",
                "On which thread services work in android?",
                "What is breakpoint in android?",
                "What is the package name of HTTP client in android?",
                "What is fragment in android?"};
        private final String[][] options = {
                {"intent","Content Provider","Broadcast Receiver"},
                {"Worker Thread","Main Thread","None of the Above"},
                {"Breaks the development code","Breaks the Execution","Breaks the Application"},
                {"com.json","com.android.json","org.apache.http.client"},
                {"JSON","Piece of Activity","Layout"}};
        private final String[] correctAnswers = {"intent",
                "Main Thread",
                "Breaks the Execution",
                "org.apache.http.client",
                "Piece of Activity"};

        public String getQuestions(int questionNumber) {
                return questions[questionNumber-1];
        }
        public String getOptions(int questionNumber,int optionNumber){
                return options[questionNumber-1][optionNumber-1];
        }
        public String getCorrectAnswer(int questionNumber){
                return correctAnswers[questionNumber-1];
        }
}

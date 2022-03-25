package com.example.quizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {

    TextView txtFinalScore,txtCongratulations;
    Button btnNewQuiz,btnFinish;
    int finalScore,questionNumber;
    String username;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        txtCongratulations = findViewById(R.id.txtCongratulations);
        txtFinalScore = findViewById(R.id.txtFinalScore);
        btnNewQuiz = findViewById(R.id.btnNewQuiz);
        btnFinish = findViewById(R.id.btnFinish);

        Intent intent = getIntent();
        finalScore = intent.getIntExtra("Score",0);
        questionNumber = intent.getIntExtra("questionNumber",0);
        username = intent.getStringExtra("Name");
        txtCongratulations.setText("Congratulations "+username+"!");
        txtFinalScore.setText(finalScore+" / "+questionNumber);

        btnNewQuiz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),MainActivity.class));
            }
        });
        btnFinish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finishAffinity();
                finishAndRemoveTask();
                System.exit(0);
            }
        });
    }
}
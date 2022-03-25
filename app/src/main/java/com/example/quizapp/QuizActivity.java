package com.example.quizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

public class QuizActivity extends AppCompatActivity implements View.OnClickListener {

    final int MAX_QUESTIONS = 5;
    int questionCount = 1,btnSubmitClick = 1, correctQuestionCount = 1;
    String username,selectedOption;
    TextView questionsView;
    TextView textWelcome;
    Button btnOption1,btnOption2,btnOption3,btnSubmit,selectedButton;
    ProgressBar progressBar;
    Questions q = new Questions();

    public void resetButton(){
        btnOption1.setBackgroundColor(getResources().getColor(R.color.purple_200));
        btnOption2.setBackgroundColor(getResources().getColor(R.color.purple_200));
        btnOption3.setBackgroundColor(getResources().getColor(R.color.purple_200));
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);
        progressBar = findViewById(R.id.questionProgressBar);
        progressBar.setMax(MAX_QUESTIONS);
        questionsView = findViewById(R.id.textQuestionsView);
        textWelcome = findViewById(R.id.textWelcome);
        btnOption1 = findViewById(R.id.btnOption1);
        btnOption2 = findViewById(R.id.btnOption2);
        btnOption3 = findViewById(R.id.btnOption3);
        btnSubmit = findViewById(R.id.btnSubmit);

        Intent intent = getIntent();
        username = intent.getStringExtra("Username");
        textWelcome.setText("Welcome "+username+"!");
        btnOption1.setOnClickListener(this);
        btnOption2.setOnClickListener(this);
        btnOption3.setOnClickListener(this);
        btnSubmit.setOnClickListener(this);
        setQuestionsOnActivity(1);
    }
    public Button checkCorrectAnswerButton(int questionNumber){
        if(btnOption1.getText().toString().equals(q.getCorrectAnswer(questionNumber))){
            return btnOption1;
        }
        else if(btnOption2.getText().toString().equals(q.getCorrectAnswer(questionNumber))){
            return btnOption2;
        }
        else {
            return btnOption3;
        }

    }
    public void checkAnswer(int questionNumber){
        if(!selectedOption.equals(q.getCorrectAnswer(questionNumber))){
            selectedButton.setBackgroundColor(getResources().getColor(com.google.android.material.R.color.design_default_color_error));
        }
        checkCorrectAnswerButton(questionNumber).setBackgroundColor(getResources().getColor(R.color.teal_700));
    }
    public void setQuestionsOnActivity(int questionNumber){
        questionsView.setText(q.getQuestions(questionNumber));
        btnOption1.setText(q.getOptions(questionNumber,1));
        btnOption2.setText(q.getOptions(questionNumber,2));
        btnOption3.setText(q.getOptions(questionNumber,3));
    }
    @Override
    public void onClick(View v){
        switch(v.getId()){
            case R.id.btnOption1:
                resetButton();
                btnOption1.setBackgroundColor(getResources().getColor(R.color.purple_700));
                selectedOption = btnOption1.getText().toString();
                selectedButton = btnOption1;
                break;
            case R.id.btnOption2:
                resetButton();
                btnOption2.setBackgroundColor(getResources().getColor(R.color.purple_700));
                selectedOption = btnOption2.getText().toString();
                selectedButton = btnOption2;
                break;
            case R.id.btnOption3:
                resetButton();
                btnOption3.setBackgroundColor(getResources().getColor(R.color.purple_700));
                selectedOption = btnOption2.getText().toString();
                selectedButton = btnOption3;
                break;
            case R.id.btnSubmit:
                if(btnSubmitClick == 1){
                    checkAnswer(questionCount);
                    if(selectedOption.equals(q.getCorrectAnswer(questionCount))){
                        correctQuestionCount++;
                    }
                    questionCount++;
                    progressBar.setProgress(questionCount-1);
                    btnSubmit.setText("Next Question");
                    btnSubmitClick++;
                }
                else if(btnSubmitClick == 2){
                    resetButton();
                    btnSubmit.setText("Submit");
                    if(questionCount<=MAX_QUESTIONS){
                        setQuestionsOnActivity(questionCount);
                    }
                    else {
                        Intent intent = new Intent(getBaseContext(), ResultActivity.class);
                        intent.putExtra("Score", correctQuestionCount);
                        intent.putExtra("questionNumber", MAX_QUESTIONS);
                        intent.putExtra("Name", username);
                        startActivity(intent);
                        //Toast.makeText(this,"Else part",Toast.LENGTH_SHORT).show();
                    }
                    btnSubmitClick=1;
                }break;
        }
    }
}
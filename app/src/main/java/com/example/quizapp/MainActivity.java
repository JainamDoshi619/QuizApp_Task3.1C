package com.example.quizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.jar.Attributes;

public class MainActivity extends AppCompatActivity {

    TextView userName;
    Button startButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        userName = findViewById(R.id.textName);
        startButton = findViewById(R.id.buttonStart);
        userName.setText(getIntent().getStringExtra("Name"));
        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(userName.getText().toString().isEmpty())
                    Toast.makeText(MainActivity.this, "Enter your name first!", Toast.LENGTH_SHORT).show();
                else {
                    Intent intent =new Intent(getApplicationContext(),QuizActivity.class);
                    intent.putExtra("Username",userName.getText().toString());
                    startActivity(intent);
                }
            }
        });
    }
}
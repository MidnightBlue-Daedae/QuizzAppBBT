package com.example.quizzappbbt;

import static android.view.View.GONE;
import static android.view.View.VISIBLE;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    TextView question;
    int questionNum, numCorrect;
    Button True, False, restart, showScore;
    boolean answer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        questionNum = 0;
        numCorrect = 0;

        question = findViewById(R.id.question);
        True = findViewById(R.id.True);
        False = findViewById(R.id.False);
        restart = findViewById(R.id.restart);
        showScore = findViewById(R.id.showScore);
        showScore.setVisibility(GONE);

        True.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (questionNum < 5) {
                    Questions questionA = new Questions(questionNum + 1);
                    answer = questionA.returnAnswer();
                    if (answer) {
                        showLargeToast("Great job, you got it correct!");
                        numCorrect++;
                    } else {
                        showLargeToast("Oh no, it's incorrect");
                    }
                    nextQuestion();
                } else {
                    question.setText("You have now completed the quiz.");
                    showScore.setVisibility(VISIBLE);

                }
            }
        });

        False.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (questionNum < 5) {
                    Questions questionB = new Questions(questionNum + 1);
                    answer = questionB.returnAnswer();
                    if (!answer) {
                        showLargeToast("Great job, you got it correct!");
                        numCorrect++;
                    } else {
                        showLargeToast("Oh no, it's incorrect");
                    }
                    nextQuestion();
                } else {
                    question.setText("You have now completed the quiz.");
                    showScore.setVisibility(VISIBLE);
                }
            }
        });

        showScore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                intent.putExtra("Score",numCorrect);
                startActivity(intent);
                questionNum = 0;
                numCorrect = 0;
                showScore.setVisibility(GONE);
                question.setText(Questions.nextQuestion(0));
            }
        });

        restart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                questionNum = 0;
                numCorrect = 0;
                showScore.setVisibility(GONE);
                question.setText(Questions.nextQuestion(0));
            }
        });
    }


    private void nextQuestion() {
        questionNum++;
        if (questionNum < 5) {
            question.setText(Questions.nextQuestion(questionNum));
        } else {
            question.setText("You have now completed the quiz.");
            showScore.setVisibility(VISIBLE);

        }
    }

    private void showLargeToast(String message) {
        Toast.makeText(MainActivity.this, message, Toast.LENGTH_SHORT).show();
    }
}
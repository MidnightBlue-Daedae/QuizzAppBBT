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

public class ShowQuestions extends AppCompatActivity {
    TextView question;
    int questionNum;
    double numCorrect;
    Button True, False, restart, showScore, Hint;
    boolean answer, bonusDone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.showquestions);

        questionNum = 0;
        numCorrect = 0.0;

        question = findViewById(R.id.question);
        True = findViewById(R.id.True);
        False = findViewById(R.id.False);
        restart = findViewById(R.id.restart);
        showScore = findViewById(R.id.showScore);
        showScore.setVisibility(GONE);
        Hint = findViewById(R.id.hint);
        bonusDone = getIntent().getBooleanExtra("BONUS_DONE", false);

        True.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (questionNum < 5) {
                    Questions questionA = new Questions(questionNum);
                    answer = questionA.returnAnswer();
                    if (answer) {
                        showLargeToast(String.valueOf(R.string.correct));
                        numCorrect++;
                    } else {
                        showLargeToast(String.valueOf(R.string.incorrect));
                    }
                    nextQuestion();
                } else {
                    question.setText(String.valueOf(R.string.complete));
                    showScore.setVisibility(VISIBLE);

                }
            }
        });

        False.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (questionNum < 5) {
                    Questions questionB = new Questions(questionNum);
                    answer = questionB.returnAnswer();
                    if (!answer) {
                        showLargeToast(String.valueOf(R.string.correct));
                        numCorrect++;
                    } else {
                        showLargeToast(String.valueOf(R.string.incorrect));
                    }
                    nextQuestion();
                } else {
                    question.setText(String.valueOf(R.string.complete));
                    showScore.setVisibility(VISIBLE);
                }
            }
        });

        showScore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ShowQuestions.this, SecondActivity.class);
                intent.putExtra("Score", numCorrect);
                intent.putExtra("Complete", bonusDone);
                startActivity(intent);
                finish();
                questionNum = 0;
                showScore.setVisibility(GONE);
                numCorrect = 0.0;
                question.setText(Questions.nextQuestion(0));
            }
        });

        restart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                questionNum = 0;
                numCorrect = 0;
                showScore.setVisibility(GONE);
                Hint.setVisibility(VISIBLE);
                question.setText(Questions.nextQuestion(0));
            }
        });

        Hint.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ShowQuestions.this, Hint.class);
                intent.putExtra("QUESTION_NUM", questionNum);
                startActivity(intent);
                numCorrect -= .5;

            }
        });
    }


    private void nextQuestion() {
        questionNum++;
        if (questionNum < 5) {
            question.setText(Questions.nextQuestion(questionNum));
        } else {
            question.setText(String.valueOf(R.string.complete));
            showScore.setVisibility(VISIBLE);

        }
    }

    private void showLargeToast(String message) {
        Toast.makeText(ShowQuestions.this, message, Toast.LENGTH_SHORT).show();
    }
}

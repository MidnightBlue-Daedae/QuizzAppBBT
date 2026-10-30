package com.example.quizzappbbt;

import static android.view.View.VISIBLE;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class bonus extends AppCompatActivity {

    TextView text;
    Button True, False, newScore;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bonus);

        text = findViewById(R.id.text);
        True = findViewById(R.id.True);
        False = findViewById(R.id.False);
        newScore = findViewById(R.id.newScore);
        final double[] prevScore = {getIntent().getDoubleExtra("score", 0.0)};


        True.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                text.setText("Uh Oh, you got it wrong. Your score will now be decreased by 2 points.");
                prevScore[0] -= 2;
                newScore.setVisibility(VISIBLE);

            }
        });

        False.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                text.setText("Congrats! 2 points have just been added to your score.");
                prevScore[0] += 2;
                newScore.setVisibility(VISIBLE);
            }
        });
        newScore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(bonus.this, SecondActivity.class);
                intent.putExtra("Score", prevScore[0]);
                intent.putExtra("Complete", true);
                startActivity(intent);
                finish();
            }
        });
    }


}

package com.example.quizzappbbt;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second); // Links to the XML layout

        int score = getIntent().getIntExtra("Score", 0);

        TextView resultText = findViewById(R.id.resultText);
        double percent = (score / 5.0) * 100;
        resultText.setText("Your final score is: " + score + "/5 or " + (int)percent +"%");

        Button btnBack = findViewById(R.id.btnBackToStart);

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}



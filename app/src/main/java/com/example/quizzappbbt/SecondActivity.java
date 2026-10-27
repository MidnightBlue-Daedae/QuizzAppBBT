package com.example.quizzappbbt;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {

    Button email;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        int score = getIntent().getIntExtra("Score", 0);
        int totalQ = 5;
        email = findViewById(R.id.email);

        email.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String[] email = new String[]{"daeyonarichardson@gmail.com"};
                String subject = "Quiz Score Results";
                String body = "I received a score of " + score + " out of " + totalQ + ".";
                Intent emailIntent = new Intent(Intent.ACTION_SENDTO);
                emailIntent.setData(Uri.parse("mailto:"));
                emailIntent.putExtra(Intent.EXTRA_EMAIL,email);
                emailIntent.putExtra(Intent.EXTRA_SUBJECT,subject);
                emailIntent.putExtra(Intent.EXTRA_TEXT,body);

                if(emailIntent.resolveActivity(getPackageManager())!=null) {
                                 startActivity(emailIntent);
                             }
                         }
        });
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



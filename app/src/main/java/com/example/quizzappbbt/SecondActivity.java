package com.example.quizzappbbt;

import static android.view.View.GONE;
import static android.view.View.VISIBLE;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Space;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {

    Button email, yes, no, home, btnBack;
    TextView bonus;
    Space btnSpace;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        TextView resultText = findViewById(R.id.resultText);
        btnBack = findViewById(R.id.btnBackToStart);
        bonus = findViewById(R.id.bonus);
        btnSpace = findViewById(R.id.btnSpace);
        home = findViewById(R.id.home);
        yes = findViewById(R.id.yes);
        no = findViewById(R.id.no);

        double score = getIntent().getDoubleExtra("Score", 0);
        double totalQ = 5.0;
        email = findViewById(R.id.email);
        boolean bonusCompleted = getIntent().getBooleanExtra("Complete", false);
        if (bonusCompleted) {
            yes.setVisibility(GONE);
            no.setVisibility(GONE);
            bonus.setVisibility(GONE);
            btnSpace.setVisibility(GONE);

            email.setVisibility(VISIBLE);
            resultText.setVisibility(VISIBLE);
            btnBack.setVisibility(VISIBLE);
        }

        email.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String[] email = new String[]{"daeyonarichardson@gmail.com"};
                String subject = "Quiz Score Results";
                double perScore = score / 5.0;
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
        double percent = (score / 5.0) * 100;
        resultText.setText(R.string.result_text + score + "/5" + R.string.or + percent);

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SecondActivity.this, ShowQuestions.class);
                intent.putExtra("BONUS_DONE", bonusCompleted);
                startActivity(intent);
                finish();
            }
        });


        yes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent bonusA = new Intent(SecondActivity.this, bonus.class);
                bonusA.putExtra("score", score);
                startActivity(bonusA);

            }
        });

        no.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                email.setVisibility(VISIBLE);
                yes.setVisibility(GONE);
                no.setVisibility(GONE);
                bonus.setVisibility(GONE);
                btnSpace.setVisibility(GONE);
                resultText.setVisibility(VISIBLE);
                btnBack.setVisibility(VISIBLE);
                home.setVisibility(VISIBLE);

            }
        });
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent home = new Intent(SecondActivity.this, MainActivity.class);
                startActivity(home);
                finish();
            }
        });
    }
}



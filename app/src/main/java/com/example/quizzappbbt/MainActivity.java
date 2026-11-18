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
import androidx.appcompat.app.AppCompatDelegate;
import androidx.core.os.LocaleListCompat;

public class MainActivity extends AppCompatActivity {
    Button start;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        start = findViewById(R.id.start);

        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ShowQuestions.class);
                startActivity(intent);
            }
        });
        Button btnLanguage = findViewById(R.id.btnLanguage);

        btnLanguage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Check the currently active app language
                LocaleListCompat currentLocales = AppCompatDelegate.getApplicationLocales();
                String currentLang = currentLocales.toLanguageTags();

                // Toggle between Thai ("Th") and English ("en")
                LocaleListCompat newLocale;
                if (currentLang.startsWith("th")) {
                    newLocale = LocaleListCompat.forLanguageTags("en");
                } else {
                    newLocale = LocaleListCompat.forLanguageTags("th");
                }

                // Apply the new language across the entire app
                AppCompatDelegate.setApplicationLocales(newLocale);
            }
        });


    }
}
package com.example.quizzappbbt;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Hint extends AppCompatActivity {

    int[] hints = new int[] {
            R.string.hint_1,
            R.string.hint_2,
            R.string.hint_3,
            R.string.hint_4,
            R.string.hint_5
    };

    TextView hintShow, hintNum;
    Button back;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.hint);

        hintShow = findViewById(R.id.hint);
        hintNum = findViewById(R.id.numHint);
        back = findViewById(R.id.back);

        int qNum = getIntent().getIntExtra("QUESTION_NUM", 0);
        if (qNum >= 0 && qNum < hints.length) {
            hintNum.setText((qNum + 1) + ":");
            hintShow.setText(hints[qNum]);
        } else {
            hintShow.setText(R.string.no_hint);
        }

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
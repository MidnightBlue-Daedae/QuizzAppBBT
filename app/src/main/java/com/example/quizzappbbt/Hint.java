package com.example.quizzappbbt;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Hint extends AppCompatActivity {

    String[] hints = new String[]
            {"Think back to classic Sheldon moments like when he hid in a ball pit or pulled a practical joke on Leonard—is that the famous word he yelled every time?",
            "The show ran for over a decade and tied Two and a Half Men for one of the longest-running multi-camera sitcoms in TV history—did it hit a dozen seasons before wrapping up in 2019?",
            "If you listen closely during the episodes, you hear real laughter rather than a standard canned laugh track—how do traditional sitcoms recorded on a stage in Burbank usually capture that laughter?",
                    "The guys frequently mention their jobs, wear university t-shirts, and work in Pasadena, California—is that top science and engineering institute where their offices and cafeteria are located?",
                    "While the creators consulted real physicists (like Dr. David Saltzberg) to make sure the whiteboards and science jokes were accurate, were the characters themselves based on a specific real team, or were they created by sitcom writers Chuck Lorre and Bill Prady?"
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
            hintShow.setText("No hint available for this question.");
        }



        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }



}

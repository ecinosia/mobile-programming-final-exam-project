package com.example.quiz_app.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import com.example.quiz_app.R;

public class HomeScreenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);

        final Button rulesButton = findViewById(R.id.rulesBtn);
        final Button scoresButton = findViewById(R.id.scoresBtn);
        final Button startButton = findViewById(R.id.startBtn);

        rulesButton.setOnClickListener(view -> {
            Intent rulesActivityIntent = new Intent(
                    this, RulesActivity.class
            );
            startActivity(rulesActivityIntent);
        });

        scoresButton.setOnClickListener(view -> {
            Intent scoresActivityIntent = new Intent(
                    this, ScoreActivity.class
            );
            startActivity(scoresActivityIntent);
        });

        startButton.setOnClickListener(view -> {
            Intent startActivityIntent = new Intent(
                    this, CategoryActivity.class
            );
            startActivity(startActivityIntent);
        });
    }
}
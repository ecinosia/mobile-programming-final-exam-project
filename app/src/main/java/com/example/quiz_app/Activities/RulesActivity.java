package com.example.quiz_app.Activities;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.quiz_app.R;
import com.example.quiz_app.R.id;

public class RulesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rules);

        final Button aboutQuiz = findViewById(id.aboutQuizBtnRules);
        final Button quizRules = findViewById(id.quizRulesBtnRules);
        final Button goBackHome = findViewById(id.goBackHomeBtnRules);

        aboutQuiz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog alertDialog = new AlertDialog.Builder(RulesActivity.this).create();
                alertDialog.setTitle("About Quiz App");
                alertDialog.setMessage("This app has 10 different categories and some of them has images and audios. \n\nYou can see your score right after you completed the quiz. \n\nThis app has made by Tahir Furkan SARIDIKEN.");
                alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                            }
                        });
                alertDialog.show();
            }
        });

        quizRules.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog alertDialog = new AlertDialog.Builder(RulesActivity.this).create();
                alertDialog.setTitle("Quiz Rules");
                alertDialog.setMessage("1- You will have 30 seconds for every category. If you can not answer the question in 30 seconds you need to start again. \n\n2- There will be audio based questions. You need to increase your phone's volume to hear the audio properly. \n\n3- Once you completed the quiz, you can see your score.");
                alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                            }
                        });
                alertDialog.show();
            }
        });

        goBackHome.setOnClickListener(view -> {
            Intent goBackHomeIntent = new Intent(
                    getApplicationContext(),MainActivity.class
            );
            startActivity(goBackHomeIntent);
        });


    }
}
package com.example.quiz_app.Activities.Categories;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.quiz_app.Activities.CategoryActivity;
import com.example.quiz_app.Activities.ScoreActivity;
import com.example.quiz_app.Classes.QuestionAnswer;
import com.example.quiz_app.R;

public class artCateActivity extends AppCompatActivity implements View.OnClickListener {
    TextView artQuestionTV;
    Button artOpt1,artOpt2,artOpt3,artOpt4;
    Button artSubmitButton;
    final int artQuestionIndex = 1;

    String selectedAnswer = "";
    int score=0;
    private int artTimerSeconds = 30;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_art_cate);

        final ImageButton artCateBackButtonAppBar = findViewById(R.id.artAppBarBackButton);
        final TextView artCateTimer = findViewById(R.id.artCateTimer);

        artQuestionTV = findViewById(R.id.artQuestion);
        artOpt1 = findViewById(R.id.artOpt1);
        artOpt2 = findViewById(R.id.artOpt2);
        artOpt3 = findViewById(R.id.artOpt3);
        artOpt4 = findViewById(R.id.artOpt4);
        artSubmitButton = findViewById(R.id.artSubmitButton);

        artOpt1.setOnClickListener(this);
        artOpt2.setOnClickListener(this);
        artOpt3.setOnClickListener(this);
        artOpt4.setOnClickListener(this);
        artSubmitButton.setOnClickListener(this);

        final Button artFinishButton = findViewById(R.id.artCatFinishQuizButton);

        artQuestionTV.setText(QuestionAnswer.question[artQuestionIndex]);
        artOpt1.setText(QuestionAnswer.choices[artQuestionIndex][0]);
        artOpt2.setText(QuestionAnswer.choices[artQuestionIndex][1]);
        artOpt3.setText(QuestionAnswer.choices[artQuestionIndex][2]);
        artOpt4.setText(QuestionAnswer.choices[artQuestionIndex][3]);

        Intent artCategIntent = getIntent();
        String categoryNameart = artCategIntent.getStringExtra("Art Category Name");
        TextView artCategoryTV = (TextView) findViewById(R.id.artAppBarTV);
        artCategoryTV.setText(categoryNameart);

        artCateBackButtonAppBar.setOnClickListener(view -> {
            Intent artAppBarBackButtonIntent = new Intent(
                    this, CategoryActivity.class
            );
            startActivity(artAppBarBackButtonIntent);
        });

        artFinishButton.setOnClickListener(view ->{
            Intent artFinishButtonIntent = new Intent(
                    this, ScoreActivity.class
            );
            startActivity(artFinishButtonIntent);
        });

        new CountDownTimer(30000, 1000) {
            public void onTick(long millisUntilFinished) {
                artCateTimer.setText(String.valueOf(artTimerSeconds));
                artTimerSeconds--;
            }

            @Override
            public void onFinish() {
                AlertDialog alertDialog = new AlertDialog.Builder(artCateActivity.this).create();
                alertDialog.setMessage("Time Has Done!");
                alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Intent artTimerDoneAlertIntent = new Intent(
                                        artCateActivity.this, CategoryActivity.class
                                );
                                startActivity(artTimerDoneAlertIntent);
                                dialog.dismiss();
                            }
                        });
                alertDialog.show();
            }
        }.start();

    }

    @Override
    public void onClick(View view) {
        Button clickedButton = (Button) view;
        if(clickedButton.getId()==R.id.artSubmitButton){
            if(selectedAnswer.equals(QuestionAnswer.correctAnswers[artQuestionIndex])){
                score++;
            }
            Intent artSubmitIntent = new Intent(
                    this, scienceCateActivity.class
            );
            startActivity(artSubmitIntent);
        }else{
            selectedAnswer  = clickedButton.getText().toString();
            QuestionAnswer.artSelectedAnswers = selectedAnswer;
            clickedButton.setBackgroundColor(Color.MAGENTA);
        }
    }
}
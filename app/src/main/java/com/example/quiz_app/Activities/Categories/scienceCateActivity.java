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

public class scienceCateActivity extends AppCompatActivity implements View.OnClickListener {

    TextView scienceQuestionTV;
    Button scienceOpt1,scienceOpt2,scienceOpt3,scienceOpt4;
    Button scienceSubmitBtn;
    final int scienceQuestionIndex = 2;
    private int scienceTimerSeconds = 30;

    String selectedAnswer = "";

    int score=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_science_cate);

        final ImageButton scienceCateBackButtonAppBar = findViewById(R.id.scienceAppBarBackButton);
        final TextView scienceCateTimer = findViewById(R.id.scienceCateTimer);
        final Button scienceFinishButton = findViewById(R.id.scienceCatFinishQuizButton);

        scienceQuestionTV = findViewById(R.id.scienceQuestion);
        scienceOpt1 = findViewById(R.id.scienceOpt1);
        scienceOpt2 = findViewById(R.id.scienceOpt2);
        scienceOpt3 = findViewById(R.id.scienceOpt3);
        scienceOpt4 = findViewById(R.id.scienceOpt4);
        scienceSubmitBtn = findViewById(R.id.scienceSubmitButton);

        scienceOpt1.setOnClickListener(this);
        scienceOpt2.setOnClickListener(this);
        scienceOpt3.setOnClickListener(this);
        scienceOpt4.setOnClickListener(this);
        scienceSubmitBtn.setOnClickListener(this);

        scienceQuestionTV.setText(QuestionAnswer.question[scienceQuestionIndex]);
        scienceOpt1.setText(QuestionAnswer.choices[scienceQuestionIndex][0]);
        scienceOpt2.setText(QuestionAnswer.choices[scienceQuestionIndex][1]);
        scienceOpt3.setText(QuestionAnswer.choices[scienceQuestionIndex][2]);
        scienceOpt4.setText(QuestionAnswer.choices[scienceQuestionIndex][3]);

        Intent scienceCategIntent = getIntent();

        String categoryNameScience = scienceCategIntent.getStringExtra("Science Category Name");

        TextView scienceCategoryTV = (TextView) findViewById(R.id.scienceAppBarTV);

        scienceCategoryTV.setText(categoryNameScience);

        scienceCateBackButtonAppBar.setOnClickListener(view -> {
            Intent scienceAppBarBackButtonIntent = new Intent(
                    this, CategoryActivity.class
            );
            startActivity(scienceAppBarBackButtonIntent);
        });

        scienceFinishButton.setOnClickListener(view ->{
            Intent scienceFinishButtonIntent = new Intent(
                    this, ScoreActivity.class
            );
            startActivity(scienceFinishButtonIntent);
        });

        new CountDownTimer(30000, 1000) {
            public void onTick(long millisUntilFinished) {
                scienceCateTimer.setText(String.valueOf(scienceTimerSeconds));
                scienceTimerSeconds--;
            }

            @Override
            public void onFinish() {
                AlertDialog alertDialog = new AlertDialog.Builder(scienceCateActivity.this).create();
                alertDialog.setMessage("Time Has Done!");
                alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Intent scienceTimerDoneAlertIntent = new Intent(
                                        scienceCateActivity.this, CategoryActivity.class
                                );
                                startActivity(scienceTimerDoneAlertIntent);
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
        if(clickedButton.getId()==R.id.scienceSubmitButton){
            if(selectedAnswer.equals(QuestionAnswer.correctAnswers[scienceQuestionIndex])){
                score++;
            }
            Intent scienceSubmitIntent = new Intent(
                    this, automobileCateActivity.class
            );
            startActivity(scienceSubmitIntent);
        }else{
            selectedAnswer  = clickedButton.getText().toString();
            QuestionAnswer.scienceSelectedAnswers = selectedAnswer;
            clickedButton.setBackgroundColor(Color.MAGENTA);
        }

    }
}
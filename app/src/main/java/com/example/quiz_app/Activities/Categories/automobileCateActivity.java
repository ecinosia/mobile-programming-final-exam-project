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

public class automobileCateActivity extends AppCompatActivity implements View.OnClickListener {

    TextView automobileQuestionTV;
    Button automobileOpt1,automobileOpt2,automobileOpt3,automobileOpt4;
    Button automobileSubmitBtn;
    final int automobileQuestionIndex = 3;
    private int automobileTimerSeconds = 30;

    String selectedAnswer = "";

    int score=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_automobile_cate);

        final ImageButton automobileCateBackButtonAppBar = findViewById(R.id.automobileAppBarBackButton);
        final TextView automobileCateTimer = findViewById(R.id.automobileCateTimer);
        final Button automobileFinishButton = findViewById(R.id.automobileCatFinishQuizButton);

        automobileQuestionTV = findViewById(R.id.automobileQuestion);
        automobileOpt1 = findViewById(R.id.automobileOpt1);
        automobileOpt2 = findViewById(R.id.automobileOpt2);
        automobileOpt3 = findViewById(R.id.automobileOpt3);
        automobileOpt4 = findViewById(R.id.automobileOpt4);
        automobileSubmitBtn = findViewById(R.id.automobileSubmitButton);

        automobileOpt1.setOnClickListener(this);
        automobileOpt2.setOnClickListener(this);
        automobileOpt3.setOnClickListener(this);
        automobileOpt4.setOnClickListener(this);
        automobileSubmitBtn.setOnClickListener(this);

        automobileQuestionTV.setText(QuestionAnswer.question[automobileQuestionIndex]);
        automobileOpt1.setText(QuestionAnswer.choices[automobileQuestionIndex][0]);
        automobileOpt2.setText(QuestionAnswer.choices[automobileQuestionIndex][1]);
        automobileOpt3.setText(QuestionAnswer.choices[automobileQuestionIndex][2]);
        automobileOpt4.setText(QuestionAnswer.choices[automobileQuestionIndex][3]);

        Intent automobileCategIntent = getIntent();

        String categoryNameautomobile = automobileCategIntent.getStringExtra("Automobile Category Name");

        TextView automobileCategoryTV = (TextView) findViewById(R.id.automobileAppBarTV);

        automobileCategoryTV.setText(categoryNameautomobile);

        automobileCateBackButtonAppBar.setOnClickListener(view -> {
            Intent automobileAppBarBackButtonIntent = new Intent(
                    this, CategoryActivity.class
            );
            startActivity(automobileAppBarBackButtonIntent);
        });

        automobileFinishButton.setOnClickListener(view ->{
            Intent automobileFinishButtonIntent = new Intent(
                    this, ScoreActivity.class
            );
            startActivity(automobileFinishButtonIntent);
        });

        new CountDownTimer(30000, 1000) {
            public void onTick(long millisUntilFinished) {
                automobileCateTimer.setText(String.valueOf(automobileTimerSeconds));
                automobileTimerSeconds--;
            }

            @Override
            public void onFinish() {
                AlertDialog alertDialog = new AlertDialog.Builder(automobileCateActivity.this).create();
                alertDialog.setMessage("Time Has Done!");
                alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Intent automobileTimerDoneAlertIntent = new Intent(
                                        automobileCateActivity.this, CategoryActivity.class
                                );
                                startActivity(automobileTimerDoneAlertIntent);
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
        if(clickedButton.getId()==R.id.automobileSubmitButton){
            if(selectedAnswer.equals(QuestionAnswer.correctAnswers[automobileQuestionIndex])){
                score++;
            }
            Intent automobileSubmitIntent = new Intent(
                    this, technologyCateActivity.class
            );
            startActivity(automobileSubmitIntent);
        }else{
            selectedAnswer  = clickedButton.getText().toString();
            QuestionAnswer.automobileSelectedAnswers = selectedAnswer;
            clickedButton.setBackgroundColor(Color.MAGENTA);

        }
    }
}
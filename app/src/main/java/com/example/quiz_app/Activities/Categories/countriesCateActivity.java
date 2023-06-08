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

public class countriesCateActivity extends AppCompatActivity implements View.OnClickListener {

    TextView countriesQuestionTV;
    Button countriesOpt1,countriesOpt2,countriesOpt3,countriesOpt4;
    Button countriesSubmitBtn;
    final int countriesQuestionIndex = 7;
    private int countriesTimerSeconds = 30;

    String selectedAnswer = "";

    int score=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_countries_cate);


        final ImageButton countriesCateBackButtonAppBar = findViewById(R.id.countriesAppBarBackButton);
        final TextView countriesCateTimer = findViewById(R.id.countriesCateTimer);
        final Button countriesFinishButton = findViewById(R.id.countriesCatFinishQuizButton);

        countriesQuestionTV = findViewById(R.id.countriesQuestion);
        countriesOpt1 = findViewById(R.id.countriesOpt1);
        countriesOpt2 = findViewById(R.id.countriesOpt2);
        countriesOpt3 = findViewById(R.id.countriesOpt3);
        countriesOpt4 = findViewById(R.id.countriesOpt4);
        countriesSubmitBtn = findViewById(R.id.countriesSubmitButton);

        countriesOpt1.setOnClickListener(this);
        countriesOpt2.setOnClickListener(this);
        countriesOpt3.setOnClickListener(this);
        countriesOpt4.setOnClickListener(this);
        countriesSubmitBtn.setOnClickListener(this);

        countriesQuestionTV.setText(QuestionAnswer.question[countriesQuestionIndex]);
        countriesOpt1.setText(QuestionAnswer.choices[countriesQuestionIndex][0]);
        countriesOpt2.setText(QuestionAnswer.choices[countriesQuestionIndex][1]);
        countriesOpt3.setText(QuestionAnswer.choices[countriesQuestionIndex][2]);
        countriesOpt4.setText(QuestionAnswer.choices[countriesQuestionIndex][3]);

        Intent countriesCategIntent = getIntent();

        String categoryNamecountries = countriesCategIntent.getStringExtra("Countries Category Name");

        TextView countriesCategoryTV = (TextView) findViewById(R.id.countriesAppBarTV);

        countriesCategoryTV.setText(categoryNamecountries);

        countriesCateBackButtonAppBar.setOnClickListener(view -> {
            Intent countriesAppBarBackButtonIntent = new Intent(
                    this, CategoryActivity.class
            );
            startActivity(countriesAppBarBackButtonIntent);
        });

        countriesFinishButton.setOnClickListener(view ->{
            Intent countriesFinishButtonIntent = new Intent(
                    this, ScoreActivity.class
            );
            startActivity(countriesFinishButtonIntent);
        });

        new CountDownTimer(30000, 1000) {
            public void onTick(long millisUntilFinished) {
                countriesCateTimer.setText(String.valueOf(countriesTimerSeconds));
                countriesTimerSeconds--;
            }

            @Override
            public void onFinish() {
                AlertDialog alertDialog = new AlertDialog.Builder(countriesCateActivity.this).create();
                alertDialog.setMessage("Time Has Done!");
                alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Intent countriesTimerDoneAlertIntent = new Intent(
                                        countriesCateActivity.this, CategoryActivity.class
                                );
                                startActivity(countriesTimerDoneAlertIntent);
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
        if(clickedButton.getId()==R.id.countriesSubmitButton){
            if(selectedAnswer.equals(QuestionAnswer.correctAnswers[countriesQuestionIndex])){
                score++;
            }
            Intent countriesSubmitIntent = new Intent(
                    this, historyCateActivity.class
            );
            startActivity(countriesSubmitIntent);
        }else{
            selectedAnswer  = clickedButton.getText().toString();
            QuestionAnswer.countriesSelectedAnswers = selectedAnswer;
            clickedButton.setBackgroundColor(Color.MAGENTA);

        }
    }
}
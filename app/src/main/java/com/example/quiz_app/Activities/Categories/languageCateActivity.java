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

public class languageCateActivity extends AppCompatActivity implements View.OnClickListener {

    TextView languageQuestionTV;
    Button languageOpt1,languageOpt2,languageOpt3,languageOpt4;
    Button languageSubmitBtn;
    final int languageQuestionIndex = 9;
    private int languageTimerSeconds = 30;

    String selectedAnswer = "";

    int score=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_language_cate);

        final ImageButton languageCateBackButtonAppBar = findViewById(R.id.languageAppBarBackButton);
        final TextView languageCateTimer = findViewById(R.id.languageCateTimer);
        final Button languageFinishButton = findViewById(R.id.languageCatFinishQuizButton);

        languageQuestionTV = findViewById(R.id.languageQuestion);
        languageOpt1 = findViewById(R.id.languageOpt1);
        languageOpt2 = findViewById(R.id.languageOpt2);
        languageOpt3 = findViewById(R.id.languageOpt3);
        languageOpt4 = findViewById(R.id.languageOpt4);
        languageSubmitBtn = findViewById(R.id.languageSubmitButton);

        languageOpt1.setOnClickListener(this);
        languageOpt2.setOnClickListener(this);
        languageOpt3.setOnClickListener(this);
        languageOpt4.setOnClickListener(this);
        languageSubmitBtn.setOnClickListener(this);

        languageQuestionTV.setText(QuestionAnswer.question[languageQuestionIndex]);
        languageOpt1.setText(QuestionAnswer.choices[languageQuestionIndex][0]);
        languageOpt2.setText(QuestionAnswer.choices[languageQuestionIndex][1]);
        languageOpt3.setText(QuestionAnswer.choices[languageQuestionIndex][2]);
        languageOpt4.setText(QuestionAnswer.choices[languageQuestionIndex][3]);

        Intent languageCategIntent = getIntent();

        String categoryNamelanguage = languageCategIntent.getStringExtra("Language Category Name");

        TextView languageCategoryTV = (TextView) findViewById(R.id.languageAppBarTV);

        languageCategoryTV.setText(categoryNamelanguage);

        languageCateBackButtonAppBar.setOnClickListener(view -> {
            Intent languageAppBarBackButtonIntent = new Intent(
                    this, CategoryActivity.class
            );
            startActivity(languageAppBarBackButtonIntent);
        });

        languageFinishButton.setOnClickListener(view ->{
            Intent languageFinishButtonIntent = new Intent(
                    this, ScoreActivity.class
            );
            startActivity(languageFinishButtonIntent);
        });

        new CountDownTimer(30000, 1000) {
            public void onTick(long millisUntilFinished) {
                languageCateTimer.setText(String.valueOf(languageTimerSeconds));
                languageTimerSeconds--;
            }

            @Override
            public void onFinish() {
                AlertDialog alertDialog = new AlertDialog.Builder(languageCateActivity.this).create();
                alertDialog.setMessage("Time Has Done!");
                alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Intent languageTimerDoneAlertIntent = new Intent(
                                        languageCateActivity.this, CategoryActivity.class
                                );
                                startActivity(languageTimerDoneAlertIntent);
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
        if(clickedButton.getId()==R.id.languageSubmitButton){
            if(selectedAnswer.equals(QuestionAnswer.correctAnswers[languageQuestionIndex])){
                score++;
            }
            Intent languageSubmitIntent = new Intent(
                    this, ScoreActivity.class
            );
            startActivity(languageSubmitIntent);
        }else{
            selectedAnswer  = clickedButton.getText().toString();
            QuestionAnswer.languageSelectedAnswers = selectedAnswer;
            clickedButton.setBackgroundColor(Color.MAGENTA);
        }
    }
}
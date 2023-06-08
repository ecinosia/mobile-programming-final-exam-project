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

public class financeCateActivity extends AppCompatActivity implements View.OnClickListener {

    TextView financeQuestionTV;
    Button financeOpt1,financeOpt2,financeOpt3,financeOpt4;
    Button financeSubmitBtn;
    final int financeQuestionIndex = 5;
    private int financeTimerSeconds = 30;

    String selectedAnswer = "";

    int score=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_finance_cate);


        final ImageButton financeCateBackButtonAppBar = findViewById(R.id.financeAppBarBackButton);
        final TextView financeCateTimer = findViewById(R.id.financeCateTimer);
        final Button financeFinishButton = findViewById(R.id.financeCatFinishQuizButton);

        financeQuestionTV = findViewById(R.id.financeQuestion);
        financeOpt1 = findViewById(R.id.financeOpt1);
        financeOpt2 = findViewById(R.id.financeOpt2);
        financeOpt3 = findViewById(R.id.financeOpt3);
        financeOpt4 = findViewById(R.id.financeOpt4);
        financeSubmitBtn = findViewById(R.id.financeSubmitButton);

        financeOpt1.setOnClickListener(this);
        financeOpt2.setOnClickListener(this);
        financeOpt3.setOnClickListener(this);
        financeOpt4.setOnClickListener(this);
        financeSubmitBtn.setOnClickListener(this);

        financeQuestionTV.setText(QuestionAnswer.question[financeQuestionIndex]);
        financeOpt1.setText(QuestionAnswer.choices[financeQuestionIndex][0]);
        financeOpt2.setText(QuestionAnswer.choices[financeQuestionIndex][1]);
        financeOpt3.setText(QuestionAnswer.choices[financeQuestionIndex][2]);
        financeOpt4.setText(QuestionAnswer.choices[financeQuestionIndex][3]);

        Intent financeCategIntent = getIntent();

        String categoryNamefinance = financeCategIntent.getStringExtra("Finance Category Name");

        TextView financeCategoryTV = (TextView) findViewById(R.id.financeAppBarTV);

        financeCategoryTV.setText(categoryNamefinance);

        financeCateBackButtonAppBar.setOnClickListener(view -> {
            Intent financeAppBarBackButtonIntent = new Intent(
                    this, CategoryActivity.class
            );
            startActivity(financeAppBarBackButtonIntent);
        });

        financeFinishButton.setOnClickListener(view ->{
            Intent financeFinishButtonIntent = new Intent(
                    this, ScoreActivity.class
            );
            startActivity(financeFinishButtonIntent);
        });

        new CountDownTimer(30000, 1000) {
            public void onTick(long millisUntilFinished) {
                financeCateTimer.setText(String.valueOf(financeTimerSeconds));
                financeTimerSeconds--;
            }

            @Override
            public void onFinish() {
                AlertDialog alertDialog = new AlertDialog.Builder(financeCateActivity.this).create();
                alertDialog.setMessage("Time Has Done!");
                alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Intent financeTimerDoneAlertIntent = new Intent(
                                        financeCateActivity.this, CategoryActivity.class
                                );
                                startActivity(financeTimerDoneAlertIntent);
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
        if(clickedButton.getId()==R.id.financeSubmitButton){
            if(selectedAnswer.equals(QuestionAnswer.correctAnswers[financeQuestionIndex])){
                score++;
            }
            Intent financeSubmitIntent = new Intent(
                    this, foodCateActivity.class
            );
            startActivity(financeSubmitIntent);
        }else{
            selectedAnswer  = clickedButton.getText().toString();
            QuestionAnswer.financeSelectedAnswers = selectedAnswer;
            clickedButton.setBackgroundColor(Color.MAGENTA);

        }
    }
}
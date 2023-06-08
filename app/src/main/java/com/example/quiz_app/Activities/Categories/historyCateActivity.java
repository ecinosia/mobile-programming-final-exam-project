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

public class historyCateActivity extends AppCompatActivity implements View.OnClickListener {

    TextView historyQuestionTV;
    Button historyOpt1,historyOpt2,historyOpt3,historyOpt4;
    Button historySubmitBtn;
    final int historyQuestionIndex = 8;
    private int historyTimerSeconds = 30;

    String selectedAnswer = "";

    int score=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history_cate);

        final ImageButton historyCateBackButtonAppBar = findViewById(R.id.historyAppBarBackButton);
        final TextView historyCateTimer = findViewById(R.id.historyCateTimer);
        final Button historyFinishButton = findViewById(R.id.historyCatFinishQuizButton);

        historyQuestionTV = findViewById(R.id.historyQuestion);
        historyOpt1 = findViewById(R.id.historyOpt1);
        historyOpt2 = findViewById(R.id.historyOpt2);
        historyOpt3 = findViewById(R.id.historyOpt3);
        historyOpt4 = findViewById(R.id.historyOpt4);
        historySubmitBtn = findViewById(R.id.historySubmitButton);

        historyOpt1.setOnClickListener(this);
        historyOpt2.setOnClickListener(this);
        historyOpt3.setOnClickListener(this);
        historyOpt4.setOnClickListener(this);
        historySubmitBtn.setOnClickListener(this);

        historyQuestionTV.setText(QuestionAnswer.question[historyQuestionIndex]);
        historyOpt1.setText(QuestionAnswer.choices[historyQuestionIndex][0]);
        historyOpt2.setText(QuestionAnswer.choices[historyQuestionIndex][1]);
        historyOpt3.setText(QuestionAnswer.choices[historyQuestionIndex][2]);
        historyOpt4.setText(QuestionAnswer.choices[historyQuestionIndex][3]);

        Intent historyCategIntent = getIntent();

        String categoryNamehistory = historyCategIntent.getStringExtra("History Category Name");

        TextView historyCategoryTV = (TextView) findViewById(R.id.historyAppBarTV);

        historyCategoryTV.setText(categoryNamehistory);

        historyCateBackButtonAppBar.setOnClickListener(view -> {
            Intent historyAppBarBackButtonIntent = new Intent(
                    this, CategoryActivity.class
            );
            startActivity(historyAppBarBackButtonIntent);
        });

        historyFinishButton.setOnClickListener(view ->{
            Intent historyFinishButtonIntent = new Intent(
                    this, ScoreActivity.class
            );
            startActivity(historyFinishButtonIntent);
        });

        new CountDownTimer(30000, 1000) {
            public void onTick(long millisUntilFinished) {
                historyCateTimer.setText(String.valueOf(historyTimerSeconds));
                historyTimerSeconds--;
            }

            @Override
            public void onFinish() {
                AlertDialog alertDialog = new AlertDialog.Builder(historyCateActivity.this).create();
                alertDialog.setMessage("Time Has Done!");
                alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Intent historyTimerDoneAlertIntent = new Intent(
                                        historyCateActivity.this, CategoryActivity.class
                                );
                                startActivity(historyTimerDoneAlertIntent);
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
        if(clickedButton.getId()==R.id.historySubmitButton){
            if(selectedAnswer.equals(QuestionAnswer.correctAnswers[historyQuestionIndex])){
                score++;
            }
            Intent historySubmitIntent = new Intent(
                    this, languageCateActivity.class
            );
            startActivity(historySubmitIntent);
        }else{
            selectedAnswer  = clickedButton.getText().toString();
            QuestionAnswer.historySelectedAnswers = selectedAnswer;
            clickedButton.setBackgroundColor(Color.MAGENTA);
        }
    }
}
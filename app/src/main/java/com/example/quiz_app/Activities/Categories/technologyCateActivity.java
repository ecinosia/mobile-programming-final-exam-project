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

public class technologyCateActivity extends AppCompatActivity implements View.OnClickListener {

    TextView technologyQuestionTV;
    Button technologyOpt1,technologyOpt2,technologyOpt3,technologyOpt4;
    Button technologySubmitBtn;
    final int technologyQuestionIndex = 4;
    private int technologyTimerSeconds = 30;

    String selectedAnswer = "";

    int score=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_technology_cate);

        final ImageButton technologyCateBackButtonAppBar = findViewById(R.id.technologyAppBarBackButton);
        final TextView technologyCateTimer = findViewById(R.id.technologyCateTimer);
        final Button technologyFinishButton = findViewById(R.id.technologyCatFinishQuizButton);

        technologyQuestionTV = findViewById(R.id.technologyQuestion);
        technologyOpt1 = findViewById(R.id.technologyOpt1);
        technologyOpt2 = findViewById(R.id.technologyOpt2);
        technologyOpt3 = findViewById(R.id.technologyOpt3);
        technologyOpt4 = findViewById(R.id.technologyOpt4);
        technologySubmitBtn = findViewById(R.id.technologySubmitButton);

        technologyOpt1.setOnClickListener(this);
        technologyOpt2.setOnClickListener(this);
        technologyOpt3.setOnClickListener(this);
        technologyOpt4.setOnClickListener(this);
        technologySubmitBtn.setOnClickListener(this);

        technologyQuestionTV.setText(QuestionAnswer.question[technologyQuestionIndex]);
        technologyOpt1.setText(QuestionAnswer.choices[technologyQuestionIndex][0]);
        technologyOpt2.setText(QuestionAnswer.choices[technologyQuestionIndex][1]);
        technologyOpt3.setText(QuestionAnswer.choices[technologyQuestionIndex][2]);
        technologyOpt4.setText(QuestionAnswer.choices[technologyQuestionIndex][3]);

        Intent technologyCategIntent = getIntent();

        String categoryNametechnology = technologyCategIntent.getStringExtra("Technology Category Name");

        TextView technologyCategoryTV = (TextView) findViewById(R.id.technologyAppBarTV);

        technologyCategoryTV.setText(categoryNametechnology);

        technologyCateBackButtonAppBar.setOnClickListener(view -> {
            Intent technologyAppBarBackButtonIntent = new Intent(
                    this, CategoryActivity.class
            );
            startActivity(technologyAppBarBackButtonIntent);
        });

        technologyFinishButton.setOnClickListener(view ->{
            Intent technologyFinishButtonIntent = new Intent(
                    this, ScoreActivity.class
            );
            startActivity(technologyFinishButtonIntent);
        });

        new CountDownTimer(30000, 1000) {
            public void onTick(long millisUntilFinished) {
                technologyCateTimer.setText(String.valueOf(technologyTimerSeconds));
                technologyTimerSeconds--;
            }

            @Override
            public void onFinish() {
                AlertDialog alertDialog = new AlertDialog.Builder(technologyCateActivity.this).create();
                alertDialog.setMessage("Time Has Done!");
                alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Intent technologyTimerDoneAlertIntent = new Intent(
                                        technologyCateActivity.this, CategoryActivity.class
                                );
                                startActivity(technologyTimerDoneAlertIntent);
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
        if(clickedButton.getId()==R.id.technologySubmitButton){
            if(selectedAnswer.equals(QuestionAnswer.correctAnswers[technologyQuestionIndex])){
                score++;
            }
            Intent technologySubmitIntent = new Intent(
                    this, financeCateActivity.class
            );
            startActivity(technologySubmitIntent);
        }else{
            selectedAnswer  = clickedButton.getText().toString();
            QuestionAnswer.technologySelectedAnswers = selectedAnswer;
            clickedButton.setBackgroundColor(Color.MAGENTA);
        }
    }
}
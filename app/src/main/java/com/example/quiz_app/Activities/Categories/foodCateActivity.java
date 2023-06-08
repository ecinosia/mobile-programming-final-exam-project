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

public class foodCateActivity extends AppCompatActivity implements View.OnClickListener {

    TextView foodQuestionTV;
    Button foodOpt1,foodOpt2,foodOpt3,foodOpt4;
    Button foodSubmitBtn;
    final int foodQuestionIndex = 6;
    private int foodTimerSeconds = 30;

    String selectedAnswer = "";

    int score=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_cate);

        final ImageButton foodCateBackButtonAppBar = findViewById(R.id.foodAppBarBackButton);
        final TextView foodCateTimer = findViewById(R.id.foodCateTimer);
        final Button foodFinishButton = findViewById(R.id.foodCatFinishQuizButton);

        foodQuestionTV = findViewById(R.id.foodQuestion);
        foodOpt1 = findViewById(R.id.foodOpt1);
        foodOpt2 = findViewById(R.id.foodOpt2);
        foodOpt3 = findViewById(R.id.foodOpt3);
        foodOpt4 = findViewById(R.id.foodOpt4);
        foodSubmitBtn = findViewById(R.id.foodSubmitButton);

        foodOpt1.setOnClickListener(this);
        foodOpt2.setOnClickListener(this);
        foodOpt3.setOnClickListener(this);
        foodOpt4.setOnClickListener(this);
        foodSubmitBtn.setOnClickListener(this);

        foodQuestionTV.setText(QuestionAnswer.question[foodQuestionIndex]);
        foodOpt1.setText(QuestionAnswer.choices[foodQuestionIndex][0]);
        foodOpt2.setText(QuestionAnswer.choices[foodQuestionIndex][1]);
        foodOpt3.setText(QuestionAnswer.choices[foodQuestionIndex][2]);
        foodOpt4.setText(QuestionAnswer.choices[foodQuestionIndex][3]);

        Intent foodCategIntent = getIntent();

        String categoryNamefood = foodCategIntent.getStringExtra("Food Category Name");

        TextView foodCategoryTV = (TextView) findViewById(R.id.foodAppBarTV);

        foodCategoryTV.setText(categoryNamefood);

        foodCateBackButtonAppBar.setOnClickListener(view -> {
            Intent foodAppBarBackButtonIntent = new Intent(
                    this, CategoryActivity.class
            );
            startActivity(foodAppBarBackButtonIntent);
        });

        foodFinishButton.setOnClickListener(view ->{
            Intent foodFinishButtonIntent = new Intent(
                    this, ScoreActivity.class
            );
            startActivity(foodFinishButtonIntent);
        });

        new CountDownTimer(30000, 1000) {
            public void onTick(long millisUntilFinished) {
                foodCateTimer.setText(String.valueOf(foodTimerSeconds));
                foodTimerSeconds--;
            }

            @Override
            public void onFinish() {
                AlertDialog alertDialog = new AlertDialog.Builder(foodCateActivity.this).create();
                alertDialog.setMessage("Time Has Done!");
                alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Intent foodTimerDoneAlertIntent = new Intent(
                                        foodCateActivity.this, CategoryActivity.class
                                );
                                startActivity(foodTimerDoneAlertIntent);
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
        if(clickedButton.getId()==R.id.foodSubmitButton){
            if(selectedAnswer.equals(QuestionAnswer.correctAnswers[foodQuestionIndex])){
                score++;
            }
            Intent foodSubmitIntent = new Intent(
                    this, countriesCateActivity.class
            );
            startActivity(foodSubmitIntent);
        }else{
            selectedAnswer  = clickedButton.getText().toString();
            QuestionAnswer.foodSelectedAnswers = selectedAnswer;
            clickedButton.setBackgroundColor(Color.MAGENTA);
        }
    }
}
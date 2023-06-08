package com.example.quiz_app.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.example.quiz_app.Classes.QuestionAnswer;
import com.example.quiz_app.R;

public class ScoreActivity extends AppCompatActivity {

    TextView musicAnswerTV, artAnswerTV,scienceAnswerTV,
            automobileAnswerTV,technologyAnswerTV,
            financeAnswerTV, foodAnswerTV,countriesAnswerTV,
            historyAnswerTV,languageAnswerTV;
    TextView scoreTV;
    String musicSelectedAnswer = "";
    int score = 0;
    int scoreIndex = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);

        musicAnswerTV = findViewById(R.id.musicAnswerTV);
        artAnswerTV = findViewById(R.id.artAnswerTV);
        scienceAnswerTV = findViewById(R.id.scienceAnswerTV);
        automobileAnswerTV = findViewById(R.id.automobileAnswerTV);
        technologyAnswerTV = findViewById(R.id.technologyAnswerTV);
        financeAnswerTV = findViewById(R.id.financeAnswerTV);
        foodAnswerTV = findViewById(R.id.foodAnswerTV);
        countriesAnswerTV = findViewById(R.id.countriesAnswerTV);
        historyAnswerTV = findViewById(R.id.historyAnswerTV);
        languageAnswerTV = findViewById(R.id.languageAnswerTV);

        scoreTV = findViewById(R.id.scoreTV);

        if(QuestionAnswer.musicSelectedAnswers.equals(QuestionAnswer.correctAnswers[0])){
            musicAnswerTV.setText("Correct!");
            score = score + 10;
        }else if(QuestionAnswer.musicSelectedAnswers.equals("")){
            musicAnswerTV.setText("");
        }else{
            musicAnswerTV.setText("Wrong!");
            score = score - 4;

        }

        if(QuestionAnswer.artSelectedAnswers.equals(QuestionAnswer.correctAnswers[1])){
            artAnswerTV.setText("Correct!");
            score = score + 10;
        }else if(QuestionAnswer.artSelectedAnswers.equals("")){
            artAnswerTV.setText("");
        }else{
            artAnswerTV.setText("Wrong!");
            score = score - 4;

        }

        if(QuestionAnswer.scienceSelectedAnswers.equals(QuestionAnswer.correctAnswers[2])){
            scienceAnswerTV.setText("Correct!");
            score = score + 10;
        }else if(QuestionAnswer.scienceSelectedAnswers.equals("")){
            scienceAnswerTV.setText("");
        }else{
            scienceAnswerTV.setText("Wrong!");
            score = score - 4;

        }

        if(QuestionAnswer.automobileSelectedAnswers.equals(QuestionAnswer.correctAnswers[3])){
            automobileAnswerTV.setText("Correct!");
            score = score + 10;
        }else if(QuestionAnswer.automobileSelectedAnswers.equals("")){
            automobileAnswerTV.setText("");
        }else{
            automobileAnswerTV.setText("Wrong!");
            score = score - 4;

        }

        if(QuestionAnswer.technologySelectedAnswers.equals(QuestionAnswer.correctAnswers[4])){
            technologyAnswerTV.setText("Correct!");
            score = score + 10;
        }else if(QuestionAnswer.technologySelectedAnswers.equals("")){
            technologyAnswerTV.setText("");
        }else{
            technologyAnswerTV.setText("Wrong!");
            score = score - 4;

        }

        if(QuestionAnswer.financeSelectedAnswers.equals(QuestionAnswer.correctAnswers[5])){
            financeAnswerTV.setText("Correct!");
            score = score + 10;
        }else if(QuestionAnswer.financeSelectedAnswers.equals("")){
            financeAnswerTV.setText("");
        }else{
            financeAnswerTV.setText("Wrong!");
            score = score - 4;

        }

        if(QuestionAnswer.foodSelectedAnswers.equals(QuestionAnswer.correctAnswers[6])){
            foodAnswerTV.setText("Correct!");
            score = score + 10;
        }else if(QuestionAnswer.foodSelectedAnswers.equals("")){
            foodAnswerTV.setText("");
        }else{
            foodAnswerTV.setText("Wrong!");
            score = score - 4;

        }

        if(QuestionAnswer.countriesSelectedAnswers.equals(QuestionAnswer.correctAnswers[7])){
            countriesAnswerTV.setText("Correct!");
            score = score + 10;
        }else if(QuestionAnswer.countriesSelectedAnswers.equals("")){
            countriesAnswerTV.setText("");
        }else{
            countriesAnswerTV.setText("Wrong!");
            score = score - 4;

        }

        if(QuestionAnswer.historySelectedAnswers.equals(QuestionAnswer.correctAnswers[8])){
            historyAnswerTV.setText("Correct!");
            score = score + 10;
        }else if(QuestionAnswer.historySelectedAnswers.equals("")){
            historyAnswerTV.setText("");
        }else{

            historyAnswerTV.setText("Wrong!");
            score = score - 4;
        }

        if(QuestionAnswer.languageSelectedAnswers.equals(QuestionAnswer.correctAnswers[9])){
            languageAnswerTV.setText("Correct!");
            score = score + 10;
        }else if(QuestionAnswer.languageSelectedAnswers.equals("")){
            languageAnswerTV.setText("");
        }else{
            languageAnswerTV.setText("Wrong!");
            score = score - 4;
        }

        scoreTV.setText("Your Score: "+score);

        final Button goBackHomeScoresButton = findViewById(R.id.goBackHomeBtnScore);

        goBackHomeScoresButton.setOnClickListener(view -> {
            Intent goBackHomeScoresIntent = new Intent(
                    this, MainActivity.class
            );
            startActivity(goBackHomeScoresIntent);
        });





    }
}
package com.example.quiz_app.Activities;

import androidx.annotation.DrawableRes;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.Button;
import android.widget.RelativeLayout;

import com.example.quiz_app.Activities.Categories.artCateActivity;
import com.example.quiz_app.Activities.Categories.automobileCateActivity;
import com.example.quiz_app.Activities.Categories.countriesCateActivity;
import com.example.quiz_app.Activities.Categories.financeCateActivity;
import com.example.quiz_app.Activities.Categories.foodCateActivity;
import com.example.quiz_app.Activities.Categories.historyCateActivity;
import com.example.quiz_app.Activities.Categories.languageCateActivity;
import com.example.quiz_app.Activities.Categories.musicCateActivity;
import com.example.quiz_app.Activities.Categories.scienceCateActivity;
import com.example.quiz_app.Activities.Categories.technologyCateActivity;
import com.example.quiz_app.Classes.QuestionAnswer;
import com.example.quiz_app.R;

public class CategoryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);

        RelativeLayout musicRL = (RelativeLayout)findViewById(R.id.musicCat);
        RelativeLayout artRL = (RelativeLayout)findViewById(R.id.artCat);
        RelativeLayout scienceRL = (RelativeLayout)findViewById(R.id.scienceCat);
        RelativeLayout automobileRL = (RelativeLayout)findViewById(R.id.automobileCat);
        RelativeLayout technologyRL = (RelativeLayout)findViewById(R.id.technologyCat);
        RelativeLayout financeRL = (RelativeLayout)findViewById(R.id.financeCat);
        RelativeLayout foodRL = (RelativeLayout)findViewById(R.id.foodCat);
        RelativeLayout countriesRL = (RelativeLayout)findViewById(R.id.countriesCat);
        RelativeLayout historyRL = (RelativeLayout)findViewById(R.id.historyCat);
        RelativeLayout languageRL = (RelativeLayout)findViewById(R.id.languageCat);

        final Button categoryGoHomeButton = findViewById(R.id.categoryBackHomeButton);
        final Button categoryGoScoreButton = findViewById(R.id.categoryGoScoreButton);

        categoryGoHomeButton.setOnClickListener(view ->{
            Intent categoryHomeBackButtonIntent = new Intent(
                    this, MainActivity.class
            );
            startActivity(categoryHomeBackButtonIntent);
        });

        categoryGoScoreButton.setOnClickListener(view ->{
            Intent categoryGoScoreButtonIntent = new Intent(
                    this, ScoreActivity.class
            );
            startActivity(categoryGoScoreButtonIntent);
        });

        Intent musicCatAnswerIntent = getIntent();
        String musicAnswer = musicCatAnswerIntent.getStringExtra("Music Answer");


        musicRL.setOnClickListener(view ->{
            Intent musicCateIntent = new Intent(
                    this, musicCateActivity.class
            );
            musicCateIntent.putExtra("Music Category Name","Music");
            startActivity(musicCateIntent);
        });

        artRL.setOnClickListener(view ->{
            Intent artCateIntent = new Intent(
                    this, artCateActivity.class
            );
            artCateIntent.putExtra("Art Category Name","Art");
            startActivity(artCateIntent);
        });

        scienceRL.setOnClickListener(view ->{
            Intent scienceCateIntent = new Intent(
                    this, scienceCateActivity.class
            );
            scienceCateIntent.putExtra("Science Category Name","Science");
            startActivity(scienceCateIntent);
        });

        automobileRL.setOnClickListener(view ->{
            Intent automobileCateIntent = new Intent(
                    this, automobileCateActivity.class
            );
            automobileCateIntent.putExtra("Automobile Category Name","Automobile");
            startActivity(automobileCateIntent);
        });

        technologyRL.setOnClickListener(view ->{
            Intent technologyCateIntent = new Intent(
                    this, technologyCateActivity.class
            );
            technologyCateIntent.putExtra("Technology Category Name","Technology");
            startActivity(technologyCateIntent);
        });

        financeRL.setOnClickListener(view ->{
            Intent financeCateIntent = new Intent(
                    this, financeCateActivity.class
            );
            financeCateIntent.putExtra("Finance Category Name","Finance");
            startActivity(financeCateIntent);
        });

        foodRL.setOnClickListener(view ->{
            Intent foodCateIntent = new Intent(
                    this, foodCateActivity.class
            );
            foodCateIntent.putExtra("Food Category Name","Food");
            startActivity(foodCateIntent);
        });

        countriesRL.setOnClickListener(view ->{
            Intent countriesCateIntent = new Intent(
                    this, countriesCateActivity.class
            );
            countriesCateIntent.putExtra("Countries Category Name","Countries");
            startActivity(countriesCateIntent);
        });

        historyRL.setOnClickListener(view ->{
            Intent historyCateIntent = new Intent(
                    this, historyCateActivity.class
            );
            historyCateIntent.putExtra("History Category Name","History");
            startActivity(historyCateIntent);
        });

        languageRL.setOnClickListener(view ->{
            Intent languageCateIntent = new Intent(
                    this, languageCateActivity.class
            );
            languageCateIntent.putExtra("Language Category Name","Language");
            startActivity(languageCateIntent);
        });


        if(QuestionAnswer.musicSelectedAnswers.equals(QuestionAnswer.correctAnswers[0])){
            musicRL.setBackgroundColor(Color.GREEN);
        }else if(QuestionAnswer.musicSelectedAnswers.equals("")){
            musicRL.setBackgroundColor(Color.YELLOW);
        }else{
            musicRL.setBackgroundColor(Color.RED);
        }

        if(QuestionAnswer.artSelectedAnswers.equals(QuestionAnswer.correctAnswers[1])){
            artRL.setBackgroundColor(Color.GREEN);
        }else if(QuestionAnswer.artSelectedAnswers.equals("")){
            artRL.setBackgroundColor(Color.YELLOW);
        }else{
            artRL.setBackgroundColor(Color.RED);
        }

        if(QuestionAnswer.scienceSelectedAnswers.equals(QuestionAnswer.correctAnswers[2])){
            scienceRL.setBackgroundColor(Color.GREEN);
        }else if(QuestionAnswer.scienceSelectedAnswers.equals("")){
            scienceRL.setBackgroundColor(Color.YELLOW);
        }else{
            scienceRL.setBackgroundColor(Color.RED);
        }

        if(QuestionAnswer.automobileSelectedAnswers.equals(QuestionAnswer.correctAnswers[3])){
            automobileRL.setBackgroundColor(Color.GREEN);
        }else if(QuestionAnswer.automobileSelectedAnswers.equals("")){
            automobileRL.setBackgroundColor(Color.YELLOW);
        }else{
            automobileRL.setBackgroundColor(Color.RED);
        }

        if(QuestionAnswer.technologySelectedAnswers.equals(QuestionAnswer.correctAnswers[4])){
            technologyRL.setBackgroundColor(Color.GREEN);
        }else if(QuestionAnswer.technologySelectedAnswers.equals("")){
            technologyRL.setBackgroundColor(Color.YELLOW);
        }else{
            technologyRL.setBackgroundColor(Color.RED);
        }

        if(QuestionAnswer.financeSelectedAnswers.equals(QuestionAnswer.correctAnswers[5])){
            financeRL.setBackgroundColor(Color.GREEN);
        }else if(QuestionAnswer.financeSelectedAnswers.equals("")){
            financeRL.setBackgroundColor(Color.YELLOW);
        }else{
            financeRL.setBackgroundColor(Color.RED);
        }

        if(QuestionAnswer.foodSelectedAnswers.equals(QuestionAnswer.correctAnswers[6])){
            foodRL.setBackgroundColor(Color.GREEN);
        }else if(QuestionAnswer.foodSelectedAnswers.equals("")){
            foodRL.setBackgroundColor(Color.YELLOW);
        }else{
            foodRL.setBackgroundColor(Color.RED);
        }

        if(QuestionAnswer.countriesSelectedAnswers.equals(QuestionAnswer.correctAnswers[7])){
            countriesRL.setBackgroundColor(Color.GREEN);
        }else if(QuestionAnswer.countriesSelectedAnswers.equals("")){
            countriesRL.setBackgroundColor(Color.YELLOW);
        }else{
            countriesRL.setBackgroundColor(Color.RED);
        }

        if(QuestionAnswer.historySelectedAnswers.equals(QuestionAnswer.correctAnswers[8])){
            historyRL.setBackgroundColor(Color.GREEN);
        }else if(QuestionAnswer.historySelectedAnswers.equals("")){
            historyRL.setBackgroundColor(Color.YELLOW);
        }else{
            historyRL.setBackgroundColor(Color.RED);
        }

        if(QuestionAnswer.languageSelectedAnswers.equals(QuestionAnswer.correctAnswers[9])){
            languageRL.setBackgroundColor(Color.GREEN);
        }else if(QuestionAnswer.languageSelectedAnswers.equals("")){
            languageRL.setBackgroundColor(Color.YELLOW);
        }else{
            languageRL.setBackgroundColor(Color.RED);
        }

    }
}
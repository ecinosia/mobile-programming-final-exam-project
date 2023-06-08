package com.example.quiz_app.Activities.Categories;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.media.MediaPlayer;
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

public class musicCateActivity extends AppCompatActivity implements View.OnClickListener{
    TextView musicQuestionTV;
    Button musicOpt1,musicOpt2,musicOpt3,musicOpt4;
    Button musicSubmitBtn;
    final int musicQuestionIndex = 0;
    String selectedAnswer = "";
    int score=0;
    private int musicTimerSeconds = 30;
    MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_music_cate);

        final ImageButton musicCateBackButtonAppBar = findViewById(R.id.musicAppBarBackButton);
        final TextView musicCateTimer = findViewById(R.id.musicCateTimer);
        final Button musicPlayButton = findViewById(R.id.musicPlayButton);
        final Button musicPauseButton = findViewById(R.id.musicPauseButton);

        musicQuestionTV = findViewById(R.id.musicQuestion);
        musicOpt1 = findViewById(R.id.musicOpt1);
        musicOpt2 = findViewById(R.id.musicOpt2);
        musicOpt3 = findViewById(R.id.musicOpt3);
        musicOpt4 = findViewById(R.id.musicOpt4);
        musicSubmitBtn = findViewById(R.id.musicSubmitButton);

        musicOpt1.setOnClickListener(this);
        musicOpt2.setOnClickListener(this);
        musicOpt3.setOnClickListener(this);
        musicOpt4.setOnClickListener(this);
        musicSubmitBtn.setOnClickListener(this);

        final Button musicFinishButton = findViewById(R.id.musicCatFinishQuizButton);

        musicQuestionTV.setText(QuestionAnswer.question[musicQuestionIndex]);
        musicOpt1.setText(QuestionAnswer.choices[musicQuestionIndex][0]);
        musicOpt2.setText(QuestionAnswer.choices[musicQuestionIndex][1]);
        musicOpt3.setText(QuestionAnswer.choices[musicQuestionIndex][2]);
        musicOpt4.setText(QuestionAnswer.choices[musicQuestionIndex][3]);

        Intent musicCategIntent = getIntent();
        String categoryNameMusic = musicCategIntent.getStringExtra("Music Category Name");
        TextView musicCategoryTV = (TextView) findViewById(R.id.musicAppBarTV);
        musicCategoryTV.setText(categoryNameMusic);

        musicCateBackButtonAppBar.setOnClickListener(view -> {
            Intent musicAppBarBackButtonIntent = new Intent(
                    this, CategoryActivity.class
            );
            startActivity(musicAppBarBackButtonIntent);
        });

        MediaPlayer mediaPlayer = MediaPlayer.create(this, R.raw.mp3_audio);

        musicPlayButton.setOnClickListener(view ->{
            mediaPlayer.start();
        });

        musicPauseButton.setOnClickListener(view ->{
            mediaPlayer.pause();
        });

        musicFinishButton.setOnClickListener(view ->{
            Intent musicFinishButtonIntent = new Intent(
                    this, ScoreActivity.class
            );
            startActivity(musicFinishButtonIntent);
        });

        new CountDownTimer(30000, 1000) {
            public void onTick(long millisUntilFinished) {
                musicCateTimer.setText(String.valueOf(musicTimerSeconds));
                musicTimerSeconds--;
            }

            @Override
            public void onFinish() {
                AlertDialog alertDialog = new AlertDialog.Builder(musicCateActivity.this).create();
                alertDialog.setMessage("Time Has Done!");
                alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Intent musicTimerDoneAlertIntent = new Intent(
                                        musicCateActivity.this, CategoryActivity.class
                                );
                                startActivity(musicTimerDoneAlertIntent);
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
        if(clickedButton.getId()==R.id.musicSubmitButton){
            if(selectedAnswer.equals(QuestionAnswer.correctAnswers[musicQuestionIndex])){
                score++;
            }
            Intent musicSubmitIntent = new Intent(
                    this, artCateActivity.class
            );
            startActivity(musicSubmitIntent);
            }else{
            selectedAnswer  = clickedButton.getText().toString();
            QuestionAnswer.musicSelectedAnswers = selectedAnswer;
            clickedButton.setBackgroundColor(Color.MAGENTA);
        }
    }
}
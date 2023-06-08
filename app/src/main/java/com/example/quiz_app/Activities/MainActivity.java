package com.example.quiz_app.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;

import com.example.quiz_app.R;

public class MainActivity extends AppCompatActivity {
    String prevStarted = "yes";
    @Override
    protected void onResume() {
        super.onResume();
        SharedPreferences sharedpreferences = getSharedPreferences(getString(R.string.app_name), Context.MODE_PRIVATE);
        if (!sharedpreferences.getBoolean(prevStarted, false)) {
            SharedPreferences.Editor editor = sharedpreferences.edit();
            editor.putBoolean(prevStarted, Boolean.FALSE);
            editor.apply();
        }else{
            moveToSecondary();
        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button welcomeContinueButton = findViewById(R.id.welcomeScreenContButton);

        welcomeContinueButton.setOnClickListener(view ->{
            Intent welcomeIntent = new Intent(this,HomeScreenActivity.class);
            startActivity(welcomeIntent);
        });
    }
    public void moveToSecondary(){
        Intent welcomeIntent = new Intent(this,HomeScreenActivity.class);
        startActivity(welcomeIntent);
    }
}
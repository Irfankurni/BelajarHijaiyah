package com.example.belajarhijaiyah;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

public class SkorKuis extends AppCompatActivity {
    Button btnMain,btnReturn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_skor_kuis);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        btnReturn = findViewById(R.id.button) ;
        btnMain = findViewById(R.id.bckTmain) ;
        btnMain.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent in = new Intent(SkorKuis.this, MainActivity.class);
                startActivity(in);
                finish();
            }
        });
        btnReturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent (SkorKuis.this,KuisActivity.class);
                startActivity(in);
                finish();
            }
        });

        TextView resultLabel = findViewById(R.id.resultLabel);
        TextView totalScoreLabel = findViewById(R.id.totalScoreLabel);
        int score=getIntent().getIntExtra("RIGHT_ANSWER_COUNT",0);

        SharedPreferences settings = getSharedPreferences("belajarngaji", Context.MODE_PRIVATE);

        int totalScore = settings.getInt("Skor Anda",0);
        totalScore+=score;
        resultLabel.setText(score + "/10");
        totalScoreLabel.setText("Total Skor :" + totalScore);

        //update the totalScore
        SharedPreferences.Editor editor =settings.edit();
        editor.putInt("totalScore",totalScore);
        editor.commit();
    }



}

package com.example.belajarhijaiyah;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

public class SkorKuis extends AppCompatActivity {

    private Button btnMain, btnReturn;
    private TextView resultLabel, totalScoreLabel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_skor_kuis);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        initializeViews();
        setupClickListeners();
        updateScore();
    }

    private void initializeViews() {
        btnReturn = findViewById(R.id.button);
        btnMain = findViewById(R.id.bckTmain);
        resultLabel = findViewById(R.id.resultLabel);
        totalScoreLabel = findViewById(R.id.totalScoreLabel);
    }

    private void setupClickListeners() {
        btnMain.setOnClickListener(v -> navigateToActivity(MainActivity.class));
        btnReturn.setOnClickListener(v -> navigateToActivity(KuisActivity.class));
    }

    private void navigateToActivity(Class<?> cls) {
        Intent intent = new Intent(SkorKuis.this, cls);
        startActivity(intent);
        finish();
    }

    private void updateScore() {
        int score = getIntent().getIntExtra("RIGHT_ANSWER_COUNT", 0);
        SharedPreferences settings = getSharedPreferences("belajarngaji", Context.MODE_PRIVATE);

        int totalScore = settings.getInt("Skor Anda", 0);
        totalScore += score;

        resultLabel.setText(String .format("%s \"/10\"", score));
        totalScoreLabel.setText(String.format("Total Skor : %s", totalScore));

        SharedPreferences.Editor editor = settings.edit();
        editor.putInt("totalScore", totalScore);
        editor.apply();
    }
}

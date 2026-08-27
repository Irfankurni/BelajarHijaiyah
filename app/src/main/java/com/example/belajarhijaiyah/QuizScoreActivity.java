package com.example.belajarhijaiyah;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.WindowCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.core.view.WindowInsetsControllerCompat;

import com.example.belajarhijaiyah.constant.Constants;

public class QuizScoreActivity extends AppCompatActivity {

    private Button btnMain, btnReturn;
    private TextView resultLabel, totalScoreLabel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_score);
        hideSystemBars();

        initializeViews();
        setupClickListeners();
        updateScore();
    }

    private void initializeViews() {
        btnReturn       = findViewById(R.id.button);
        btnMain         = findViewById(R.id.back_to_main_button);
        resultLabel     = findViewById(R.id.result_label);
        totalScoreLabel = findViewById(R.id.total_score_label);
    }

    private void setupClickListeners() {
        btnMain.setOnClickListener(v -> navigateToActivity(MainActivity.class));
        btnReturn.setOnClickListener(v -> navigateToActivity(QuizMenuActivity.class));
    }

    private void navigateToActivity(Class<?> cls) {
        startActivity(new Intent(this, cls));
        finish();
    }

    private void updateScore() {
        int score = getIntent().getIntExtra("RIGHT_ANSWER_COUNT", 0);
        SharedPreferences prefs = getSharedPreferences(Constants.PREF_NAME, Context.MODE_PRIVATE);

        int totalScore = prefs.getInt(Constants.PREF_TOTAL_SCORE, 0) + score;

        resultLabel.setText(String.format("%s/%s", score, Constants.QUIZ_COUNT));
        totalScoreLabel.setText(String.format("Total Score: %s", totalScore));

        prefs.edit().putInt(Constants.PREF_TOTAL_SCORE, totalScore).apply();
    }

    private void hideSystemBars() {
        WindowCompat.setDecorFitsSystemWindows(getWindow(), false);
        WindowInsetsControllerCompat controller =
                WindowCompat.getInsetsController(getWindow(), getWindow().getDecorView());
        controller.hide(WindowInsetsCompat.Type.systemBars());
        controller.setSystemBarsBehavior(
                WindowInsetsControllerCompat.BEHAVIOR_SHOW_TRANSIENT_BARS_BY_SWIPE);
    }
}

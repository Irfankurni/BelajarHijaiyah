package com.example.belajarhijaiyah;

import static android.content.ContentValues.TAG;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.WindowManager;
import android.widget.ProgressBar;

public class SplashActivity extends AppCompatActivity {

    private static final int SPLASH_DURATION = 6000; // 6 seconds
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        progressBar = findViewById(R.id.splashscreen);
        progressBar.setMax(100);
        progressBar.setProgress(0);

        simulateLoading();
    }

    private void simulateLoading() {
        new Handler().postDelayed(() -> {
            Intent intent = new Intent(SplashActivity.this, MainActivity.class);
            startActivity(intent);
            finish();
        }, SPLASH_DURATION);

        new Thread(() -> {
            try {
                for (int i = 0; i <= 100; i++) {
                    final int progress = i;
                    runOnUiThread(() -> progressBar.setProgress(progress));
                    Thread.sleep(SPLASH_DURATION / 100);
                }
            } catch (InterruptedException e) {
                Log.e(TAG, "Thread interrupted", e);
            }
        }).start();
    }
}

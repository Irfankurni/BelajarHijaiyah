package com.example.belajarhijaiyah;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.widget.ProgressBar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.WindowCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.core.view.WindowInsetsControllerCompat;

public class SplashActivity extends AppCompatActivity {

    private static final int SPLASH_DURATION_MS = 6000;
    private static final int STEP_INTERVAL_MS = SPLASH_DURATION_MS / 100;
    private ProgressBar progressBar;
    private final Handler mainHandler = new Handler(Looper.getMainLooper());
    private int currentProgress = 0;
    private boolean isDestroyed = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        hideSystemBars();

        progressBar = findViewById(R.id.progress_bar);
        progressBar.setMax(100);
        progressBar.setProgress(0);

        startLoadingSequence();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        isDestroyed = true;
        mainHandler.removeCallbacksAndMessages(null);
    }

    private void startLoadingSequence() {
        // Navigate after full duration
        mainHandler.postDelayed(() -> {
            if (!isDestroyed) {
                startActivity(new Intent(SplashActivity.this, MainActivity.class));
                finish();
            }
        }, SPLASH_DURATION_MS);

        // Tick progress on the main thread — no raw Thread needed
        tickProgress();
    }

    private void tickProgress() {
        mainHandler.postDelayed(() -> {
            if (isDestroyed) return;
            if (currentProgress <= 100) {
                progressBar.setProgress(currentProgress);
                currentProgress++;
                tickProgress();
            }
        }, STEP_INTERVAL_MS);
    }

    /**
     * Replaces the deprecated WindowManager.FLAG_FULLSCREEN approach.
     */
    private void hideSystemBars() {
        WindowCompat.setDecorFitsSystemWindows(getWindow(), false);
        WindowInsetsControllerCompat controller =
                WindowCompat.getInsetsController(getWindow(), getWindow().getDecorView());
        controller.hide(WindowInsetsCompat.Type.systemBars());
        controller.setSystemBarsBehavior(
                WindowInsetsControllerCompat.BEHAVIOR_SHOW_TRANSIENT_BARS_BY_SWIPE);
    }
}

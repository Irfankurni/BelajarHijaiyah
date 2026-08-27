package com.example.belajarhijaiyah;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityOptionsCompat;
import androidx.core.view.WindowCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.core.view.WindowInsetsControllerCompat;

import com.example.belajarhijaiyah.kuis.DhommahQuizActivity;
import com.example.belajarhijaiyah.kuis.DotainQuizActivity;
import com.example.belajarhijaiyah.kuis.FatainQuizActivity;
import com.example.belajarhijaiyah.kuis.FathahQuizActivity;
import com.example.belajarhijaiyah.kuis.HijaiyahQuizActivity;
import com.example.belajarhijaiyah.kuis.KasrohQuizActivity;
import com.example.belajarhijaiyah.kuis.KastainQuizActivity;

public class QuizMenuActivity extends AppCompatActivity implements ServiceConnection {

    private ImageButton hijaiyah, fathah, kasroh, dhommah, fatain, kastain, dotain, backButton;
    private Animation bounce;
    private MusicService musicService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_menu);
        hideSystemBars();

        bounce = AnimationUtils.loadAnimation(this, R.anim.bounce);
        initializeViews();
        setupClickListeners();
    }

    private void initializeViews() {
        hijaiyah = findViewById(R.id.kuis_hijaiyah);
        fathah   = findViewById(R.id.kuis_fathah);
        kasroh   = findViewById(R.id.kuis_kasroh);
        dhommah    = findViewById(R.id.kuis_domah);
        fatain   = findViewById(R.id.kuis_fathah_tain);
        kastain  = findViewById(R.id.kuis_kasroh_tain);
        dotain   = findViewById(R.id.kuis_domah_tain);
        backButton  = findViewById(R.id.close_button);
    }

    private void setupClickListeners() {
        backButton.setOnClickListener(v -> {
            v.startAnimation(bounce);
            finish();
        });

        hijaiyah.setOnClickListener(v -> startActivityWithAnimation(HijaiyahQuizActivity.class));
        fathah.setOnClickListener(v   -> startActivityWithAnimation(FathahQuizActivity.class));
        kasroh.setOnClickListener(v   -> startActivityWithAnimation(KasrohQuizActivity.class));
        dhommah.setOnClickListener(v    -> startActivityWithAnimation(DhommahQuizActivity.class));
        fatain.setOnClickListener(v   -> startActivityWithAnimation(FatainQuizActivity.class));
        kastain.setOnClickListener(v  -> startActivityWithAnimation(KastainQuizActivity.class));
        dotain.setOnClickListener(v   -> startActivityWithAnimation(DotainQuizActivity.class));
    }

    private void startActivityWithAnimation(Class<?> cls) {
        ActivityOptionsCompat options = ActivityOptionsCompat.makeCustomAnimation(
                this, R.anim.fade_in, R.anim.fade_out);
        startActivity(new Intent(this, cls), options.toBundle());
        finish();
    }

    @Override
    protected void onResume() {
        super.onResume();
        bindService(new Intent(this, MusicService.class), this, Context.BIND_AUTO_CREATE);
        startService(new Intent(this, MusicService.class));
    }

    @Override
    protected void onPause() {
        super.onPause();
        unbindService(this);
        stopService(new Intent(this, MusicService.class));
    }

    @Override
    public void onServiceConnected(ComponentName name, IBinder service) {
        MusicService.ServiceBinder binder = (MusicService.ServiceBinder) service;
        musicService = binder.getService();
    }

    @Override
    public void onServiceDisconnected(ComponentName name) {
        musicService = null;
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

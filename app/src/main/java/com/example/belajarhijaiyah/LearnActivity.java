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

import com.example.belajarhijaiyah.belajar.DhotainLearningActivity;
import com.example.belajarhijaiyah.belajar.DhommahLearningActivity;
import com.example.belajarhijaiyah.belajar.FatainLearningActivity;
import com.example.belajarhijaiyah.belajar.FathahLearningActivity;
import com.example.belajarhijaiyah.belajar.HijaiyahLearningActivity;
import com.example.belajarhijaiyah.belajar.KastainLearningActivity;
import com.example.belajarhijaiyah.belajar.KasrohLearningActivity;

public class LearnActivity extends AppCompatActivity implements ServiceConnection {

    private ImageButton hijaiyah, fathah, kasroh, dhommah, tanwin1, tanwin2, tanwin3, backButton;
    private Animation bounce;
    private MusicService musicService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_learn);
        hideSystemBars();

        bounce = AnimationUtils.loadAnimation(this, R.anim.bounce);
        initializeViews();
        setupClickListeners();
    }

    private void initializeViews() {
        backButton  = findViewById(R.id.back_button);
        hijaiyah = findViewById(R.id.menu_hijaiyah);
        fathah   = findViewById(R.id.menu_fathah);
        kasroh   = findViewById(R.id.menu_kasroh);
        dhommah  = findViewById(R.id.menu_dhomah);
        tanwin1  = findViewById(R.id.menu_tanwin1);
        tanwin2  = findViewById(R.id.menu_tanwin2);
        tanwin3  = findViewById(R.id.menu_tanwin3);
    }

    private void setupClickListeners() {
        backButton.setOnClickListener(v -> {
            v.startAnimation(bounce);
            finish();
        });

        hijaiyah.setOnClickListener(v -> startActivityWithAnimation(HijaiyahLearningActivity.class));
        fathah.setOnClickListener(v  -> startActivityWithAnimation(FathahLearningActivity.class));
        kasroh.setOnClickListener(v  -> startActivityWithAnimation(KasrohLearningActivity.class));
        dhommah.setOnClickListener(v -> startActivityWithAnimation(DhommahLearningActivity.class));
        tanwin1.setOnClickListener(v -> startActivityWithAnimation(FatainLearningActivity.class));
        tanwin2.setOnClickListener(v -> startActivityWithAnimation(KastainLearningActivity.class));
        tanwin3.setOnClickListener(v -> startActivityWithAnimation(DhotainLearningActivity.class));
    }

    private void startActivityWithAnimation(Class<?> cls) {
        ActivityOptionsCompat options = ActivityOptionsCompat.makeCustomAnimation(
                this, R.anim.fade_in, R.anim.fade_out);
        startActivity(new Intent(this, cls), options.toBundle());
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

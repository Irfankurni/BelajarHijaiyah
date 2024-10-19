package com.example.belajarhijaiyah;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageButton;

import com.example.belajarhijaiyah.belajar.DhoTainActivity;
import com.example.belajarhijaiyah.belajar.DhommahActivity;
import com.example.belajarhijaiyah.belajar.FaTainActivity;
import com.example.belajarhijaiyah.belajar.FathahActivity;
import com.example.belajarhijaiyah.belajar.HIjaiyahActivity;
import com.example.belajarhijaiyah.belajar.KasTainActivity;
import com.example.belajarhijaiyah.belajar.KasrohActivity;

public class BelajarActivity extends AppCompatActivity implements ServiceConnection {

    private ImageButton hijaiyah, fathah, kasroh, dhommah, tanwin1, tanwin2, tanwin3, kembali;
    private Animation bounce;
    private MusicService mServ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_belajar);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        bounce = AnimationUtils.loadAnimation(this, R.anim.bounce);
        initializeViews();
        setupClickListeners();
    }

    private void initializeViews() {
        kembali = findViewById(R.id.kembali);
        hijaiyah = findViewById(R.id.menu_hijaiyah);
        fathah = findViewById(R.id.menu_fathah);
        kasroh = findViewById(R.id.menu_kasroh);
        dhommah = findViewById(R.id.menu_dhomah);
        tanwin1 = findViewById(R.id.menu_tanwin1);
        tanwin2 = findViewById(R.id.menu_tanwin2);
        tanwin3 = findViewById(R.id.menu_tanwin3);
    }

    private void setupClickListeners() {
        kembali.setOnClickListener(v -> {
            v.startAnimation(bounce);
            finish();
        });

        hijaiyah.setOnClickListener(v -> startActivityWithAnimation(HIjaiyahActivity.class));
        fathah.setOnClickListener(v -> startActivityWithAnimation(FathahActivity.class));
        kasroh.setOnClickListener(v -> startActivityWithAnimation(KasrohActivity.class));
        dhommah.setOnClickListener(v -> startActivityWithAnimation(DhommahActivity.class));
        tanwin1.setOnClickListener(v -> startActivityWithAnimation(FaTainActivity.class));
        tanwin2.setOnClickListener(v -> startActivityWithAnimation(KasTainActivity.class));
        tanwin3.setOnClickListener(v -> startActivityWithAnimation(DhoTainActivity.class));
    }

    private void startActivityWithAnimation(Class<?> cls) {
        Intent intent = new Intent(BelajarActivity.this, cls);
        startActivity(intent);
        overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
    }

    @Override
    protected void onResume() {
        super.onResume();
        bindService(new Intent(this, MusicService.class), this, Context.BIND_AUTO_CREATE);
        startService(new Intent(getApplicationContext(), MusicService.class));
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
        mServ = binder.getService();
    }

    @Override
    public void onServiceDisconnected(ComponentName name) {
        mServ = null;
    }
}

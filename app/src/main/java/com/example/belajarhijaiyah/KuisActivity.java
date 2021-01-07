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

import com.example.belajarhijaiyah.belajar.FathahActivity;
import com.example.belajarhijaiyah.kuis.KuisDhomahActivity;
import com.example.belajarhijaiyah.kuis.KuisDotainActivity;
import com.example.belajarhijaiyah.kuis.KuisFatainActivity;
import com.example.belajarhijaiyah.kuis.KuisFathahActivity;
import com.example.belajarhijaiyah.kuis.KuisHijaiyahActivity;
import com.example.belajarhijaiyah.kuis.KuisKasrohActivity;
import com.example.belajarhijaiyah.kuis.KuisKastainActivity;


public class KuisActivity extends AppCompatActivity implements ServiceConnection {
    ImageButton hijaiyah, fathah, kasroh, domah, fatain, kastain, dotain, kembali;
    Animation bounce;
    MusicService mServ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_latihan);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
//        stopService(new Intent(this, MusicService.class));

        bounce = AnimationUtils.loadAnimation(this,R.anim.bounce);
        hijaiyah = findViewById(R.id.kuis_hijaiyah);
        fathah = findViewById(R.id.kuis_fathah);
        kasroh = findViewById(R.id.kuis_kasroh);
        domah = findViewById(R.id.kuis_domah);
        fatain = findViewById(R.id.kuis_fathah_tain);
        kastain = findViewById(R.id.kuis_kasroh_tain);
        dotain = findViewById(R.id.kuis_domah_tain);
        kembali = findViewById(R.id.exit8);


        kembali.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.startAnimation(AnimationUtils.loadAnimation(getApplicationContext(),R.anim.bounce));
                finish();
                Intent service = new Intent(getApplicationContext(), MusicService.class);
//                getApplicationContext().startService(service);
            }
        });

        hijaiyah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hijaiyah.startAnimation(bounce);
                Intent hijaiyah = new Intent(KuisActivity.this, KuisHijaiyahActivity.class);
                startActivity(hijaiyah);
                finish();
            }
        });

        fathah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fathah.startAnimation(bounce);
                Intent fathah = new Intent(KuisActivity.this, KuisFathahActivity.class);
                startActivity(fathah);
                finish();
            }
        });

        kasroh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                kasroh.startAnimation(bounce);
                Intent kasroh = new Intent(KuisActivity.this, KuisKasrohActivity.class);
                startActivity(kasroh);
                finish();
            }
        });

        domah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                domah.startAnimation(bounce);
                Intent domah = new Intent(KuisActivity.this, KuisDhomahActivity.class);
                startActivity(domah);
                finish();
            }
        });

        fatain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fatain.startAnimation(bounce);
                Intent fatain = new Intent(KuisActivity.this, KuisFatainActivity.class);
                startActivity(fatain);
                finish();
            }
        });

        kastain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                kastain.startAnimation(bounce);
                Intent kastain = new Intent(KuisActivity.this, KuisKastainActivity.class);
                startActivity(kastain);
                finish();
            }
        });

        dotain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dotain.startAnimation(bounce);
                Intent dotain = new Intent(KuisActivity.this, KuisDotainActivity.class);
                startActivity(dotain);
                finish();
            }
        });

    }

    @Override
    protected void onResume() {
        super.onResume();
        Intent intent= new Intent(this, MainActivity.class);
        bindService(intent, this, Context.BIND_AUTO_CREATE);
        Intent service = new Intent(getApplicationContext(), MusicService.class);
        getApplicationContext().startService(service);
    }
    @Override
    protected void onPause() {
        super.onPause();
        unbindService(this);
        stopService(new Intent(this, MusicService.class));
    }
    @Override
    public void onServiceConnected(ComponentName name, IBinder service) {
        MusicService.ServiceBinder b = (MusicService.ServiceBinder) service;
        mServ = b.getService();

    }

    @Override
    public void onServiceDisconnected(ComponentName name) {
        mServ = null;
    }
}

package com.example.belajarhijaiyah;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
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


public class KuisActivity extends AppCompatActivity {
    ImageButton hijaiyah, fathah, kasroh, domah, fatain, kastain, dotain, kembali;
    Animation bounce;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_latihan);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

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
}

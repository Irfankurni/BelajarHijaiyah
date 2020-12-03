package com.example.belajarhijaiyah;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
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

public class BelajarActivity extends AppCompatActivity {
    ImageButton hijaiyah, fathah, kasroh, dhommah, tanwin1, tanwin2, tanwin3, kembali;
    Animation bounce;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_belajar);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        bounce = AnimationUtils.loadAnimation(this,R.anim.bounce);


        kembali = findViewById(R.id.kembali);
        kembali.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        hijaiyah = findViewById(R.id.menu_hijaiyah);
        hijaiyah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                hijaiyah.startAnimation(bounce);
                Intent hijaiyah = new Intent(BelajarActivity.this, HIjaiyahActivity.class);
                startActivity(hijaiyah);
            }
        });
        fathah = findViewById(R.id.menu_fathah);
        fathah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                fathah.startAnimation(bounce);
                Intent fathah = new Intent(BelajarActivity.this, FathahActivity.class);
                startActivity(fathah);
            }
        });
        kasroh = findViewById(R.id.menu_kasroh);
        kasroh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                kasroh.startAnimation(bounce);
                Intent kasroh = new Intent(BelajarActivity.this, KasrohActivity.class);
                startActivity(kasroh);
            }
        });
        dhommah = findViewById(R.id.menu_dhomah);
        dhommah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                dhommah.startAnimation(bounce);
                Intent dhomah = new Intent(BelajarActivity.this, DhommahActivity.class);
                startActivity(dhomah);
            }
        });
        tanwin1 = findViewById(R.id.menu_tanwin1);
        tanwin1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                tanwin1.startAnimation(bounce);
                Intent tanwin1 = new Intent(BelajarActivity.this, FaTainActivity.class);
                startActivity(tanwin1);
            }
        });
        tanwin2 = findViewById(R.id.menu_tanwin2);
        tanwin2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                tanwin2.startAnimation(bounce);
                Intent tanwin2 = new Intent(BelajarActivity.this, KasTainActivity.class);
                startActivity(tanwin2);
            }
        });
        tanwin3 = findViewById(R.id.menu_tanwin3);
        tanwin3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                tanwin3.startAnimation(bounce);
                Intent tanwin3 = new Intent(BelajarActivity.this, DhoTainActivity.class);
                startActivity(tanwin3);
            }
        });

    }
}

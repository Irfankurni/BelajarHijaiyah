package com.example.belajarhijaiyah;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {
    ImageButton belajar, kuis;
    Animation bounce;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        bounce = AnimationUtils.loadAnimation(this,R.anim.bounce);

        belajar = findViewById(R.id.belajar);
        kuis = findViewById(R.id.kuis);

        belajar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent belajar = new Intent(MainActivity.this, BelajarActivity.class);
                startActivity(belajar);
            }
        });

        kuis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                kuis.startAnimation(bounce);
                Intent latihan = new Intent(MainActivity.this, KuisActivity.class);
                startActivity(latihan);
            }
        });

    }
    @Override
    public void onBackPressed() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(false);
        builder.setMessage("Do you want to Exit?");
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                //if user pressed "yes", then he is allowed to exit from application
                System.exit(0);
                finish();
            }
        });
        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                //if user select "No", just cancel this dialog and continue with app
                dialog.cancel();
            }
        });
        AlertDialog alert = builder.create();
        alert.show();
    }
}

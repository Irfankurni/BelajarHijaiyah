package com.example.belajarhijaiyah;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.ComponentName;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.ServiceConnection;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.IBinder;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.AnimationUtils;
import android.view.animation.BounceInterpolator;
import android.widget.ImageButton;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity implements ServiceConnection {
    ImageButton belajar, kuis, info, exit;
    MediaPlayer mp;
    MusicService mServ;
    Dialog dialog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        belajar = findViewById(R.id.belajar);
        kuis = findViewById(R.id.kuis);
        exit = findViewById(R.id.exit);
        dialog = new Dialog(this);
        info = findViewById(R.id.info);
        belajar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.startAnimation(AnimationUtils.loadAnimation(getApplicationContext(),R.anim.bounce));
                Intent belajar = new Intent(MainActivity.this, BelajarActivity.class);
                startActivity(belajar);
            }

        });
        kuis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.startAnimation(AnimationUtils.loadAnimation(getApplicationContext(),R.anim.bounce));
                Intent latihan = new Intent(MainActivity.this, KuisActivity.class);
                startActivity(latihan);
            }
        });
        info.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openInfo();
            }
        });
        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.startAnimation(AnimationUtils.loadAnimation(getApplicationContext(),R.anim.bounce));
                onBackPressed();
            }
        });
        Animation();
    }

    private void openInfo(){
        dialog.setContentView(R.layout.about);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        ImageView ivclose = dialog.findViewById(R.id.exit1);
        ivclose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
        dialog.show();
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
    private void Animation() {
        ObjectAnimator scaleY = ObjectAnimator.ofFloat(belajar, "scaleY", 0.8f);
        scaleY.setDuration(200);
        ObjectAnimator scaleYBack = ObjectAnimator.ofFloat(belajar, "scaleY", 1f);
        scaleYBack.setDuration(500);
        scaleYBack.setInterpolator(new BounceInterpolator());
        ObjectAnimator skalaY = ObjectAnimator.ofFloat(kuis, "scaleY", 0.8f);
        skalaY.setDuration(200);
        ObjectAnimator skalaYBack = ObjectAnimator.ofFloat(kuis, "scaleY", 1f);
        skalaYBack.setDuration(500);
        ObjectAnimator sY = ObjectAnimator.ofFloat(exit, "scaleY", 0.8f);
        skalaY.setDuration(200);
        ObjectAnimator sYBack = ObjectAnimator.ofFloat(exit, "scaleY", 1f);
        skalaYBack.setDuration(500);
        skalaYBack.setInterpolator(new BounceInterpolator());

        final AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.setStartDelay(800);
        animatorSet.playSequentially(scaleY, scaleYBack, skalaY, skalaYBack, sY, sYBack);
        animatorSet.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                animatorSet.setStartDelay(1500);
                animatorSet.start();
            }
        });
        belajar.setLayerType(View.LAYER_TYPE_HARDWARE, null);
        kuis.setLayerType(View.LAYER_TYPE_HARDWARE, null);
        animatorSet.start();
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

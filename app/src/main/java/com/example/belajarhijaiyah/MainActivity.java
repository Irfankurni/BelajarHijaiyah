package com.example.belajarhijaiyah;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.IBinder;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.view.animation.BounceInterpolator;
import android.widget.ImageButton;
import android.widget.ImageView;

import androidx.activity.OnBackPressedCallback;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.WindowCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.core.view.WindowInsetsControllerCompat;

public class MainActivity extends AppCompatActivity implements ServiceConnection {

    private ImageButton belajar, kuis, info, exit;
    private MusicService mServ;
    private Dialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        hideSystemBars();
        initializeViews();
        setupClickListeners();
        setupBackPressHandler();
        startAnimations();
    }

    private void initializeViews() {
        belajar = findViewById(R.id.belajar);
        kuis    = findViewById(R.id.kuis);
        exit    = findViewById(R.id.exit);
        info    = findViewById(R.id.info);
        dialog  = new Dialog(this);
    }

    private void setupClickListeners() {
        belajar.setOnClickListener(v -> {
            v.startAnimation(AnimationUtils.loadAnimation(this, R.anim.bounce));
            startActivity(new Intent(this, BelajarActivity.class));
        });

        kuis.setOnClickListener(v -> {
            v.startAnimation(AnimationUtils.loadAnimation(this, R.anim.bounce));
            startActivity(new Intent(this, KuisActivity.class));
        });

        info.setOnClickListener(v -> openInfo());

        exit.setOnClickListener(v -> {
            v.startAnimation(AnimationUtils.loadAnimation(this, R.anim.bounce));
            showExitDialog();
        });
    }

    private void setupBackPressHandler() {
        getOnBackPressedDispatcher().addCallback(this, new OnBackPressedCallback(true) {
            @Override
            public void handleOnBackPressed() {
                showExitDialog();
            }
        });
    }

    private void openInfo() {
        dialog.setContentView(R.layout.about);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        ImageView ivClose = dialog.findViewById(R.id.exit1);
        ivClose.setOnClickListener(v -> dialog.dismiss());
        dialog.show();
    }

    private void showExitDialog() {
        new AlertDialog.Builder(this)
                .setCancelable(false)
                .setMessage("Do you want to Exit?")
                .setPositiveButton("Yes", (d, which) -> finishAffinity())
                .setNegativeButton("No", (d, which) -> d.cancel())
                .create()
                .show();
    }

    private void startAnimations() {
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.setStartDelay(800);
        animatorSet.playSequentially(
                createScaleAnimator(belajar, "scaleY", 0.8f, 200),
                createScaleAnimator(belajar, "scaleY", 1f,   500, new BounceInterpolator()),
                createScaleAnimator(kuis,    "scaleY", 0.8f, 200),
                createScaleAnimator(kuis,    "scaleY", 1f,   500, new BounceInterpolator()),
                createScaleAnimator(exit,    "scaleY", 0.8f, 200),
                createScaleAnimator(exit,    "scaleY", 1f,   500, new BounceInterpolator())
        );

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

    private ObjectAnimator createScaleAnimator(View view, String property, float value, long duration) {
        return ObjectAnimator.ofFloat(view, property, value).setDuration(duration);
    }

    private ObjectAnimator createScaleAnimator(View view, String property, float value, long duration, BounceInterpolator interpolator) {
        ObjectAnimator animator = createScaleAnimator(view, property, value, duration);
        animator.setInterpolator(interpolator);
        return animator;
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
        mServ = binder.getService();
    }

    @Override
    public void onServiceDisconnected(ComponentName name) {
        mServ = null;
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

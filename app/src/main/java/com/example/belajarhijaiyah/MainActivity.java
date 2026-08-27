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

    private ImageButton learnButton, quizButton, info, exit;
    private MusicService musicService;
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
        learnButton = findViewById(R.id.learn_button);
        quizButton    = findViewById(R.id.quiz_button);
        exit    = findViewById(R.id.exit);
        info    = findViewById(R.id.info);
        dialog  = new Dialog(this);
    }

    private void setupClickListeners() {
        learnButton.setOnClickListener(v -> {
            v.startAnimation(AnimationUtils.loadAnimation(this, R.anim.bounce));
            startActivity(new Intent(this, LearnActivity.class));
        });

        quizButton.setOnClickListener(v -> {
            v.startAnimation(AnimationUtils.loadAnimation(this, R.anim.bounce));
            startActivity(new Intent(this, QuizMenuActivity.class));
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
                createScaleAnimator(learnButton, "scaleY", 0.8f, 200),
                createScaleAnimator(learnButton, "scaleY", 1f,   500, new BounceInterpolator()),
                createScaleAnimator(quizButton,    "scaleY", 0.8f, 200),
                createScaleAnimator(quizButton,    "scaleY", 1f,   500, new BounceInterpolator()),
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

        learnButton.setLayerType(View.LAYER_TYPE_HARDWARE, null);
        quizButton.setLayerType(View.LAYER_TYPE_HARDWARE, null);
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
        musicService = binder.getService();
    }

    @Override
    public void onServiceDisconnected(ComponentName name) {
        musicService = null;
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

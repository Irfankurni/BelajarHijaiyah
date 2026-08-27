package com.example.belajarhijaiyah;

import android.media.AudioAttributes;
import android.media.MediaPlayer;
import android.media.SoundPool;
import android.os.Bundle;
import android.util.SparseArray;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageButton;
import android.widget.ImageView;

import androidx.activity.OnBackPressedCallback;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.WindowCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.core.view.WindowInsetsControllerCompat;

import java.util.Map;

/**
 * Abstract base class for all Belajar (Learning) screens.
 *
 * Subclasses only need to provide:
 *   - getLayoutId()           – the layout resource
 *   - getImageViewId()        – the id of the central ImageView that shows the popup
 *   - getBackButtonId()       – the id of the "kembali" button
 *   - buildLetterMap()        – SparseArray of viewId → LetterItem (drawable + sound raw res)
 */
public abstract class BaseLearningActivity extends AppCompatActivity
        implements View.OnClickListener {

    // ── Fields ──────────────────────────────────────────────────────────────
    private SoundPool soundPool;
    private MediaPlayer backgroundPlayer;
    private ImageView displayImage;
    private Animation scaleAnimation;
    private SparseArray<LetterItem> letterMap;

    // ── Abstract API ─────────────────────────────────────────────────────────
    protected abstract int getLayoutId();
    protected abstract int getImageViewId();
    protected abstract int getBackButtonId();
    /** Return a map of: viewId → LetterItem(drawableRes, soundRawRes) */
    protected abstract SparseArray<LetterItem> buildLetterMap();

    // ── Lifecycle ────────────────────────────────────────────────────────────
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
        hideSystemBars();
        setupBackPressHandler();

        scaleAnimation = AnimationUtils.loadAnimation(this, R.anim.anim_scale);
        displayImage = findViewById(getImageViewId());

        // Build SoundPool
        AudioAttributes audioAttributes = new AudioAttributes.Builder()
                .setUsage(AudioAttributes.USAGE_GAME)
                .setContentType(AudioAttributes.CONTENT_TYPE_MUSIC)
                .build();
        soundPool = new SoundPool.Builder()
                .setMaxStreams(28)
                .setAudioAttributes(audioAttributes)
                .build();

        // Load all letter sounds and register click listeners
        letterMap = buildLetterMap();
        for (int i = 0; i < letterMap.size(); i++) {
            int viewId = letterMap.keyAt(i);
            LetterItem item = letterMap.valueAt(i);
            item.setSoundPoolId(soundPool.load(this, item.soundRes, 1));

            View btn = findViewById(viewId);
            if (btn != null) {
                btn.setOnClickListener(this);
            }
        }
    }

    @Override
    public void onClick(View v) {
        LetterItem item = letterMap.get(v.getId());
        if (item != null) {
            displayImage.setImageResource(item.drawableRes);
            displayImage.startAnimation(scaleAnimation);
            soundPool.play(item.getSoundPoolId(), 1, 1, 0, 0, 1);
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (backgroundPlayer == null) {
            backgroundPlayer = MediaPlayer.create(this, R.raw.backsound);
            if (backgroundPlayer != null) {
                backgroundPlayer.setVolume(0.06f, 0.06f);
                backgroundPlayer.setLooping(true);
                backgroundPlayer.start();
            }
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        releaseBackgroundPlayer();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        releaseBackgroundPlayer();
        if (soundPool != null) {
            soundPool.release();
            soundPool = null;
        }
    }

    // ── Helpers ───────────────────────────────────────────────────────────────

    private void releaseBackgroundPlayer() {
        if (backgroundPlayer != null) {
            if (backgroundPlayer.isPlaying()) {
                backgroundPlayer.stop();
            }
            backgroundPlayer.release();
            backgroundPlayer = null;
        }
    }

    /**
     * Hide status bar and navigation bar using the modern WindowInsetsController API.
     * Replaces the deprecated FLAG_FULLSCREEN approach.
     */
    private void hideSystemBars() {
        WindowCompat.setDecorFitsSystemWindows(getWindow(), false);
        WindowInsetsControllerCompat controller =
                WindowCompat.getInsetsController(getWindow(), getWindow().getDecorView());
        controller.hide(WindowInsetsCompat.Type.systemBars());
        controller.setSystemBarsBehavior(
                WindowInsetsControllerCompat.BEHAVIOR_SHOW_TRANSIENT_BARS_BY_SWIPE);
    }

    /**
     * Register back-press behavior on the "kembali" button using the modern
     * OnBackPressedCallback API (replaces deprecated onBackPressed() override).
     */
    private void setupBackPressHandler() {
        ImageButton backButton = findViewById(getBackButtonId());
        if (backButton != null) {
            Animation bounceAnim = AnimationUtils.loadAnimation(this, R.anim.bounce);
            backButton.setOnClickListener(v -> {
                v.startAnimation(bounceAnim);
                finish();
            });
        }

        getOnBackPressedDispatcher().addCallback(this, new OnBackPressedCallback(true) {
            @Override
            public void handleOnBackPressed() {
                finish();
            }
        });
    }
}

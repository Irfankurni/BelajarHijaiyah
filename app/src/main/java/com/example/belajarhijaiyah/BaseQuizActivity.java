package com.example.belajarhijaiyah;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.media.AudioAttributes;
import android.media.MediaPlayer;
import android.media.SoundPool;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.OnBackPressedCallback;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.WindowCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.core.view.WindowInsetsControllerCompat;

import com.example.belajarhijaiyah.constant.Constants;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Objects;
import java.util.Random;

/**
 * Abstract base class for all Kuis (Quiz) screens.
 *
 * Subclasses only need to provide:
 *   - getLayoutId()    – the layout resource
 *   - getQuizData()    – the 2-D String[][] quiz data from Soal.*
 */
public abstract class BaseQuizActivity extends AppCompatActivity {

    // ── Fields ──────────────────────────────────────────────────────────────
    private SoundPool soundPool;
    private int finishSoundId;
    private MediaPlayer backgroundPlayer;

    // Current question state
    private MediaPlayer questionPlayer;
    private String rightAnswer;
    private int rightAnswerCount = 0;
    private int quizCount = 1;
    private final ArrayList<ArrayList<String>> quizList = new ArrayList<>();

    // Views (resolved in onCreate)
    private TextView countLabel;
    private ImageButton questionButton;
    private Button ansButton1, ansButton2, ansButton3, ansButton4;

    // ── Abstract API ─────────────────────────────────────────────────────────
    protected abstract int getLayoutId();
    protected abstract String[][] getQuizData();

    // ── Lifecycle ────────────────────────────────────────────────────────────
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
        hideSystemBars();

        // SoundPool for finish jingle
        AudioAttributes audioAttributes = new AudioAttributes.Builder()
                .setUsage(AudioAttributes.USAGE_GAME)
                .setContentType(AudioAttributes.CONTENT_TYPE_MUSIC)
                .build();
        soundPool = new SoundPool.Builder()
                .setMaxStreams(3)
                .setAudioAttributes(audioAttributes)
                .build();
        finishSoundId = soundPool.load(this, R.raw.sound_selesai, 1);

        // Bind views
        countLabel = findViewById(R.id.countLabel);
        questionButton = findViewById(R.id.suara);
        ansButton1 = findViewById(R.id.ansButton1);
        ansButton2 = findViewById(R.id.ansButton2);
        ansButton3 = findViewById(R.id.ansButton3);
        ansButton4 = findViewById(R.id.ansButton4);

        // Close / back button
        ImageButton closeButton = findViewById(R.id.exit8);
        if (closeButton != null) {
            closeButton.setOnClickListener(v -> navigateToKuis());
        }
        getOnBackPressedDispatcher().addCallback(this, new OnBackPressedCallback(true) {
            @Override
            public void handleOnBackPressed() {
                navigateToKuis();
            }
        });

        // Attach answer listeners
        View.OnClickListener answerListener = this::checkAnswer;
        ansButton1.setOnClickListener(answerListener);
        ansButton2.setOnClickListener(answerListener);
        ansButton3.setOnClickListener(answerListener);
        ansButton4.setOnClickListener(answerListener);

        // Build quiz list from data
        for (String[] row : getQuizData()) {
            ArrayList<String> entry = new ArrayList<>();
            for (String cell : row) {
                entry.add(cell);
            }
            quizList.add(entry);
        }

        showNextQuiz();
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (backgroundPlayer == null) {
            backgroundPlayer = MediaPlayer.create(this, R.raw.backsound);
            if (backgroundPlayer != null) {
                backgroundPlayer.setVolume(0.05f, 0.05f);
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
        releaseQuestionPlayer();
        if (soundPool != null) {
            soundPool.release();
            soundPool = null;
        }
    }

    // ── Quiz Logic ────────────────────────────────────────────────────────────

    private void showNextQuiz() {
        countLabel.setText(quizCount + "/" + Constants.QUIZ_COUNT);

        // Pick a random question
        Random random = new Random();
        int randomIndex = random.nextInt(quizList.size());
        ArrayList<String> quiz = quizList.get(randomIndex);

        // Load and play question audio
        releaseQuestionPlayer();
        int resId = getResources().getIdentifier(quiz.get(0), "raw", getPackageName());
        questionPlayer = MediaPlayer.create(getApplicationContext(), resId);
        if (questionPlayer != null) {
            questionPlayer.start();
            questionButton.setOnClickListener(v -> {
                if (questionPlayer != null) {
                    // Restart from beginning on replay tap
                    questionPlayer.seekTo(0);
                    questionPlayer.start();
                }
            });
        }

        // Store the correct answer, then remove the key, shuffle answers
        rightAnswer = quiz.get(1);
        quiz.remove(0); // remove the audio-key element
        Collections.shuffle(quiz);
        ansButton1.setText(quiz.get(0));
        ansButton2.setText(quiz.get(1));
        ansButton3.setText(quiz.get(2));
        ansButton4.setText(quiz.get(3));

        // Remove used question from pool
        quizList.remove(randomIndex);
    }

    private void checkAnswer(View view) {
        Button tapped = (Button) view;
        String answer = tapped.getText().toString();

        if (answer.equals(rightAnswer)) {
            Toast.makeText(this, Constants.ANS_RIGHT, Toast.LENGTH_SHORT).show();
            rightAnswerCount++;
        } else {
            Toast.makeText(this, Constants.ANS_WRONG, Toast.LENGTH_SHORT).show();
        }

        if (quizCount == Constants.QUIZ_COUNT) {
            Toast.makeText(this, Constants.FINISH, Toast.LENGTH_SHORT).show();
            soundPool.play(finishSoundId, 1, 1, 0, 0, 1);
            showResult();
        } else {
            quizCount++;
            showNextQuiz();
        }
    }

    private void showResult() {
        AlertDialog dialog = new AlertDialog.Builder(this).create();
        dialog.setCancelable(false);
        Objects.requireNonNull(dialog.getWindow())
                .setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

        View dialogLayout = LayoutInflater.from(this).inflate(R.layout.skor_kuis, null);
        dialog.setView(dialogLayout);

        // Score display
        int score = rightAnswerCount;
        SharedPreferences prefs = getSharedPreferences(Constants.PREF_NAME, Context.MODE_PRIVATE);
        int totalScore = prefs.getInt(Constants.PREF_TOTAL_SCORE, 0) + score;

        ((TextView) dialogLayout.findViewById(R.id.resultLabel))
                .setText(score + "/" + Constants.QUIZ_COUNT);
        ((TextView) dialogLayout.findViewById(R.id.totalScoreLabel))
                .setText("Total Skor : " + totalScore);

        // Persist new total
        prefs.edit().putInt(Constants.PREF_TOTAL_SCORE, totalScore).apply();

        // Buttons
        Button cobaLagi = dialogLayout.findViewById(R.id.button);
        Button close = dialogLayout.findViewById(R.id.exit);
        cobaLagi.setOnClickListener(v -> recreate());
        close.setOnClickListener(v -> navigateToKuis());

        dialog.show();
    }

    // ── Navigation ────────────────────────────────────────────────────────────

    private void navigateToKuis() {
        startActivity(new Intent(this, KuisActivity.class));
        finish();
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

    private void releaseQuestionPlayer() {
        if (questionPlayer != null) {
            if (questionPlayer.isPlaying()) {
                questionPlayer.stop();
            }
            questionPlayer.release();
            questionPlayer = null;
        }
    }

    /**
     * Hide status bar and navigation bar using the modern WindowInsetsController API.
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

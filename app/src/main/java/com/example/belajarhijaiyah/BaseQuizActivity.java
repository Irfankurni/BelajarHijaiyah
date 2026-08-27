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
import java.util.Objects;
import java.util.Random;

/**
 * Abstract base class for all Kuis (Quiz) screens.
 *
 * Subclasses only need to provide:
 *   - getLayoutId()    – the layout resource
 *   - getQuizData()    – the 2-D String[][] quiz data from QuizData.*
 */
public abstract class BaseQuizActivity extends AppCompatActivity {

    // ── Fields ──────────────────────────────────────────────────────────────
    private SoundPool soundPool;
    private int finishSoundId;
    private MediaPlayer backgroundPlayer;

    // Current question state
    private MediaPlayer questionPlayer;
    private String correctAnswer;
    private int correctAnswerCount = 0;
    private int questionNumber = 1;
    private final ArrayList<ArrayList<String>> questionPool = new ArrayList<>();

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
        finishSoundId = soundPool.load(this, R.raw.sound_finish, 1);

        // Bind views
        countLabel = findViewById(R.id.question_counter_label);
        questionButton = findViewById(R.id.play_sound_button);
        ansButton1 = findViewById(R.id.answer_button_1);
        ansButton2 = findViewById(R.id.answer_button_2);
        ansButton3 = findViewById(R.id.answer_button_3);
        ansButton4 = findViewById(R.id.answer_button_4);

        // Close / back button
        ImageButton closeButton = findViewById(R.id.close_button);
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
            questionPool.add(entry);
        }

        // Shuffle the question pool so questions appear in random order
        fisherYatesShuffle(questionPool);

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

    /**
     * Fisher-Yates shuffle algorithm for an ArrayList.
     * Produces a uniformly random permutation in O(n) time.
     */
    private <T> void fisherYatesShuffle(ArrayList<T> list) {
        Random random = new Random();
        for (int i = list.size() - 1; i > 0; i--) {
            int j = random.nextInt(i + 1);
            T temp = list.get(i);
            list.set(i, list.get(j));
            list.set(j, temp);
        }
    }

    private void showNextQuiz() {
        countLabel.setText(questionNumber + "/" + Constants.QUIZ_COUNT);

        // Take the next question from the (already shuffled) pool
        ArrayList<String> quiz = questionPool.get(0);

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

        // Store the correct answer (index 1), then build answer choices list
        correctAnswer = quiz.get(1);

        // Build a separate list of answer choices so we don't mutate questionPool entries
        ArrayList<String> choices = new ArrayList<>();
        for (int i = 1; i < quiz.size(); i++) {
            choices.add(quiz.get(i));
        }

        // Fisher-Yates shuffle the answer choices so the correct answer
        // is never stuck in the same button position
        fisherYatesShuffle(choices);

        ansButton1.setText(choices.get(0));
        ansButton2.setText(choices.get(1));
        ansButton3.setText(choices.get(2));
        ansButton4.setText(choices.get(3));

        // Remove used question from pool
        questionPool.remove(0);
    }

    private void checkAnswer(View view) {
        Button tapped = (Button) view;
        String answer = tapped.getText().toString();

        if (answer.equals(correctAnswer)) {
            Toast.makeText(this, Constants.ANS_RIGHT, Toast.LENGTH_SHORT).show();
            correctAnswerCount++;
        } else {
            Toast.makeText(this, Constants.ANS_WRONG, Toast.LENGTH_SHORT).show();
        }

        if (questionNumber == Constants.QUIZ_COUNT) {
            Toast.makeText(this, Constants.FINISH, Toast.LENGTH_SHORT).show();
            soundPool.play(finishSoundId, 1, 1, 0, 0, 1);
            showResult();
        } else {
            questionNumber++;
            showNextQuiz();
        }
    }

    private void showResult() {
        AlertDialog dialog = new AlertDialog.Builder(this).create();
        dialog.setCancelable(false);
        Objects.requireNonNull(dialog.getWindow())
                .setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

        View dialogLayout = LayoutInflater.from(this).inflate(R.layout.quiz_score_dialog, null);
        dialog.setView(dialogLayout);

        // Score display
        int score = correctAnswerCount;
        SharedPreferences prefs = getSharedPreferences(Constants.PREF_NAME, Context.MODE_PRIVATE);
        int totalScore = prefs.getInt(Constants.PREF_TOTAL_SCORE, 0) + score;

        ((TextView) dialogLayout.findViewById(R.id.result_label))
                .setText(score + "/" + Constants.QUIZ_COUNT);
        ((TextView) dialogLayout.findViewById(R.id.total_score_label))
                .setText("Total Score: " + totalScore);

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
        startActivity(new Intent(this, QuizMenuActivity.class));
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

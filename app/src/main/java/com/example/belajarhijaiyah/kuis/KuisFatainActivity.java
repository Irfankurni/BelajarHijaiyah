package com.example.belajarhijaiyah.kuis;

import static com.example.belajarhijaiyah.constant.Constants.ANS_RIGHT;
import static com.example.belajarhijaiyah.constant.Constants.ANS_WRONG;
import static com.example.belajarhijaiyah.constant.Constants.FINISH;

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
import android.view.WindowManager;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.belajarhijaiyah.KuisActivity;
import com.example.belajarhijaiyah.R;
import com.example.belajarhijaiyah.constant.Soal;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Objects;
import java.util.Random;

public class KuisFatainActivity extends AppCompatActivity {
    private SoundPool soundPool;
    private TextView countLabel;
    private ImageButton questionLabel, close;
    private MediaPlayer audio;
    private Button ansButton1, ansButton2, ansButton3, ansButton4;
    private int suaraFinish;
    private String rightAnswer;
    private int rightAnswerCount = 0;
    private int quizCount = 1;
    private static final int QUIZ_COUNT = 5;
    private ArrayList<ArrayList<String>> quizArray = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kuis_fatain);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        initializeSoundPool();
        suaraFinish = soundPool.load(this, R.raw.sound_selesai, 1);
        initializeViews();
        setupQuizData();
        showNextQuiz();
    }

    private void initializeSoundPool() {
        AudioAttributes audioAttributes = new AudioAttributes.Builder()
                .setUsage(AudioAttributes.USAGE_GAME)
                .setContentType(AudioAttributes.CONTENT_TYPE_MUSIC)
                .build();
        soundPool = new SoundPool.Builder()
                .setMaxStreams(3)
                .setAudioAttributes(audioAttributes)
                .build();
    }

    private void initializeViews() {
        close = findViewById(R.id.exit8);
        close.setOnClickListener(v -> {
            v.startAnimation(AnimationUtils.loadAnimation(getApplicationContext(), R.anim.bounce));
            startActivity(new Intent(KuisFatainActivity.this, KuisActivity.class));
            finish();
        });

        countLabel = findViewById(R.id.countLabel);
        questionLabel = findViewById(R.id.suara);
        ansButton1 = findViewById(R.id.ansButton1);
        ansButton2 = findViewById(R.id.ansButton2);
        ansButton3 = findViewById(R.id.ansButton3);
        ansButton4 = findViewById(R.id.ansButton4);
    }

    private void setupQuizData() {
        for (String[] data : Soal.fatainData) {
            ArrayList<String> tmpArray = new ArrayList<>();
            Collections.addAll(tmpArray, data);
            quizArray.add(tmpArray);
        }
    }

    @SuppressWarnings("ResourceType")
    public void showNextQuiz() {
        countLabel.setText(String.format("%s/5", quizCount));
        Random random = new Random();
        int randomNum = random.nextInt(quizArray.size());
        ArrayList<String> quiz = quizArray.get(randomNum);

        int resID = getResources().getIdentifier(quiz.get(0), "raw", getPackageName());
        final MediaPlayer mp = MediaPlayer.create(getApplicationContext(), resID);
        mp.setOnPreparedListener(MediaPlayer::start);
        mp.prepareAsync();

        rightAnswer = quiz.get(1);
        quiz.remove(0);
        Collections.shuffle(quiz);
        ansButton1.setText(quiz.get(0));
        ansButton2.setText(quiz.get(1));
        ansButton3.setText(quiz.get(2));
        ansButton4.setText(quiz.get(3));
        quizArray.remove(randomNum);

        questionLabel.setOnClickListener(v -> mp.start());
    }

    public void checkAnswer(View view) {
        Button ansButton = findViewById(view.getId());
        String btnText = ansButton.getText().toString();
        if (btnText.equals(rightAnswer)) {
            Toast.makeText(KuisFatainActivity.this, ANS_RIGHT, Toast.LENGTH_SHORT).show();
            rightAnswerCount++;
        } else {
            Toast.makeText(KuisFatainActivity.this, ANS_WRONG, Toast.LENGTH_SHORT).show();
        }

        if (quizCount == QUIZ_COUNT) {
            Toast.makeText(KuisFatainActivity.this, FINISH, Toast.LENGTH_SHORT).show();
            soundPool.play(suaraFinish, 1, 1, 0, 0, 1);
            showResult();
        } else {
            quizCount++;
            showNextQuiz();
        }
    }

    public void showResult() {
        AlertDialog builder = new AlertDialog.Builder(this).create();
        LayoutInflater inflater = getLayoutInflater();
        builder.setCancelable(false);
        Objects.requireNonNull(builder.getWindow()).setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        View dialogLayout = inflater.inflate(R.layout.skor_kuis, null);
        final TextView resultLabel = dialogLayout.findViewById(R.id.resultLabel);
        final TextView totalScoreLabel = dialogLayout.findViewById(R.id.totalScoreLabel);
        Button cobaLagi = dialogLayout.findViewById(R.id.button);
        Button close = dialogLayout.findViewById(R.id.exit);
        int score = rightAnswerCount;
        SharedPreferences settings = getSharedPreferences("belajarngaji", Context.MODE_PRIVATE);

        int totalScore = settings.getInt("Skor Anda", 0);
        totalScore += score;
        resultLabel.setText(String.format("%s/5",score));
        totalScoreLabel.setText(String.format("Total Skor : %s", totalScore));

        // Update the totalScore
        SharedPreferences.Editor editor = settings.edit();
        editor.putInt("totalScore", totalScore);
        editor.apply();

        builder.setView(dialogLayout);

        cobaLagi.setOnClickListener(v -> recreate());
        close.setOnClickListener(v -> {
            Intent exit = new Intent(KuisFatainActivity.this, KuisActivity.class);
            startActivity(exit);
            finish();
        });

        builder.show();
    }

    @Override
    protected void onResume() {
        super.onResume();
        audio = MediaPlayer.create(this, R.raw.backsound);
        audio.setVolume(0.05f, 0.05f);
        audio.setLooping(true);
        audio.start();
    }

    @Override
    protected void onPause() {
        super.onPause();
        if (audio != null) {
            audio.stop();
            audio.release();
            audio = null;
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (soundPool != null) {
            soundPool.release();
            soundPool = null;
        }
        if (audio != null) {
            audio.release();
            audio = null;
        }
    }
}

package com.example.belajarhijaiyah.kuis;

import androidx.appcompat.app.AppCompatActivity;

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
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.belajarhijaiyah.KuisActivity;
import com.example.belajarhijaiyah.R;
import com.example.belajarhijaiyah.constant.Constants;
import com.example.belajarhijaiyah.constant.Soal;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Objects;
import java.util.Random;

public class KuisKastainActivity extends AppCompatActivity {
    private static final int QUIZ_COUNT = 5;
    private static final int MAX_STREAMS = 3;
    private static final int SOUND_PRIORITY = 1;
    private static final int SOUND_QUALITY = 0;

    private SoundPool soundPool;
    private TextView countLabel;
    private ImageButton questionLabel, close;
    private String rightAnswer;
    MediaPlayer audio;
    private Button ansButton1, ansButton2, ansButton3, ansButton4;
    private int suaraFinish, rightAnswerCount = 0, quizCount = 1;
    private final ArrayList<ArrayList<String>> quizArray = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kuis_kastain);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        AudioAttributes audioAttributes = new AudioAttributes.Builder()
                .setUsage(AudioAttributes.USAGE_GAME).setContentType(AudioAttributes.CONTENT_TYPE_MUSIC).build();
        soundPool = new SoundPool.Builder()
                .setMaxStreams(MAX_STREAMS)
                .setAudioAttributes(audioAttributes).build();

        suaraFinish = soundPool.load(this, R.raw.sound_selesai, SOUND_PRIORITY);

        close = findViewById(R.id.exit8);
        close.setOnClickListener(v -> {
            v.startAnimation(AnimationUtils.loadAnimation(getApplicationContext(), R.anim.bounce));
            startActivity(new Intent(KuisKastainActivity.this, KuisActivity.class));
            finish();
        });

        countLabel = findViewById(R.id.countLabel);
        questionLabel = findViewById(R.id.suara);
        ansButton1 = findViewById(R.id.ansButton1);
        ansButton2 = findViewById(R.id.ansButton2);
        ansButton3 = findViewById(R.id.ansButton3);
        ansButton4 = findViewById(R.id.ansButton4);

        for (int i = 0; i< Soal.kastain.length; i++){
            ArrayList<String> tmpArray=new ArrayList<>();
            tmpArray.add(Soal.kastain[i][0]);
            tmpArray.add(Soal.kastain[i][1]);
            tmpArray.add(Soal.kastain[i][2]);
            tmpArray.add(Soal.kastain[i][3]);
            tmpArray.add(Soal.kastain[i][4]);

            // Membuat tmpArray ke QuizArray
            quizArray.add(tmpArray);
        }
        showNextQuiz();
    }
    public void showNextQuiz() {
        countLabel.setText(quizCount + "/5");

        Random random =new Random();
        int randomNum=random.nextInt(quizArray.size());
        ArrayList<String> Quiz = quizArray.get(randomNum);

        int resID = getResources().getIdentifier(Quiz.get(0),"raw", getPackageName());
        final MediaPlayer mp = MediaPlayer.create(getApplicationContext(), resID);
        try{
            mp.prepareAsync();
        } catch (IllegalStateException e){
            e.printStackTrace();
        }
        mp.start();
        Log.i("Acak", "Soal"+Quiz);
        rightAnswer=Quiz.get(1);
        Quiz.remove(0);
        Collections.shuffle(Quiz);
        ansButton1.setText(Quiz.get(0));
        ansButton2.setText(Quiz.get(1));
        ansButton3.setText(Quiz.get(2));
        ansButton4.setText(Quiz.get(3));
        quizArray.remove(randomNum);

        questionLabel.setOnClickListener(view -> mp.start());
        ansButton1.setOnClickListener(this::checkAnswer);
        ansButton2.setOnClickListener(this::checkAnswer);
        ansButton3.setOnClickListener(this::checkAnswer);
        ansButton4.setOnClickListener(this::checkAnswer);
    }
    public void checkAnswer(View view){
        Button ansButton = findViewById(view.getId());
        String btntxt = ansButton.getText().toString();
        if(btntxt.equals(rightAnswer)){
            Toast.makeText(KuisKastainActivity.this, Constants.ANS_RIGHT, Toast.LENGTH_SHORT).show();
            rightAnswerCount++;
        }
        else{
            Toast.makeText(KuisKastainActivity.this, Constants.ANS_WRONG, Toast.LENGTH_SHORT).show();
        }
        if (quizCount == QUIZ_COUNT){
            Toast.makeText(KuisKastainActivity.this, Constants.FINISH, Toast.LENGTH_SHORT).show();
            soundPool.play(suaraFinish, 1, 1, 0, 0, 1);
            showResult();
        }
        else {
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

        int totalScore = settings.getInt("Skor Anda",0);
        totalScore+=score;
        resultLabel.setText(score + "/5");
        totalScoreLabel.setText("Total Skor :" + totalScore);

        SharedPreferences.Editor editor = settings.edit();
        editor.putInt("totalScore",totalScore);
        editor.apply();
        builder.setView(dialogLayout);


        cobaLagi.setOnClickListener(v -> recreate());
        close.setOnClickListener(v -> {
            Intent exit = new Intent(KuisKastainActivity.this, KuisActivity.class);
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
        audio.stop();
        audio.release();
    }
    @Override
    protected void onDestroy(){
        super.onDestroy();
        soundPool.release();
        soundPool = null;
        audio.release();
        audio = null;
    }
}
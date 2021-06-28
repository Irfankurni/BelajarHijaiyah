package com.example.belajarhijaiyah.kuis;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.media.AudioAttributes;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.SoundPool;
import android.os.Build;
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

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class KuisKastainActivity extends AppCompatActivity {
    SoundPool soundPool;
    TextView countLabel;
    ImageButton questionLabel, close;
    MediaPlayer audio;
    Button ansButton1, ansButton2, ansButton3, ansButton4;
    private int suaraFinish, Pertanyaan;
    private String rightAnswer;
    private int rightAnswerCount = 0;
    private int quizCount = 1;
    private final int QUIZ_COUNT = 5;
    ArrayList<ArrayList<String>> quizArray = new ArrayList<>();
    String[][] quizData = {
            {"kuiskastain_in",  "اٍ", "اَ", "ثِ", "ضَ"},
            {"kuiskastain_bin", "بٍ","نِ", "بَ", "ت"},
            {"kuiskastain_tin", "تٍ", "نَ", "ثِ", "بَ"},
            {"kuiskastain_tsin", "ثٍ", "ب", "نَ", "ثُ"},
            {"kuiskastain_jin", "جٍ", "ظَ", "حُ", "خَ"},
            {"kuiskastain_hin", "حٍ", "خ", "جِ", "حُ"},
            {"kuiskastain_khi", "خٍ", "ج", "فَ", "حُ"},
            {"kuiskastain_din", "دٍ", "دَ", "سَ", "دُ"},
            {"kuiskastain_dzin", "ذٍ", "دَ", "دُ", "ذ"},
            {"kuiskastain_rin", "رٍ", "زَ", "ر", "زُ"},
            {"kuiskastain_zin", "زٍ", "ذ", "رِ", "ت"},
            {"kuiskastain_sin", "سٍ", "ش", "شَ", "شِ"},
            {"kuiskastain_syin", "شٍ", "س", "شَ", "ي"},
            {"kuiskastain_shin", "صٍ", "ي", "ضَ", "ضِ"},
            {"kuiskastain_din", "ضٍ", "ف", "ضَ", "ضِ"},
            {"kuiskastain_thin", "طٍ", "ل", "ط", "طُ"},
            {"kuiskastain_dzhin", "ظٍ", "طُ", "غً", "ف"},
            {"kuiskastain_iin", "عٍ", "غً", "غ", "عَ"},
            {"kuiskastain_ghin", "غٍ", "عً", "ع", "عَ"},
            {"kuiskastain_fin", "فٍ", "ق", "فَ", "فِ"},
            {"kuiskastain_qin", "قٍ", "فَ", "قِ", "م"},
            {"kuiskastain_kin", "كٍ", "ح", "كَ", "كُ"},
            {"kuiskastain_lin", "لٍ", "ك", "لَ", "لً"},
            {"kuiskastain_min", "مٍ", "ف", "مً", "مَ"},
            {"kuiskastain_nin", "نٍ", "ب", "نُ", "مَ"},
            {"kuiskastain_win", "وٍ", "ه", "يَ", "وِ"},
            {"kuiskastain_hiin", "هٍ", "حُ", "هِ", "خ"},
            {"kuiskastain_yin", "يٍ", "م", "يَ", "مِ"}
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kuis_kastain);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            AudioAttributes audioAttributes = new AudioAttributes.Builder()
                    .setUsage(AudioAttributes.USAGE_GAME).setContentType(AudioAttributes.CONTENT_TYPE_MUSIC).build();
            soundPool = new SoundPool.Builder()
                    .setMaxStreams(3)
                    .setAudioAttributes(audioAttributes).build();

        } else {
            soundPool = new SoundPool(3, AudioManager.STREAM_MUSIC, 0);
        }
        suaraFinish = soundPool.load(this, R.raw.sound_selesai, 1);

        close = findViewById(R.id.exit8);
        close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.startAnimation(AnimationUtils.loadAnimation(getApplicationContext(),R.anim.bounce));
                startActivity(new Intent(KuisKastainActivity.this, KuisActivity.class));
                finish();
            }
        });
        countLabel = findViewById(R.id.countLabel);
        questionLabel = findViewById(R.id.suara);
        ansButton1 = findViewById(R.id.ansButton1);
        ansButton2 = findViewById(R.id.ansButton2);
        ansButton3 = findViewById(R.id.ansButton3);
        ansButton4 = findViewById(R.id.ansButton4);

        //Membuat Kuis Array dari Quis Data
        for (int i=0;i<quizData.length;i++){
            ArrayList<String> tmpArray=new ArrayList<>();
            tmpArray.add(quizData[i][0]);
            tmpArray.add(quizData[i][1]);
            tmpArray.add(quizData[i][2]);
            tmpArray.add(quizData[i][3]);
            tmpArray.add(quizData[i][4]);

            // Membuat tmpArray ke QuizArray
            quizArray.add(tmpArray);
        }
        showNextQuiz();
    }
    public void showNextQuiz() {
        countLabel.setText(quizCount + "/5");

        //acak random nomor berbeda 0 dan quizArray length -1
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

        questionLabel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mp.start();
            }
        });
    }
    public void checkAnswer(View view){
        Button ansButton = findViewById(view.getId());
        String btntxt = ansButton.getText().toString();
        if(btntxt.equals(rightAnswer)){
            Toast.makeText(KuisKastainActivity.this, "Benar!", Toast.LENGTH_SHORT).show();
            rightAnswerCount++;
        }
        else{
            Toast.makeText(KuisKastainActivity.this, "Salah!", Toast.LENGTH_SHORT).show();
        }
        if (quizCount == QUIZ_COUNT){
            //berpindah ke hasil/skor
            Toast.makeText(KuisKastainActivity.this, "Selesai!", Toast.LENGTH_SHORT).show();
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
        builder.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
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

        //update the totalScore
        SharedPreferences.Editor editor =settings.edit();
        editor.putInt("totalScore",totalScore);
        editor.commit();
        builder.setView(dialogLayout);


        cobaLagi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                recreate();
            }
        });
        close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent exit = new Intent(KuisKastainActivity.this, KuisActivity.class);
                startActivity(exit);
                finish();
            }
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
//        audio.stop();
        audio.release();
        audio = null;
    }
}
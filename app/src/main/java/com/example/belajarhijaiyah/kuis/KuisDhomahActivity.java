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

public class KuisDhomahActivity extends AppCompatActivity {
    SoundPool soundPool;
    TextView countLabel;
    ImageButton questionLabel, close;
    MediaPlayer audio;
    Button ansButton1, ansButton2, ansButton3, ansButton4;
    private String rightAnswer;
    private int suaraFinish, Pertanyaan;
    private int rightAnswerCount = 0;
    private int quizCount = 1;
    private final int QUIZ_COUNT = 5;
    ArrayList<ArrayList<String>> quizArray = new ArrayList<>();
    String[][] quizData = {
            {"kuisdomah_u",  "اُ", "كَ", "د", "ضَ"},
            {"kuisdomah_bu", "بُ","اُ", "فَ", "جَ"},
            {"kuisdomah_tu", "تُ", "بَ", "نَ", "بُ"},
            {"kuisdomah_tsu", "ثُ", "نَ", "رَ", "تُ"},
            {"kuisdomah_ju", "جُ", "حَ", "ثُ", "سَ"},
            {"kuisdomah_hu", "حُ", "ظَ", "جُ", "هَ"},
            {"kuisdomah_khu", "خُ", "ج", "حُ", "جَ"},
            {"kuisdomah_du", "دُ", "رَ", "خُ", "ش"},
            {"kuisdomah_dzu", "ذُ", "ط", "دُ", "دَ"},
            {"kuisdomah_ru", "رُ", "يَ", "بَ", "ذُ"},
            {"kuisdomah_zu", "زُ", "ضَ", "رُ", "ز"},
            {"kuisdomah_su", "سُ", "سِ", "زُ", "د"},
            {"kuisdomah_syu", "شُ", "بَ", "اَ", "سِ"},
            {"kuisdomah_shu", "صُ", "ضَ", "سِ", "شُ"},
            {"kuisdomah_dhu", "ضُ", "ض", "صَ", "صُ"},
            {"kuisdomah_thu", "طُ", "كَ", "ل", "م"},
            {"kuisdomah_dzhu", "ظُ", "ط", "لَ", "طُ"},
            {"kuisdomah_uu", "عُ", "غُ", "غ", "د"},
            {"kuisdomah_ghu", "غُ", "شَ", "ع", "عُ"},
            {"kuisdomah_fu", "فُ", "قَ", "ض", "قُ"},
            {"kuisdomah_qu", "قُ", "فَ", "ل", "فُ"},
            {"kuisdomah_ku", "كُ", "كِ", "لَ", "لُ"},
            {"kuisdomah_lu", "لُ", "كَ", "كُ", "هَ"},
            {"kuisdomah_mu", "مُ", "زَ", "هَ", "وَ"},
            {"kuisdomah_nu", "نُ", "ب", "زَ", "مُ"},
            {"kuisdomah_wu", "وُ", "زَ", "هُ", "ف"},
            {"kuisdomah_huu", "هُ", "زَ", "يُ", "وَ"},
            {"kuisdomah_yu", "يُ", "زَ", "ق", "يُ"}
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kuis_dhomah);
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
                startActivity(new Intent(KuisDhomahActivity.this, KuisActivity.class));
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
            Toast.makeText(KuisDhomahActivity.this, "Benar!", Toast.LENGTH_SHORT).show();
            rightAnswerCount++;
        }
        else{
            Toast.makeText(KuisDhomahActivity.this, "Salah!", Toast.LENGTH_SHORT).show();
        }
        if (quizCount == QUIZ_COUNT){
            //berpindah ke hasil/skor
            Toast.makeText(KuisDhomahActivity.this, "Selesai!", Toast.LENGTH_SHORT).show();
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
                Intent exit = new Intent(KuisDhomahActivity.this, KuisActivity.class);
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
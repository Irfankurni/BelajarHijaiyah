package com.example.belajarhijaiyah.belajar;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.media.AudioAttributes;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.SoundPool;
import android.os.Build;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.example.belajarhijaiyah.R;

public class KasrohActivity extends AppCompatActivity implements View.OnClickListener{
    ImageView TampilGambar;
    ImageButton show,hide, kembali;
    SoundPool soundPool;
    MediaPlayer mp;
    private int SuaraAlif,SuaraBa,SuaraTa,SuaraSa,SuaraJim,SuaraHa,SuaraKho,SuaraDal,SuaraDzal,SuaraRo,
            Suaraza,SuaraSin,SuaraSyin,SuaraShad,SuaraDod,SuaraTo,SuaraDo,SuaraAin,SuaraGin,Suarafa,SuaraKof,
            SuaraKaf,SuaraLam,SuaraMim,SuaraNun,SuaraWawu,SuaraHA,SuaraYa;
    Animation anImScale;

    @SuppressLint("CutPasteId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kasroh);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        TampilGambar = findViewById(R.id.tampil_kasroh);
        show = findViewById(R.id.kasroh_i);
        hide = findViewById(R.id.kasroh_bi);
        kembali = findViewById(R.id.kembali);

        anImScale = AnimationUtils.loadAnimation(this, R.anim.anim_scale);
        show.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                TampilGambar.setVisibility(View.VISIBLE);

            }
        });

        hide.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                TampilGambar.setVisibility(View.INVISIBLE);

            }
        });

        kembali.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.startAnimation(AnimationUtils.loadAnimation(getApplicationContext(),R.anim.bounce));
                finish();
            }
        });
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            AudioAttributes audioAttributes = new AudioAttributes.Builder()
                    .setUsage(AudioAttributes.USAGE_GAME).setContentType(AudioAttributes.CONTENT_TYPE_MUSIC).build();
            soundPool = new SoundPool.Builder()
                    .setMaxStreams(28)
                    .setAudioAttributes(audioAttributes).build();

        } else {
            soundPool = new SoundPool(28, AudioManager.STREAM_MUSIC, 0);
        }
        SuaraAlif = soundPool.load(this, R.raw.kasroh_i,1);
        SuaraBa = soundPool.load(this, R.raw.kasroh_bi,1);
        SuaraTa = soundPool.load(this, R.raw.kasroh_ti,1);
        SuaraSa = soundPool.load(this, R.raw.kasroh_tsi,1);
        SuaraJim = soundPool.load(this, R.raw.kasroh_ji,1);
        SuaraHa = soundPool.load(this, R.raw.kasroh_hi,1);
        SuaraKho = soundPool.load(this, R.raw.kasroh_khi,1);
        SuaraDal = soundPool.load(this, R.raw.kasroh_di,1);
        SuaraDzal = soundPool.load(this, R.raw.kasroh_dzi,1);
        SuaraRo = soundPool.load(this, R.raw.kasroh_ri,1);
        Suaraza = soundPool.load(this, R.raw.kasroh_zi,1);
        SuaraSin = soundPool.load(this, R.raw.kasroh_si,1);
        SuaraSyin = soundPool.load(this, R.raw.kasroh_syi,1);
        SuaraShad = soundPool.load(this, R.raw.kasroh_shi,1);
        SuaraDod = soundPool.load(this, R.raw.kasroh_dhi,1);
        SuaraTo = soundPool.load(this, R.raw.kasroh_thi,1);
        SuaraDo = soundPool.load(this, R.raw.kasroh_dzhi,1);
        SuaraAin = soundPool.load(this, R.raw.kasroh_ii,1);
        SuaraGin = soundPool.load(this, R.raw.kasroh_ghi,1);
        Suarafa = soundPool.load(this, R.raw.kasroh_fi,1);
        SuaraKof = soundPool.load(this, R.raw.kasroh_qi,1);
        SuaraKaf = soundPool.load(this, R.raw.kasroh_ki,1);
        SuaraLam = soundPool.load(this, R.raw.kasroh_li,1);
        SuaraMim = soundPool.load(this, R.raw.kasroh_mi,1);
        SuaraNun = soundPool.load(this, R.raw.kasroh_ni,1);
        SuaraWawu = soundPool.load(this, R.raw.kasroh_wi,1);
        SuaraHA = soundPool.load(this, R.raw.kasroh_hii,1);
        SuaraYa = soundPool.load(this, R.raw.kasroh_yi,1);

        ImageButton ButtonSuara = findViewById(R.id.kasroh_i);
        ImageButton ButtonSuara2 = findViewById(R.id.kasroh_bi);
        ImageButton ButtonSuara3 = findViewById(R.id.kasroh_ti);
        ImageButton ButtonSuara4 = findViewById(R.id.kasroh_tsi);
        ImageButton ButtonSuara5 = findViewById(R.id.kasroh_ji);
        ImageButton ButtonSuara6 = findViewById(R.id.kasroh_ha);
        ImageButton ButtonSuara7 = findViewById(R.id.kasroh_khi);
        ImageButton ButtonSuara8 = findViewById(R.id.kasroh_di);
        ImageButton ButtonSuara9 = findViewById(R.id.kasroh_dzi);
        ImageButton ButtonSuara10 = findViewById(R.id.kasroh_ri);
        ImageButton ButtonSuara11 = findViewById(R.id.kasroh_dzi);
        ImageButton ButtonSuara12 = findViewById(R.id.kasroh_si);
        ImageButton ButtonSuara13 = findViewById(R.id.kasroh_syi);
        ImageButton ButtonSuara14 = findViewById(R.id.kasroh_shi);
        ImageButton ButtonSuara15 = findViewById(R.id.kasroh_dhi);
        ImageButton ButtonSuara16 = findViewById(R.id.kasroh_thi);
        ImageButton ButtonSuara17 = findViewById(R.id.kasroh_dzhi);
        ImageButton ButtonSuara18 = findViewById(R.id.kasroh_ain);
        ImageButton ButtonSuara19 = findViewById(R.id.kasroh_ghi);
        ImageButton ButtonSuara20 = findViewById(R.id.kasroh_fi);
        ImageButton ButtonSuara21 = findViewById(R.id.kasroh_qi);
        ImageButton ButtonSuara22 = findViewById(R.id.kasroh_ki);
        ImageButton ButtonSuara23 = findViewById(R.id.kasroh_li);
        ImageButton ButtonSuara24 = findViewById(R.id.kasroh_mi);
        ImageButton ButtonSuara25 = findViewById(R.id.kasroh_nun);
        ImageButton ButtonSuara26 = findViewById(R.id.kasroh_wi);
        ImageButton ButtonSuara27 = findViewById(R.id.kasroh_haa);
        ImageButton ButtonSuara28 = findViewById(R.id.kasroh_yi);

        ButtonSuara.setOnClickListener(this);
        ButtonSuara2.setOnClickListener(this);
        ButtonSuara3.setOnClickListener(this);
        ButtonSuara4.setOnClickListener(this);
        ButtonSuara5.setOnClickListener(this);
        ButtonSuara6.setOnClickListener(this);
        ButtonSuara7.setOnClickListener(this);
        ButtonSuara8.setOnClickListener(this);
        ButtonSuara9.setOnClickListener(this);
        ButtonSuara10.setOnClickListener(this);
        ButtonSuara11.setOnClickListener(this);
        ButtonSuara12.setOnClickListener(this);
        ButtonSuara13.setOnClickListener(this);
        ButtonSuara14.setOnClickListener(this);
        ButtonSuara15.setOnClickListener(this);
        ButtonSuara16.setOnClickListener(this);
        ButtonSuara17.setOnClickListener(this);
        ButtonSuara18.setOnClickListener(this);
        ButtonSuara19.setOnClickListener(this);
        ButtonSuara20.setOnClickListener(this);
        ButtonSuara21.setOnClickListener(this);
        ButtonSuara22.setOnClickListener(this);
        ButtonSuara23.setOnClickListener(this);
        ButtonSuara24.setOnClickListener(this);
        ButtonSuara25.setOnClickListener(this);
        ButtonSuara26.setOnClickListener(this);
        ButtonSuara27.setOnClickListener(this);
        ButtonSuara28.setOnClickListener(this);

    }
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.kasroh_i:
                TampilGambar.setImageResource(R.drawable.pop_kasroh_i);
                TampilGambar.startAnimation(anImScale);
                soundPool.play(SuaraAlif,1,1,0,0,1);
                break;
            case R.id.kasroh_bi:
                TampilGambar.setImageResource(R.drawable.pop_kasroh_bi);
                TampilGambar.startAnimation(anImScale);
                soundPool.play(SuaraBa,1,1,0,0,1);
                break;
            case R.id.kasroh_ti:
                TampilGambar.setImageResource(R.drawable.pop_kasroh_ti);
                TampilGambar.startAnimation(anImScale);
                soundPool.play(SuaraTa,1,1,0,0,1);
                break;
            case R.id.kasroh_tsi:
                TampilGambar.setImageResource(R.drawable.pop_kasroh_tsi);
                TampilGambar.startAnimation(anImScale);
                soundPool.play(SuaraSa,1,1,0,0,1);
                break;
            case R.id.kasroh_ji:
                TampilGambar.setImageResource(R.drawable.pop_kasroh_ji);
                TampilGambar.startAnimation(anImScale);
                soundPool.play(SuaraJim,1,1,0,0,1);
                break;
            case R.id.kasroh_ha:
                TampilGambar.setImageResource(R.drawable.pop_kasroh_hi);
                TampilGambar.startAnimation(anImScale);
                soundPool.play(SuaraHa,1,1,0,0,1);
                break;
            case R.id.kasroh_khi:
                TampilGambar.setImageResource(R.drawable.pop_kasroh_khi);
                TampilGambar.startAnimation(anImScale);
                soundPool.play(SuaraKho,1,1,0,0,1);
                break;
            case R.id.kasroh_di:
                TampilGambar.setImageResource(R.drawable.pop_kasroh_di);
                TampilGambar.startAnimation(anImScale);
                soundPool.play(SuaraDal,1,1,0,0,1);
                break;
            case R.id.kasroh_dzi:
                TampilGambar.setImageResource(R.drawable.pop_kasroh_dzi);
                TampilGambar.startAnimation(anImScale);
                soundPool.play(SuaraDzal,1,1,0,0,1);
                break;
            case R.id.kasroh_ri:
                TampilGambar.setImageResource(R.drawable.pop_kasroh_ri);
                TampilGambar.startAnimation(anImScale);
                soundPool.play(SuaraRo,1,1,0,0,1);
                break;
            case R.id.kasroh_za:
                TampilGambar.setImageResource(R.drawable.pop_kasroh_zi);
                TampilGambar.startAnimation(anImScale);
                soundPool.play(Suaraza,1,1,0,0,1);
                break;
            case R.id.kasroh_si:
                TampilGambar.setImageResource(R.drawable.pop_kasroh_si);
                TampilGambar.startAnimation(anImScale);
                soundPool.play(SuaraSin,1,1,0,0,1);
                break;
            case R.id.kasroh_syi:
                TampilGambar.setImageResource(R.drawable.pop_kasroh_syi);
                TampilGambar.startAnimation(anImScale);
                soundPool.play(SuaraSyin,1,1,0,0,1);
                break;
            case R.id.kasroh_shi:
                TampilGambar.setImageResource(R.drawable.pop_kasroh_shi);
                TampilGambar.startAnimation(anImScale);
                soundPool.play(SuaraShad,1,1,0,0,1);
                break;
            case R.id.kasroh_dhi:
                TampilGambar.setImageResource(R.drawable.pop_kasroh_dhi);
                TampilGambar.startAnimation(anImScale);
                soundPool.play(SuaraDod ,1,1,0,0,1);
                break;
            case R.id.kasroh_thi:
                TampilGambar.setImageResource(R.drawable.pop_kasroh_thi);
                TampilGambar.startAnimation(anImScale);
                soundPool.play(SuaraTo ,1,1,0,0,1);
                break;
            case R.id.kasroh_dzhi:
                TampilGambar.setImageResource(R.drawable.pop_kasroh_dzi);
                TampilGambar.startAnimation(anImScale);
                soundPool.play(SuaraDo ,1,1,0,0,1);
                break;
            case R.id.kasroh_ain:
                TampilGambar.setImageResource(R.drawable.pop_kasroh_ii);
                TampilGambar.startAnimation(anImScale);
                soundPool.play(SuaraAin ,1,1,0,0,1);
                break;
            case R.id.kasroh_ghi:
                TampilGambar.setImageResource(R.drawable.pop_kasroh_ghi);
                TampilGambar.startAnimation(anImScale);
                soundPool.play(SuaraGin ,1,1,0,0,1);
                break;
            case R.id.kasroh_fi:
                TampilGambar.setImageResource(R.drawable.pop_kasroh_fi);
                TampilGambar.startAnimation(anImScale);
                soundPool.play(Suarafa ,1,1,0,0,1);
                break;
            case R.id.kasroh_qi:
                TampilGambar.setImageResource(R.drawable.pop_kasroh_qi);
                TampilGambar.startAnimation(anImScale);
                soundPool.play(SuaraKof ,1,1,0,0,1);
                break;
            case R.id.kasroh_ki:
                TampilGambar.setImageResource(R.drawable.pop_kasroh_ki);
                TampilGambar.startAnimation(anImScale);
                soundPool.play(SuaraKaf ,1,1,0,0,1);
                break;
            case R.id.kasroh_li:
                TampilGambar.setImageResource(R.drawable.pop_kasroh_li);
                TampilGambar.startAnimation(anImScale);
                soundPool.play(SuaraLam ,1,1,0,0,1);
                break;
            case R.id.kasroh_mi:
                TampilGambar.setImageResource(R.drawable.pop_kasroh_mi);
                TampilGambar.startAnimation(anImScale);
                soundPool.play(SuaraMim ,1,1,0,0,1);
                break;
            case R.id.kasroh_nun:
                TampilGambar.setImageResource(R.drawable.pop_kasroh_ni);
                TampilGambar.startAnimation(anImScale);
                soundPool.play(SuaraNun ,1,1,0,0,1);
                break;
            case R.id.kasroh_wi:
                TampilGambar.setImageResource(R.drawable.pop_kasroh_wi);
                TampilGambar.startAnimation(anImScale);
                soundPool.play(SuaraWawu ,1,1,0,0,1);
                break;
            case R.id.kasroh_haa:
                TampilGambar.setImageResource(R.drawable.pop_kasroh_hii);
                TampilGambar.startAnimation(anImScale);
                soundPool.play(SuaraHA ,1,1,0,0,1);
                break;
            case R.id.kasroh_yi:
                TampilGambar.setImageResource(R.drawable.pop_kasroh_yi);
                TampilGambar.startAnimation(anImScale);
                soundPool.play(SuaraYa ,1,1,0,0,1);
                break;
        }
    }
    @Override
    protected void onResume() {
        super.onResume();
        mp = MediaPlayer.create(this, R.raw.backsound);
        mp.setVolume(0.06f, 0.06f);
        mp.setLooping(true);
        mp.start();
    }

    @Override
    protected void onPause() {
        super.onPause();
        mp.stop();
        mp.release();

    }
    @Override
    protected void onDestroy(){
        super.onDestroy();
        soundPool.release();
        soundPool = null;
        mp.release();
        mp = null;
    }

}

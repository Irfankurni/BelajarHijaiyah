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

public class DhoTainActivity extends AppCompatActivity implements View.OnClickListener{
    ImageButton show, hide, kembali;
    ImageView TampilGambar;
    Animation anImScale;
    SoundPool soundPool;
    MediaPlayer mp;
    private int SuaraAlif,SuaraBa,SuaraTa,SuaraSa,SuaraJim,SuaraHa,SuaraKho,SuaraDal,SuaraDzal,SuaraRo,
            SuaraJa,SuaraSin,SuaraSyin,SuaraShad,SuaraDod,SuaraTo,SuaraDo,SuaraAin,SuaraGin,Suarafa,SuaraKof,
            SuaraKaf,SuaraLam,SuaraMim,SuaraNun,SuaraWawu,SuaraHA,SuaraYa;

    @SuppressLint("CutPasteId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dho_tain);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        anImScale = AnimationUtils.loadAnimation(this, R.anim.anim_scale);
        TampilGambar = findViewById(R.id.tampil_huruf);
        show = findViewById(R.id.domah_tain_alif);
        hide = findViewById(R.id.domah_tain_ba);
        kembali = findViewById(R.id.kembali);

        show.setOnClickListener(new View.OnClickListener(){
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
        SuaraAlif =soundPool.load(this, R.raw.tanwin_domah_un,1);
        SuaraBa = soundPool.load(this, R.raw.tanwin_domah_bun,1);
        SuaraTa = soundPool.load(this, R.raw.tanwin_domah_tun,1);
        SuaraSa = soundPool.load(this, R.raw.tanwin_domah_tsun,1);
        SuaraJim = soundPool.load(this, R.raw.tanwin_domah_jun,1);
        SuaraHa = soundPool.load(this, R.raw.tanwin_domah_hun,1);
        SuaraKho = soundPool.load(this, R.raw.tanwin_domah_khun,1);
        SuaraDal = soundPool.load(this, R.raw.tanwin_domah_dun,1);
        SuaraDzal = soundPool.load(this, R.raw.tanwin_domah_dzun,1);
        SuaraRo = soundPool.load(this, R.raw.tanwin_domah_run,1);
        SuaraJa = soundPool.load(this, R.raw.tanwin_domah_zun,1);
        SuaraSin = soundPool.load(this, R.raw.tanwin_domah_sun,1);
        SuaraSyin = soundPool.load(this, R.raw.tanwin_domah_syun,1);
        SuaraShad = soundPool.load(this, R.raw.tanwin_domah_shun,1);
        SuaraDod = soundPool.load(this, R.raw.tanwin_domah_dhun,1);
        SuaraTo = soundPool.load(this, R.raw.tanwin_domah_thun,1);
        SuaraDo = soundPool.load(this, R.raw.tanwin_domah_dzhun,1);
        SuaraAin = soundPool.load(this, R.raw.tanwin_domah_uun,1);
        SuaraGin = soundPool.load(this, R.raw.tanwin_domah_ghun,1);
        Suarafa = soundPool.load(this, R.raw.tanwin_domah_fun,1);
        SuaraKof = soundPool.load(this, R.raw.tanwin_domah_qun,1);
        SuaraKaf = soundPool.load(this, R.raw.tanwin_domah_kun,1);
        SuaraLam = soundPool.load(this, R.raw.tanwin_domah_lun,1);
        SuaraMim = soundPool.load(this, R.raw.tanwin_domah_mun,1);
        SuaraNun = soundPool.load(this, R.raw.tanwin_domah_nun,1);
        SuaraWawu = soundPool.load(this, R.raw.tanwin_domah_wun,1);
        SuaraHA = soundPool.load(this, R.raw.tanwin_domah_huun,1);
        SuaraYa = soundPool.load(this, R.raw.tanwin_domah_yun,1);

        ImageButton ButtonSuara = findViewById(R.id.domah_tain_alif);
        ImageButton ButtonSuara2 = findViewById(R.id.domah_tain_ba);
        ImageButton ButtonSuara3 = findViewById(R.id.domah_tain_ta);
        ImageButton ButtonSuara4 = findViewById(R.id.domah_tain_tsa);
        ImageButton ButtonSuara5 = findViewById(R.id.domah_tain_ja);
        ImageButton ButtonSuara6 = findViewById(R.id.domah_tain_ha);
        ImageButton ButtonSuara7 = findViewById(R.id.domah_tain_kha);
        ImageButton ButtonSuara8 = findViewById(R.id.domah_tain_da);
        ImageButton ButtonSuara9 = findViewById(R.id.domah_tain_dza);
        ImageButton ButtonSuara10 = findViewById(R.id.domah_tain_ra);
        ImageButton ButtonSuara11 = findViewById(R.id.domah_tain_za);
        ImageButton ButtonSuara12 = findViewById(R.id.domah_tain_sin);
        ImageButton ButtonSuara13 = findViewById(R.id.domah_tain_syin);
        ImageButton ButtonSuara14 = findViewById(R.id.domah_tain_shad);
        ImageButton ButtonSuara15 = findViewById(R.id.domah_tain_dhad);
        ImageButton ButtonSuara16 = findViewById(R.id.domah_tain_tha);
        ImageButton ButtonSuara17 = findViewById(R.id.domah_tain_dha);
        ImageButton ButtonSuara18 = findViewById(R.id.domah_tain_ain);
        ImageButton ButtonSuara19 = findViewById(R.id.domah_tain_ghain);
        ImageButton ButtonSuara20 = findViewById(R.id.domah_tain_fa);
        ImageButton ButtonSuara21 = findViewById(R.id.domah_tain_qof);
        ImageButton ButtonSuara22 = findViewById(R.id.domah_tain_kaf);
        ImageButton ButtonSuara23 = findViewById(R.id.domah_tain_lam);
        ImageButton ButtonSuara24 = findViewById(R.id.domah_tain_mim);
        ImageButton ButtonSuara25 = findViewById(R.id.domah_tain_nun);
        ImageButton ButtonSuara26 = findViewById(R.id.domah_tain_wawu);
        ImageButton ButtonSuara27 = findViewById(R.id.domah_tain_haa);
        ImageButton ButtonSuara28 = findViewById(R.id.domah_tain_ya);

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
            case R.id.domah_tain_alif:
                TampilGambar.setImageResource(R.drawable.pop_domahtain_un);
                TampilGambar.startAnimation(anImScale);
                soundPool.play(SuaraAlif,1,1,0,0,1);
                break;
            case R.id.domah_tain_ba:
                TampilGambar.setImageResource(R.drawable.pop_domahtain_bun);
                TampilGambar.startAnimation(anImScale);
                soundPool.play(SuaraBa,1,1,0,0,1);
                break;
            case R.id.domah_tain_ta:
                TampilGambar.setImageResource(R.drawable.pop_domahtain_tun);
                TampilGambar.startAnimation(anImScale);
                soundPool.play(SuaraTa,1,1,0,0,1);
                break;
            case R.id.domah_tain_tsa:
                TampilGambar.setImageResource(R.drawable.pop_domahtain_tsun);
                TampilGambar.startAnimation(anImScale);
                soundPool.play(SuaraSa,1,1,0,0,1);
                break;
            case R.id.domah_tain_ja:
                TampilGambar.setImageResource(R.drawable.pop_domahtain_jun);
                TampilGambar.startAnimation(anImScale);
                soundPool.play(SuaraJim,1,1,0,0,1);
                break;
            case R.id.domah_tain_ha:
                TampilGambar.setImageResource(R.drawable.pop_domahtain_hun);
                TampilGambar.startAnimation(anImScale);
                soundPool.play(SuaraHa,1,1,0,0,1);
                break;
            case R.id.domah_tain_kha:
                TampilGambar.setImageResource(R.drawable.pop_domahtain_khun);
                TampilGambar.startAnimation(anImScale);
                soundPool.play(SuaraKho,1,1,0,0,1);
                break;
            case R.id.domah_tain_da:
                TampilGambar.setImageResource(R.drawable.pop_domahtain_dun);
                TampilGambar.startAnimation(anImScale);
                soundPool.play(SuaraDal,1,1,0,0,1);
                break;
            case R.id.domah_tain_dza:
                TampilGambar.setImageResource(R.drawable.pop_domahtain_dzun);
                TampilGambar.startAnimation(anImScale);
                soundPool.play(SuaraDzal,1,1,0,0,1);
                break;
            case R.id.domah_tain_ra:
                TampilGambar.setImageResource(R.drawable.pop_domahtain_run);
                TampilGambar.startAnimation(anImScale);
                soundPool.play(SuaraRo,1,1,0,0,1);
                break;
            case R.id.domah_tain_za:
                TampilGambar.setImageResource(R.drawable.pop_domahtain_zun);
                TampilGambar.startAnimation(anImScale);
                soundPool.play(SuaraJa,1,1,0,0,1);
                break;
            case R.id.domah_tain_sin:
                TampilGambar.setImageResource(R.drawable.pop_domahtain_sun);
                TampilGambar.startAnimation(anImScale);
                soundPool.play(SuaraSin,1,1,0,0,1);
                break;
            case R.id.domah_tain_syin:
                TampilGambar.setImageResource(R.drawable.pop_domahtain_syun);
                TampilGambar.startAnimation(anImScale);
                soundPool.play(SuaraSyin,1,1,0,0,1);
                break;
            case R.id.domah_tain_shad:
                TampilGambar.setImageResource(R.drawable.pop_domahtain_shun);
                TampilGambar.startAnimation(anImScale);
                soundPool.play(SuaraShad,1,1,0,0,1);
                break;
            case R.id.domah_tain_dhad:
                TampilGambar.setImageResource(R.drawable.pop_domahtain_dhun);
                TampilGambar.startAnimation(anImScale);
                soundPool.play(SuaraDod ,1,1,0,0,1);
                break;
            case R.id.domah_tain_tha:
                TampilGambar.setImageResource(R.drawable.pop_domahtain_thun);
                TampilGambar.startAnimation(anImScale);
                soundPool.play(SuaraTo ,1,1,0,0,1);
                break;
            case R.id.domah_tain_dha:
                TampilGambar.setImageResource(R.drawable.pop_domahtain_dzuun);
                TampilGambar.startAnimation(anImScale);
                soundPool.play(SuaraDo ,1,1,0,0,1);
                break;
            case R.id.domah_tain_ain:
                TampilGambar.setImageResource(R.drawable.pop_domahtain_uun);
                TampilGambar.startAnimation(anImScale);
                soundPool.play(SuaraAin ,1,1,0,0,1);
                break;
            case R.id.domah_tain_ghain:
                TampilGambar.setImageResource(R.drawable.pop_domahtain_ghun);
                TampilGambar.startAnimation(anImScale);
                soundPool.play(SuaraGin ,1,1,0,0,1);
                break;
            case R.id.domah_tain_fa:
                TampilGambar.setImageResource(R.drawable.pop_domahtain_fun);
                TampilGambar.startAnimation(anImScale);
                soundPool.play(Suarafa ,1,1,0,0,1);
                break;
            case R.id.domah_tain_qof:
                TampilGambar.setImageResource(R.drawable.pop_domahtain_qun);
                TampilGambar.startAnimation(anImScale);
                soundPool.play(SuaraKof ,1,1,0,0,1);
                break;
            case R.id.domah_tain_kaf:
                TampilGambar.setImageResource(R.drawable.pop_domahtain_kun);
                TampilGambar.startAnimation(anImScale);
                soundPool.play(SuaraKaf ,1,1,0,0,1);
                break;
            case R.id.domah_tain_lam:
                TampilGambar.setImageResource(R.drawable.pop_domahtain_lun);
                TampilGambar.startAnimation(anImScale);
                soundPool.play(SuaraLam ,1,1,0,0,1);
                break;
            case R.id.domah_tain_mim:
                TampilGambar.setImageResource(R.drawable.pop_domahtain_mun);
                TampilGambar.startAnimation(anImScale);
                soundPool.play(SuaraMim ,1,1,0,0,1);
                break;
            case R.id.domah_tain_nun:
                TampilGambar.setImageResource(R.drawable.pop_domahtain_nun);
                TampilGambar.startAnimation(anImScale);
                soundPool.play(SuaraNun ,1,1,0,0,1);
                break;
            case R.id.domah_tain_wawu:
                TampilGambar.setImageResource(R.drawable.pop_domahtain_wun);
                TampilGambar.startAnimation(anImScale);
                soundPool.play(SuaraWawu ,1,1,0,0,1);
                break;
            case R.id.domah_tain_haa:
                TampilGambar.setImageResource(R.drawable.pop_domahtain_huun);
                TampilGambar.startAnimation(anImScale);
                soundPool.play(SuaraHA ,1,1,0,0,1);
                break;
            case R.id.domah_tain_ya:
                TampilGambar.setImageResource(R.drawable.pop_domahtain_yun);
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
    protected void onDestroy() {
        super.onDestroy();
        soundPool.release();
        soundPool = null;
//        mp.stop();
        mp.release();
        mp = null;
    }

}

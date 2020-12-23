package com.example.belajarhijaiyah.belajar;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.media.AudioAttributes;
import android.media.AudioManager;
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

public class KasTainActivity extends AppCompatActivity implements View.OnClickListener{
    ImageButton show, hide, kembali;
    ImageView TampilGambar;
    Animation anImScale;
    private SoundPool soundPool;
    private int SuaraAlif,SuaraBa,SuaraTa,SuaraSa,SuaraJim,SuaraHa,SuaraKho,SuaraDal,SuaraDzal,SuaraRo,
            Suaraza,SuaraSin,SuaraSyin,SuaraShad,SuaraDod,SuaraTo,SuaraDo,SuaraAin,SuaraGin,Suarafa,SuaraKof,
            SuaraKaf,SuaraLam,SuaraMim,SuaraNun,SuaraWawu,SuaraHA,SuaraYa;

    @SuppressLint("CutPasteId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kas_tain);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);


        TampilGambar = findViewById(R.id.tampil_huruf);
        show = findViewById(R.id.kasrohtain_in);
        hide = findViewById(R.id.kasrohtain_bin);
        anImScale = AnimationUtils.loadAnimation(this, R.anim.anim_scale);
        kembali = findViewById(R.id.kembali);

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
        SuaraAlif = soundPool.load(this, R.raw.tanwin_kasroh_in,1);
        SuaraBa = soundPool.load(this, R.raw.tanwin_kasroh_bin,1);
        SuaraTa = soundPool.load(this, R.raw.tanwin_kasroh_tin,1);
        SuaraSa = soundPool.load(this, R.raw.tanwin_kasroh_tsin,1);
        SuaraJim = soundPool.load(this, R.raw.tanwin_kasroh_jin,1);
        SuaraHa = soundPool.load(this, R.raw.tanwin_kasroh_hin,1);
        SuaraKho = soundPool.load(this, R.raw.tanwin_kasroh_khin,1);
        SuaraDal = soundPool.load(this, R.raw.tanwin_kasroh_din,1);
        SuaraDzal = soundPool.load(this, R.raw.tanwin_kasroh_dzin,1);
        SuaraRo = soundPool.load(this, R.raw.tanwin_kasroh_rin,1);
        Suaraza = soundPool.load(this, R.raw.tanwin_kasroh_zin,1);
        SuaraSin = soundPool.load(this, R.raw.tanwin_kasroh_sin,1);
        SuaraSyin = soundPool.load(this, R.raw.tanwin_kasroh_syin,1);
        SuaraShad = soundPool.load(this, R.raw.tanwin_kasroh_shin,1);
        SuaraDod = soundPool.load(this, R.raw.tanwin_kasroh_dhin,1);
        SuaraTo = soundPool.load(this, R.raw.tanwin_kasroh_thin,1);
        SuaraDo = soundPool.load(this, R.raw.tanwin_kasroh_dzhin,1);
        SuaraAin = soundPool.load(this, R.raw.tanwin_kasroh_iin,1);
        SuaraGin = soundPool.load(this, R.raw.tanwin_kasroh_ghin,1);
        Suarafa = soundPool.load(this, R.raw.tanwin_kasroh_fin,1);
        SuaraKof = soundPool.load(this, R.raw.tanwin_kasroh_qin,1);
        SuaraKaf = soundPool.load(this, R.raw.tanwin_kasroh_kin,1);
        SuaraLam = soundPool.load(this, R.raw.tanwin_kasroh_lin,1);
        SuaraMim = soundPool.load(this, R.raw.tanwin_kasroh_min,1);
        SuaraNun = soundPool.load(this, R.raw.tanwin_kasroh_nin,1);
        SuaraWawu = soundPool.load(this, R.raw.tanwin_kasroh_win,1);
        SuaraHA = soundPool.load(this, R.raw.tanwin_kasroh_hiin,1);
        SuaraYa = soundPool.load(this, R.raw.tanwin_kasroh_yin,1);

        ImageButton ButtonSuara = findViewById(R.id.kasrohtain_in);
        ImageButton ButtonSuara2 = findViewById(R.id.kasrohtain_bin);
        ImageButton ButtonSuara3 = findViewById(R.id.kasrohtain_tin);
        ImageButton ButtonSuara4 = findViewById(R.id.kasrohtain_tsin);
        ImageButton ButtonSuara5 = findViewById(R.id.kasrohtain_jin);
        ImageButton ButtonSuara6 = findViewById(R.id.kasrohtain_hin);
        ImageButton ButtonSuara7 = findViewById(R.id.kasrohtain_khin);
        ImageButton ButtonSuara8 = findViewById(R.id.kasrohtain_din);
        ImageButton ButtonSuara9 = findViewById(R.id.kasrohtain_dzin);
        ImageButton ButtonSuara10 = findViewById(R.id.kasrohtain_rin);
        ImageButton ButtonSuara11 = findViewById(R.id.kasrohtain_zin);
        ImageButton ButtonSuara12 = findViewById(R.id.kasrohtain_sin);
        ImageButton ButtonSuara13 = findViewById(R.id.kasrohtain_syin);
        ImageButton ButtonSuara14 = findViewById(R.id.kasrohtain_shin);
        ImageButton ButtonSuara15 = findViewById(R.id.kasrohtain_dhin);
        ImageButton ButtonSuara16 = findViewById(R.id.kasrohtain_thin);
        ImageButton ButtonSuara17 = findViewById(R.id.kasrohtain_zhin);
        ImageButton ButtonSuara18 = findViewById(R.id.kasrohtain_ain);
        ImageButton ButtonSuara19 = findViewById(R.id.kasrohtain_gin);
        ImageButton ButtonSuara20 = findViewById(R.id.kasrohtain_fin);
        ImageButton ButtonSuara21 = findViewById(R.id.kasrohtain_qin);
        ImageButton ButtonSuara22 = findViewById(R.id.kasrohtain_kin);
        ImageButton ButtonSuara23 = findViewById(R.id.kasrohtain_lin);
        ImageButton ButtonSuara24 = findViewById(R.id.kasrohtain_min);
        ImageButton ButtonSuara25 = findViewById(R.id.kasrohtain_nin);
        ImageButton ButtonSuara26 = findViewById(R.id.kasrohtain_win);
        ImageButton ButtonSuara27 = findViewById(R.id.kasrohtain_hiin);
        ImageButton ButtonSuara28 = findViewById(R.id.kasrohtain_yin);

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
            case R.id.kasrohtain_in:
                TampilGambar.setImageResource(R.drawable.pop_kasroh_tain_in);
                TampilGambar.startAnimation(anImScale);
                soundPool.play(SuaraAlif,1,1,0,0,1);
                break;
            case R.id.kasrohtain_bin:
                TampilGambar.setImageResource(R.drawable.pop_kasroh_tain_bin);
                TampilGambar.startAnimation(anImScale);
                soundPool.play(SuaraBa,1,1,0,0,1);
                break;
            case R.id.kasrohtain_tin:
                TampilGambar.setImageResource(R.drawable.pop_kasroh_tain_tin);
                TampilGambar.startAnimation(anImScale);
                soundPool.play(SuaraTa,1,1,0,0,1);
                break;
            case R.id.kasrohtain_tsin:
                TampilGambar.setImageResource(R.drawable.pop_kasroh_tain_tsin);
                TampilGambar.startAnimation(anImScale);
                soundPool.play(SuaraSa,1,1,0,0,1);
                break;
            case R.id.kasrohtain_jin:
                TampilGambar.setImageResource(R.drawable.pop_kasroh_tain_jin);
                TampilGambar.startAnimation(anImScale);
                soundPool.play(SuaraJim,1,1,0,0,1);
                break;
            case R.id.kasrohtain_hin:
                TampilGambar.setImageResource(R.drawable.pop_kasroh_tain_hin);
                TampilGambar.startAnimation(anImScale);
                soundPool.play(SuaraHa,1,1,0,0,1);
                break;
            case R.id.kasrohtain_khin:
                TampilGambar.setImageResource(R.drawable.pop_kasroh_tain_khin);
                TampilGambar.startAnimation(anImScale);
                soundPool.play(SuaraKho,1,1,0,0,1);
                break;
            case R.id.kasrohtain_din:
                TampilGambar.setImageResource(R.drawable.pop_kasroh_tain_din);
                TampilGambar.startAnimation(anImScale);
                soundPool.play(SuaraDal,1,1,0,0,1);
                break;
            case R.id.kasrohtain_dzin:
                TampilGambar.setImageResource(R.drawable.pop_kasroh_tain_dzin);
                TampilGambar.startAnimation(anImScale);
                soundPool.play(SuaraDzal,1,1,0,0,1);
                break;
            case R.id.kasrohtain_rin:
                TampilGambar.setImageResource(R.drawable.pop_kasroh_tain_rin);
                TampilGambar.startAnimation(anImScale);
                soundPool.play(SuaraRo,1,1,0,0,1);
                break;
            case R.id.kasrohtain_zin:
                TampilGambar.setImageResource(R.drawable.pop_kasroh_tain_zin);
                TampilGambar.startAnimation(anImScale);
                soundPool.play(Suaraza,1,1,0,0,1);
                break;
            case R.id.kasrohtain_sin:
                TampilGambar.setImageResource(R.drawable.pop_kasroh_tain_sin);
                TampilGambar.startAnimation(anImScale);
                soundPool.play(SuaraSin,1,1,0,0,1);
                break;
            case R.id.kasrohtain_syin:
                TampilGambar.setImageResource(R.drawable.pop_kasroh_tain_syin);
                TampilGambar.startAnimation(anImScale);
                soundPool.play(SuaraSyin,1,1,0,0,1);
                break;
            case R.id.kasrohtain_shin:
                TampilGambar.setImageResource(R.drawable.pop_kasroh_tain_shin);
                TampilGambar.startAnimation(anImScale);
                soundPool.play(SuaraShad,1,1,0,0,1);
                break;
            case R.id.kasrohtain_dhin:
                TampilGambar.setImageResource(R.drawable.pop_kasroh_tain_dhin);
                TampilGambar.startAnimation(anImScale);
                soundPool.play(SuaraDod ,1,1,0,0,1);
                break;
            case R.id.kasrohtain_thin:
                TampilGambar.setImageResource(R.drawable.pop_kasroh_tain_thin);
                TampilGambar.startAnimation(anImScale);
                soundPool.play(SuaraTo ,1,1,0,0,1);
                break;
            case R.id.kasrohtain_zhin:
                TampilGambar.setImageResource(R.drawable.pop_kasroh_tain_dzin);
                TampilGambar.startAnimation(anImScale);
                soundPool.play(SuaraDo ,1,1,0,0,1);
                break;
            case R.id.kasrohtain_ain:
                TampilGambar.setImageResource(R.drawable.pop_kasroh_tain_ain);
                TampilGambar.startAnimation(anImScale);
                soundPool.play(SuaraAin ,1,1,0,0,1);
                break;
            case R.id.kasrohtain_gin:
                TampilGambar.setImageResource(R.drawable.pop_kasroh_tain_ghin);
                TampilGambar.startAnimation(anImScale);
                soundPool.play(SuaraGin ,1,1,0,0,1);
                break;
            case R.id.kasrohtain_fin:
                TampilGambar.setImageResource(R.drawable.pop_kasroh_tain_fin);
                TampilGambar.startAnimation(anImScale);
                soundPool.play(Suarafa ,1,1,0,0,1);
                break;
            case R.id.kasrohtain_qin:
                TampilGambar.setImageResource(R.drawable.pop_kasroh_tain_qin);
                TampilGambar.startAnimation(anImScale);
                soundPool.play(SuaraKof ,1,1,0,0,1);
                break;
            case R.id.kasrohtain_kin:
                TampilGambar.setImageResource(R.drawable.pop_kasroh_tain_kin);
                TampilGambar.startAnimation(anImScale);
                soundPool.play(SuaraKaf ,1,1,0,0,1);
                break;
            case R.id.kasrohtain_lin:
                TampilGambar.setImageResource(R.drawable.pop_kasroh_tain_lin);
                TampilGambar.startAnimation(anImScale);
                soundPool.play(SuaraLam ,1,1,0,0,1);
                break;
            case R.id.kasrohtain_min:
                TampilGambar.setImageResource(R.drawable.pop_kasroh_tain_min);
                TampilGambar.startAnimation(anImScale);
                soundPool.play(SuaraMim ,1,1,0,0,1);
                break;
            case R.id.kasrohtain_nin:
                TampilGambar.setImageResource(R.drawable.pop_kasroh_tain_nin);
                TampilGambar.startAnimation(anImScale);
                soundPool.play(SuaraNun ,1,1,0,0,1);
                break;
            case R.id.kasrohtain_win:
                TampilGambar.setImageResource(R.drawable.pop_kasroh_tain_win);
                TampilGambar.startAnimation(anImScale);
                soundPool.play(SuaraWawu ,1,1,0,0,1);
                break;
            case R.id.kasrohtain_hiin:
                TampilGambar.setImageResource(R.drawable.pop_kasroh_tain_hiin);
                TampilGambar.startAnimation(anImScale);
                soundPool.play(SuaraHA ,1,1,0,0,1);
                break;
            case R.id.kasrohtain_yin:
                TampilGambar.setImageResource(R.drawable.pop_kasroh_tain_yin);
                TampilGambar.startAnimation(anImScale);
                soundPool.play(SuaraYa ,1,1,0,0,1);
                break;
        }
    }

    @Override
    protected void onDestroy(){
        super.onDestroy();
        soundPool.release();
        soundPool = null;
    }

}

package com.example.belajarhijaiyah.belajar;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.media.AudioAttributes;
import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.example.belajarhijaiyah.R;

public class FathahActivity extends AppCompatActivity implements View.OnClickListener{
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
        setContentView(R.layout.activity_fathah);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        anImScale = AnimationUtils.loadAnimation(this, R.anim.anim_scale);
        TampilGambar = findViewById(R.id.tampil_fathah);
        show = findViewById(R.id.fatah_a);
        hide = findViewById(R.id.fatah_ba);
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

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP){
            AudioAttributes audioAttributes = new AudioAttributes.Builder()
                    .setUsage(AudioAttributes.USAGE_GAME).setContentType(AudioAttributes.CONTENT_TYPE_MUSIC).build();
            soundPool = new SoundPool.Builder()
                    .setMaxStreams(28)
                    .setAudioAttributes(audioAttributes).build();
        } else {
            soundPool = new SoundPool(28, AudioManager.STREAM_MUSIC, 0);
        }
        SuaraAlif = soundPool.load(this, R.raw.fatah_a,1);
        SuaraBa = soundPool.load(this, R.raw.fatah_ba,1);
        SuaraTa = soundPool.load(this, R.raw.fatah_ta,1);
        SuaraSa = soundPool.load(this, R.raw.fatah_sa,1);
        SuaraJim = soundPool.load(this, R.raw.fatah_ja,1);
        SuaraHa = soundPool.load(this, R.raw.fatah_ha,1);
        SuaraKho = soundPool.load(this, R.raw.fatah_kha,1);
        SuaraDal = soundPool.load(this, R.raw.fatah_da,1);
        SuaraDzal = soundPool.load(this, R.raw.fatah_dza,1);
        SuaraRo = soundPool.load(this, R.raw.fatah_ro,1);
        Suaraza = soundPool.load(this, R.raw.fatah_za,2);
        SuaraSin = soundPool.load(this, R.raw.fatah_sa,1);
        SuaraSyin = soundPool.load(this, R.raw.fatah_sya,1);
        SuaraShad =soundPool.load(this, R.raw.fatah_sho,1);
        SuaraDod = soundPool.load(this, R.raw.fatah_dho,1);
        SuaraTo = soundPool.load(this, R.raw.fatah_tho,1);
        SuaraDo = soundPool.load(this, R.raw.fatah_dzho,1);
        SuaraAin = soundPool.load(this, R.raw.fatah_aa,1);
        SuaraGin = soundPool.load(this, R.raw.fatah_gho,1);
        Suarafa = soundPool.load(this, R.raw.fatah_fa,1);
        SuaraKof = soundPool.load(this, R.raw.fatah_qo,1);
        SuaraKaf = soundPool.load(this, R.raw.fatah_ka,1);
        SuaraLam = soundPool.load(this, R.raw.fatah_la,1);
        SuaraMim = soundPool.load(this, R.raw.fatah_ma,1);
        SuaraNun = soundPool.load(this, R.raw.fatah_na,1);
        SuaraWawu = soundPool.load(this, R.raw.fatah_wa,1);
        SuaraHA = soundPool.load(this, R.raw.fatah_haa,1);
        SuaraYa = soundPool.load(this, R.raw.fatah_ya,1);

        ImageButton ButtonSuara = findViewById(R.id.fatah_a);
        ImageButton ButtonSuara2 = findViewById(R.id.fatah_ba);
        ImageButton ButtonSuara3 = findViewById(R.id.fatah_ta);
        ImageButton ButtonSuara4 = findViewById(R.id.fatah_tsa);
        ImageButton ButtonSuara5 = findViewById(R.id.fatah_ja);
        ImageButton ButtonSuara6 = findViewById(R.id.fatah_ha);
        ImageButton ButtonSuara7 = findViewById(R.id.fatah_kha);
        ImageButton ButtonSuara8 = findViewById(R.id.fatah_da);
        ImageButton ButtonSuara9 = findViewById(R.id.fatah_dza);
        ImageButton ButtonSuara10 = findViewById(R.id.fatah_ro);
        ImageButton ButtonSuara11 = findViewById(R.id.fatah_za);
        ImageButton ButtonSuara12 = findViewById(R.id.fatah_sa);
        ImageButton ButtonSuara13 = findViewById(R.id.fatah_sya);
        ImageButton ButtonSuara14 = findViewById(R.id.fatah_sho);
        ImageButton ButtonSuara15 = findViewById(R.id.fatah_dho);
        ImageButton ButtonSuara16 = findViewById(R.id.fatah_tho);
        ImageButton ButtonSuara17 = findViewById(R.id.fatah_dzo);
        ImageButton ButtonSuara18 = findViewById(R.id.fatah_zz);
        ImageButton ButtonSuara19 = findViewById(R.id.fatah_gho);
        ImageButton ButtonSuara20 = findViewById(R.id.fatah_fa);
        ImageButton ButtonSuara21 = findViewById(R.id.fatah_qo);
        ImageButton ButtonSuara22 = findViewById(R.id.fatah_ka);
        ImageButton ButtonSuara23 = findViewById(R.id.fatah_lam);
        ImageButton ButtonSuara24 = findViewById(R.id.fatah_mim);
        ImageButton ButtonSuara25 = findViewById(R.id.fatah_nun);
        ImageButton ButtonSuara26 = findViewById(R.id.fatah_wa);
        ImageButton ButtonSuara27 = findViewById(R.id.fatah_haa);
        ImageButton ButtonSuara28 = findViewById(R.id.fatah_ya);

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
    public void onClick (View v){
        switch (v.getId()){
            case R.id.fatah_a:
                TampilGambar.setImageResource(R.drawable.pop_fatah_a);
                TampilGambar.startAnimation(anImScale);
                soundPool.play(SuaraAlif,1,1,0,0,1);
                break;
            case R.id.fatah_ba:
                TampilGambar.setImageResource(R.drawable.pop_fatah_ba);
                TampilGambar.startAnimation(anImScale);
                soundPool.play(SuaraBa,1,1,0,0,1);
                break;
            case R.id.fatah_ta:
                TampilGambar.setImageResource(R.drawable.pop_fatah_ta);
                TampilGambar.startAnimation(anImScale);
                soundPool.play(SuaraTa,1,1,0,0,1);
                break;
            case R.id.fatah_tsa:
                TampilGambar.setImageResource(R.drawable.pop_fatah_tsa);
                TampilGambar.startAnimation(anImScale);
                soundPool.play(SuaraSa,1,1,0,0,1);
                break;
            case R.id.fatah_ja:
                TampilGambar.setImageResource(R.drawable.pop_fatah_ja);
                TampilGambar.startAnimation(anImScale);
                soundPool.play(SuaraJim,1,1,0,0,1);
                break;
            case R.id.fatah_ha:
                TampilGambar.setImageResource(R.drawable.pop_fatah_ha);
                TampilGambar.startAnimation(anImScale);
                soundPool.play(SuaraHa,1,1,0,0,1);
                break;
            case R.id.fatah_kha:
                TampilGambar.setImageResource(R.drawable.pop_fatah_kha);
                TampilGambar.startAnimation(anImScale);
                soundPool.play(SuaraKho,1,1,0,0,1);
                break;
            case R.id.fatah_da:
                TampilGambar.setImageResource(R.drawable.pop_fatah_da);
                TampilGambar.startAnimation(anImScale);
                soundPool.play(SuaraDal,1,1,0,0,1);
                break;
            case R.id.fatah_dza:
                TampilGambar.setImageResource(R.drawable.pop_fatah_dza);
                TampilGambar.startAnimation(anImScale);
                soundPool.play(SuaraDzal,1,1,0,0,1);
                break;
            case R.id.fatah_ro:
                TampilGambar.setImageResource(R.drawable.pop_fatah_ra);
                TampilGambar.startAnimation(anImScale);
                soundPool.play(SuaraRo,1,1,0,0,1);
                break;
            case R.id.fatah_za:
                TampilGambar.setImageResource(R.drawable.pop_fatah_za);
                TampilGambar.startAnimation(anImScale);
                soundPool.play(Suaraza,1,1,0,0,1);
                break;
            case R.id.fatah_sa:
                TampilGambar.setImageResource(R.drawable.pop_fatah_sa);
                TampilGambar.startAnimation(anImScale);
                soundPool.play(SuaraSin,1,1,0,0,1);
                break;
            case R.id.fatah_sya:
                TampilGambar.setImageResource(R.drawable.pop_fatah_sya);
                TampilGambar.startAnimation(anImScale);
                soundPool.play(SuaraSyin,1,1,0,0,1);
                break;
            case R.id.fatah_sho:
                TampilGambar.setImageResource(R.drawable.pop_fatah_sha);
                TampilGambar.startAnimation(anImScale);
                soundPool.play(SuaraShad,1,1,0,0,1);
                break;
            case R.id.fatah_dho:
                TampilGambar.setImageResource(R.drawable.pop_fatah_dha);
                TampilGambar.startAnimation(anImScale);
                soundPool.play(SuaraDod ,1,1,0,0,1);
                break;
            case R.id.fatah_tho:
                TampilGambar.setImageResource(R.drawable.pop_fatah_tha);
                TampilGambar.startAnimation(anImScale);
                soundPool.play(SuaraTo ,1,1,0,0,1);
                break;
            case R.id.fatah_dzo:
                TampilGambar.setImageResource(R.drawable.pop_fatah_dzaa);
                TampilGambar.startAnimation(anImScale);
                soundPool.play(SuaraDo ,1,1,0,0,1);
                break;
            case R.id.fatah_zz:
                TampilGambar.setImageResource(R.drawable.pop_fatah_ain);
                TampilGambar.startAnimation(anImScale);
                soundPool.play(SuaraAin ,1,1,0,0,1);
                break;
            case R.id.fatah_gho:
                TampilGambar.setImageResource(R.drawable.pop_fatah_gha);
                TampilGambar.startAnimation(anImScale);
                soundPool.play(SuaraGin ,1,1,0,0,1);
                break;
            case R.id.fatah_fa:
                TampilGambar.setImageResource(R.drawable.pop_fatah_fa);
                TampilGambar.startAnimation(anImScale);
                soundPool.play(Suarafa ,1,1,0,0,1);
                break;
            case R.id.fatah_qo:
                TampilGambar.setImageResource(R.drawable.pop_fatah_qa);
                TampilGambar.startAnimation(anImScale);
                soundPool.play(SuaraKof ,1,1,0,0,1);
                break;
            case R.id.fatah_ka:
                TampilGambar.setImageResource(R.drawable.pop_fatah_ka);
                TampilGambar.startAnimation(anImScale);
                soundPool.play(SuaraKaf ,1,1,0,0,1);
                break;
            case R.id.fatah_lam:
                TampilGambar.setImageResource(R.drawable.pop_fatah_la);
                TampilGambar.startAnimation(anImScale);
                soundPool.play(SuaraLam ,1,1,0,0,1);
                break;
            case R.id.fatah_mim:
                TampilGambar.setImageResource(R.drawable.pop_fatah_ma);
                TampilGambar.startAnimation(anImScale);
                soundPool.play(SuaraMim ,1,1,0,0,1);
                break;
            case R.id.fatah_nun:
                TampilGambar.setImageResource(R.drawable.pop_fatah_na);
                TampilGambar.startAnimation(anImScale);
                soundPool.play(SuaraNun ,1,1,0,0,1);
                break;
            case R.id.fatah_wa:
                TampilGambar.setImageResource(R.drawable.pop_fatah_wa);
                TampilGambar.startAnimation(anImScale);
                soundPool.play(SuaraWawu ,1,1,0,0,1);
                break;
            case R.id.fatah_haa:
                TampilGambar.setImageResource(R.drawable.pop_fatah_haa);
                TampilGambar.startAnimation(anImScale);
                soundPool.play(SuaraHA ,1,1,0,0,1);
                break;
            case R.id.fatah_ya:
                TampilGambar.setImageResource(R.drawable.pop_fatah_ya);
                TampilGambar.startAnimation(anImScale);
                soundPool.play(SuaraYa ,1,1,0,0,1);
                break;
        }
    }
    protected void onDestroy() {
        super.onDestroy();
        soundPool.release();
        soundPool = null;
    }


}

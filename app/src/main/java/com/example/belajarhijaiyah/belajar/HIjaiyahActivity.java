package com.example.belajarhijaiyah.belajar;

import androidx.appcompat.app.AppCompatActivity;

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

public class HIjaiyahActivity extends AppCompatActivity implements View.OnClickListener {
    ImageButton show,hide,kembali;
    ImageView TampilGambar;
    private SoundPool soundPool;
    private int SuaraAlif,SuaraBa,SuaraTa,SuaraSa,SuaraJim,SuaraHa,SuaraKho,SuaraDal,SuaraDzal,SuaraRo,
            SuaraZa,SuaraSin,SuaraSyin,SuaraShad,SuaraDod,SuaraTo,SuaraDo,SuaraAin,SuaraGin,Suarafa,SuaraKof,
            SuaraKaf,SuaraLam,SuaraMim,SuaraNun,SuaraWawu,SuaraHA,SuaraYa;
    Animation anImScale;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hijaiyah);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        anImScale = AnimationUtils.loadAnimation(this,R.anim.anim_scale);

        TampilGambar = findViewById(R.id.tampil_hijaiyah);
        show = findViewById(R.id.alif);
        hide = findViewById(R.id.ba);
        kembali= findViewById(R.id.kembali);

        show.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                TampilGambar.setVisibility(View.VISIBLE);
            }

        });

        hide.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                TampilGambar.setVisibility(View.INVISIBLE);
            }

        });

        kembali.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
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
        SuaraAlif = soundPool.load(this, R.raw.hijaiyah_alif,1);
        SuaraBa = soundPool.load(this, R.raw.hijaiyah_ba,1);
        SuaraTa = soundPool.load(this, R.raw.hijaiyah_ta,1);
        SuaraSa = soundPool.load(this, R.raw.hijaiyah_tsa,1);
        SuaraJim = soundPool.load(this, R.raw.hijaiyah_ja,1);
        SuaraHa = soundPool.load(this, R.raw.hijaiyah_ha,1);
        SuaraKho = soundPool.load(this, R.raw.hijaiyah_kha,1);
        SuaraDal = soundPool.load(this, R.raw.hijaiyah_da,1);
        SuaraDzal = soundPool.load(this, R.raw.hijaiyah_dza,1);
        SuaraRo = soundPool.load(this, R.raw.hijaiyah_ro,1);
        SuaraZa = soundPool.load(this, R.raw.hijaiyah_zha,1);
        SuaraSin = soundPool.load(this, R.raw.hijaiyah_sin,1);
        SuaraSyin = soundPool.load(this, R.raw.hijaiyah_syin,1);
        SuaraShad = soundPool.load(this, R.raw.hijaiyah_sho,1);
        SuaraDod = soundPool.load(this, R.raw.hijaiyah_dzho,1);
        SuaraTo = soundPool.load(this, R.raw.hijaiyah_tho,1);
        SuaraDo = soundPool.load(this, R.raw.hijaiyah_dho,1);
        SuaraAin = soundPool.load(this, R.raw.hijaiyah_ain,1);
        SuaraGin = soundPool.load(this, R.raw.hijaiyah_gho,1);
        Suarafa = soundPool.load(this, R.raw.hijaiyah_fa,1);
        SuaraKof = soundPool.load(this, R.raw.hijaiyah_qo,1);
        SuaraKaf = soundPool.load(this, R.raw.hijaiyah_ka,1);
        SuaraLam = soundPool.load(this, R.raw.hijaiyah_lam,1);
        SuaraMim = soundPool.load(this, R.raw.hijaiyah_min,1);
        SuaraNun = soundPool.load(this, R.raw.hijaiyah_nun,1);
        SuaraWawu = soundPool.load(this, R.raw.hijaiyah_wawu,1);
        SuaraHA = soundPool.load(this, R.raw.hijaiyah_haa,1);
        SuaraYa = soundPool.load(this, R.raw.hijaiyah_ya,1);


        ImageButton ButtonSuara = this.findViewById(R.id.alif);
        ImageButton ButtonSuara2 = this.findViewById(R.id.ba);
        ImageButton ButtonSuara3 = this.findViewById(R.id.ta);
        ImageButton ButtonSuara4 = this.findViewById(R.id.tsa);
        ImageButton ButtonSuara5 = this.findViewById(R.id.ja);
        ImageButton ButtonSuara6 = this.findViewById(R.id.ha);
        ImageButton ButtonSuara7 = this.findViewById(R.id.kha);
        ImageButton ButtonSuara8 = this.findViewById(R.id.da);
        ImageButton ButtonSuara9 = this.findViewById(R.id.dza);
        ImageButton ButtonSuara10 = this.findViewById(R.id.ro);
        ImageButton ButtonSuara11 = this.findViewById(R.id.za);
        ImageButton ButtonSuara12 = this.findViewById(R.id.sin);
        ImageButton ButtonSuara13 = this.findViewById(R.id.syin);
        ImageButton ButtonSuara14 = this.findViewById(R.id.sod);
        ImageButton ButtonSuara15 = this.findViewById(R.id.dho);
        ImageButton ButtonSuara16 = this.findViewById(R.id.tho);
        ImageButton ButtonSuara17 = this.findViewById(R.id.dod);
        ImageButton ButtonSuara18 = this.findViewById(R.id.ain);
        ImageButton ButtonSuara19 = this.findViewById(R.id.ghain);
        ImageButton ButtonSuara20 = this.findViewById(R.id.fa);
        ImageButton ButtonSuara21 = this.findViewById(R.id.kof);
        ImageButton ButtonSuara22 = this.findViewById(R.id.ka);
        ImageButton ButtonSuara23 = this.findViewById(R.id.lam);
        ImageButton ButtonSuara24 = this.findViewById(R.id.mim);
        ImageButton ButtonSuara25 = this.findViewById(R.id.nun);
        ImageButton ButtonSuara26 = this.findViewById(R.id.wau);
        ImageButton ButtonSuara27 = this.findViewById(R.id.haa);
        ImageButton ButtonSuara28 = this.findViewById(R.id.ya);

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
            case R.id.alif:
                TampilGambar.setImageResource(R.drawable.pop_alif);
                TampilGambar.startAnimation(anImScale);
                soundPool.play(SuaraAlif,1,1,0,0,1);
                break;
            case R.id.ba:
                TampilGambar.setImageResource(R.drawable.pop_ba);
                TampilGambar.startAnimation(anImScale);
                soundPool.play(SuaraBa,1,1,0,0,1);
                break;
            case R.id.ta:
                TampilGambar.setImageResource(R.drawable.pop_ta);
                TampilGambar.startAnimation(anImScale);
                soundPool.play(SuaraTa,1,1,0,0,1);
                break;
            case R.id.tsa:
                TampilGambar.setImageResource(R.drawable.pop_tsa);
                TampilGambar.startAnimation(anImScale);
                soundPool.play(SuaraSa,1,1,0,0,1);
                break;
            case R.id.ja:
                TampilGambar.setImageResource(R.drawable.pop_jim);
                TampilGambar.startAnimation(anImScale);
                soundPool.play(SuaraJim,1,1,0,0,1);
                break;
            case R.id.ha:
                TampilGambar.setImageResource(R.drawable.pop_ha);
                TampilGambar.startAnimation(anImScale);
                soundPool.play(SuaraHa,1,1,0,0,1);
                break;
            case R.id.kha:
                TampilGambar.setImageResource(R.drawable.pop_kha);
                TampilGambar.startAnimation(anImScale);
                soundPool.play(SuaraKho,1,1,0,0,1);
                break;
            case R.id.da:
                TampilGambar.setImageResource(R.drawable.pop_dal);
                TampilGambar.startAnimation(anImScale);
                soundPool.play(SuaraDal,1,1,0,0,1);
                break;
            case R.id.dza:
                TampilGambar.setImageResource(R.drawable.pop_dzal);
                TampilGambar.startAnimation(anImScale);
                soundPool.play(SuaraDzal,1,1,0,0,1);
                break;
            case R.id.ro:
                TampilGambar.setImageResource(R.drawable.pop_ra);
                TampilGambar.startAnimation(anImScale);
                soundPool.play(SuaraRo,1,1,0,0,1);
                break;
            case R.id.za:
                TampilGambar.setImageResource(R.drawable.pop_zai);
                TampilGambar.startAnimation(anImScale);
                soundPool.play(SuaraZa,1,1,0,0,1);
                break;
            case R.id.sin:
                TampilGambar.setImageResource(R.drawable.pop_sin);
                TampilGambar.startAnimation(anImScale);
                soundPool.play(SuaraSin,1,1,0,0,1);
                break;
            case R.id.syin:
                TampilGambar.setImageResource(R.drawable.pop_syin);
                TampilGambar.startAnimation(anImScale);
                soundPool.play(SuaraSyin,1,1,0,0,1);
                break;
            case R.id.sod:
                TampilGambar.setImageResource(R.drawable.pop_shad);
                TampilGambar.startAnimation(anImScale);
                soundPool.play(SuaraShad,1,1,0,0,1);
                break;
            case R.id.dho:
                TampilGambar.setImageResource(R.drawable.pop_dhad);
                TampilGambar.startAnimation(anImScale);
                soundPool.play(SuaraDod ,1,1,0,0,1);
                break;
            case R.id.tho:
                TampilGambar.setImageResource(R.drawable.pop_tha);
                TampilGambar.startAnimation(anImScale);
                soundPool.play(SuaraTo ,1,1,0,0,1);
                break;
            case R.id.dod:
                TampilGambar.setImageResource(R.drawable.pop_zha);
                TampilGambar.startAnimation(anImScale);
                soundPool.play(SuaraDo ,1,1,0,0,1);
                break;
            case R.id.ain:
                TampilGambar.setImageResource(R.drawable.pop_ain);
                TampilGambar.startAnimation(anImScale);
                soundPool.play(SuaraAin ,1,1,0,0,1);
                break;
            case R.id.ghain:
                TampilGambar.setImageResource(R.drawable.pop_hijaiyah_ghain);
                TampilGambar.startAnimation(anImScale);
                soundPool.play(SuaraGin ,1,1,0,0,1);
                break;
            case R.id.fa:
                TampilGambar.setImageResource(R.drawable.pop_fa);
                TampilGambar.startAnimation(anImScale);
                soundPool.play(Suarafa ,1,1,0,0,1);
                break;
            case R.id.kof:
                TampilGambar.setImageResource(R.drawable.pop_qaf);
                TampilGambar.startAnimation(anImScale);
                soundPool.play(SuaraKof ,1,1,0,0,1);
                break;
            case R.id.ka:
                TampilGambar.setImageResource(R.drawable.pop_kaf);
                TampilGambar.startAnimation(anImScale);
                soundPool.play(SuaraKaf ,1,1,0,0,1);
                break;
            case R.id.lam:
                TampilGambar.setImageResource(R.drawable.pop_lam);
                TampilGambar.startAnimation(anImScale);
                soundPool.play(SuaraLam ,1,1,0,0,1);
                break;
            case R.id.mim:
                TampilGambar.setImageResource(R.drawable.pop_mim);
                TampilGambar.startAnimation(anImScale);
                soundPool.play(SuaraMim ,1,1,0,0,1);
                break;
            case R.id.nun:
                TampilGambar.setImageResource(R.drawable.pop_nun);
                TampilGambar.startAnimation(anImScale);
                soundPool.play(SuaraNun ,1,1,0,0,1);
                break;
            case R.id.wau:
                TampilGambar.setImageResource(R.drawable.pop_wawu);
                TampilGambar.startAnimation(anImScale);
                soundPool.play(SuaraWawu ,1,1,0,0,1);
                break;
            case R.id.haa:
                TampilGambar.setImageResource(R.drawable.pop_haa);
                TampilGambar.startAnimation(anImScale);
                soundPool.play(SuaraHA ,1,1,0,0,1);
                break;
            case R.id.ya:
                TampilGambar.setImageResource(R.drawable.pop_ya);
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

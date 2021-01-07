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

public class FaTainActivity extends AppCompatActivity implements View.OnClickListener{
    ImageButton show, hide, kembali;
    ImageView TampilGambar;
    Animation animScale;
    SoundPool soundPool;
    private int SuaraAlif,SuaraBa,SuaraTa,SuaraSa,SuaraJim,SuaraHa,SuaraKho,SuaraDal,SuaraDzal,SuaraRo,
            SuaraZa,SuaraSin,SuaraSyin,SuaraShad,SuaraDod,SuaraTo,SuaraDo,SuaraAin,SuaraGin,Suarafa,SuaraKof,
            SuaraKaf,SuaraLam,SuaraMim,SuaraNun,SuaraWawu,SuaraHA,SuaraYa;

    @SuppressLint("CutPasteId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fa_tain);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        animScale = AnimationUtils.loadAnimation(this, R.anim.anim_scale);
        TampilGambar = findViewById(R.id.tampil_huruf);
        show = findViewById(R.id.tain_an);
        hide = findViewById(R.id.tain_ban);
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
        SuaraAlif = soundPool.load(this, R.raw.tanwin_fathah_an,1);
        SuaraBa = soundPool.load(this, R.raw.tanwin_fathah_ban,1);
        SuaraTa = soundPool.load(this, R.raw.tanwin_fathah_tan,1);
        SuaraSa = soundPool.load(this, R.raw.tanwin_fathah_tsan,1);
        SuaraJim = soundPool.load(this, R.raw.tanwin_fathah_jan,1);
        SuaraHa = soundPool.load(this, R.raw.tanwin_fathah_han,1);
        SuaraKho = soundPool.load(this, R.raw.tanwin_fathah_khon,1);
        SuaraDal = soundPool.load(this, R.raw.tanwin_fathah_dan,1);
        SuaraDzal = soundPool.load(this, R.raw.tanwin_fathah_dzan,1);
        SuaraRo = soundPool.load(this, R.raw.tanwin_fathah_ron,1);
        SuaraZa = soundPool.load(this, R.raw.tanwin_fathah_zan,1);
        SuaraSin = soundPool.load(this, R.raw.tanwin_fathah_san,1);
        SuaraSyin = soundPool.load(this, R.raw.tanwin_fathah_syan,1);
        SuaraShad = soundPool.load(this, R.raw.tanwin_fathah_shon,1);
        SuaraDod = soundPool.load(this, R.raw.tanwin_fathah_dhon,1);
        SuaraTo = soundPool.load(this, R.raw.tanwin_fathah_thon,1);
        SuaraDo = soundPool.load(this, R.raw.tanwin_fathah_dzhon,1);
        SuaraAin = soundPool.load(this, R.raw.tanwin_fathah_aan,1);
        SuaraGin = soundPool.load(this, R.raw.tanwin_fathah_ghon,1);
        Suarafa = soundPool.load(this, R.raw.tanwin_fathah_fan,1);
        SuaraKof = soundPool.load(this, R.raw.tanwin_fathah_qon,1);
        SuaraKaf = soundPool.load(this, R.raw.tanwin_fathah_kan,1);
        SuaraLam = soundPool.load(this, R.raw.tanwin_fathah_lan,1);
        SuaraMim = soundPool.load(this, R.raw.tanwin_fathah_man,1);
        SuaraNun = soundPool.load(this, R.raw.tanwin_fathah_nan,1);
        SuaraWawu = soundPool.load(this, R.raw.tanwin_fathah_wan,1);
        SuaraHA = soundPool.load(this, R.raw.tanwin_fathah_haan,1);
        SuaraYa = soundPool.load(this, R.raw.tanwin_fathah_yan,1);

        ImageButton ButtonSuara = findViewById(R.id.tain_an);
        ImageButton ButtonSuara2 = findViewById(R.id.tain_ban);
        ImageButton ButtonSuara3 = findViewById(R.id.tain_tan);
        ImageButton ButtonSuara4 = findViewById(R.id.tain_tsin);
        ImageButton ButtonSuara5 = findViewById(R.id.tain_jan);
        ImageButton ButtonSuara6 = findViewById(R.id.tain_han);
        ImageButton ButtonSuara7 = findViewById(R.id.tain_khon);
        ImageButton ButtonSuara8 = findViewById(R.id.tain_dan);
        ImageButton ButtonSuara9 = findViewById(R.id.tain_dzan);
        ImageButton ButtonSuara10 = findViewById(R.id.tain_ron);
        ImageButton ButtonSuara11 = findViewById(R.id.tain_zan);
        ImageButton ButtonSuara12 = findViewById(R.id.tain_san);
        ImageButton ButtonSuara13 = findViewById(R.id.tain_syan);
        ImageButton ButtonSuara14 = findViewById(R.id.tain_shon);
        ImageButton ButtonSuara15 = findViewById(R.id.tain_dhon);
        ImageButton ButtonSuara16 = findViewById(R.id.tain_thon);
        ImageButton ButtonSuara17 = findViewById(R.id.tain_dzon);
        ImageButton ButtonSuara18 = findViewById(R.id.tain_ain);
        ImageButton ButtonSuara19 = findViewById(R.id.tain_ghon);
        ImageButton ButtonSuara20 = findViewById(R.id.tain_fan);
        ImageButton ButtonSuara21 = findViewById(R.id.tain_qon);
        ImageButton ButtonSuara22 = findViewById(R.id.tain_kan);
        ImageButton ButtonSuara23 = findViewById(R.id.tain_lan);
        ImageButton ButtonSuara24 = findViewById(R.id.tain_man);
        ImageButton ButtonSuara25 = findViewById(R.id.tain_nan);
        ImageButton ButtonSuara26 = findViewById(R.id.tain_wan);
        ImageButton ButtonSuara27 = findViewById(R.id.tain_hann);
        ImageButton ButtonSuara28 = findViewById(R.id.tain_yan);

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
            case R.id.tain_an:
                TampilGambar.setImageResource(R.drawable.pop_fatahtain_an);
                TampilGambar.startAnimation(animScale);
                soundPool.play(SuaraAlif,1,1,0,0,1);
                break;
            case R.id.tain_ban:
                TampilGambar.setImageResource(R.drawable.pop_fatahtain_ban);
                TampilGambar.startAnimation(animScale);
                soundPool.play(SuaraBa,1,1,0,0,1);
                break;
            case R.id.tain_tan:
                TampilGambar.setImageResource(R.drawable.pop_fatahtain_tan);
                TampilGambar.startAnimation(animScale);
                soundPool.play(SuaraTa,1,1,0,0,1);
                break;
            case R.id.tain_tsin:
                TampilGambar.setImageResource(R.drawable.pop_fatahtain_tsan);
                TampilGambar.startAnimation(animScale);
                soundPool.play(SuaraSa,1,1,0,0,1);
                break;
            case R.id.tain_jan:
                TampilGambar.setImageResource(R.drawable.pop_fatahtain_jan);
                TampilGambar.startAnimation(animScale);
                soundPool.play(SuaraJim,1,1,0,0,1);
                break;
            case R.id.tain_han:
                TampilGambar.setImageResource(R.drawable.pop_fatahtain_han);
                TampilGambar.startAnimation(animScale);
                soundPool.play(SuaraHa,1,1,0,0,1);
                break;
            case R.id.tain_khon:
                TampilGambar.setImageResource(R.drawable.pop_fatahtain_khan);
                TampilGambar.startAnimation(animScale);
                soundPool.play(SuaraKho,1,1,0,0,1);
                break;
            case R.id.tain_dan:
                TampilGambar.setImageResource(R.drawable.pop_fatahtain_dan);
                TampilGambar.startAnimation(animScale);
                soundPool.play(SuaraDal,1,1,0,0,1);
                break;
            case R.id.tain_dzan:
                TampilGambar.setImageResource(R.drawable.pop_fatahtain_dzan);
                TampilGambar.startAnimation(animScale);
                soundPool.play(SuaraDzal,1,1,0,0,1);
                break;
            case R.id.tain_ron:
                TampilGambar.setImageResource(R.drawable.pop_fatahtain_ran);
                TampilGambar.startAnimation(animScale);
                soundPool.play(SuaraRo,1,1,0,0,1);
                break;
            case R.id.tain_zan:
                TampilGambar.setImageResource(R.drawable.pop_fatahtain_zan);
                TampilGambar.startAnimation(animScale);
                soundPool.play(SuaraZa,1,1,0,0,1);
                break;
            case R.id.tain_san:
                TampilGambar.setImageResource(R.drawable.pop_fatahtain_san);
                TampilGambar.startAnimation(animScale);
                soundPool.play(SuaraSin,1,1,0,0,1);
                break;
            case R.id.tain_syan:
                TampilGambar.setImageResource(R.drawable.pop_fatahtain_syan);
                TampilGambar.startAnimation(animScale);
                soundPool.play(SuaraSyin,1,1,0,0,1);
                break;
            case R.id.tain_shon:
                TampilGambar.setImageResource(R.drawable.pop_fatahtain_shan);
                TampilGambar.startAnimation(animScale);
                soundPool.play(SuaraShad,1,1,0,0,1);
                break;
            case R.id.tain_dhon:
                TampilGambar.setImageResource(R.drawable.pop_fatahtain_dhan);
                TampilGambar.startAnimation(animScale);
                soundPool.play(SuaraDod ,1,1,0,0,1);
                break;
            case R.id.tain_thon:
                TampilGambar.setImageResource(R.drawable.pop_fatahtain_than);
                TampilGambar.startAnimation(animScale);
                soundPool.play(SuaraTo ,1,1,0,0,1);
                break;
            case R.id.tain_dzon:
                TampilGambar.setImageResource(R.drawable.pop_fatahtain_dzan);
                TampilGambar.startAnimation(animScale);
                soundPool.play(SuaraDo ,1,1,0,0,1);
                break;
            case R.id.tain_ain:
                TampilGambar.setImageResource(R.drawable.pop_fatahtain_aan);
                TampilGambar.startAnimation(animScale);
                soundPool.play(SuaraAin ,1,1,0,0,1);
                break;
            case R.id.tain_ghon:
                TampilGambar.setImageResource(R.drawable.pop_fatahtain_ghan);
                TampilGambar.startAnimation(animScale);
                soundPool.play(SuaraGin ,1,1,0,0,1);
                break;
            case R.id.tain_fan:
                TampilGambar.setImageResource(R.drawable.pop_fatahtain_fan);
                TampilGambar.startAnimation(animScale);
                soundPool.play(Suarafa ,1,1,0,0,1);
                break;
            case R.id.tain_qon:
                TampilGambar.setImageResource(R.drawable.pop_fatahtain_qan);
                TampilGambar.startAnimation(animScale);
                soundPool.play(SuaraKof ,1,1,0,0,1);
                break;
            case R.id.tain_kan:
                TampilGambar.setImageResource(R.drawable.pop_fatahtain_kan);
                TampilGambar.startAnimation(animScale);
                soundPool.play(SuaraKaf ,1,1,0,0,1);
                break;
            case R.id.tain_lan:
                TampilGambar.setImageResource(R.drawable.pop_fatahtain_lan);
                TampilGambar.startAnimation(animScale);
                soundPool.play(SuaraLam ,1,1,0,0,1);
                break;
            case R.id.tain_man:
                TampilGambar.setImageResource(R.drawable.pop_fatahtain_ma);
                TampilGambar.startAnimation(animScale);
                soundPool.play(SuaraMim ,1,1,0,0,1);
                break;
            case R.id.tain_nan:
                TampilGambar.setImageResource(R.drawable.pop_fatahtain_nan);
                TampilGambar.startAnimation(animScale);
                soundPool.play(SuaraNun ,1,1,0,0,1);
                break;
            case R.id.tain_wan:
                TampilGambar.setImageResource(R.drawable.pop_fatahtain_wan);
                TampilGambar.startAnimation(animScale);
                soundPool.play(SuaraWawu ,1,1,0,0,1);
                break;
            case R.id.tain_hann:
                TampilGambar.setImageResource(R.drawable.pop_fatahtain_haan);
                TampilGambar.startAnimation(animScale);
                soundPool.play(SuaraHA ,1,1,0,0,1);
                break;
            case R.id.tain_yan:
                TampilGambar.setImageResource(R.drawable.pop_fatahtain_yan);
                TampilGambar.startAnimation(animScale);
                soundPool.play(SuaraYa ,1,1,0,0,1);
                break;
        }
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        soundPool.release();
        soundPool = null;
    }

}

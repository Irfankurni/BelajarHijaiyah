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

public class DhommahActivity extends AppCompatActivity implements View.OnClickListener{
    ImageButton kembali, show, hide;
    SoundPool soundPool;
    private int SuaraAlif, SuaraBa, SuaraTa, SuaraSa, SuaraJim, SuaraHa, SuaraKho, SuaraDal, SuaraDzal, SuaraRo,
            Suaraza, SuaraSin, SuaraSyin, SuaraShad, SuaraDod, SuaraTo, SuaraDo, SuaraAin, SuaraGin, Suarafa, SuaraKof,
            SuaraKaf, SuaraLam, SuaraMim, SuaraNun, SuaraWawu, SuaraHA, SuaraYa;
    ImageView TampilGambar;
    Animation anImScale;

    @SuppressLint("CutPasteId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dhommah);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        TampilGambar = findViewById(R.id.tampil_domah);
        show = findViewById(R.id.domah_u);
        hide = findViewById(R.id.domah_bu);
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
        SuaraAlif = soundPool.load(this, R.raw.u, 1);
        SuaraBa = soundPool.load(this, R.raw.bu, 1);
        SuaraTa = soundPool.load(this, R.raw.tu, 1);
        SuaraSa = soundPool.load(this, R.raw.tsu, 1);
        SuaraJim = soundPool.load(this, R.raw.ju, 1);
        SuaraHa = soundPool.load(this, R.raw.hu, 1);
        SuaraKho = soundPool.load(this, R.raw.khu, 1);
        SuaraDal = soundPool.load(this, R.raw.du, 1);
        SuaraDzal = soundPool.load(this, R.raw.dzu, 1);
        SuaraRo = soundPool.load(this, R.raw.ru, 1);
        Suaraza = soundPool.load(this, R.raw.zu, 1);
        SuaraSin = soundPool.load(this, R.raw.su, 1);
        SuaraSyin = soundPool.load(this, R.raw.syu, 1);
        SuaraShad = soundPool.load(this, R.raw.shu, 1);
        SuaraDod = soundPool.load(this, R.raw.dhu, 1);
        SuaraTo = soundPool.load(this, R.raw.thu, 1);
        SuaraDo = soundPool.load(this, R.raw.dzhu, 1);
        SuaraAin = soundPool.load(this, R.raw.uu, 1);
        SuaraGin = soundPool.load(this, R.raw.ghu, 1);
        Suarafa = soundPool.load(this, R.raw.fu, 1);
        SuaraKof = soundPool.load(this, R.raw.qu, 1);
        SuaraKaf = soundPool.load(this, R.raw.ku, 1);
        SuaraLam = soundPool.load(this, R.raw.lu, 1);
        SuaraMim = soundPool.load(this, R.raw.mu, 1);
        SuaraNun = soundPool.load(this, R.raw.nu, 1);
        SuaraWawu = soundPool.load(this, R.raw.wu, 1);
        SuaraHA = soundPool.load(this, R.raw.huu, 1);
        SuaraYa = soundPool.load(this, R.raw.yu, 1);

        ImageButton ButtonSuara = findViewById(R.id.domah_u);
        ImageButton ButtonSuara2 = findViewById(R.id.domah_bu);
        ImageButton ButtonSuara3 = findViewById(R.id.domah_tu);
        ImageButton ButtonSuara4 = findViewById(R.id.domah_tsu);
        ImageButton ButtonSuara5 = findViewById(R.id.domah_ju);
        ImageButton ButtonSuara6 = findViewById(R.id.domah_hu);
        ImageButton ButtonSuara7 = findViewById(R.id.domah_khu);
        ImageButton ButtonSuara8 = findViewById(R.id.domah_du);
        ImageButton ButtonSuara9 = findViewById(R.id.domah_dzu);
        ImageButton ButtonSuara10 = findViewById(R.id.domah_ru);
        ImageButton ButtonSuara11 = findViewById(R.id.domah_zu);
        ImageButton ButtonSuara12 = findViewById(R.id.domah_su);
        ImageButton ButtonSuara13 = findViewById(R.id.domah_syu);
        ImageButton ButtonSuara14 = findViewById(R.id.domah_shu);
        ImageButton ButtonSuara15 = findViewById(R.id.domah_dhu);
        ImageButton ButtonSuara16 = findViewById(R.id.domah_thu);
        ImageButton ButtonSuara17 = findViewById(R.id.domah_duu);
        ImageButton ButtonSuara18 = findViewById(R.id.domah_uu);
        ImageButton ButtonSuara19 = findViewById(R.id.domah_ghu);
        ImageButton ButtonSuara20 = findViewById(R.id.domah_fu);
        ImageButton ButtonSuara21 = findViewById(R.id.domah_qu);
        ImageButton ButtonSuara22 = findViewById(R.id.domah_ku);
        ImageButton ButtonSuara23 = findViewById(R.id.domah_lu);
        ImageButton ButtonSuara24 = findViewById(R.id.domah_mu);
        ImageButton ButtonSuara25 = findViewById(R.id.domah_nu);
        ImageButton ButtonSuara26 = findViewById(R.id.domah_wu);
        ImageButton ButtonSuara27 = findViewById(R.id.domah_huu);
        ImageButton ButtonSuara28 = findViewById(R.id.domah_yu);

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
            case R.id.domah_u:
                soundPool.play(SuaraAlif,1,1,0,0,1);
                TampilGambar.setImageResource(R.drawable.pop_domah_u);
                TampilGambar.startAnimation(anImScale);
                break;
            case R.id.domah_bu:
                TampilGambar.setImageResource(R.drawable.pop_domah_bu);
                soundPool.play(SuaraBa,1,1,0,0,1);
                TampilGambar.startAnimation(anImScale);
                break;
            case R.id.domah_tu:
                TampilGambar.setImageResource(R.drawable.pop_domah_tu);
                soundPool.play(SuaraTa,1,1,0,0,1);
                TampilGambar.startAnimation(anImScale);
                break;
            case R.id.domah_tsu:
                TampilGambar.setImageResource(R.drawable.pop_domah_tsu);
                soundPool.play(SuaraSa,1,1,0,0,1);
                TampilGambar.startAnimation(anImScale);
                break;
            case R.id.domah_ju:
                TampilGambar.setImageResource(R.drawable.pop_domah_ju);
                soundPool.play(SuaraJim,1,1,0,0,1);
                TampilGambar.startAnimation(anImScale);
                break;
            case R.id.domah_hu:
                TampilGambar.setImageResource(R.drawable.pop_domah_hu);
                soundPool.play(SuaraHa,1,1,0,0,1);
                TampilGambar.startAnimation(anImScale);
                break;
            case R.id.domah_khu:
                TampilGambar.setImageResource(R.drawable.pop_domah_khu);
                soundPool.play(SuaraKho,1,1,0,0,1);
                TampilGambar.startAnimation(anImScale);
                break;
            case R.id.domah_du:
                TampilGambar.setImageResource(R.drawable.pop_domah_du);
                soundPool.play(SuaraDal,1,1,0,0,1);
                TampilGambar.startAnimation(anImScale);
                break;
            case R.id.domah_dzu:
                TampilGambar.setImageResource(R.drawable.pop_domah_dzu);
                soundPool.play(SuaraDzal,1,1,0,0,1);
                TampilGambar.startAnimation(anImScale);
                break;
            case R.id.domah_ru:
                TampilGambar.setImageResource(R.drawable.pop_domah_ru);
                soundPool.play(SuaraRo,1,1,0,0,1);
                TampilGambar.startAnimation(anImScale);
                break;
            case R.id.domah_zu:
                TampilGambar.setImageResource(R.drawable.pop_domah_zu);
                soundPool.play(Suaraza,1,1,0,0,1);
                TampilGambar.startAnimation(anImScale);
                break;
            case R.id.domah_su:
                TampilGambar.setImageResource(R.drawable.pop_domah_su);
                soundPool.play(SuaraSin,1,1,0,0,1);
                TampilGambar.startAnimation(anImScale);
                break;
            case R.id.domah_syu:
                TampilGambar.setImageResource(R.drawable.pop_domah_syu);
                soundPool.play(SuaraSyin,1,1,0,0,1);
                TampilGambar.startAnimation(anImScale);
                break;
            case R.id.domah_shu:
                TampilGambar.setImageResource(R.drawable.pop_domah_shu);
                soundPool.play(SuaraShad,1,1,0,0,1);
                TampilGambar.startAnimation(anImScale);
                break;
            case R.id.domah_dhu:
                TampilGambar.setImageResource(R.drawable.pop_domah_dhu);
                soundPool.play(SuaraDod,1,1,0,0,1);
                TampilGambar.startAnimation(anImScale);
                break;
            case R.id.domah_thu:
                TampilGambar.setImageResource(R.drawable.pop_domah_thu);
                soundPool.play(SuaraTo ,1,1,0,0,1);
                TampilGambar.startAnimation(anImScale);
                break;
            case R.id.domah_duu:
                TampilGambar.setImageResource(R.drawable.pop_domah_dzuu);
                soundPool.play(SuaraDo ,1,1,0,0,1);
                TampilGambar.startAnimation(anImScale);
                break;
            case R.id.domah_uu:
                TampilGambar.setImageResource(R.drawable.pop_domah_uu);
                soundPool.play(SuaraAin ,1,1,0,0,1);
                TampilGambar.startAnimation(anImScale);
                break;
            case R.id.domah_ghu:
                TampilGambar.setImageResource(R.drawable.pop_domah_ghu);
                soundPool.play(SuaraGin ,1,1,0,0,1);
                TampilGambar.startAnimation(anImScale);
                break;
            case R.id.domah_fu:
                TampilGambar.setImageResource(R.drawable.pop_domah_fu);
                soundPool.play(Suarafa ,1,1,0,0,1);
                TampilGambar.startAnimation(anImScale);
                break;
            case R.id.domah_qu:
                TampilGambar.setImageResource(R.drawable.pop_domah_qu);
                soundPool.play(SuaraKof ,1,1,0,0,1);
                TampilGambar.startAnimation(anImScale);
                break;
            case R.id.domah_ku:
                TampilGambar.setImageResource(R.drawable.pop_domah_ku);
                soundPool.play(SuaraKaf ,1,1,0,0,1);
                TampilGambar.startAnimation(anImScale);
                break;
            case R.id.domah_lu:
                TampilGambar.setImageResource(R.drawable.pop_domah_lu);
                soundPool.play(SuaraLam ,1,1,0,0,1);
                TampilGambar.startAnimation(anImScale);
                break;
            case R.id.domah_mu:
                TampilGambar.setImageResource(R.drawable.pop_domah_mu);
                soundPool.play(SuaraMim ,1,1,0,0,1);
                TampilGambar.startAnimation(anImScale);
                break;
            case R.id.domah_nu:
                TampilGambar.setImageResource(R.drawable.pop_domah_nu);
                soundPool.play(SuaraNun ,1,1,0,0,1);
                TampilGambar.startAnimation(anImScale);
                break;
            case R.id.domah_wu:
                TampilGambar.setImageResource(R.drawable.pop_domah_wu);
                soundPool.play(SuaraWawu ,1,1,0,0,1);
                TampilGambar.startAnimation(anImScale);
                break;
            case R.id.domah_huu:
                TampilGambar.setImageResource(R.drawable.pop_domah_huu);
                soundPool.play(SuaraHA ,1,1,0,0,1);
                TampilGambar.startAnimation(anImScale);
                break;
            case R.id.domah_yu:
                TampilGambar.setImageResource(R.drawable.pop_domah_yu);
                soundPool.play(SuaraYa ,1,1,0,0,1);
                TampilGambar.startAnimation(anImScale);
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

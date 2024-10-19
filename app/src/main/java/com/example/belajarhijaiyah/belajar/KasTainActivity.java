package com.example.belajarhijaiyah.belajar;

import android.annotation.SuppressLint;
import android.content.pm.ActivityInfo;
import android.media.AudioAttributes;
import android.media.MediaPlayer;
import android.media.SoundPool;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageButton;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.belajarhijaiyah.R;

public class KasTainActivity extends AppCompatActivity implements View.OnClickListener {
    ImageButton show, hide, kembali;
    ImageView TampilGambar;
    Animation anImScale;
    SoundPool soundPool;
    MediaPlayer mp;
    private int SuaraAlif, SuaraBa, SuaraTa, SuaraSa, SuaraJim, SuaraHa, SuaraKho, SuaraDal, SuaraDzal, SuaraRo,
            Suaraza, SuaraSin, SuaraSyin, SuaraShad, SuaraDod, SuaraTo, SuaraDo, SuaraAin, SuaraGin, Suarafa, SuaraKof,
            SuaraKaf, SuaraLam, SuaraMim, SuaraNun, SuaraWawu, SuaraHA, SuaraYa;

    private ImageButton ButtonSuara, ButtonSuara2, ButtonSuara3, ButtonSuara4, ButtonSuara5, ButtonSuara6, ButtonSuara7, ButtonSuara8, ButtonSuara9, ButtonSuara10, ButtonSuara11, ButtonSuara12, ButtonSuara13, ButtonSuara14, ButtonSuara15, ButtonSuara16, ButtonSuara17, ButtonSuara18, ButtonSuara19, ButtonSuara20, ButtonSuara21, ButtonSuara22, ButtonSuara23, ButtonSuara24, ButtonSuara25, ButtonSuara26, ButtonSuara27, ButtonSuara28;

    @SuppressLint("CutPasteId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kas_tain);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        anImScale = AnimationUtils.loadAnimation(this, R.anim.anim_scale);
        initializeViews();
        setupClickListeners();
        loadSounds();
    }

    @Override
public void onClick(View v) {
    if (v.getId() == R.id.kasrohtain_in) {
        handleButtonClick(R.drawable.pop_kasroh_tain_in, SuaraAlif);
    } else if (v.getId() == R.id.kasrohtain_bin) {
        handleButtonClick(R.drawable.pop_kasroh_tain_bin, SuaraBa);
    } else if (v.getId() == R.id.kasrohtain_tin) {
        handleButtonClick(R.drawable.pop_kasroh_tain_tin, SuaraTa);
    } else if (v.getId() == R.id.kasrohtain_tsin) {
        handleButtonClick(R.drawable.pop_kasroh_tain_tsin, SuaraSa);
    } else if (v.getId() == R.id.kasrohtain_jin) {
        handleButtonClick(R.drawable.pop_kasroh_tain_jin, SuaraJim);
    } else if (v.getId() == R.id.kasrohtain_hin) {
        handleButtonClick(R.drawable.pop_kasroh_tain_hin, SuaraHa);
    } else if (v.getId() == R.id.kasrohtain_khin) {
        handleButtonClick(R.drawable.pop_kasroh_tain_khin, SuaraKho);
    } else if (v.getId() == R.id.kasrohtain_din) {
        handleButtonClick(R.drawable.pop_kasroh_tain_din, SuaraDal);
    } else if (v.getId() == R.id.kasrohtain_dzin) {
        handleButtonClick(R.drawable.pop_kasroh_tain_dzin, SuaraDzal);
    } else if (v.getId() == R.id.kasrohtain_rin) {
        handleButtonClick(R.drawable.pop_kasroh_tain_rin, SuaraRo);
    } else if (v.getId() == R.id.kasrohtain_zin) {
        handleButtonClick(R.drawable.pop_kasroh_tain_zin, Suaraza);
    } else if (v.getId() == R.id.kasrohtain_sin) {
        handleButtonClick(R.drawable.pop_kasroh_tain_sin, SuaraSin);
    } else if (v.getId() == R.id.kasrohtain_syin) {
        handleButtonClick(R.drawable.pop_kasroh_tain_syin, SuaraSyin);
    } else if (v.getId() == R.id.kasrohtain_shin) {
        handleButtonClick(R.drawable.pop_kasroh_tain_shin, SuaraShad);
    } else if (v.getId() == R.id.kasrohtain_dhin) {
        handleButtonClick(R.drawable.pop_kasroh_tain_dhin, SuaraDod);
    } else if (v.getId() == R.id.kasrohtain_thin) {
        handleButtonClick(R.drawable.pop_kasroh_tain_thin, SuaraTo);
    } else if (v.getId() == R.id.kasrohtain_zhin) {
        handleButtonClick(R.drawable.pop_kasroh_tain_dzin, SuaraDo);
    } else if (v.getId() == R.id.kasrohtain_ain) {
        handleButtonClick(R.drawable.pop_kasroh_tain_ain, SuaraAin);
    } else if (v.getId() == R.id.kasrohtain_gin) {
        handleButtonClick(R.drawable.pop_kasroh_tain_ghin, SuaraGin);
    } else if (v.getId() == R.id.kasrohtain_fin) {
        handleButtonClick(R.drawable.pop_kasroh_tain_fin, Suarafa);
    } else if (v.getId() == R.id.kasrohtain_qin) {
        handleButtonClick(R.drawable.pop_kasroh_tain_qin, SuaraKof);
    } else if (v.getId() == R.id.kasrohtain_kin) {
        handleButtonClick(R.drawable.pop_kasroh_tain_kin, SuaraKaf);
    } else if (v.getId() == R.id.kasrohtain_lin) {
        handleButtonClick(R.drawable.pop_kasroh_tain_lin, SuaraLam);
    } else if (v.getId() == R.id.kasrohtain_min) {
        handleButtonClick(R.drawable.pop_kasroh_tain_min, SuaraMim);
    } else if (v.getId() == R.id.kasrohtain_nin) {
        handleButtonClick(R.drawable.pop_kasroh_tain_nin, SuaraNun);
    } else if (v.getId() == R.id.kasrohtain_win) {
        handleButtonClick(R.drawable.pop_kasroh_tain_win, SuaraWawu);
    } else if (v.getId() == R.id.kasrohtain_hiin) {
        handleButtonClick(R.drawable.pop_kasroh_tain_hiin, SuaraHA);
    } else if (v.getId() == R.id.kasrohtain_yin) {
        handleButtonClick(R.drawable.pop_kasroh_tain_yin, SuaraYa);
    }
}


    @SuppressLint("CutPasteId")
    private void initializeViews() {
        TampilGambar = findViewById(R.id.tampil_huruf);
        show = findViewById(R.id.kasrohtain_in);
        hide = findViewById(R.id.kasrohtain_bin);
        kembali = findViewById(R.id.kembali);
        ButtonSuara = findViewById(R.id.kasrohtain_in);
        ButtonSuara2 = findViewById(R.id.kasrohtain_bin);
        ButtonSuara3 = findViewById(R.id.kasrohtain_tin);
        ButtonSuara4 = findViewById(R.id.kasrohtain_tsin);
        ButtonSuara5 = findViewById(R.id.kasrohtain_jin);
        ButtonSuara6 = findViewById(R.id.kasrohtain_hin);
        ButtonSuara7 = findViewById(R.id.kasrohtain_khin);
        ButtonSuara8 = findViewById(R.id.kasrohtain_din);
        ButtonSuara9 = findViewById(R.id.kasrohtain_dzin);
        ButtonSuara10 = findViewById(R.id.kasrohtain_rin);
        ButtonSuara11 = findViewById(R.id.kasrohtain_zin);
        ButtonSuara12 = findViewById(R.id.kasrohtain_sin);
        ButtonSuara13 = findViewById(R.id.kasrohtain_syin);
        ButtonSuara14 = findViewById(R.id.kasrohtain_shin);
        ButtonSuara15 = findViewById(R.id.kasrohtain_dhin);
        ButtonSuara16 = findViewById(R.id.kasrohtain_thin);
        ButtonSuara17 = findViewById(R.id.kasrohtain_zhin);
        ButtonSuara18 = findViewById(R.id.kasrohtain_ain);
        ButtonSuara19 = findViewById(R.id.kasrohtain_gin);
        ButtonSuara20 = findViewById(R.id.kasrohtain_fin);
        ButtonSuara21 = findViewById(R.id.kasrohtain_qin);
        ButtonSuara22 = findViewById(R.id.kasrohtain_kin);
        ButtonSuara23 = findViewById(R.id.kasrohtain_lin);
        ButtonSuara24 = findViewById(R.id.kasrohtain_min);
        ButtonSuara25 = findViewById(R.id.kasrohtain_nin);
        ButtonSuara26 = findViewById(R.id.kasrohtain_win);
        ButtonSuara27 = findViewById(R.id.kasrohtain_hiin);
        ButtonSuara28 = findViewById(R.id.kasrohtain_yin);
    }

    private void setupClickListeners() {
        show.setOnClickListener(v -> TampilGambar.setVisibility(View.VISIBLE));
        hide.setOnClickListener(v -> TampilGambar.setVisibility(View.INVISIBLE));
        kembali.setOnClickListener(v -> {
            v.startAnimation(AnimationUtils.loadAnimation(getApplicationContext(), R.anim.bounce));
            finish();
        });
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

    private void loadSounds() {
        soundPool = new SoundPool.Builder()
                .setMaxStreams(28).build();

        SuaraAlif = soundPool.load(this, R.raw.tanwin_kasroh_in, 1);
        SuaraBa = soundPool.load(this, R.raw.tanwin_kasroh_bin, 1);
        SuaraTa = soundPool.load(this, R.raw.tanwin_kasroh_tin, 1);
        SuaraSa = soundPool.load(this, R.raw.tanwin_kasroh_tsin, 1);
        SuaraJim = soundPool.load(this, R.raw.tanwin_kasroh_jin, 1);
        SuaraHa = soundPool.load(this, R.raw.tanwin_kasroh_hin, 1);
        SuaraKho = soundPool.load(this, R.raw.tanwin_kasroh_khin, 1);
        SuaraDal = soundPool.load(this, R.raw.tanwin_kasroh_din, 1);
        SuaraDzal = soundPool.load(this, R.raw.tanwin_kasroh_dzin, 1);
        SuaraRo = soundPool.load(this, R.raw.tanwin_kasroh_rin, 1);
        Suaraza = soundPool.load(this, R.raw.tanwin_kasroh_zin, 1);
        SuaraSin = soundPool.load(this, R.raw.tanwin_kasroh_sin, 1);
        SuaraSyin = soundPool.load(this, R.raw.tanwin_kasroh_syin, 1);
        SuaraShad = soundPool.load(this, R.raw.tanwin_kasroh_shin, 1);
        SuaraDod = soundPool.load(this, R.raw.tanwin_kasroh_dhin, 1);
        SuaraTo = soundPool.load(this, R.raw.tanwin_kasroh_thin, 1);
        SuaraDo = soundPool.load(this, R.raw.tanwin_kasroh_dzhin, 1);
        SuaraAin = soundPool.load(this, R.raw.tanwin_kasroh_iin, 1);
        SuaraGin = soundPool.load(this, R.raw.tanwin_kasroh_ghin, 1);
        Suarafa = soundPool.load(this, R.raw.tanwin_kasroh_fin, 1);
        SuaraKof = soundPool.load(this, R.raw.tanwin_kasroh_qin, 1);
        SuaraKaf = soundPool.load(this, R.raw.tanwin_kasroh_kin, 1);
        SuaraLam = soundPool.load(this, R.raw.tanwin_kasroh_lin, 1);
        SuaraMim = soundPool.load(this, R.raw.tanwin_kasroh_min, 1);
        SuaraNun = soundPool.load(this, R.raw.tanwin_kasroh_nin, 1);
        SuaraWawu = soundPool.load(this, R.raw.tanwin_kasroh_win, 1);
        SuaraHA = soundPool.load(this, R.raw.tanwin_kasroh_hiin, 1);
        SuaraYa = soundPool.load(this, R.raw.tanwin_kasroh_yin, 1);
    }

    private void handleButtonClick(int drawableResId, int soundId) {
        TampilGambar.setImageResource(drawableResId);
        TampilGambar.startAnimation(anImScale);
        soundPool.play(soundId, 1, 1, 0, 0, 1);
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
        if (mp != null) {
            mp.stop();
            mp.release();
            mp = null;
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (soundPool != null) {
            soundPool.release();
            soundPool = null;
        }
        if (mp != null) {
            mp.release();
            mp = null;
        }
    }
}

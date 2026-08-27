package com.example.belajarhijaiyah.belajar;

import android.util.SparseArray;

import com.example.belajarhijaiyah.BaseLearningActivity;
import com.example.belajarhijaiyah.LetterItem;
import com.example.belajarhijaiyah.R;

public class KasTainActivity extends BaseLearningActivity {

    @Override
    protected int getLayoutId() {
        return R.layout.activity_kas_tain;
    }

    @Override
    protected int getImageViewId() {
        return R.id.tampil_huruf;
    }

    @Override
    protected int getBackButtonId() {
        return R.id.kembali;
    }

    @Override
    protected SparseArray<LetterItem> buildLetterMap() {
        SparseArray<LetterItem> map = new SparseArray<>();
        map.put(R.id.kasrohtain_in,   new LetterItem(R.drawable.pop_kasroh_tain_in,   R.raw.tanwin_kasroh_in));
        map.put(R.id.kasrohtain_bin,  new LetterItem(R.drawable.pop_kasroh_tain_bin,  R.raw.tanwin_kasroh_bin));
        map.put(R.id.kasrohtain_tin,  new LetterItem(R.drawable.pop_kasroh_tain_tin,  R.raw.tanwin_kasroh_tin));
        map.put(R.id.kasrohtain_tsin, new LetterItem(R.drawable.pop_kasroh_tain_tsin, R.raw.tanwin_kasroh_tsin));
        map.put(R.id.kasrohtain_jin,  new LetterItem(R.drawable.pop_kasroh_tain_jin,  R.raw.tanwin_kasroh_jin));
        map.put(R.id.kasrohtain_hin,  new LetterItem(R.drawable.pop_kasroh_tain_hin,  R.raw.tanwin_kasroh_hin));
        map.put(R.id.kasrohtain_khin, new LetterItem(R.drawable.pop_kasroh_tain_khin, R.raw.tanwin_kasroh_khin));
        map.put(R.id.kasrohtain_din,  new LetterItem(R.drawable.pop_kasroh_tain_din,  R.raw.tanwin_kasroh_din));
        map.put(R.id.kasrohtain_dzin, new LetterItem(R.drawable.pop_kasroh_tain_dzin, R.raw.tanwin_kasroh_dzin));
        map.put(R.id.kasrohtain_rin,  new LetterItem(R.drawable.pop_kasroh_tain_rin,  R.raw.tanwin_kasroh_rin));
        map.put(R.id.kasrohtain_zin,  new LetterItem(R.drawable.pop_kasroh_tain_zin,  R.raw.tanwin_kasroh_zin));
        map.put(R.id.kasrohtain_sin,  new LetterItem(R.drawable.pop_kasroh_tain_sin,  R.raw.tanwin_kasroh_sin));
        map.put(R.id.kasrohtain_syin, new LetterItem(R.drawable.pop_kasroh_tain_syin, R.raw.tanwin_kasroh_syin));
        map.put(R.id.kasrohtain_shin, new LetterItem(R.drawable.pop_kasroh_tain_shin, R.raw.tanwin_kasroh_shin));
        map.put(R.id.kasrohtain_dhin, new LetterItem(R.drawable.pop_kasroh_tain_dhin, R.raw.tanwin_kasroh_dhin));
        map.put(R.id.kasrohtain_thin, new LetterItem(R.drawable.pop_kasroh_tain_thin, R.raw.tanwin_kasroh_thin));
        map.put(R.id.kasrohtain_zhin, new LetterItem(R.drawable.pop_kasroh_tain_dzin, R.raw.tanwin_kasroh_dzhin));
        map.put(R.id.kasrohtain_ain,  new LetterItem(R.drawable.pop_kasroh_tain_ain,  R.raw.tanwin_kasroh_iin));
        map.put(R.id.kasrohtain_gin,  new LetterItem(R.drawable.pop_kasroh_tain_ghin, R.raw.tanwin_kasroh_ghin));
        map.put(R.id.kasrohtain_fin,  new LetterItem(R.drawable.pop_kasroh_tain_fin,  R.raw.tanwin_kasroh_fin));
        map.put(R.id.kasrohtain_qin,  new LetterItem(R.drawable.pop_kasroh_tain_qin,  R.raw.tanwin_kasroh_qin));
        map.put(R.id.kasrohtain_kin,  new LetterItem(R.drawable.pop_kasroh_tain_kin,  R.raw.tanwin_kasroh_kin));
        map.put(R.id.kasrohtain_lin,  new LetterItem(R.drawable.pop_kasroh_tain_lin,  R.raw.tanwin_kasroh_lin));
        map.put(R.id.kasrohtain_min,  new LetterItem(R.drawable.pop_kasroh_tain_min,  R.raw.tanwin_kasroh_min));
        map.put(R.id.kasrohtain_nin,  new LetterItem(R.drawable.pop_kasroh_tain_nin,  R.raw.tanwin_kasroh_nin));
        map.put(R.id.kasrohtain_win,  new LetterItem(R.drawable.pop_kasroh_tain_win,  R.raw.tanwin_kasroh_win));
        map.put(R.id.kasrohtain_hiin, new LetterItem(R.drawable.pop_kasroh_tain_hiin, R.raw.tanwin_kasroh_hiin));
        map.put(R.id.kasrohtain_yin,  new LetterItem(R.drawable.pop_kasroh_tain_yin,  R.raw.tanwin_kasroh_yin));
        return map;
    }
}

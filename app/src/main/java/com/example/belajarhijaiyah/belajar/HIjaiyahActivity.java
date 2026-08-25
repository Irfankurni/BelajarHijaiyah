package com.example.belajarhijaiyah.belajar;

import android.util.SparseArray;

import com.example.belajarhijaiyah.BaseLearningActivity;
import com.example.belajarhijaiyah.LetterItem;
import com.example.belajarhijaiyah.R;

public class HIjaiyahActivity extends BaseLearningActivity {

    @Override
    protected int getLayoutId() {
        return R.layout.activity_hijaiyah;
    }

    @Override
    protected int getImageViewId() {
        return R.id.tampil_hijaiyah;
    }

    @Override
    protected int getBackButtonId() {
        return R.id.kembali;
    }

    @Override
    protected SparseArray<LetterItem> buildLetterMap() {
        SparseArray<LetterItem> map = new SparseArray<>();
        map.put(R.id.alif,  new LetterItem(R.drawable.pop_alif,             R.raw.hijaiyah_alif));
        map.put(R.id.ba,    new LetterItem(R.drawable.pop_ba,               R.raw.hijaiyah_ba));
        map.put(R.id.ta,    new LetterItem(R.drawable.pop_ta,               R.raw.hijaiyah_ta));
        map.put(R.id.tsa,   new LetterItem(R.drawable.pop_tsa,              R.raw.hijaiyah_tsa));
        map.put(R.id.ja,    new LetterItem(R.drawable.pop_jim,              R.raw.hijaiyah_ja));
        map.put(R.id.ha,    new LetterItem(R.drawable.pop_ha,               R.raw.hijaiyah_ha));
        map.put(R.id.kha,   new LetterItem(R.drawable.pop_kha,              R.raw.hijaiyah_kha));
        map.put(R.id.da,    new LetterItem(R.drawable.pop_dal,              R.raw.hijaiyah_da));
        map.put(R.id.dza,   new LetterItem(R.drawable.pop_dzal,             R.raw.hijaiyah_dza));
        map.put(R.id.ro,    new LetterItem(R.drawable.pop_ra,               R.raw.hijaiyah_ro));
        map.put(R.id.za,    new LetterItem(R.drawable.pop_zai,              R.raw.hijaiyah_zha));
        map.put(R.id.sin,   new LetterItem(R.drawable.pop_sin,              R.raw.hijaiyah_sin));
        map.put(R.id.syin,  new LetterItem(R.drawable.pop_syin,             R.raw.hijaiyah_syin));
        map.put(R.id.sod,   new LetterItem(R.drawable.pop_shad,             R.raw.hijaiyah_sho));
        map.put(R.id.dho,   new LetterItem(R.drawable.pop_dhad,             R.raw.hijaiyah_dzho));
        map.put(R.id.tho,   new LetterItem(R.drawable.pop_tha,              R.raw.hijaiyah_tho));
        map.put(R.id.dod,   new LetterItem(R.drawable.pop_zha,              R.raw.hijaiyah_dho));
        map.put(R.id.ain,   new LetterItem(R.drawable.pop_ain,              R.raw.hijaiyah_ain));
        map.put(R.id.ghain, new LetterItem(R.drawable.pop_hijaiyah_ghain,   R.raw.hijaiyah_gho));
        map.put(R.id.fa,    new LetterItem(R.drawable.pop_fa,               R.raw.hijaiyah_fa));
        map.put(R.id.kof,   new LetterItem(R.drawable.pop_qaf,              R.raw.hijaiyah_qo));
        map.put(R.id.ka,    new LetterItem(R.drawable.pop_kaf,              R.raw.hijaiyah_ka));
        map.put(R.id.lam,   new LetterItem(R.drawable.pop_lam,              R.raw.hijaiyah_lam));
        map.put(R.id.mim,   new LetterItem(R.drawable.pop_mim,              R.raw.hijaiyah_min));
        map.put(R.id.nun,   new LetterItem(R.drawable.pop_nun,              R.raw.hijaiyah_nun));
        map.put(R.id.wau,   new LetterItem(R.drawable.pop_wawu,             R.raw.hijaiyah_wawu));
        map.put(R.id.haa,   new LetterItem(R.drawable.pop_haa,              R.raw.hijaiyah_haa));
        map.put(R.id.ya,    new LetterItem(R.drawable.pop_ya,               R.raw.hijaiyah_ya));
        return map;
    }
}

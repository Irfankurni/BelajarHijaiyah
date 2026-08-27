package com.example.belajarhijaiyah.belajar;

import android.util.SparseArray;

import com.example.belajarhijaiyah.BaseLearningActivity;
import com.example.belajarhijaiyah.LetterItem;
import com.example.belajarhijaiyah.R;

public class FathahLearningActivity extends BaseLearningActivity {

    @Override
    protected int getLayoutId() {
        return R.layout.activity_fathah_learn;
    }

    @Override
    protected int getImageViewId() {
        return R.id.tampil_fathah;
    }

    @Override
    protected int getBackButtonId() {
        return R.id.back_button;
    }

    @Override
    protected SparseArray<LetterItem> buildLetterMap() {
        SparseArray<LetterItem> map = new SparseArray<>();
        map.put(R.id.fatah_a,    new LetterItem(R.drawable.pop_fatah_a,    R.raw.fatah_a));
        map.put(R.id.fatah_ba,   new LetterItem(R.drawable.pop_fatah_ba,   R.raw.fatah_ba));
        map.put(R.id.fatah_ta,   new LetterItem(R.drawable.pop_fatah_ta,   R.raw.fatah_ta));
        map.put(R.id.fatah_tsa,  new LetterItem(R.drawable.pop_fatah_tsa,  R.raw.fatah_sa));
        map.put(R.id.fatah_ja,   new LetterItem(R.drawable.pop_fatah_ja,   R.raw.fatah_ja));
        map.put(R.id.fatah_ha,   new LetterItem(R.drawable.pop_fatah_ha,   R.raw.fatah_ha));
        map.put(R.id.fatah_kha,  new LetterItem(R.drawable.pop_fatah_kha,  R.raw.fatah_kha));
        map.put(R.id.fatah_da,   new LetterItem(R.drawable.pop_fatah_da,   R.raw.fatah_da));
        map.put(R.id.fatah_dza,  new LetterItem(R.drawable.pop_fatah_dza,  R.raw.fatah_dza));
        map.put(R.id.fatah_ro,   new LetterItem(R.drawable.pop_fatah_ra,   R.raw.fatah_ro));
        map.put(R.id.fatah_za,   new LetterItem(R.drawable.pop_fatah_za,   R.raw.fatah_za));
        map.put(R.id.fatah_sa,   new LetterItem(R.drawable.pop_fatah_sa,   R.raw.fatah_sa));
        map.put(R.id.fatah_sya,  new LetterItem(R.drawable.pop_fatah_sya,  R.raw.fatah_sya));
        map.put(R.id.fatah_sho,  new LetterItem(R.drawable.pop_fatah_sha,  R.raw.fatah_sho));
        map.put(R.id.fatah_dho,  new LetterItem(R.drawable.pop_fatah_dha,  R.raw.fatah_dho));
        map.put(R.id.fatah_tho,  new LetterItem(R.drawable.pop_fatah_tha,  R.raw.fatah_tho));
        map.put(R.id.fatah_dzo,  new LetterItem(R.drawable.pop_fatah_dzaa, R.raw.fatah_dzho));
        map.put(R.id.fatah_zz,   new LetterItem(R.drawable.pop_fatah_ain,  R.raw.fatah_aa));
        map.put(R.id.fatah_gho,  new LetterItem(R.drawable.pop_fatah_gha,  R.raw.fatah_gho));
        map.put(R.id.fatah_fa,   new LetterItem(R.drawable.pop_fatah_fa,   R.raw.fatah_fa));
        map.put(R.id.fatah_qo,   new LetterItem(R.drawable.pop_fatah_qa,   R.raw.fatah_qo));
        map.put(R.id.fatah_ka,   new LetterItem(R.drawable.pop_fatah_ka,   R.raw.fatah_ka));
        map.put(R.id.fatah_lam,  new LetterItem(R.drawable.pop_fatah_la,   R.raw.fatah_la));
        map.put(R.id.fatah_mim,  new LetterItem(R.drawable.pop_fatah_ma,   R.raw.fatah_ma));
        map.put(R.id.fatah_nun,  new LetterItem(R.drawable.pop_fatah_na,   R.raw.fatah_na));
        map.put(R.id.fatah_wa,   new LetterItem(R.drawable.pop_fatah_wa,   R.raw.fatah_wa));
        map.put(R.id.fatah_haa,  new LetterItem(R.drawable.pop_fatah_haa,  R.raw.fatah_haa));
        map.put(R.id.fatah_ya,   new LetterItem(R.drawable.pop_fatah_ya,   R.raw.fatah_ya));
        return map;
    }
}

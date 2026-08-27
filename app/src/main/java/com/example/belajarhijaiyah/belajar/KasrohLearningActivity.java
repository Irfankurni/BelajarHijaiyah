package com.example.belajarhijaiyah.belajar;

import android.util.SparseArray;

import com.example.belajarhijaiyah.BaseLearningActivity;
import com.example.belajarhijaiyah.LetterItem;
import com.example.belajarhijaiyah.R;

public class KasrohLearningActivity extends BaseLearningActivity {

    @Override
    protected int getLayoutId() {
        return R.layout.activity_kasroh_learn;
    }

    @Override
    protected int getImageViewId() {
        return R.id.tampil_kasroh;
    }

    @Override
    protected int getBackButtonId() {
        return R.id.back_button;
    }

    @Override
    protected SparseArray<LetterItem> buildLetterMap() {
        SparseArray<LetterItem> map = new SparseArray<>();
        map.put(R.id.kasroh_i,    new LetterItem(R.drawable.pop_kasroh_i,   R.raw.kasroh_i));
        map.put(R.id.kasroh_bi,   new LetterItem(R.drawable.pop_kasroh_bi,  R.raw.kasroh_bi));
        map.put(R.id.kasroh_ti,   new LetterItem(R.drawable.pop_kasroh_ti,  R.raw.kasroh_ti));
        map.put(R.id.kasroh_tsi,  new LetterItem(R.drawable.pop_kasroh_tsi, R.raw.kasroh_tsi));
        map.put(R.id.kasroh_ji,   new LetterItem(R.drawable.pop_kasroh_ji,  R.raw.kasroh_ji));
        map.put(R.id.kasroh_ha,   new LetterItem(R.drawable.pop_kasroh_hi,  R.raw.kasroh_hi));
        map.put(R.id.kasroh_khi,  new LetterItem(R.drawable.pop_kasroh_khi, R.raw.kasroh_khi));
        map.put(R.id.kasroh_di,   new LetterItem(R.drawable.pop_kasroh_di,  R.raw.kasroh_di));
        map.put(R.id.kasroh_dzi,  new LetterItem(R.drawable.pop_kasroh_dzi, R.raw.kasroh_dzi));
        map.put(R.id.kasroh_ri,   new LetterItem(R.drawable.pop_kasroh_ri,  R.raw.kasroh_ri));
        map.put(R.id.kasroh_za,   new LetterItem(R.drawable.pop_kasroh_zi,  R.raw.kasroh_zi));
        map.put(R.id.kasroh_si,   new LetterItem(R.drawable.pop_kasroh_si,  R.raw.kasroh_si));
        map.put(R.id.kasroh_syi,  new LetterItem(R.drawable.pop_kasroh_syi, R.raw.kasroh_syi));
        map.put(R.id.kasroh_shi,  new LetterItem(R.drawable.pop_kasroh_shi, R.raw.kasroh_shi));
        map.put(R.id.kasroh_dhi,  new LetterItem(R.drawable.pop_kasroh_dhi, R.raw.kasroh_dhi));
        map.put(R.id.kasroh_thi,  new LetterItem(R.drawable.pop_kasroh_thi, R.raw.kasroh_thi));
        map.put(R.id.kasroh_dzhi, new LetterItem(R.drawable.pop_kasroh_dzi, R.raw.kasroh_dzhi));
        map.put(R.id.kasroh_ain,  new LetterItem(R.drawable.pop_kasroh_ii,  R.raw.kasroh_ii));
        map.put(R.id.kasroh_ghi,  new LetterItem(R.drawable.pop_kasroh_ghi, R.raw.kasroh_ghi));
        map.put(R.id.kasroh_fi,   new LetterItem(R.drawable.pop_kasroh_fi,  R.raw.kasroh_fi));
        map.put(R.id.kasroh_qi,   new LetterItem(R.drawable.pop_kasroh_qi,  R.raw.kasroh_qi));
        map.put(R.id.kasroh_ki,   new LetterItem(R.drawable.pop_kasroh_ki,  R.raw.kasroh_ki));
        map.put(R.id.kasroh_li,   new LetterItem(R.drawable.pop_kasroh_li,  R.raw.kasroh_li));
        map.put(R.id.kasroh_mi,   new LetterItem(R.drawable.pop_kasroh_mi,  R.raw.kasroh_mi));
        map.put(R.id.kasroh_nun,  new LetterItem(R.drawable.pop_kasroh_ni,  R.raw.kasroh_ni));
        map.put(R.id.kasroh_wi,   new LetterItem(R.drawable.pop_kasroh_wi,  R.raw.kasroh_wi));
        map.put(R.id.kasroh_haa,  new LetterItem(R.drawable.pop_kasroh_hii, R.raw.kasroh_hii));
        map.put(R.id.kasroh_yi,   new LetterItem(R.drawable.pop_kasroh_yi,  R.raw.kasroh_yi));
        return map;
    }
}

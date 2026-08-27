package com.example.belajarhijaiyah.belajar;

import android.util.SparseArray;

import com.example.belajarhijaiyah.BaseLearningActivity;
import com.example.belajarhijaiyah.LetterItem;
import com.example.belajarhijaiyah.R;

public class DhommahActivity extends BaseLearningActivity {

    @Override
    protected int getLayoutId() {
        return R.layout.activity_dhommah;
    }

    @Override
    protected int getImageViewId() {
        return R.id.tampil_domah;
    }

    @Override
    protected int getBackButtonId() {
        return R.id.kembali;
    }

    @Override
    protected SparseArray<LetterItem> buildLetterMap() {
        SparseArray<LetterItem> map = new SparseArray<>();
        map.put(R.id.domah_u,   new LetterItem(R.drawable.pop_domah_u,    R.raw.u));
        map.put(R.id.domah_bu,  new LetterItem(R.drawable.pop_domah_bu,   R.raw.bu));
        map.put(R.id.domah_tu,  new LetterItem(R.drawable.pop_domah_tu,   R.raw.tu));
        map.put(R.id.domah_tsu, new LetterItem(R.drawable.pop_domah_tsu,  R.raw.tsu));
        map.put(R.id.domah_ju,  new LetterItem(R.drawable.pop_domah_ju,   R.raw.ju));
        map.put(R.id.domah_hu,  new LetterItem(R.drawable.pop_domah_hu,   R.raw.hu));
        map.put(R.id.domah_khu, new LetterItem(R.drawable.pop_domah_khu,  R.raw.khu));
        map.put(R.id.domah_du,  new LetterItem(R.drawable.pop_domah_du,   R.raw.du));
        map.put(R.id.domah_dzu, new LetterItem(R.drawable.pop_domah_dzu,  R.raw.dzu));
        map.put(R.id.domah_ru,  new LetterItem(R.drawable.pop_domah_ru,   R.raw.ru));
        map.put(R.id.domah_zu,  new LetterItem(R.drawable.pop_domah_zu,   R.raw.zu));
        map.put(R.id.domah_su,  new LetterItem(R.drawable.pop_domah_su,   R.raw.su));
        map.put(R.id.domah_syu, new LetterItem(R.drawable.pop_domah_syu,  R.raw.syu));
        map.put(R.id.domah_shu, new LetterItem(R.drawable.pop_domah_shu,  R.raw.shu));
        map.put(R.id.domah_dhu, new LetterItem(R.drawable.pop_domah_dhu,  R.raw.dhu));
        map.put(R.id.domah_thu, new LetterItem(R.drawable.pop_domah_thu,  R.raw.thu));
        map.put(R.id.domah_duu, new LetterItem(R.drawable.pop_domah_dzuu, R.raw.dzhu));
        map.put(R.id.domah_uu,  new LetterItem(R.drawable.pop_domah_uu,   R.raw.uu));
        map.put(R.id.domah_ghu, new LetterItem(R.drawable.pop_domah_ghu,  R.raw.ghu));
        map.put(R.id.domah_fu,  new LetterItem(R.drawable.pop_domah_fu,   R.raw.fu));
        map.put(R.id.domah_qu,  new LetterItem(R.drawable.pop_domah_qu,   R.raw.qu));
        map.put(R.id.domah_ku,  new LetterItem(R.drawable.pop_domah_ku,   R.raw.ku));
        map.put(R.id.domah_lu,  new LetterItem(R.drawable.pop_domah_lu,   R.raw.lu));
        map.put(R.id.domah_mu,  new LetterItem(R.drawable.pop_domah_mu,   R.raw.mu));
        map.put(R.id.domah_nu,  new LetterItem(R.drawable.pop_domah_nu,   R.raw.nu));
        map.put(R.id.domah_wu,  new LetterItem(R.drawable.pop_domah_wu,   R.raw.wu));
        map.put(R.id.domah_huu, new LetterItem(R.drawable.pop_domah_huu,  R.raw.huu));
        map.put(R.id.domah_yu,  new LetterItem(R.drawable.pop_domah_yu,   R.raw.yu));
        return map;
    }
}
package com.example.belajarhijaiyah.belajar;

import android.util.SparseArray;

import com.example.belajarhijaiyah.BaseLearningActivity;
import com.example.belajarhijaiyah.LetterItem;
import com.example.belajarhijaiyah.R;

public class DhotainLearningActivity extends BaseLearningActivity {

    @Override
    protected int getLayoutId() {
        return R.layout.activity_dhotain_learn;
    }

    @Override
    protected int getImageViewId() {
        return R.id.tampil_huruf;
    }

    @Override
    protected int getBackButtonId() {
        return R.id.back_button;
    }

    @Override
    protected SparseArray<LetterItem> buildLetterMap() {
        SparseArray<LetterItem> map = new SparseArray<>();
        map.put(R.id.domah_tain_alif,  new LetterItem(R.drawable.pop_domahtain_un,    R.raw.tanwin_domah_un));
        map.put(R.id.domah_tain_ba,    new LetterItem(R.drawable.pop_domahtain_bun,   R.raw.tanwin_domah_bun));
        map.put(R.id.domah_tain_ta,    new LetterItem(R.drawable.pop_domahtain_tun,   R.raw.tanwin_domah_tun));
        map.put(R.id.domah_tain_tsa,   new LetterItem(R.drawable.pop_domahtain_tsun,  R.raw.tanwin_domah_tsun));
        map.put(R.id.domah_tain_ja,    new LetterItem(R.drawable.pop_domahtain_jun,   R.raw.tanwin_domah_jun));
        map.put(R.id.domah_tain_ha,    new LetterItem(R.drawable.pop_domahtain_hun,   R.raw.tanwin_domah_hun));
        map.put(R.id.domah_tain_kha,   new LetterItem(R.drawable.pop_domahtain_khun,  R.raw.tanwin_domah_khun));
        map.put(R.id.domah_tain_da,    new LetterItem(R.drawable.pop_domahtain_dun,   R.raw.tanwin_domah_dun));
        map.put(R.id.domah_tain_dza,   new LetterItem(R.drawable.pop_domahtain_dzun,  R.raw.tanwin_domah_dzun));
        map.put(R.id.domah_tain_ra,    new LetterItem(R.drawable.pop_domahtain_run,   R.raw.tanwin_domah_run));
        map.put(R.id.domah_tain_za,    new LetterItem(R.drawable.pop_domahtain_zun,   R.raw.tanwin_domah_zun));
        map.put(R.id.domah_tain_sin,   new LetterItem(R.drawable.pop_domahtain_sun,   R.raw.tanwin_domah_sun));
        map.put(R.id.domah_tain_syin,  new LetterItem(R.drawable.pop_domahtain_syun,  R.raw.tanwin_domah_syun));
        map.put(R.id.domah_tain_shad,  new LetterItem(R.drawable.pop_domahtain_shun,  R.raw.tanwin_domah_shun));
        map.put(R.id.domah_tain_dhad,  new LetterItem(R.drawable.pop_domahtain_dhun,  R.raw.tanwin_domah_dhun));
        map.put(R.id.domah_tain_tha,   new LetterItem(R.drawable.pop_domahtain_thun,  R.raw.tanwin_domah_thun));
        map.put(R.id.domah_tain_dha,   new LetterItem(R.drawable.pop_domahtain_dzuun, R.raw.tanwin_domah_dzhun));
        map.put(R.id.domah_tain_ain,   new LetterItem(R.drawable.pop_domahtain_uun,   R.raw.tanwin_domah_uun));
        map.put(R.id.domah_tain_ghain, new LetterItem(R.drawable.pop_domahtain_ghun,  R.raw.tanwin_domah_ghun));
        map.put(R.id.domah_tain_fa,    new LetterItem(R.drawable.pop_domahtain_fun,   R.raw.tanwin_domah_fun));
        map.put(R.id.domah_tain_qof,   new LetterItem(R.drawable.pop_domahtain_qun,   R.raw.tanwin_domah_qun));
        map.put(R.id.domah_tain_kaf,   new LetterItem(R.drawable.pop_domahtain_kun,   R.raw.tanwin_domah_kun));
        map.put(R.id.domah_tain_lam,   new LetterItem(R.drawable.pop_domahtain_lun,   R.raw.tanwin_domah_lun));
        map.put(R.id.domah_tain_mim,   new LetterItem(R.drawable.pop_domahtain_mun,   R.raw.tanwin_domah_mun));
        map.put(R.id.domah_tain_nun,   new LetterItem(R.drawable.pop_domahtain_nun,   R.raw.tanwin_domah_nun));
        map.put(R.id.domah_tain_wawu,  new LetterItem(R.drawable.pop_domahtain_wun,   R.raw.tanwin_domah_wun));
        map.put(R.id.domah_tain_haa,   new LetterItem(R.drawable.pop_domahtain_huun,  R.raw.tanwin_domah_huun));
        map.put(R.id.domah_tain_ya,    new LetterItem(R.drawable.pop_domahtain_yun,   R.raw.tanwin_domah_yun));
        return map;
    }
}

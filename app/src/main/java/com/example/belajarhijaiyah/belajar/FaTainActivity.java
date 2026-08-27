package com.example.belajarhijaiyah.belajar;

import android.util.SparseArray;

import com.example.belajarhijaiyah.BaseLearningActivity;
import com.example.belajarhijaiyah.LetterItem;
import com.example.belajarhijaiyah.R;

public class FaTainActivity extends BaseLearningActivity {

    @Override
    protected int getLayoutId() {
        return R.layout.activity_fa_tain;
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
        map.put(R.id.tain_an,   new LetterItem(R.drawable.pop_fatahtain_an,   R.raw.tanwin_fathah_an));
        map.put(R.id.tain_ban,  new LetterItem(R.drawable.pop_fatahtain_ban,  R.raw.tanwin_fathah_ban));
        map.put(R.id.tain_tan,  new LetterItem(R.drawable.pop_fatahtain_tan,  R.raw.tanwin_fathah_tan));
        map.put(R.id.tain_tsin, new LetterItem(R.drawable.pop_fatahtain_tsan, R.raw.tanwin_fathah_tsan));
        map.put(R.id.tain_jan,  new LetterItem(R.drawable.pop_fatahtain_jan,  R.raw.tanwin_fathah_jan));
        map.put(R.id.tain_han,  new LetterItem(R.drawable.pop_fatahtain_han,  R.raw.tanwin_fathah_han));
        map.put(R.id.tain_khon, new LetterItem(R.drawable.pop_fatahtain_khan, R.raw.tanwin_fathah_khon));
        map.put(R.id.tain_dan,  new LetterItem(R.drawable.pop_fatahtain_dan,  R.raw.tanwin_fathah_dan));
        map.put(R.id.tain_dzan, new LetterItem(R.drawable.pop_fatahtain_dzan, R.raw.tanwin_fathah_dzan));
        map.put(R.id.tain_ron,  new LetterItem(R.drawable.pop_fatahtain_ran,  R.raw.tanwin_fathah_ron));
        map.put(R.id.tain_zan,  new LetterItem(R.drawable.pop_fatahtain_zan,  R.raw.tanwin_fathah_zan));
        map.put(R.id.tain_san,  new LetterItem(R.drawable.pop_fatahtain_san,  R.raw.tanwin_fathah_san));
        map.put(R.id.tain_syan, new LetterItem(R.drawable.pop_fatahtain_syan, R.raw.tanwin_fathah_syan));
        map.put(R.id.tain_shon, new LetterItem(R.drawable.pop_fatahtain_shan, R.raw.tanwin_fathah_shon));
        map.put(R.id.tain_dhon, new LetterItem(R.drawable.pop_fatahtain_dhan, R.raw.tanwin_fathah_dhon));
        map.put(R.id.tain_thon, new LetterItem(R.drawable.pop_fatahtain_than, R.raw.tanwin_fathah_thon));
        map.put(R.id.tain_dzon, new LetterItem(R.drawable.pop_fatahtain_dzan, R.raw.tanwin_fathah_dzhon));
        map.put(R.id.tain_ain,  new LetterItem(R.drawable.pop_fatahtain_aan,  R.raw.tanwin_fathah_aan));
        map.put(R.id.tain_ghon, new LetterItem(R.drawable.pop_fatahtain_ghan, R.raw.tanwin_fathah_ghon));
        map.put(R.id.tain_fan,  new LetterItem(R.drawable.pop_fatahtain_fan,  R.raw.tanwin_fathah_fan));
        map.put(R.id.tain_qon,  new LetterItem(R.drawable.pop_fatahtain_qan,  R.raw.tanwin_fathah_qon));
        map.put(R.id.tain_kan,  new LetterItem(R.drawable.pop_fatahtain_kan,  R.raw.tanwin_fathah_kan));
        map.put(R.id.tain_lan,  new LetterItem(R.drawable.pop_fatahtain_lan,  R.raw.tanwin_fathah_lan));
        map.put(R.id.tain_man,  new LetterItem(R.drawable.pop_fatahtain_ma,   R.raw.tanwin_fathah_man));
        map.put(R.id.tain_nan,  new LetterItem(R.drawable.pop_fatahtain_nan,  R.raw.tanwin_fathah_nan));
        map.put(R.id.tain_wan,  new LetterItem(R.drawable.pop_fatahtain_wan,  R.raw.tanwin_fathah_wan));
        map.put(R.id.tain_hann, new LetterItem(R.drawable.pop_fatahtain_haan, R.raw.tanwin_fathah_haan));
        map.put(R.id.tain_yan,  new LetterItem(R.drawable.pop_fatahtain_yan,  R.raw.tanwin_fathah_yan));
        return map;
    }
}

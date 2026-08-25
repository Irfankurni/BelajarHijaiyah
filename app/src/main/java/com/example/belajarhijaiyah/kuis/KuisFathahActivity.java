package com.example.belajarhijaiyah.kuis;

import com.example.belajarhijaiyah.BaseQuizActivity;
import com.example.belajarhijaiyah.R;
import com.example.belajarhijaiyah.constant.Soal;

public class KuisFathahActivity extends BaseQuizActivity {

    @Override
    protected int getLayoutId() {
        return R.layout.activity_kuis_fathah;
    }

    @Override
    protected String[][] getQuizData() {
        return Soal.fathah;
    }
}
package com.example.belajarhijaiyah.kuis;

import com.example.belajarhijaiyah.BaseQuizActivity;
import com.example.belajarhijaiyah.R;
import com.example.belajarhijaiyah.constant.Soal;

public class KuisFatainActivity extends BaseQuizActivity {

    @Override
    protected int getLayoutId() {
        return R.layout.activity_kuis_fatain;
    }

    @Override
    protected String[][] getQuizData() {
        return Soal.fatainData;
    }
}

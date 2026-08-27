package com.example.belajarhijaiyah.kuis;

import com.example.belajarhijaiyah.BaseQuizActivity;
import com.example.belajarhijaiyah.R;
import com.example.belajarhijaiyah.constant.QuizData;

public class KastainQuizActivity extends BaseQuizActivity {

    @Override
    protected int getLayoutId() {
        return R.layout.activity_kastain_quiz;
    }

    @Override
    protected String[][] getQuizData() {
        return QuizData.kastain;
    }
}
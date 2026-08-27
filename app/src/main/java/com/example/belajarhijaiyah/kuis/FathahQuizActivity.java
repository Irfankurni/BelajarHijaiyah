package com.example.belajarhijaiyah.kuis;

import com.example.belajarhijaiyah.BaseQuizActivity;
import com.example.belajarhijaiyah.R;
import com.example.belajarhijaiyah.constant.QuizData;

public class FathahQuizActivity extends BaseQuizActivity {

    @Override
    protected int getLayoutId() {
        return R.layout.activity_fathah_quiz;
    }

    @Override
    protected String[][] getQuizData() {
        return QuizData.fathah;
    }
}
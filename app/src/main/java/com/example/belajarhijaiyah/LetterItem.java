package com.example.belajarhijaiyah;

/**
 * Immutable data holder pairing a letter button's popup drawable
 * and its SoundPool sound ID (set after SoundPool.load() completes).
 */
public class LetterItem {

    public final int drawableRes;
    public final int soundRes;
    private int soundPoolId = 0;

    public LetterItem(int drawableRes, int soundRes) {
        this.drawableRes = drawableRes;
        this.soundRes = soundRes;
    }

    public void setSoundPoolId(int id) {
        this.soundPoolId = id;
    }

    public int getSoundPoolId() {
        return soundPoolId;
    }
}

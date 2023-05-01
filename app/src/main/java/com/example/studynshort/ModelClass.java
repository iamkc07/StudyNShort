package com.example.studynshort;

import android.view.View;

public class ModelClass {
    private int imageview1;
    private String textview1;
    private String textview2;
    private String sendUrl;

    public ModelClass(int imageview1, String textview1, String textview2, String sendUrl) {
        this.imageview1 = imageview1;
        this.textview1 = textview1;
        this.textview2 = textview2;
        this.sendUrl = sendUrl;
    }

    public int getImageview1() {
        return imageview1;
    }

    public String getTextview1() {
        return textview1;
    }

    public String getTextview2() {
        return textview2;
    }

    public String getSendUrl() {
        return sendUrl;
    }
}

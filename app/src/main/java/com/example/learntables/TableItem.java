package com.example.learntables;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class TableItem {

    private String mTexteqn, mTextans;
//    private int mId;

    public TableItem(String texteqn, String textans) {
        mTexteqn = texteqn;
        mTextans = textans;
//        mId = id;

    }

    public String getmTexteqn() {
        return mTexteqn;
    }

    public String getmTextans() {
        return mTextans;
    }

//    public int getmId() {
//        return mId;
//    }
}
package com.example.learntables;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class TableItem {

    private String mTexteqn, mTextans;


    public TableItem(String texteqn, String textans) {
        mTexteqn = texteqn;
        mTextans = textans;

    }

    public String getmTexteqn() {
        return mTexteqn;
    }

    public String getmTextans() {
        return mTextans;
    }


}
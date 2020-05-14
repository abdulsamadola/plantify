package com.campstore.plantify.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.campstore.plantify.R;

import spencerstudios.com.bungeelib.Bungee;

public class Detail extends AppCompatActivity {

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Bungee.slideUp(this);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

    }

    public void goBack(View view) {
        onBackPressed();
    }
}

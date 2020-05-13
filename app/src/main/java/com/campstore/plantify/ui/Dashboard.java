package com.campstore.plantify.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.campstore.plantify.R;

import spencerstudios.com.bungeelib.Bungee;

public class Dashboard extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Bungee.slideRight(this);
    }
}

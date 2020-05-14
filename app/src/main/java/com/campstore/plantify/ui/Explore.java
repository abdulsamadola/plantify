package com.campstore.plantify.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.campstore.plantify.R;

import spencerstudios.com.bungeelib.Bungee;

public class Explore extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_explore);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Bungee.spin(this);
    }

    public void goBack(View view) {
        onBackPressed();
    }

    public void goToSettings(View view) {
        startActivity(new Intent(this, Settings.class));
        Bungee.card(this);
    }
}

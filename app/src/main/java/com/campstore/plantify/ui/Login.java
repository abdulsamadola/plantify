package com.campstore.plantify.ui;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.campstore.plantify.R;
import com.google.android.material.textfield.TextInputEditText;

import spencerstudios.com.bungeelib.Bungee;

public class Login extends AppCompatActivity {
private TextInputEditText email;
private TextView emaillabel;
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Bungee.slideRight(this);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        isEmailFocus();


    }

    private void isEmailFocus() {
        email = findViewById(R.id.email);
        emaillabel = findViewById(R.id.emailLabel);

        email.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(hasFocus){
                    emaillabel.setTextColor(getResources().getColor(R.color.colorAccent));
                    email.setBackgroundTintList(getBaseContext().getResources().getColorStateList(R.color.colorAccent));
                }else{
                    emaillabel.setTextColor(getResources().getColor(R.color.textColorLight));
                    email.setBackgroundTintList(getBaseContext().getResources().getColorStateList(R.color.textColorLight));

                }
            }
        });



    }

    public void goBack(View view) {
        onBackPressed();
    }

    public void goToDashboard(View view) {
        startActivity(new Intent(Login.this, Dashboard.class));
        Bungee.split(Login.this);
    }
}

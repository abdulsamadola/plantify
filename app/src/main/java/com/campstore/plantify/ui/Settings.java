package com.campstore.plantify.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.LinearGradient;
import android.graphics.Shader;
import android.os.Bundle;
import android.view.View;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import com.campstore.plantify.R;

import java.text.NumberFormat;

import spencerstudios.com.bungeelib.Bungee;

public class Settings extends AppCompatActivity {
private TextView usernameEditLabel,locationEditLabel, budget, monthlyCap;
private SeekBar budgetSeekBar, monthlyCapSeekBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        usernameEditLabel = findViewById(R.id.usernameEditLabel);
        locationEditLabel = findViewById(R.id.locationEditLabel);
        monthlyCap = findViewById(R.id.monthlyCap);
        budget = findViewById(R.id.budget);
        budgetSeekBar = findViewById(R.id.budgetSeekBar);
        monthlyCapSeekBar = findViewById(R.id.monthlyCapSeekBar);


        makeTextGradient(usernameEditLabel);
        makeTextGradient(locationEditLabel);


        seekBarChangeListener(budgetSeekBar, budget);
        seekBarChangeListener(monthlyCapSeekBar, monthlyCap);

    }


    private void seekBarChangeListener(SeekBar seekbar, final TextView label){
      seekbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                NumberFormat numberFormat = NumberFormat.getCurrencyInstance();
                label.setText(numberFormat.format(progress));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Bungee.inAndOut(this);
    }

    public void goBack(View view) {
        onBackPressed();
    }

    private void makeTextGradient(TextView label) {
        int[] color = {getResources().getColor(R.color.darkGreen),
                getResources().getColor(R.color.lightGreen)};
        Shader.TileMode tile_mode = Shader.TileMode.CLAMP;
        LinearGradient lin_grad = new LinearGradient(0, 0, 270, 0, color[0], color[1],
                tile_mode);
        Shader shader_gradient = lin_grad;
        label.getPaint().setShader(shader_gradient);
    }
}

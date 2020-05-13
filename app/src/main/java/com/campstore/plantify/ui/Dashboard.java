package com.campstore.plantify.ui;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.graphics.LinearGradient;
import android.graphics.Shader;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.campstore.plantify.R;
import com.campstore.plantify.controller.ContentSliderAdapter;

import spencerstudios.com.bungeelib.Bungee;

public class Dashboard extends AppCompatActivity {
private TextView productsLabel, inspirationsLabel, shopsLabel;
private  View underline;
private ViewPager contentSlider;
private ContentSliderAdapter mContentSliderAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        productsLabel = findViewById(R.id.productsLabel);
        inspirationsLabel = findViewById(R.id.inspirationsLabel);
        shopsLabel = findViewById(R.id.shopsLabel);
        underline = findViewById(R.id.underline);

        initiateContentSlider();
        setContentSlideListenner();

        makeTextGradient(productsLabel);

        onContentLabelClick(productsLabel, 0);
        onContentLabelClick(inspirationsLabel, 1);
        onContentLabelClick(shopsLabel, 2);

    }

    private void onContentLabelClick(TextView label, final int position){

        label.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                contentSlider.setCurrentItem(position);
            }
        });
    }

    private void setContentSlideListenner() {
        contentSlider.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                if (position == 0){
                    productsLabel.setBackground(getResources().getDrawable(R.drawable.fragment_label_background));
                    makeTextGradient(productsLabel);

                    inspirationsLabel.setBackground(null);
                    removeTextGradient(inspirationsLabel);
                    shopsLabel.setBackground(null);
                    removeTextGradient(shopsLabel);

                }

                if (position == 1){
                    inspirationsLabel.setBackground(getResources().getDrawable(R.drawable.fragment_label_background));
                    makeTextGradient(inspirationsLabel);

                    productsLabel.setBackground(null);
                    removeTextGradient(productsLabel);
                    shopsLabel.setBackground(null);
                    removeTextGradient(shopsLabel);


                }

                if (position == 2){
                    shopsLabel.setBackground(getResources().getDrawable(R.drawable.fragment_label_background));
                    makeTextGradient(shopsLabel);

                    inspirationsLabel.setBackground(null);
                    removeTextGradient(inspirationsLabel);
                    productsLabel.setBackground(null);
                    removeTextGradient(productsLabel);


                }

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    private void initiateContentSlider() {
        contentSlider = findViewById(R.id.content_slider);

        mContentSliderAdapter = new ContentSliderAdapter(getSupportFragmentManager());

        contentSlider.setAdapter(mContentSliderAdapter);
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

    private void removeTextGradient(TextView label){
        label.getPaint().setShader(null);
    }


    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Bungee.slideRight(this);
    }

    public void goBack(View view) {
        onBackPressed();
    }
}

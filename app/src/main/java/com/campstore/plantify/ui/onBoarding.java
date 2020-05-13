package com.campstore.plantify.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Shader;
import android.os.Bundle;
import android.text.Html;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.campstore.plantify.R;
import com.campstore.plantify.controller.SliderAdapter;

public class onBoarding extends AppCompatActivity {
private TextView greenerLabel;
private SliderAdapter mSliderAdapter;
private ViewPager slider;
private LinearLayout threeDotsLayout;
private TextView[] mTextViews;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_on_boarding);
     greenerLabel = findViewById(R.id.greenerLabel);
     threeDotsLayout = findViewById(R.id.dotCounts);

        makeTextGradient();
        sliderHandler();
        onSliderChangeHandler();
        addThreeDots(0);

    }

    private void onSliderChangeHandler() {
        slider.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {

                addThreeDots(position);

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    private void addThreeDots(int position) {
        threeDotsLayout.removeAllViews();

        mTextViews = new TextView[3];

        for(int i = 0; i<mTextViews.length; i++){
           mTextViews[i] = new TextView(this);
            mTextViews[i].setText(Html.fromHtml("&#8226;"));
            mTextViews[i].setTextSize(25);
            mTextViews[i].setTextColor(getResources().getColor(R.color.textColorLight));
            threeDotsLayout.addView(mTextViews[i]);
        }

        if(mTextViews.length>0){
            mTextViews[position].setTextColor(getResources().getColor(R.color.dotDarkColor));
        }


    }

    private void sliderHandler() {
        slider = findViewById(R.id.slider);
        mSliderAdapter = new SliderAdapter(getApplicationContext());

        slider.setAdapter(mSliderAdapter);
    }

    private void makeTextGradient() {
        int[] color = {getResources().getColor(R.color.darkGreen),
                getResources().getColor(R.color.lightGreen)};
        Shader.TileMode tile_mode = Shader.TileMode.CLAMP;
        LinearGradient lin_grad = new LinearGradient(0, 0, 270, 0, color[0], color[1],
                tile_mode);
        Shader shader_gradient = lin_grad;
        greenerLabel.getPaint().setShader(shader_gradient);
    }
}

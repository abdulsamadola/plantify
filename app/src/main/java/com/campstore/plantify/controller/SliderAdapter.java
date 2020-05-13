package com.campstore.plantify.controller;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewpager.widget.PagerAdapter;

import com.campstore.plantify.R;

public class SliderAdapter extends PagerAdapter {
    Context mContext;
    LayoutInflater mLayoutInflater;

    int[] images = {
            R.drawable.ic_plant2,
            R.drawable.ic_plant1,
            R.drawable.ic_plant3
    };

    public SliderAdapter(Context context) {
        mContext = context;
    }

    @Override
    public int getCount() {
        return images.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
//         super.instantiateItem(container, position);
         mLayoutInflater =
                 (LayoutInflater) mContext.getSystemService(mContext.LAYOUT_INFLATER_SERVICE);
         View view = mLayoutInflater.inflate(R.layout.slider_row, container, false);

        ImageView sliderImage = view.findViewById(R.id.sliderImage);
         sliderImage.setImageResource(images[position]);
         container.addView(view);

         return  view;

    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
       // super.destroyItem(container, position, object);
        container.removeView((ConstraintLayout) object);
    }
}

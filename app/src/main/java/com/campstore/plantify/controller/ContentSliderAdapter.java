package com.campstore.plantify.controller;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.campstore.plantify.ui.Inspirations;
import com.campstore.plantify.ui.Products;
import com.campstore.plantify.ui.Shops;

public class ContentSliderAdapter extends FragmentPagerAdapter {

    public ContentSliderAdapter(@NonNull FragmentManager fm) {
        super(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
    }


    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return new Products();
            case 1:
                return new Inspirations();
            case 2:
                return  new Shops();
            default: return null;
        }
    }

    @Override
    public int getCount() {
        return 3;
    }
}

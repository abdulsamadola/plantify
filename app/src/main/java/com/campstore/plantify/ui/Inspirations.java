package com.campstore.plantify.ui;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.campstore.plantify.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class Inspirations extends Fragment {


    public Inspirations() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_inspirations, container, false);
    }


}

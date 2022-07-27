package com.example.movietrackerapp;

import android.content.Context;
import android.os.Bundle;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.appcompat.app.AppCompatDelegate;
import androidx.fragment.app.Fragment;

public class SearchFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        Context contextThemeWrapper;

        if (AppCompatDelegate.getDefaultNightMode() == AppCompatDelegate.MODE_NIGHT_YES) {
            contextThemeWrapper = new ContextThemeWrapper(getActivity(), R.style.Theme_Dark);
        } else {
            contextThemeWrapper = new ContextThemeWrapper(getActivity(), R.style.Theme_Light);
        }

        LayoutInflater layoutInflater = inflater.cloneInContext(contextThemeWrapper);

        View view = layoutInflater.inflate(R.layout.fragment_search, container, false);


        return view;
    }
}

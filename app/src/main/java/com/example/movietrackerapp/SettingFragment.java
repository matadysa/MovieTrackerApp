package com.example.movietrackerapp;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatDelegate;
import androidx.appcompat.widget.SwitchCompat;
import androidx.fragment.app.Fragment;

import com.google.android.material.tabs.TabLayout;

public class SettingFragment extends Fragment {
    SwitchCompat switchCompat;
    TextView creditTextView;
    TextView contactTextView;
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

        View view = layoutInflater.inflate(R.layout.fragment_setting, container, false);

        switchCompat = view.findViewById(R.id.dark_theme_switch);

        switchCompat.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (switchCompat.isChecked()) {
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
                } else {
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
                }
                TabLayout.Tab tab = ((StartActivity) getActivity()).tabLayout.getTabAt(3);
                tab.select();
            }
        });

        creditTextView = view.findViewById(R.id.credits_text);
        creditTextView.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View view) {
                if(creditTextView.getText().toString().equals("Credits")){
                    creditTextView.setText(
                            "Credits:\n" +
                            "Mahdi khsodhell\n" +
                            "Matin Mahmudi");
                } else {
                    creditTextView.setText("Credits");
                }
            }
        });

        contactTextView = view.findViewById(R.id.contact_text);
        contactTextView.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View view) {
                if(contactTextView.getText().toString().equals("Contact us")){
                    contactTextView.setText("Contact us:\nkhoshdellmahdi@gmail.com");
                } else {
                    contactTextView.setText("Contact us");
                }
            }
        });
        return view;
    }


}

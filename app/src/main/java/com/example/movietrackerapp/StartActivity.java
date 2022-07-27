package com.example.movietrackerapp;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.viewpager2.widget.ViewPager2;

import com.google.android.material.tabs.TabLayout;

public class StartActivity extends AppCompatActivity {

    private FragmentsStateAdapter fragmentsStateAdapter;
    private ViewPager2 viewPager;

    public TabLayout tabLayout;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {

        if (AppCompatDelegate.getDefaultNightMode() == AppCompatDelegate.MODE_NIGHT_YES)
            setTheme(R.style.Theme_Dark);
        else
            setTheme(R.style.Theme_Light);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        fragmentsStateAdapter = new FragmentsStateAdapter(getSupportFragmentManager(), getLifecycle());
        viewPager = findViewById(R.id.container);
        setupViewPager(viewPager);

        tabLayout = findViewById(R.id.main_tab);
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                if (tab.getPosition() == 0) {
                    setViewPager(0);
                } else if(tab.getPosition() == 1) {
                    setViewPager(1);
                } else if(tab.getPosition() == 2) {
                    setViewPager(2);
                } else if(tab.getPosition() == 3) {
                    setViewPager(3);
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
                if (tab.getPosition() == 0) {
                    setViewPager(0);
                } else if(tab.getPosition() == 1) {
                    setViewPager(1);
                } else if(tab.getPosition() == 2) {
                    setViewPager(2);
                } else if(tab.getPosition() == 3) {
                    setViewPager(3);
                }
            }
        });
    }

    private void setupViewPager(ViewPager2 viewPager) {
        FragmentsStateAdapter adapter = new FragmentsStateAdapter(getSupportFragmentManager(), getLifecycle());
        adapter.addFragment(new HomeFragment());
        adapter.addFragment(new SearchFragment());
        adapter.addFragment(new WatchListFragment());
        adapter.addFragment(new SettingFragment());
        viewPager.setAdapter(adapter);
    }

    public void setViewPager(int fragmentNumber) {
        viewPager.setCurrentItem(fragmentNumber);
    }
}

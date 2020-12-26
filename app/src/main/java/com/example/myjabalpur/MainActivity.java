package com.example.myjabalpur;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SimpleFragmentPagerAdaptor fragmentPagerAdaptor = new SimpleFragmentPagerAdaptor(getSupportFragmentManager());

        ViewPager viewpager = findViewById(R.id.viewpager);

        viewpager.setAdapter(fragmentPagerAdaptor);

        TabLayout tablayout = findViewById(R.id.tablayout);

        tablayout.setupWithViewPager(viewpager);
    }
}
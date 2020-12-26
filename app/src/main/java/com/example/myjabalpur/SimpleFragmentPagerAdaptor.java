package com.example.myjabalpur;

import android.widget.Switch;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class SimpleFragmentPagerAdaptor extends FragmentPagerAdapter
{

    private int pageCount = 3;
    private String title[] = {"Places", "Restaurants", "Hotels"};

    public SimpleFragmentPagerAdaptor(@NonNull FragmentManager fm)
    {
        super(fm);
    }

    @NonNull
    @Override
    public Fragment getItem(int position)
    {
        switch(position)
        {
            case 0:
                return new Places();

                case 1:
                    return new Restaurants();

            case 2:
                return new Hotels();

            default:
                return null;
        }
    }

    @Override
    public int getCount()
    {
        return pageCount;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position)
    {
        return title[position];
    }
}

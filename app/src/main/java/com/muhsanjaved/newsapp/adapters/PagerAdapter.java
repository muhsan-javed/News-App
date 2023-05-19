package com.muhsanjaved.newsapp.adapters;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.muhsanjaved.newsapp.fragments.HomeFragment;
import com.muhsanjaved.newsapp.fragments.ScienceFragment;
import com.muhsanjaved.newsapp.fragments.entertainmentFragment;
import com.muhsanjaved.newsapp.fragments.healthFragment;
import com.muhsanjaved.newsapp.fragments.sportsFragment;
import com.muhsanjaved.newsapp.fragments.technologyFragment;

public class PagerAdapter extends FragmentPagerAdapter {
  int tabCount;

    public PagerAdapter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
        tabCount = behavior;
    }


    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return new HomeFragment();
            case 1:
                return new sportsFragment();
            case 2:
                return new healthFragment();
            case 3:
                return new ScienceFragment();
            case 4:
                return new entertainmentFragment();
            case 5:
                return new technologyFragment();

            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return tabCount;
    }
}

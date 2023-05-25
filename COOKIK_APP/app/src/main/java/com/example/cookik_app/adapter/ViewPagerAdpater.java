package com.example.cookik_app.adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.example.cookik_app.activity.fragment.FragmentHome;
import com.example.cookik_app.activity.fragment.FragmentInfo;
import com.example.cookik_app.activity.fragment.FragmentSearch;

public class ViewPagerAdpater extends FragmentStatePagerAdapter {
    public ViewPagerAdpater(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new FragmentHome();
            case 1:
                return new FragmentInfo();
            case 2:
                return new FragmentSearch();
            default:
                return new FragmentHome();
        }
//        return null;
    }
    @Override
    public int getCount() {
        return 3;
    }
}

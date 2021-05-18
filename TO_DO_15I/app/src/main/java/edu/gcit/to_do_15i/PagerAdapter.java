package edu.gcit.to_do_15i;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

public class PagerAdapter extends FragmentStatePagerAdapter {
    int mNumOfTabls;
    public PagerAdapter(FragmentManager fm, int mNumOfTabls) {
        super(fm);
        this.mNumOfTabls = mNumOfTabls;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0: return new fragment1();
            case 1: return new fragment2();
            case 2: return new fragment3();
            default: return null;
        }
    }

    @Override
    public int getCount() {
        return mNumOfTabls;
    }
}

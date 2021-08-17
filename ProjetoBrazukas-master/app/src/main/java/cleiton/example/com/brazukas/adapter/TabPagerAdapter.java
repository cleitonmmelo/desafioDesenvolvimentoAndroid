package cleiton.example.com.brazukas.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import cleiton.example.com.brazukas.fragment.ClubesFragment;
import cleiton.example.com.brazukas.fragment.PartidasFragment;

/**
 * Created by Cleiton on 13/10/2017.
 */

public class TabPagerAdapter extends FragmentPagerAdapter{
    int mNumOfTabs;

    public TabPagerAdapter(FragmentManager fm, int NumOfTabs) {
        super(fm);
        this.mNumOfTabs = NumOfTabs;
    }

    @Override
    public Fragment getItem(int position) {

        switch (position) {
            case 0:
                ClubesFragment tab1 = new ClubesFragment();
                return tab1;
            case 1:
                PartidasFragment tab2 = new PartidasFragment();
                return tab2;
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return mNumOfTabs;
    }
}

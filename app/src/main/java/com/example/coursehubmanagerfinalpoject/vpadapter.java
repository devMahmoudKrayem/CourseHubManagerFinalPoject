package com.example.coursehubmanagerfinalpoject;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import java.util.ArrayList;

public class vpadapter extends FragmentPagerAdapter {

    private final ArrayList<Fragment> fragmentArrayList=new ArrayList<>();
    private final ArrayList<String> fragmentTitleArrayList=new ArrayList<>();

    public vpadapter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        return fragmentArrayList.get(position);
    }

    @Override
    public int getCount() {
        return fragmentArrayList.size();
    }


    public void addFragment(Fragment fragment,String title){
        fragmentArrayList.add(fragment);
        fragmentTitleArrayList.add(title);
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return fragmentTitleArrayList.get(position);
    }
    public Fragment getFragmentAt(int position) {
        return fragmentArrayList.get(position);
    }

}

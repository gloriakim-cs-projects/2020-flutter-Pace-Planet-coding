package com.paceplanet.instruction;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.annotation.StringRes;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class InstructionSectionsPagerAdapter extends FragmentPagerAdapter {

    @StringRes
    private final Context mContext;

    public InstructionSectionsPagerAdapter(Context context, FragmentManager fm) {
        super(fm);
        mContext = context;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return FragmentInstructionOne.newInstance();
            case 1:
                return FragmentInstructionTwo.newInstance();
            case 2:
                return FragmentInstructionThree.newInstance();
        }
        return null;
    }

    @Override
    public int getCount() {
        return 3;
    }
}

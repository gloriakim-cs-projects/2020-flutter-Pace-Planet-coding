package com.paceplanet.instruction;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.paceplanet.R;

public class FragmentInstructionTwo extends Fragment {
    private View view;

    public static FragmentInstructionTwo newInstance() {
        FragmentInstructionTwo fragmentInstructionTwo = new FragmentInstructionTwo();
        return fragmentInstructionTwo;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_instruction_two, container, false);



        return view;
    }
}

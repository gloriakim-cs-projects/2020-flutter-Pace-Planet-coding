package com.paceplanet.instruction;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.paceplanet.MainActivity;
import com.paceplanet.R;

public class FragmentInstructionThree extends Fragment {
    private View view;

    public static FragmentInstructionThree newInstance() {
        FragmentInstructionThree fragmentInstructionThree = new FragmentInstructionThree();
        return fragmentInstructionThree;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_instruction_three, container, false);


        return view;
    }
}


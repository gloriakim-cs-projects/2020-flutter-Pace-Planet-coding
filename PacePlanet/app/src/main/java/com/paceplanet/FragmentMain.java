package com.paceplanet;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.os.SystemClock;
import android.text.format.DateFormat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Chronometer;
import android.widget.ImageButton;
import android.widget.Toast;

public class FragmentMain extends Fragment {

    private View view;
    private Chronometer chronometer;
    private boolean running;
    private long pauseOffset;

    //play or pause button
    private ImageButton ic_play_pause;
    private boolean start;
    private long timeElapsed =0;

    public static FragmentMain newInstance() {
        FragmentMain fragmentMain = new FragmentMain();
        return fragmentMain;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_main, container, false);

        chronometer = view.findViewById(R.id.chronometer);

        //set chrometer's format as HH:MM:SS
        chronometer.setOnChronometerTickListener(new Chronometer.OnChronometerTickListener(){
            @Override
            public void onChronometerTick(Chronometer cArg) {
                long time = SystemClock.elapsedRealtime() - cArg.getBase();
                int h   = (int)(time /3600000);
                int m = (int)(time - h*3600000)/60000;
                int s= (int)(time - h*3600000- m*60000)/1000 ;
                String hh = h < 10 ? "0"+h: h+"";
                String mm = m < 10 ? "0"+m: m+"";
                String ss = s < 10 ? "0"+s: s+"";
                cArg.setText(hh+":"+mm+":"+ss);
            }
        });
        chronometer.setBase(SystemClock.elapsedRealtime());

        //set play or pause button
        ic_play_pause = view.findViewById(R.id.ic_play_pause);
        ic_play_pause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //if pause is true
                if (start) {
                    //start the timer
                    startChronometer(view);
                    //set the image as pause
                    ic_play_pause.setImageResource(R.drawable.ic_pause);
                    start = false;
                }
                //if pause is false
                else {
                    //pause the timer
                    pauseChronometer(view);
                    //set the image as play
                    ic_play_pause.setImageResource(R.drawable.ic_play);
                    start = true;
                }
            }
        });


        return view;
    }

    public void startChronometer(View v) {
        if (!running) {
            chronometer.setBase(SystemClock.elapsedRealtime() - pauseOffset);
            chronometer.start();
            running = true;
        }
    }

    public void pauseChronometer(View v) {
        if (running) {
            chronometer.stop();
            pauseOffset = SystemClock.elapsedRealtime() - chronometer.getBase();
            running = false;
        }
    }
//
//    public void resetChronometer(View v) {
//        chronometer.setBase(SystemClock.elapsedRealtime());
//        pauseOffset = 0;
//
//    }

    private void toastMessage(String message){
        Toast.makeText(getActivity(), message, Toast.LENGTH_SHORT).show();
    }
}

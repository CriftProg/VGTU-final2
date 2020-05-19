package com.example.vgtu_final;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.Toast;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;

public class LecturesFragment extends Fragment   {
    private Activity context;

    DisplayLectures displayLectures;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        context = getActivity();

        FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
        final FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.setCustomAnimations(R.anim.slide_in_right,R.anim.slide_out_left);

        final View rootView = inflater.inflate(R.layout.fragment_dashboard, container, false);

        rootView.setOnTouchListener(new OnSwipeTouchListener(context) {

            public void onSwipeRight() {
                //Toast.makeText(context, "right", Toast.LENGTH_SHORT).show();
            }
            public void onSwipeLeft() {
                //Toast.makeText(context, "left", Toast.LENGTH_SHORT).show();
                transaction.replace(R.id.fragment_container,
                        new TomorrowFragment()).commit();
            }

        });

        displayLectures = new DisplayLectures(getContext());
        displayLectures.TodayLecture(rootView);

        pops(rootView);


        return  rootView;
    }

    public void pops(View rootView){
        ImageButton b = (ImageButton) rootView.findViewById(R.id.button_lecture1_1);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(context,Pop.class));
            }
        });
    }


}

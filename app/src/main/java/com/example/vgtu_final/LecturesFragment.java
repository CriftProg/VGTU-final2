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
import android.widget.TextView;
import android.widget.Toast;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;

import java.nio.Buffer;

public class LecturesFragment extends Fragment   {
    private Activity context;

    DisplayLectures displayLectures;
    LecturesDBHelper dbHelper;
    String caller;

    int [] pop_button = {R.id.button_popOutLecture1_1,
            R.id.button_popOutLecture2_1,
            R.id.button_popOutLecture3_1,
            R.id.button_popOutLecture4_1,
            R.id.button_popOutLecture5_1,
            R.id.button_popOutLecture6_1};
    int [] lecture_names = {R.id.text_lectureName1_1,
            R.id.text_lectureName2_1,
            R.id.text_lectureName3_1,
            R.id.text_lectureName4_1,
            R.id.text_lectureName5_1,
            R.id.text_lectureName6_1};
    Pop pop;


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

        dbHelper = new LecturesDBHelper(context);

        displayLectures = new DisplayLectures(getContext(), dbHelper.getReadableDatabase());
        displayLectures.TodayLecture(rootView);


        pop = new Pop();

        for(int i = 0; i< pop_button.length ; i++){
            pop.openPop(rootView,context,pop_button[i],lecture_names[i]);

        }


        return  rootView;
    }



    }






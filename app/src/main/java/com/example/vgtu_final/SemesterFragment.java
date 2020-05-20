package com.example.vgtu_final;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.Toast;

public class SemesterFragment extends Fragment {
    private Activity context;

    DisplayLectures displayLectures;
    LecturesDBHelper helperDb;
    Pop pop;

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

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        context = getActivity();
        FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
        final FragmentTransaction transaction_right = fragmentManager.beginTransaction();
        final FragmentTransaction transaction_left = fragmentManager.beginTransaction();
        transaction_right.setCustomAnimations(R.anim.slide_in_left,R.anim.slide_out_right);

        final View rootView = inflater.inflate(R.layout.fragment_semester, container, false);
        ScrollView scroll = rootView.findViewById(R.id.scroll_id);


       scroll.setOnTouchListener(new OnSwipeTouchListener(context) {

            public void onSwipeRight() {
                //Toast.makeText(context, "right", Toast.LENGTH_SHORT).show();
                transaction_right.replace(R.id.fragment_container,
                        new TomorrowFragment()).commit();
            }
            public void onSwipeLeft() {
                //Toast.makeText(context, "left", Toast.LENGTH_SHORT).show();

            }




        });

        helperDb = new LecturesDBHelper(context);

        displayLectures = new DisplayLectures(getContext(),helperDb.getReadableDatabase());
        displayLectures.SemesterLectures(rootView);

        LinearLayout layout1 = rootView.findViewById(R.id.semester_linday1);
        LinearLayout layout2 = rootView.findViewById(R.id.semester_linday2);
        LinearLayout layout3 = rootView.findViewById(R.id.semester_linday3);
        LinearLayout layout4 = rootView.findViewById(R.id.semester_linday4);
        LinearLayout layout5 = rootView.findViewById(R.id.semester_linday5);

        pop = new Pop();

        for(int i = 0; i< pop_button.length ; i++){
            pop.openPop(layout1,context,pop_button[i],lecture_names[i]);
        }

        for(int i = 0; i< pop_button.length ; i++){
            pop.openPop(layout2,context,pop_button[i],lecture_names[i]);
        }

        for(int i = 0; i< pop_button.length ; i++){
            pop.openPop(layout3,context,pop_button[i],lecture_names[i]);
        }

        for(int i = 0; i< pop_button.length ; i++){
            pop.openPop(layout4,context,pop_button[i],lecture_names[i]);
        }

        for(int i = 0; i< pop_button.length ; i++){
            pop.openPop(layout5,context,pop_button[i],lecture_names[i]);
        }


        return  rootView;
    }
}

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
import android.widget.Toast;

public class TomorrowFragment extends Fragment {
    private Activity context;

    DisplayLectures displayLectures;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        context = getActivity();
        FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
        final FragmentTransaction transaction_right = fragmentManager.beginTransaction();
        final FragmentTransaction transaction_left = fragmentManager.beginTransaction();
        transaction_right.setCustomAnimations(R.anim.slide_in_left,R.anim.slide_out_right);
        transaction_left.setCustomAnimations(R.anim.slide_in_right,R.anim.slide_out_left);

        final View rootView = inflater.inflate(R.layout.fragment_tomorrow, container, false);

        rootView.setOnTouchListener(new OnSwipeTouchListener(context) {

            public void onSwipeRight() {
                //Toast.makeText(context, "right", Toast.LENGTH_SHORT).show();
                transaction_right.replace(R.id.fragment_container,
                        new LecturesFragment()).commit();
            }
            public void onSwipeLeft() {
                //Toast.makeText(context, "left", Toast.LENGTH_SHORT).show();
                transaction_left.replace(R.id.fragment_container,
                        new SemesterFragment()).commit();

            }




        });

        displayLectures = new DisplayLectures(getContext());
        displayLectures.TomorrowLecture(rootView);

        return  rootView;
    }
}

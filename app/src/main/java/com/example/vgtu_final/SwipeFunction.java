package com.example.vgtu_final;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MotionEvent;



public class SwipeFunction extends AppCompatActivity {

    float x1, x2, y1, y2;



    private AppCompatActivity current;
    private Class swipe_right;
    private Class swipe_left;

    public SwipeFunction(Activity current, Class swipe_right, Class swipe_left) {
        this.current = (AppCompatActivity) current;
        this.swipe_right = swipe_right;
        this.swipe_left = swipe_left;
    }

    public void checkReference(){
        current.getBaseContext();
    }

    public boolean onTouchEvent(MotionEvent touchevent) {



            switch (touchevent.getAction()) {
                case MotionEvent.ACTION_DOWN:

                    x1 = touchevent.getX();
                    y1 = touchevent.getY();
                    Log.i("Button", "LOOOLZdown");
                    break;
                case MotionEvent.ACTION_UP:
                    x2 = touchevent.getX();
                    y2 = touchevent.getY();
                    Log.i("Button", "LOOOLZup");
                    if (x1 > x2) {
                        if (swipe_right == null) {

                            break;
                        }
                        Intent change_to_right = new Intent(current, swipe_right);
                        Log.i("Button", "Works");
                        current.startActivity(change_to_right);
                        current.overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                    }
                    if (x2 > x1) {
                        if (swipe_left == null) {

                            break;
                        }
                        Intent change_to_left = new Intent(current, swipe_left);
                        current.startActivity(change_to_left);
                        current.overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
                    }

                    break;

            }

        return false;
    }
}


/*
    public boolean onTouchEvent(MotionEvent touchevent) {



        switch (touchevent.getAction()) {
            case MotionEvent.ACTION_DOWN:
                x1 = touchevent.getX();
                y1 = touchevent.getY();
                break;
            case MotionEvent.ACTION_UP:
                x2 = touchevent.getX();
                y2 = touchevent.getY();
                if (x1 > x2) {
                    Intent change_to_right = new Intent(current, swipe_right);
                    Log.i("Swipe", "Works");
                    current.startActivity(change_to_right);
                    overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);

                }
                if(x2 > x1){
                    Intent change_to_left = new Intent(current, swipe_left);
                    current.startActivity(change_to_left);
                    overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
                }
                break;
        }
        return false;
    }
}*/



package com.example.vgtu_final;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;



public class DashboardActivity extends AppCompatActivity {


    //SwipeFunction swipe = new SwipeFunction(this, TemplateActivity.class, LoginActivity.class);



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_dashboard);
        //swipe.checkReference();
        setDayIndicator();
        //Slidr.attach( this);
       // ButtonChange();
        pops();

    }

    public boolean onTouchEvent(MotionEvent touchevent){
       // swipe.onTouchEvent(touchevent);
        return false;
    }


    public void ButtonChange(){
        //Button b = (Button) findViewById(R.id.button);
        //b.setVisibility(b.GONE);
    }


    public void setDayIndicator(){
        CalendarTime calendar = new CalendarTime();
        String current_day = calendar.getDayOfWeek();

        TextView view = (TextView) findViewById(R.id.dashboard_currentDay);
        view.setText(current_day);
    }



    public void pops(){
        ImageButton b = (ImageButton) findViewById(R.id.button_lecture1_1);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(DashboardActivity.this,Pop.class));
            }
        });
        }







}

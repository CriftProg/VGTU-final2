package com.example.vgtu_final;


import android.os.Build;



import java.util.Calendar;


public class CalendarTime {

    private String dayOfWeek1 = "Monday";
    private String dayOfWeek2 = "Tuesday";
    private String dayOfWeek3 = "Wednesday";
    private String dayOfWeek4 = "Thursday";
    private String dayOfWeek5 = "Friday";
    private String dayOfWeek6 = "Saturday";
    private String dayOfWeek7 = "Sunday";

    private String NO_DAY_FOUND = "Unable to determine dayOfWeek";


    public String getDayOfWeek(){
        Calendar calendar = Calendar.getInstance();
        int day = calendar.get(Calendar.DAY_OF_WEEK);

        switch (day) {
            case Calendar.SUNDAY:
                return dayOfWeek7;

            case Calendar.SATURDAY:
                return dayOfWeek6;

            case Calendar.FRIDAY:
                return dayOfWeek5;

            case Calendar.THURSDAY:
                return dayOfWeek4;

            case Calendar.WEDNESDAY:
                return dayOfWeek3;

            case Calendar.TUESDAY:
                return dayOfWeek2;

            case Calendar.MONDAY:
                return dayOfWeek1;

        }
        return NO_DAY_FOUND;
    }

    public String getTomorrowOfWeek(){
        Calendar calendar = Calendar.getInstance();
        int day = calendar.get(Calendar.DAY_OF_WEEK);

        switch (day+1) {
            case Calendar.SUNDAY:
                return dayOfWeek7;

            case Calendar.SATURDAY:
                return dayOfWeek6;

            case Calendar.FRIDAY:
                return dayOfWeek5;

            case Calendar.THURSDAY:
                return dayOfWeek4;

            case Calendar.WEDNESDAY:
                return dayOfWeek3;

            case Calendar.TUESDAY:
                return dayOfWeek2;

            case Calendar.MONDAY:
                return dayOfWeek1;

        }
        return NO_DAY_FOUND;
    }


    public int week_count(){
        Calendar calendar = Calendar.getInstance();
        int week = calendar.get(Calendar.WEEK_OF_MONTH);
        if (week == 2 || week == 4) {
            return 2;
        }
        else
            return 1;


    }

}

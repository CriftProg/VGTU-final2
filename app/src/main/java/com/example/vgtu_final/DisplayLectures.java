package com.example.vgtu_final;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.vgtu_final.LecturesContract.LecturesEntry;

public class DisplayLectures {
    SQLiteDatabase db;
    Context context;
    CalendarTime time;
    Cursor cursor;

    int pop_count;

    DBManager dbm;

    boolean first_lec = true;
    boolean second_lec = false;
    boolean third_lec = false;
    boolean fourth_lec = true;


    String week_name =" Wk.";
    String number_name = " Lecture";



    int [] lecture1 = {R.id.text_lectureNumber1_1, R.id.text_lectureName1_1, R.id.text_Week1_1 ,R.id.text_lectureRoom1_1, R.id.text_lectureTime1_1, R.id.view_homework1_1, R.id.view_test1_1 };
    int [] lecture2 = {R.id.text_lectureNumber2_1, R.id.text_lectureName2_1, R.id.text_Week2_1 ,R.id.text_lectureRoom2_1, R.id.text_lectureTime2_1, R.id.view_homework2_1, R.id.view_test2_1 };
    int [] lecture3 = {R.id.text_lectureNumber3_1, R.id.text_lectureName3_1, R.id.text_Week3_1 ,R.id.text_lectureRoom3_1, R.id.text_lectureTime3_1, R.id.view_homework3_1, R.id.view_test3_1 };
    int [] lecture4 = {R.id.text_lectureNumber4_1, R.id.text_lectureName4_1, R.id.text_Week4_1 ,R.id.text_lectureRoom4_1, R.id.text_lectureTime4_1, R.id.view_homework4_1, R.id.view_test4_1 };
    int [] lecture5 = {R.id.text_lectureNumber5_1, R.id.text_lectureName5_1, R.id.text_Week5_1 ,R.id.text_lectureRoom5_1, R.id.text_lectureTime5_1, R.id.view_homework5_1, R.id.view_test5_1 };
    int [] lecture6 = {R.id.text_lectureNumber6_1, R.id.text_lectureName6_1, R.id.text_Week6_1 ,R.id.text_lectureRoom6_1, R.id.text_lectureTime6_1, R.id.view_homework6_1, R.id.view_test6_1 };

    String[] columns = {LecturesEntry.COLUMN__LECTURE_NUMBER,LecturesEntry.COLUMN_LECTURE_NAME, LecturesEntry.COLUMN_LECTURE_WEEK, LecturesEntry.COLUMN_LECTURE_ROOM, LecturesEntry.COLUMN_LECTURE_START, LecturesEntry.COLUMN_LECTURE_END, LecturesEntry.COLUMN_LECTURE_HOMEWORK, LecturesEntry.COLUMN_LECTURE_TEST};

    DisplayLectures(Context context ,  SQLiteDatabase db){
        this.context = context;
        this.db = db;
        LecturesDBHelper dbHelper = new LecturesDBHelper(context);
        //db = dbHelper.getReadableDatabase();
        //db.isOpen();


        }
        public void SemesterLectures(View rootView){
            int today_week = 0;
            LinearLayout layout_monday = rootView.findViewById(R.id.semester_linday1);
            setDay(layout_monday, LecturesEntry.TABLE_NAME_MONDAY, columns, today_week);

            LinearLayout layout_tuesday = rootView.findViewById(R.id.semester_linday2);
            setDay(layout_tuesday, LecturesEntry.TABLE_NAME_TUESDAY, columns, today_week);

            LinearLayout layout_wednesday = rootView.findViewById(R.id.semester_linday3);
            setDay(layout_wednesday, LecturesEntry.TABLE_NAME_WEDNESDAY, columns, today_week);

            LinearLayout layout_thursday = rootView.findViewById(R.id.semester_linday4);
            setDay(layout_thursday, LecturesEntry.TABLE_NAME_THURSDAY, columns, today_week);

            LinearLayout layout_friday =  rootView.findViewById(R.id.semester_linday5);
            setDay(layout_friday, LecturesEntry.TABLE_NAME_FRIDAY, columns, today_week);
        }
        public void TomorrowLecture(View rootView){
            int today_week;


            time = new CalendarTime();
            TextView day_index = rootView.findViewById(R.id.dashboard_currentDay);

            day_index.setText(time.getTomorrowOfWeek());



            Log.i("Button",time.getDayOfWeek());
            today_week = time.week_count();
            switch (time.getTomorrowOfWeek()){
                case "Monday":
                    setDay(rootView, LecturesEntry.TABLE_NAME_MONDAY, columns, today_week);

                    break;
                case "Tuesday":
                    setDay(rootView, LecturesEntry.TABLE_NAME_TUESDAY, columns, today_week);
                    break;
                case "Wednesday":
                    setDay(rootView, LecturesEntry.TABLE_NAME_WEDNESDAY, columns, today_week);
                    break;
                case "Thursday":
                    setDay(rootView, LecturesEntry.TABLE_NAME_THURSDAY, columns, today_week);
                    break;
                case "Friday":
                    setDay(rootView, LecturesEntry.TABLE_NAME_FRIDAY, columns, today_week);
                    break;
                case "Saturday":
                    setDay(rootView, null, columns, today_week);
                    break;
                case "Sunday":
                    setDay(rootView, null, columns, today_week);
                    break;
            }
        }
        public void TodayLecture(View rootView){
            int today_week;


            time = new CalendarTime();
            TextView day_index = rootView.findViewById(R.id.dashboard_currentDay);

            day_index.setText(time.getDayOfWeek());

            Log.i("Button",time.getDayOfWeek());
            today_week = time.week_count();
            switch (time.getDayOfWeek()){
                case "Monday":
                   setDay(rootView, LecturesEntry.TABLE_NAME_MONDAY, columns, today_week);

                    break;
                case "Tuesday":
                    setDay(rootView, LecturesEntry.TABLE_NAME_TUESDAY, columns, today_week);
                    break;
                case "Wednesday":
                    setDay(rootView, LecturesEntry.TABLE_NAME_WEDNESDAY, columns, today_week);
                    break;
                case "Thursday":
                    setDay(rootView, LecturesEntry.TABLE_NAME_THURSDAY, columns, today_week);
                    break;
                case "Friday":
                    setDay(rootView, LecturesEntry.TABLE_NAME_FRIDAY, columns, today_week);
                    break;
                case "Saturday":
                    setDay(rootView, null, columns, today_week);
                    break;
                case "Sunday":
                    setDay(rootView, null, columns, today_week);
                    break;
            }

            //number_of_lectures = cursor.getCount();

           // Log.i("Button", String.valueOf(number_of_lectures));


           // name1 = cursor.getString(cursor.getColumnIndex(LecturesEntry.COLUMN_LECTURE_NAME));
            //name.setText(cursor.getColumnIndex(LecturesEntry.COLUMN_LECTURE_NAME));
        }

        public void setDay(View rootView, String table_name, String[] columns, int week){
            String[] lectures = new String[]{LecturesEntry._ID, LecturesEntry.COLUMN_LECTURE_WEEK};



            if(table_name == null){
                rootView.findViewById(R.id.frameLayout_Lecture6_1).setVisibility(View.GONE);
                rootView.findViewById(R.id.frameLayout_Lecture5_1).setVisibility(View.GONE);
                rootView.findViewById(R.id.frameLayout_Lecture4_1).setVisibility(View.GONE);
                rootView.findViewById(R.id.frameLayout_Lecture3_1).setVisibility(View.GONE);
                rootView.findViewById(R.id.frameLayout_Lecture2_1).setVisibility(View.GONE);
                rootView.findViewById(R.id.frameLayout_lecture1_1).setVisibility(View.GONE);
                rootView.findViewById(R.id.dashboard_nolecture).setVisibility(View.VISIBLE);
                return;
            }
            String[][] text = getAllData(table_name,columns,week);
            switch (howManyLectures(table_name,lectures,week)){
                case 6:
                    setLectureInfo(rootView, lecture1 , text[0]);
                    setLectureInfo(rootView, lecture2 , text[1]);
                    setLectureInfo(rootView, lecture3 , text[2]);
                    setLectureInfo(rootView, lecture4 , text[3]);
                    setLectureInfo(rootView, lecture5 , text[4]);
                    setLectureInfo(rootView,lecture6, text[5]);
                    break;
                case 5:
                    setLectureInfo(rootView, lecture1 , text[0]);
                    setLectureInfo(rootView, lecture2 , text[1]);
                    setLectureInfo(rootView, lecture3 , text[2]);
                    setLectureInfo(rootView, lecture4 , text[3]);
                    setLectureInfo(rootView, lecture5 , text[4]);
                    rootView.findViewById(R.id.frameLayout_Lecture6_1).setVisibility(View.GONE);
                    break;
                case 4:
                    //Log.i("Button","XXXXXXXX");
                    setLectureInfo(rootView, lecture1 , text[0]);
                    setLectureInfo(rootView, lecture2 , text[1]);
                    setLectureInfo(rootView, lecture3 , text[2]);
                    setLectureInfo(rootView, lecture4 , text[3]);
                    rootView.findViewById(R.id.frameLayout_Lecture5_1).setVisibility(View.GONE);
                    rootView.findViewById(R.id.frameLayout_Lecture6_1).setVisibility(View.GONE);
                    break;
                case 3:
                    //Log.i("Button","YYYYYYYY");
                    setLectureInfo(rootView, lecture1 , text[0]);
                    setLectureInfo(rootView, lecture2 , text[1]);
                    setLectureInfo(rootView, lecture3 , text[2]);
                    rootView.findViewById(R.id.frameLayout_Lecture4_1).setVisibility(View.GONE);
                    rootView.findViewById(R.id.frameLayout_Lecture5_1).setVisibility(View.GONE);
                    rootView.findViewById(R.id.frameLayout_Lecture6_1).setVisibility(View.GONE);
                    break;
                case 2:
                    setLectureInfo(rootView, lecture1 , text[0]);
                    setLectureInfo(rootView, lecture2 , text[1]);
                    rootView.findViewById(R.id.frameLayout_Lecture4_1).setVisibility(View.GONE);
                    rootView.findViewById(R.id.frameLayout_Lecture3_1).setVisibility(View.GONE);
                    rootView.findViewById(R.id.frameLayout_Lecture5_1).setVisibility(View.GONE);
                    rootView.findViewById(R.id.frameLayout_Lecture6_1).setVisibility(View.GONE);
                    break;
                case 1:
                    setLectureInfo(rootView, lecture1 , text[0]);
                    rootView.findViewById(R.id.frameLayout_Lecture5_1).setVisibility(View.GONE);
                    rootView.findViewById(R.id.frameLayout_Lecture6_1).setVisibility(View.GONE);
                    rootView.findViewById(R.id.frameLayout_Lecture4_1).setVisibility(View.GONE);
                    rootView.findViewById(R.id.frameLayout_Lecture3_1).setVisibility(View.GONE);
                    rootView.findViewById(R.id.frameLayout_Lecture2_1).setVisibility(View.GONE);
                    break;
                case 0:
                    rootView.findViewById(R.id.frameLayout_Lecture5_1).setVisibility(View.GONE);
                    rootView.findViewById(R.id.frameLayout_Lecture6_1).setVisibility(View.GONE);
                    rootView.findViewById(R.id.frameLayout_Lecture4_1).setVisibility(View.GONE);
                    rootView.findViewById(R.id.frameLayout_Lecture3_1).setVisibility(View.GONE);
                    rootView.findViewById(R.id.frameLayout_Lecture2_1).setVisibility(View.GONE);
                    rootView.findViewById(R.id.frameLayout_lecture1_1).setVisibility(View.GONE);
                    rootView.findViewById(R.id.dashboard_nolecture).setVisibility(View.VISIBLE);
                    break;

            }
        }

        public void setLectureInfo(View rootView,  int[] data_id, String[] text){
            TextView view;
            ImageView image;
            int unit = data_id.length-2;
            //Log.i("Button", "text all " + text[2] + " /");
            for(int i = 0; i < unit; i++) {
                view = rootView.findViewById(data_id[i]);
                //Log.i("Button", "text changed " + data_id[i]);
                view.setText(text[i]);
                //Log.i("Button", "text changed2 " + text[i]);
            }
            if(Integer.parseInt(text[unit]) == 0){
                image = rootView.findViewById(data_id[unit]);
                image.setVisibility(View.GONE);
                Log.i("Button", "text all end 222ZZZZZ " + text[unit] + " /");
            }
            if(Integer.parseInt(text[unit+1]) == 0){
                image = rootView.findViewById(data_id[unit+1]);
                image.setVisibility(View.GONE);
            }
            Log.i("Button", "text all end " + text[unit+1] + " /");

        }




    public String[][] getAllData(String table_name, String[] columns , int week){
        //Log.i("Button", "getAlldata" );



        Cursor cursor = db.query(table_name, columns, null,null,null,null,null);



        int i = 0;
        String [][] data = new String[100][15];
        while (cursor.moveToNext()){

            //Log.i("Button", "Id " + i);
            String lec_number = cursor.getString(cursor.getColumnIndex(columns[0]));
            String lec_name = cursor.getString(cursor.getColumnIndex(columns[1]));
            String lec_week = cursor.getString(cursor.getColumnIndex(columns[2]));
            if(Integer.parseInt(lec_week) == week || Integer.parseInt(lec_week) == 0 ){

                String lec_room = cursor.getString(cursor.getColumnIndex(columns[3]));
                String lec_stTime = cursor.getString(cursor.getColumnIndex(columns[4]));
                String lec_endTime = cursor.getString(cursor.getColumnIndex(columns[5]));
                String lec_homework = cursor.getString(cursor.getColumnIndex(columns[6]));
                String lec_test = cursor.getString(cursor.getColumnIndex(columns[7]));
                data[i] = new String[]{lec_number + number_name, lec_name, lec_week + week_name, lec_room, lec_stTime + " - "+ lec_endTime, lec_homework, lec_test};
                i++;

            }else if(week == 0){
                String lec_room = cursor.getString(cursor.getColumnIndex(columns[3]));
                String lec_stTime = cursor.getString(cursor.getColumnIndex(columns[4]));
                String lec_endTime = cursor.getString(cursor.getColumnIndex(columns[5]));
                String lec_homework = cursor.getString(cursor.getColumnIndex(columns[6]));
                String lec_test = cursor.getString(cursor.getColumnIndex(columns[7]));
                data[i] = new String[]{lec_number + number_name, lec_name, lec_week + week_name, lec_room, lec_stTime + " - "+ lec_endTime, lec_homework, lec_test};
                i++;
            }

            //Log.i("Button", "Data " + data[i][3]);
            /*String lec_room = cursor.getString(cursor.getColumnIndex(columns[3]));
            String lec_stTime = cursor.getString(cursor.getColumnIndex(columns[4]));
            String lec_endTime = cursor.getString(cursor.getColumnIndex(columns[5]));
            String lec_homework = cursor.getString(cursor.getColumnIndex(columns[6]));
            String lec_test = cursor.getString(cursor.getColumnIndex(columns[7]));
            data[i] = new String[]{lec_number + number_name, lec_name, lec_week + week_name, lec_room, lec_stTime + " - "+ lec_endTime, lec_homework, lec_test};
            i++;
            //buffer.append(id + " " + name + "\n");

             */
        }
        cursor.close();
        //Log.i("Button", "Return Data " + data[i][3]);
        return data;
    }

    public String[][] getPopData(String table_name, String[] columns){

        Cursor cursor = db.query(table_name, columns, null,null,null,null,null);

        int i = 0;
        String[][] data = new String[100][15];
        while (cursor.moveToNext()){


            String subject_name  = cursor.getString(cursor.getColumnIndex(columns[0]));
            String subject_teacher = cursor.getString(cursor.getColumnIndex(columns[1]));
            String subject_date   = cursor.getString(cursor.getColumnIndex(columns[2]));
            String subject_group  = cursor.getString(cursor.getColumnIndex(columns[3]));

            Log.i("Button", "subject " + subject_name);

            data[i] = new String[]{subject_name,
                    subject_teacher,
                    subject_date,
                    subject_group  };
            i++;
            }
        pop_count = i;

        return data;
    }

    public String getCaller(String table_name, String[] columns){
        Cursor cursor = db.query(table_name, columns, null,null,null,null,null);
        String caller = new String();
        while (cursor.moveToNext()) {
             caller = cursor.getString(cursor.getColumnIndex(columns[0]));
        }
        return caller;

    }


    public int howManyLectures(String table_name, String[] columns, int week){
        Cursor cursor = db.query(table_name, columns, null,null,null,null,null);
        int number = 0;
        while (cursor.moveToNext()){
            int w = cursor.getInt(cursor.getColumnIndex(columns[1]));
            if(week == 0){
               number++;
               continue;
            }
            if(w == week | w == 0){
                Log.i("Button", "Wee " + w);
                number++;
            }

        }
        cursor.close();
        Log.i("Button", "Records " + number);
        return number;
    }




}

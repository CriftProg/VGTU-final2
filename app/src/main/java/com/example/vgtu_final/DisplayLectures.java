package com.example.vgtu_final;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.example.vgtu_final.LecturesContract.LecturesEntry;

public class DisplayLectures {
    SQLiteDatabase db;
    Context context;
    CalendarTime time;
    Cursor cursor;

    DBManager dbm;

    boolean first_lec = true;
    boolean second_lec = false;
    boolean third_lec = false;
    boolean fourth_lec = true;

    String[] columns = {LecturesEntry.COLUMN_LECTURE_NAME};



    DisplayLectures(Context context){
        this.context = context;
        dbm = new DBManager(context);

        LecturesDBHelper dbHelper = new LecturesDBHelper(context);
        db = dbHelper.getWritableDatabase();

        }
        public void TodayLecture(View rootView){
            int today_week;
            int number_of_lectures;

            time = new CalendarTime();
            Log.i("Button",time.getDayOfWeek());

            switch (time.getDayOfWeek()){
                case "Monday":
                    Log.i("Button"," DD " + getAllData(LecturesEntry.TABLE_NAME_MONDAY) + "/");

                    break;
                case "Tuesday":
                    cursor = getAllItems(LecturesEntry.TABLE_NAME_TUESDAY, columns);
                    break;
                case "Wednesday":
                    cursor = getAllItems(LecturesEntry.TABLE_NAME_WEDNESDAY,columns);
                    break;
                case "Thursday":
                    cursor = getAllItems(LecturesEntry.TABLE_NAME_THURSDAY,columns);
                    break;
                case "Friday":
                    cursor = getAllItems(LecturesEntry.TABLE_NAME_FRIDAY,columns);
                    break;
            }
            today_week = time.week_count();
            //number_of_lectures = cursor.getCount();

           // Log.i("Button", String.valueOf(number_of_lectures));
            int [] lecture1 = {R.id.text_lectureNumber1_1, R.id.text_lectureName1_1, R.id.text_Week1_1 ,R.id.text_lectureRoom1_1, R.id.text_lectureTime1_1, R.id.view_homework1_1, R.id.view_test1_1 };
            int [] lecture2 = {R.id.text_lectureNumber2_1, R.id.text_lectureName2_1, R.id.text_Week2_1 ,R.id.text_lectureRoom2_1, R.id.text_lectureTime2_1, R.id.view_homework2_1, R.id.view_test2_1 };
            int [] lecture3 = {R.id.text_lectureNumber3_1, R.id.text_lectureName3_1, R.id.text_Week3_1 ,R.id.text_lectureRoom3_1, R.id.text_lectureTime3_1, R.id.view_homework1_1, R.id.view_test1_1 };
            int [] lecture4 = {R.id.text_lectureNumber4_1, R.id.text_lectureName4_1, R.id.text_Week4_1 ,R.id.text_lectureRoom4_1, R.id.text_lectureTime4_1, R.id.view_homework2_1, R.id.view_test2_1 };
            TextView name = rootView.findViewById(R.id.text_lectureName1_1);

            TextView number = rootView.findViewById(R.id.text_lectureNumber1_1);
            String name1= new String();
           // name1 = cursor.getString(cursor.getColumnIndex(LecturesEntry.COLUMN_LECTURE_NAME));
            //name.setText(cursor.getColumnIndex(LecturesEntry.COLUMN_LECTURE_NAME));
        }


    private Cursor getAllItems(String table_name, String[] columns) {

        return db.query(table_name,columns,null,null,null,null,null);
}

    public String getAllData(String table_name){
        Log.i("Button", "getAlldata" );

        String[] columns = {LecturesEntry._ID,LecturesEntry.COLUMN_LECTURE_NAME, LecturesEntry.COLUMN_LECTURE_WEEK, LecturesEntry.COLUMN_LECTURE_TYPE};

        Cursor cursor = db.query(table_name, columns, null,null,null,null,null);
        Log.i("Button", "getAlldata db " + cursor.getCount());
        StringBuffer buffer = new StringBuffer();
        while (cursor.moveToNext()){
            int id = cursor.getInt(cursor.getColumnIndex(columns[0]));
            Log.i("Button", "Id " + id);
            String name = cursor.getString(cursor.getColumnIndex(columns[1]));
            buffer.append(id + " " + name + "\n");
        }
        return buffer.toString();
    }

    public void setLectureData(){

    }


}

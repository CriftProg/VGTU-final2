package com.example.vgtu_final;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.example.vgtu_final.LecturesContract.LecturesEntry;
public class DBManager {

    public SQLiteDatabase mDatabase;
    private LecturesDBHelper dbHelper;
    private Context context;
    private String[] lecture_files_to_read = {"mondaylec.txt",
            "tuesdaylec.txt",
            "wednesdaylec.txt",
            "thursdaylec.txt",
            "fridaylec.txt"};
    private String[] lecture_table_names = {LecturesEntry.TABLE_NAME_MONDAY, LecturesEntry.TABLE_NAME_TUESDAY,
            LecturesEntry.TABLE_NAME_WEDNESDAY, LecturesEntry.TABLE_NAME_THURSDAY, LecturesEntry.TABLE_NAME_FRIDAY};

    DBManager(Context context) {

        dbHelper = new LecturesDBHelper(context);
        mDatabase = dbHelper.getWritableDatabase();
        this.context = context;
        Log.i("Button", "DB start " + lecture_files_to_read[1]);
        readFromFiles();
        Log.i("Button", "DB readed");

    }

    public void readFromFiles() {
        int array_size = 0;
        FileReader fr = new FileReader(context);
        String[][] array_lectureparams;

        for (int i = 0; i < lecture_files_to_read.length; i++) {
            //Log.i("Button","Loop st " + lecture_files_to_read[i]);
            array_lectureparams = fr.readfile_dayLectures(lecture_files_to_read[i]);
            Log.i("Button","Loop st2");
            fillDB_lectures(array_lectureparams, fr.array_size, mDatabase, lecture_table_names[i]);
        }
        mDatabase.close();
    }


    public void fillDB_lectures(String[][] array_lectureparams, int array_length, SQLiteDatabase mDatabase, String tablename) {

        if(array_lectureparams[0][1] == null){
            Log.i("Button","LLLLLOOL");
            return;
        }



        Log.i("Button", "length " + array_length);
        for (int i = 0; i < array_length; i++) {
            mDatabase = dbHelper.getWritableDatabase();
            ContentValues cv = new ContentValues();

            String name = array_lectureparams[i][0].trim();
            int week = Integer.parseInt(array_lectureparams[i][1].trim());
            int type = Integer.parseInt(array_lectureparams[i][2].trim());
            int number = Integer.parseInt(array_lectureparams[i][3].trim());
            String st_time = array_lectureparams[i][4].trim();
            String end_time = array_lectureparams[i][5].trim();
            String room = array_lectureparams[i][6].trim();
            int homework = Integer.parseInt(array_lectureparams[i][7].trim());
            int test = Integer.parseInt(array_lectureparams[i][8].trim());

            Log.i("Button", "name " + room);
            cv.put(LecturesEntry.COLUMN_LECTURE_NAME, name);
            cv.put(LecturesEntry.COLUMN_LECTURE_WEEK, week);
            cv.put(LecturesEntry.COLUMN_LECTURE_TYPE, type);
            cv.put(LecturesEntry.COLUMN__LECTURE_NUMBER, number);
            cv.put(LecturesEntry.COLUMN_LECTURE_START, st_time);
            cv.put(LecturesEntry.COLUMN_LECTURE_END, end_time);
            cv.put(LecturesEntry.COLUMN_LECTURE_ROOM, room);
            cv.put(LecturesEntry.COLUMN_LECTURE_HOMEWORK, homework);
            cv.put(LecturesEntry.COLUMN_LECTURE_TEST, test);

            mDatabase.insert(tablename, null, cv);
            cv.clear();
            mDatabase.close();

        }
        Log.i("Button", "table " + tablename);
        //mDatabase.insert(tablename, null, cv);


    }




}

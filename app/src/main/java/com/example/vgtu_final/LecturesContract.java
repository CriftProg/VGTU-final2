package com.example.vgtu_final;

import android.provider.BaseColumns;
import android.support.v7.app.AppCompatActivity;




public class LecturesContract extends AppCompatActivity {


    public static final String SQL_CREATE_LECTURE_MONDAYTABLE = createDailyTables(LecturesEntry.TABLE_NAME_MONDAY);
    public static final String SQL_CREATE_LECTURE_TUESDAYTABLE = createDailyTables(LecturesEntry.TABLE_NAME_TUESDAY);
    public static final String SQL_CREATE_LECTURE_WEDNESDAYTABLE = createDailyTables(LecturesEntry.TABLE_NAME_WEDNESDAY);
    public static final String SQL_CREATE_LECTURE_THURSDAYTABLE = createDailyTables(LecturesEntry.TABLE_NAME_THURSDAY);
    public static final String SQL_CREATE_LECTURE_FRIDAYTABLE= createDailyTables(LecturesEntry.TABLE_NAME_FRIDAY);



    private LecturesContract(){
    }

    public static final class LecturesEntry implements BaseColumns {
        public static final String TABLE_NAME_MONDAY = "mondayLectures";
        public static final String TABLE_NAME_TUESDAY = "tuesdayLectures";
        public static final String TABLE_NAME_WEDNESDAY = "wednesdayLectures";
        public static final String TABLE_NAME_THURSDAY = "thursdayLectures";
        public static final String TABLE_NAME_FRIDAY = "fridayLectures";

        public static final String TABLE_SUBJECT_LIST = "lectureList";



        public static final String COLUMN_LECTURE_NAME = "lecture_name";
        public static final String COLUMN__LECTURE_NUMBER = "lecture_number";
        public static final String COLUMN_LECTURE_WEEK = "lecture_week";
        public static final String COLUMN_LECTURE_ROOM = "lecture_room";
        public static final String COLUMN_LECTURE_START = "lecture_startTime";
        public static final String COLUMN_LECTURE_END = "lecture_endTime";
        public static final String COLUMN_LECTURE_TYPE = "lecture_type";
        public static final String COLUMN_LECTURE_HOMEWORK = "lecture_homework";
        public static final String COLUMN_LECTURE_TEST = "lecture_test";

        public static final String COLUMN_SUBJECT_NAME = "subject_name";
        public static final String COLUMN_SUBJECT_TEACHER = "subject_teacher";
        public static final String COLUMN_SUBJECT_DATE = "subject_date";
        public static final String COLUMN_SUBJECT_GROUP = "subject_group";
        public static final String COLUMN_SUBJECT_TEST = "subject_group";
        public static final String COLUMN_SUBJECT_HOMEWORK = "subject_homework";

        public static final String DATABASE_NAME = "lectureslist.db";




    }


    public static final String createDailyTables(String TABLE_NAME){
        return  "CREATE TABLE " +
                TABLE_NAME + " (" +
                LecturesEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                LecturesEntry.COLUMN_LECTURE_NAME + " TEXT NOT NULL, " +
                LecturesEntry.COLUMN_LECTURE_WEEK + " INTEGER , " +
                LecturesEntry.COLUMN_LECTURE_TYPE + " TEXT , " +
                LecturesEntry.COLUMN__LECTURE_NUMBER + " INTEGER , " +
                LecturesEntry.COLUMN_LECTURE_ROOM + " TEXT , " +
                LecturesEntry.COLUMN_LECTURE_START + " TEXT , " +
                LecturesEntry.COLUMN_LECTURE_END + " TEXT , " +
                LecturesEntry.COLUMN_LECTURE_HOMEWORK + " INTEGER , " +
                LecturesEntry.COLUMN_LECTURE_TEST + " INTEGER  " +
                ");";
    }




    final String SQL_CREATE_GROCERYLIST_TABLE = "CREATE TABLE " +
            LecturesEntry.TABLE_NAME_WEDNESDAY + " (" +
            LecturesEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
            LecturesEntry.COLUMN_LECTURE_NAME + " TEXT NOT NULL, " +
            LecturesEntry.COLUMN_LECTURE_WEEK + " INTEGER NOT NULL, " +
            LecturesEntry.COLUMN__LECTURE_NUMBER + "INTEGER NOT NULL" +
            LecturesEntry.COLUMN_LECTURE_ROOM + "TEXT NOT NULL" +
            LecturesEntry.COLUMN_LECTURE_START+ " TEXT NOT NULL" +
            LecturesEntry.COLUMN_LECTURE_END + " TEXT NOT NULL" +
            LecturesEntry.COLUMN_LECTURE_END + " TEXT NOT NULL" +
            LecturesEntry.COLUMN_LECTURE_HOMEWORK + " INTEGER" +
            LecturesEntry.COLUMN_LECTURE_TEST + " INTEGER" +
            ");";



}

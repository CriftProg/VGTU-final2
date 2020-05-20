package com.example.vgtu_final;

import android.provider.BaseColumns;
import android.support.v7.app.AppCompatActivity;




public class LecturesContract extends AppCompatActivity {


    public static final String SQL_CREATE_LECTURE_MONDAYTABLE = createDailyTables(LecturesEntry.TABLE_NAME_MONDAY);
    public static final String SQL_CREATE_LECTURE_TUESDAYTABLE = createDailyTables(LecturesEntry.TABLE_NAME_TUESDAY);
    public static final String SQL_CREATE_LECTURE_WEDNESDAYTABLE = createDailyTables(LecturesEntry.TABLE_NAME_WEDNESDAY);
    public static final String SQL_CREATE_LECTURE_THURSDAYTABLE = createDailyTables(LecturesEntry.TABLE_NAME_THURSDAY);
    public static final String SQL_CREATE_LECTURE_FRIDAYTABLE= createDailyTables(LecturesEntry.TABLE_NAME_FRIDAY);

    public static final String SQL_CREATE_SUBJECT_LIST = "CREATE TABLE " +
            LecturesEntry.TABLE_SUBJECT_LIST + " (" +
            LecturesEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
            LecturesEntry.COLUMN_SUBJECT_NAME + " TEXT NOT NULL , " +
            LecturesEntry.COLUMN_SUBJECT_TEACHER + " TEXT NOT  NULL , " +
            LecturesEntry.COLUMN_SUBJECT_DATE + " TEXT NOT NULL ," +
            LecturesEntry.COLUMN_SUBJECT_GROUP + " TEXT NOT NULL" + ");";

    public static final String SQL_CREATE_LOGIN_LIST = "CREATE TABLE " +
            LecturesEntry.TABLE_LOGIN_LIST + " (" +
            LecturesEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
            LecturesEntry.COLUMN_LOGIN_IDCODE + " TEXT NOT NULL , " +
            LecturesEntry.COLUMN_LOGIN_PASS + " TEXT NOT NULL , " +
            LecturesEntry.COLUMN_LOGIN_MAIL + " TEXT NOT NULL , " +
            LecturesEntry.COLUMN_LOGIN_NAME + " TEXT NOT NULL ," +
            LecturesEntry.COLUMN_LOGIN_SURNAME + " TEXT NOT NULL ," +
            LecturesEntry.COLUMN_LOGIN_STATUS + ");";

    public static final String SQL_CREATE_HOMEWORK_LIST = "CREATE TABLE " +
            LecturesEntry.TABLE_SUBJECT_HOMEWORK + " (" +
            LecturesEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
            LecturesEntry.COLUMN_HOMEWORK_SUBJECT + " TEXT NOT NULL, " +
            LecturesEntry.COLUMN_HOMEWORK_CONTENT + " TEXT NOT NULL, " +
            LecturesEntry.COLUMN_HOMEWORK_DEADLINE + "TEXT NOT NULL" +
             ");";

    public static final String SQL_CREATE_TEST_LIST = "CREATE TABLE " +
            LecturesEntry.TABLE_SUBJECT_TEST + " (" +
            LecturesEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
            LecturesEntry.COLUMN_TEST_SUBJECT + " TEXT NOT NULL, " +
            LecturesEntry.COLUMN_TEST_CONTENT + " TEXT NOT NULL, " +
            LecturesEntry.COLUMN_TEST_DEADLINE + " TEXT NOT NULL" +
            ");";


    public static final String SQL_CREATE_CALLER = "CREATE TABLE " +
            LecturesEntry.TABLE_CALLER + " (" +
            LecturesEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
            LecturesEntry.COLUMN_CALLER_CONTENT + " TEXT NOT NULL" +
            ");";

    private LecturesContract(){
    }

    public static final class LecturesEntry implements BaseColumns {
        public static final String TABLE_NAME_MONDAY = "mondayLectures";
        public static final String TABLE_NAME_TUESDAY = "tuesdayLectures";
        public static final String TABLE_NAME_WEDNESDAY = "wednesdayLectures";
        public static final String TABLE_NAME_THURSDAY = "thursdayLectures";
        public static final String TABLE_NAME_FRIDAY = "fridayLectures";

        public static final String TABLE_SUBJECT_LIST = "subjectList";
        public static final String TABLE_LOGIN_LIST = "loginData";
        public static final String TABLE_SUBJECT_HOMEWORK = "subjecthome";
        public static final String TABLE_SUBJECT_TEST = "subjectest";
        public static final String TABLE_CALLER = "caller";



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

        public static final String COLUMN_LOGIN_IDCODE = "login_idcode";
        public static final String COLUMN_LOGIN_PASS = "login_pass";
        public static final String COLUMN_LOGIN_MAIL = "login_mail";
        public static final String COLUMN_LOGIN_NAME = "login_name";
        public static final String COLUMN_LOGIN_SURNAME = "login_surname";
        public static final String COLUMN_LOGIN_STATUS = "login_status";

        public static final String COLUMN_HOMEWORK_SUBJECT = "homework_subject";
        public static final String COLUMN_HOMEWORK_CONTENT= "homework_contents";
        public static final String COLUMN_HOMEWORK_DEADLINE = "homework_deadline";

        public static final String COLUMN_TEST_SUBJECT = "test_subject";
        public static final String COLUMN_TEST_CONTENT= "test_contents";
        public static final String COLUMN_TEST_DEADLINE = "test_deadline";

        public static final String COLUMN_CALLER_CONTENT = "caller_content";




        public static final String DATABASE_NAME = "lectureslist.db";




    }


    public static final String createDailyTables(String TABLE_NAME){
        return  "CREATE TABLE " +
                TABLE_NAME + " (" +
                LecturesEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                LecturesEntry.COLUMN_LECTURE_NAME + " TEXT NOT NULL , " +
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

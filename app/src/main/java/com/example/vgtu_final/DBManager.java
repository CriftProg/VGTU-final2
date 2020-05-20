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
    private String subject_file = "lectures.txt";
    private String login_file = "account.txt";
    private String[] lecture_table_names = {LecturesEntry.TABLE_NAME_MONDAY, LecturesEntry.TABLE_NAME_TUESDAY,
            LecturesEntry.TABLE_NAME_WEDNESDAY, LecturesEntry.TABLE_NAME_THURSDAY, LecturesEntry.TABLE_NAME_FRIDAY};

    DBManager(Context context) {
        context.deleteDatabase(LecturesEntry.DATABASE_NAME);
        dbHelper = new LecturesDBHelper(context);
        mDatabase = dbHelper.getWritableDatabase();
        this.context = context;

        readFromFiles();


    }

    public void readFromFiles() {
        int array_size = 0;
        FileReader fr = new FileReader(context);
        String[][] array_lectureparams;

        for (int i = 0; i < lecture_files_to_read.length; i++) {
            //Log.i("Button","Loop st " + lecture_files_to_read[i]);
            array_lectureparams = fr.readfile_dayLectures(lecture_files_to_read[i]);

            fillDB_lectures(array_lectureparams, fr.array_size, mDatabase, lecture_table_names[i]);
        }

        array_lectureparams = fr.readfile_dayLectures(subject_file);
        fillDB_subjects(array_lectureparams,fr.array_size,mDatabase,LecturesEntry.TABLE_SUBJECT_LIST);

        array_lectureparams = fr.readfile_dayLectures(login_file);
        fillDB_login(array_lectureparams,fr.array_size,mDatabase,LecturesEntry.TABLE_LOGIN_LIST);



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

    public void fillDB_subjects(String[][] array_lectureparams, int array_length, SQLiteDatabase mDatabase, String tablename){
        if(array_lectureparams[0][1] == null){

            return;
        }

        for (int i = 0; i < array_length; i++) {
            //dbHelper.dropTables(mDatabase);
            mDatabase = dbHelper.getWritableDatabase();

            ContentValues cv = new ContentValues();

            Log.i("Button" , "XXXX" + array_length);
            String name = array_lectureparams[i][0].trim();
            String teacher = array_lectureparams[i][1].trim();
            String date = array_lectureparams[i][2].trim();
            String group = array_lectureparams[i][3].trim();


            cv.put(LecturesEntry.COLUMN_SUBJECT_NAME, name);
            cv.put(LecturesEntry.COLUMN_SUBJECT_TEACHER, teacher);
            cv.put(LecturesEntry.COLUMN_SUBJECT_DATE, date);
            cv.put(LecturesEntry.COLUMN_SUBJECT_GROUP, group);


            Log.i("Button" , "XXXXttable" + tablename);
            mDatabase.insert(tablename, null, cv);
            cv.clear();
            mDatabase.close();

        }



    }

    public void fillDB_login(String[][] array_lectureparams, int array_length, SQLiteDatabase mDatabase, String tablename){
        if(array_lectureparams[0][1] == null){
            return;
        }



        for (int i = 0; i < array_length; i++) {
            mDatabase = dbHelper.getWritableDatabase();
            //dbHelper.dropTables(mDatabase);
            //dbHelper.onCreate(mDatabase);

            ContentValues cv = new ContentValues();

            String idcode = array_lectureparams[i][0].trim();
            String pass = array_lectureparams[i][1].trim();
            String mail = array_lectureparams[i][2].trim();
            String name = array_lectureparams[i][3].trim();
            String surname = array_lectureparams[i][4].trim();
            String status = array_lectureparams[i][5].trim();


            cv.put(LecturesEntry.COLUMN_LOGIN_IDCODE, idcode);
            cv.put(LecturesEntry.COLUMN_LOGIN_PASS, pass);
            cv.put(LecturesEntry.COLUMN_LOGIN_MAIL, mail);
            cv.put(LecturesEntry.COLUMN_LOGIN_NAME, name);
            cv.put(LecturesEntry.COLUMN_LOGIN_SURNAME, surname);
            cv.put(LecturesEntry.COLUMN_LOGIN_STATUS, status);



            mDatabase.insert(tablename, null, cv);
            cv.clear();
            mDatabase.close();

        }


    }


    public void fillDB_homwork(String[] array,  String tablename){
        if(array[1] == null){
            return;
        }


            mDatabase = dbHelper.getWritableDatabase();
            ContentValues cv = new ContentValues();

            String subject = array[0].trim();
            String content = array[1];
            String deadline = array[2].trim();



            cv.put(LecturesEntry.COLUMN_HOMEWORK_SUBJECT, subject);
            cv.put(LecturesEntry.COLUMN_HOMEWORK_CONTENT, content);
            cv.put(LecturesEntry.COLUMN_HOMEWORK_DEADLINE, deadline);






            mDatabase.insert(tablename, null, cv);
            cv.clear();
            mDatabase.close();

        }


    public void fillDB_test(String[] array,String tablename){
        if(array[1] == null){
            return;
        }


        mDatabase = dbHelper.getWritableDatabase();
        ContentValues cv = new ContentValues();

        String subject = array[1].trim();
        String content = array[2];
        String deadline = array[3].trim();


        cv.put(LecturesEntry.COLUMN_TEST_SUBJECT, subject);
        cv.put(LecturesEntry.COLUMN_TEST_CONTENT, content);
        cv.put(LecturesEntry.COLUMN_TEST_DEADLINE, deadline);







        mDatabase.insert(tablename, null, cv);
        cv.clear();
        mDatabase.close();

    }


    public void fillDB_caller(String is, String tablename){
        if(is == null){
            return;
        }


        mDatabase = dbHelper.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(LecturesEntry.COLUMN_CALLER_CONTENT, is);


        mDatabase.insert(tablename, null, cv);
        cv.clear();
        mDatabase.close();
    }
}






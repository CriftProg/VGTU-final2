package com.example.vgtu_final;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

public class FileReader {



    private Context context;
    public int array_size;


    static Scanner scan;

    public FileReader(Context context ) {
        this.context = context;

    }
    // is = this.getResources().openRawResource(raw.mondaylecture);

    public String[][] readfile_dayLectures(String filename) {

        String text = "";
        String[] noblanks_text = new String[0];

        String[] array_lectures = new String[0];
        String[][] array_lectureparams = new String[10][10];

        int num = 0;
        int gg = 0;

        try {
            InputStream is = context.getAssets().open(filename);
            int size = is.available();
            byte[] lecture_name = new byte[size];
            is.read(lecture_name);

            is.close();
            text = new String(lecture_name);
            noblanks_text = text.split("/");
            array_lectures = noblanks_text[0].split(";");
            String[] temp;
            String[] noblanks_param;


            for (int i = 0; i < array_lectures.length; i++) {
                temp = array_lectures[i].split(",");

                //Log.i("Button", "Loop 1: " + array_lectures[i] + " ids " + i );
                //Log.i("Button", "Loop 1 noblank: " + noblanks_param[0] + " ids " + i );
                for (int j = 0; j < temp.length; j++) {
                    // Log.i("Button", "Loop 2: " + temp[j] + " ids " + j + " , " + i);
                    array_lectureparams[i][j] = temp[j];
                    //Log.i("Button", "Loop 2x: " + array_lectureparams[i][j] + " ids " + j + " , " + i);
                    gg = j;
                }
                num = i;

            }


        } catch (IOException ex) {
            ex.printStackTrace();
        }
        array_size = array_lectures.length;

        return array_lectureparams;
    }





    public static void fileExists(File myObj){
        if (myObj.exists()) {
            Log.i("Button","File name: " + myObj.getName());
            Log.i("Button","Absolute path: " + myObj.getAbsolutePath());
            Log.i("Button","Writeable: " + myObj.canWrite());
            Log.i("Button","Readable " + myObj.canRead());
            Log.i("Button","File size in bytes " + myObj.length());
        } else {
            Log.i("Button","The file does not exist.");
        }
    }
}

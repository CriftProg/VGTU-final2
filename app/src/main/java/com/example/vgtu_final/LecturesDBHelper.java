package com.example.vgtu_final;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.Nullable;


import com.example.vgtu_final.LecturesContract.LecturesEntry;

public class LecturesDBHelper extends SQLiteOpenHelper {

    public static final int DATABASE_VERSION = 1;


    public LecturesDBHelper(@Nullable Context context) {
        super(context, LecturesEntry.DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(LecturesContract.SQL_CREATE_LECTURE_MONDAYTABLE);
        db.execSQL(LecturesContract.SQL_CREATE_LECTURE_TUESDAYTABLE);
        db.execSQL(LecturesContract.SQL_CREATE_LECTURE_WEDNESDAYTABLE);
        db.execSQL(LecturesContract.SQL_CREATE_LECTURE_THURSDAYTABLE);
        db.execSQL(LecturesContract.SQL_CREATE_LECTURE_FRIDAYTABLE);
    }

    public void dropTables(SQLiteDatabase db){
        db.execSQL("DROP TABLE IF EXISTS " + LecturesContract.LecturesEntry.TABLE_NAME_MONDAY);
        db.execSQL("DROP TABLE IF EXISTS " + LecturesEntry.TABLE_NAME_TUESDAY);
        db.execSQL("DROP TABLE IF EXISTS " + LecturesEntry.TABLE_NAME_WEDNESDAY);
        db.execSQL("DROP TABLE IF EXISTS " + LecturesEntry.TABLE_NAME_THURSDAY);
        db.execSQL("DROP TABLE IF EXISTS " + LecturesEntry.TABLE_NAME_FRIDAY);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        dropTables(db);
        onCreate(db);
    }
}

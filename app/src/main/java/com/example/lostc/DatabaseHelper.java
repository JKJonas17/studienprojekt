package com.example.lostc;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DatabaseHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "Fragen.db";
    public static final String TABLE_NAME = "Fragen_Table";

    public static final String ID= "ID";
    public static final String COL_1 = "FRAGE";
    public static final String COL_2 = "A1";
    public static final String COL_3= "A2";
    public static final String COL_4 = "A3";
    public static final String COL_5 = "A4";
    public static final String COL_6 = "A_Nr";


    public DatabaseHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, 2);
        SQLiteDatabase db = this.getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("CREATE TABLE " + TABLE_NAME+ "(ID INTEGER PRIMARY KEY AUTOINCREMENT, FRAGE TEXT, A1 TEXT, A2 TEXT,A3 TEXT, A4 TEXT, A_Nr INTEGER)" );
        db.execSQL("INSERT INTO" + TABLE_NAME +);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);

    }



}

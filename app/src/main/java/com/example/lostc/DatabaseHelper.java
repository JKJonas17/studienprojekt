package com.example.lostc;

import android.annotation.SuppressLint;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.io.File;
import java.util.ArrayList;


public class DatabaseHelper extends SQLiteOpenHelper {


   public static final String DATABASE_NAME = "test.sqlite";
   //public static final String DBLOCATION = "/data/data/com.example.lostc/databases/";
   private Context context;

   private SQLiteDatabase db;


    public DatabaseHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, 1);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void openDatabase()
    {
        String dbPath = context.getDatabasePath(DATABASE_NAME).getPath();
        if(db != null && db.isOpen())
        {
            return;
        }
        db = SQLiteDatabase.openDatabase(dbPath,null,SQLiteDatabase.OPEN_READWRITE);
    }

    public void closeDatabase()
    {
        if(db!= null)
        {
            db.close();
        }
    }

    public ArrayList<Question> getQuestions(String kategorie)
    {

        Question q = null;
        ArrayList<Question> questionList = new ArrayList<>();
        openDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM FRAGEN WHERE KatNr = ?" ,new String[] {kategorie});
        cursor.moveToFirst();
        while(!cursor.isAfterLast())
        {
            q = new Question();
            q.setQuestion(cursor.getString(1));
            q.setOption1(cursor.getString(2));
            q.setOption2(cursor.getString(3));
            q.setOption3(cursor.getString(4));
            q.setOption4(cursor.getString(5));
            q.setAnswerNr(cursor.getString(6));
            q.setKategorieNr(cursor.getString(7));
            questionList.add(q);
            cursor.moveToNext();
        }
        cursor.close();
        closeDatabase();
        return questionList;

    }





}

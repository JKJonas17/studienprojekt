package com.example.lostc;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.ContactsContract;
import android.util.Log;

import androidx.annotation.Nullable;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;


public class DatabaseHelper extends SQLiteOpenHelper {


    public static final String DATABASE_NAME = "fragen.sqlite";
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

    public void openDatabase() {
        String dbPath = context.getDatabasePath(DATABASE_NAME).getPath();
        if (db != null && db.isOpen()) {
            return;
        }
        db = SQLiteDatabase.openDatabase(dbPath, null, SQLiteDatabase.OPEN_READWRITE);
    }

    public void closeDatabase() {
        if (db != null) {
            db.close();
        }
    }

    public ArrayList<Question> getQuestions(String kategorie) {
        Question q = null;
        ArrayList<Question> questionList = new ArrayList<>();
        openDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM FRAGEN WHERE KatNr = ?", new String[]{kategorie});
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            q = new Question();
            q.setId(cursor.getString(0));
            q.setQuestion(cursor.getString(1));
            q.setOption1(cursor.getString(2));
            q.setOption2(cursor.getString(3));
            q.setOption3(cursor.getString(4));
            q.setOption4(cursor.getString(5));
            q.setAnswerNr(cursor.getString(6));
            q.setKategorieNr(cursor.getString(7));
            q.setAnswered(cursor.getString(8));
            questionList.add(q);
            cursor.moveToNext();
        }
        cursor.close();
        closeDatabase();
        return questionList;

    }

    /**
     * Updatet die Spalte "Answered" in der Tabelle: Fragen
     *
     * @param id      Primary Key als Referenz in der Datenbank
     * @param correct aus Klasse Quiz zur Überprüfung ob
     */

    public void setAnswered(String id, boolean correct) {
        SQLiteDatabase db = this.getWritableDatabase();

        //ist die Antwort richtig wird der Wert in Answered auf 2 gesetzt die Frage kann somit nicht mehr bepunktet werden
        if (correct) {
            db.beginTransaction();
            try {
                ContentValues cv = new ContentValues();
                cv.put("Answered", "2");
                db.update("Fragen", cv, "ID = " + id, null);
                db.setTransactionSuccessful();
            } finally {
                db.endTransaction();
            }
            db.close();
        }
        // sonst: Answered wird auf 1 gesetzt kann beim nächsten durchlauf noch bepunktet werden.
        else {
            db.beginTransaction();
            try {
                ContentValues cv = new ContentValues();
                cv.put("Answered", "1");
                db.update("Fragen", cv, "ID = " + id, null);
                db.setTransactionSuccessful();
            } finally {
                db.endTransaction();
            }
            db.close();
        }
    }

    public double levelup(String kategorie) {

        openDatabase();
        Cursor cursor = db.rawQuery("SELECT COUNT(Answered) FROM Fragen WHERE Answered = ? AND KatNr = ?", new String[]{"2",kategorie});
        Cursor cursor1 = db.rawQuery("SELECT COUNT(Answered) FROM Fragen WHERE KatNr = ?", new String[]{kategorie});
        cursor.moveToFirst();
        cursor1.moveToFirst();
        int correctRows = cursor.getInt(0);
        int answeredRows = cursor.getInt(0);
        closeDatabase();
        cursor.close();
        cursor1.close();
        double avg = (correctRows / answeredRows);
        return avg;


    }


}

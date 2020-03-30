package com.example.lostc;

import android.content.Context;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "Fragen.db";
    private static final String TABLE_NAME = "Fragen_Table";

    private SQLiteDatabase db;



    public DatabaseHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, 1);
        SQLiteDatabase db = this.getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        this.db = db;

        db.execSQL("CREATE TABLE " + TABLE_NAME+ "(ID INTEGER PRIMARY KEY AUTOINCREMENT, FRAGE TEXT, A1 TEXT, A2 TEXT,A3 TEXT, A4 TEXT, A_Nr INTEGER,K_Nr INTEGER)" );
    }

    /**
     *Methode um Einträge in Fragen Tabelle zu erfassen
     *
     * @param Frage
     * @param A1
     * @param A2
     * @param A3
     * @param A4
     * @param A_Nr
     * @param kategorie
     */
    public void insertQuestion(String Frage,String A1,String A2,String A3,String A4,String A_Nr, String kategorie)
    {
        this.getWritableDatabase().execSQL("Insert Into " + TABLE_NAME + " (FRAGE,A1,A2,A3,A4,A_Nr,K_Nr) VALUES('"+Frage+"','"+A1+"','"+A2+"','"+A3+"','"+A4+"',"+A_Nr+","+kategorie+")");
    }

    /**
     * Auslesen der Fragen Tabelle unterschieden nach Kategorie

     * @throws Exception
     */
    public ArrayList<Question> getAllQuestions ()
    {
        ArrayList <Question> al = new ArrayList<>();

        try {
            Cursor c = this.getWritableDatabase().rawQuery("Select * From " + TABLE_NAME, null);

            while (c.moveToNext()) {
                Question q = new Question();
                q.setQuestion(c.getString(1));
                q.setOption1(c.getString(2));
                q.setOption2(c.getString(3));
                q.setOption3(c.getString(4));
                q.setOption4(c.getString(5));
                q.setAnswerNr(c.getString(6));

                al.add(q);
            }
            c.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return al;

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);

    }




}

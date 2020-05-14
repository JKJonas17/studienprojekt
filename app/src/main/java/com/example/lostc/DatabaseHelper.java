package com.example.lostc;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;


public class DatabaseHelper extends SQLiteOpenHelper {


    public static final String DATABASE_NAME = "fragen.sqlite";
    private Context context;

    private SQLiteDatabase db;


    public DatabaseHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, 1);
        this.context = context;
    }

    public SQLiteDatabase getDb()
    {
        return db;
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

    /**
     * Liest alle relevanten Fragen der übergebenen Kategorie ein und übergibt sie an einen Array
     *
     * @param kategorie Kategorie aus Seekarte
     * @return ql ArrayList mit Fragen für Quiz
     */

    public ArrayList<Question> getQuestions(String kategorie) {
        Question q;
        Cursor cursor;
        ArrayList<Question> questionList = new ArrayList<>();
        openDatabase();

        cursor = db.rawQuery("SELECT * FROM FRAGEN WHERE KatNr = ?", new String[]{kategorie});
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

    /**
     * Hat der Spieler mehr als 80% der Fragen beantwortet kann er ein Level-fortfahren
     * @param kategorie wird benötigt um alle Zeilen einer bestimmten Kategorie zu finden
     * @return avg double Wert der bestimmt ob ein Spieler genügend Fragen beantwortet hat um ein Level aufzusteigen
     */

    public double levelup(String kategorie) {

        double avg;
        openDatabase();

        Cursor cursor = db.rawQuery("SELECT COUNT(Answered) FROM Fragen WHERE Answered = ? AND KatNr = ?", new String[]{"2", kategorie});
        Cursor cursor1 = db.rawQuery("SELECT COUNT(Answered) FROM Fragen WHERE KatNr = ?", new String[]{kategorie});
        cursor.moveToFirst();
        cursor1.moveToFirst();
        int correctRows = cursor.getInt(0);     //Alle Zeilen die den Wert 2 für richtig beantwortert
        int answeredRows = cursor1.getInt(0);   // Wert aller Zeilen
        closeDatabase();
        cursor.close();
        cursor1.close();

        avg = ((double) correctRows / (double) answeredRows); // durschnitt der Entscheidet ob Spieler ein Level aufsteigt oder nicht
        return avg;
    }

    /**
     * Setzt bei allen Fragen den Wert der Spalte Answered auf den default-Wert 0 zurück um ein erneutes Scoren zu ermöglichen
     */
    public void resetAnswered() {
        SQLiteDatabase db = this.getWritableDatabase();
        db.beginTransaction();
        try {
            ContentValues cv = new ContentValues();
            cv.put("Answered", "0");
            db.update("Fragen", cv, "Answered = 1 OR Answered = 2", null);
            db.setTransactionSuccessful();
        } finally {
            db.endTransaction();
        }
        db.close();
    }

    /**
     * Gibt den Durschnittswert der richtig beantworteten Fragen
     * @return avg
     */
    public double getAvarage()
    {
        double avg;
        openDatabase();

        Cursor cursor = db.rawQuery("SELECT COUNT(Answered) FROM Fragen WHERE Answered = ?", new String[]{"2"});
        Cursor cursor1 = db.rawQuery("SELECT COUNT(Answered) FROM Fragen", null);
        cursor.moveToFirst();
        cursor1.moveToFirst();
        int correctRows = cursor.getInt(0);     //Alle Zeilen die den Wert 2 für richtig beantwortert
        int answeredRows = cursor1.getInt(0);   // Wert aller Zeilen
        closeDatabase();
        cursor.close();
        cursor1.close();

        avg = ((double) correctRows / (double) answeredRows); // durschnitt der Entscheidet ob Spieler ein Level aufsteigt oder nicht
        return avg;

    }

}

package com.example.lostc;

import com.example.lostc.QuizContract.*;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

public class DBHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME ="Database";
    private static final int DATABASE_VERSION = 1;

    private SQLiteDatabase db;


    public DBHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        SQLiteDatabase db = this.getWritableDatabase();
    }

    @Override
    // Wird nur beim ersten aufruf erstellt
    public void onCreate(SQLiteDatabase db) {
        this.db = db;

                db.execSQL("CREATE TABLE " +
                QuestionsTable.TABLE_NAME + "(" +
                QuestionsTable._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                QuestionsTable.COLUMN_QUESTION +" TEXT, " +
                QuestionsTable.COLUMN_OPTION1+ " TEXT, " +
                QuestionsTable.COLUMN_OPTION2+ " TEXT, " +
                QuestionsTable.COLUMN_OPTION3+" TEXT, " +
                QuestionsTable.COLUMN_OPTION4+ " TEXT, " +
                QuestionsTable.COLUMN_ANSWER_NR + " INTEGER" +")");

        fillQuestionsTable();

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " +QuestionsTable.TABLE_NAME);
        onCreate(db);

    }

    private void fillQuestionsTable(){
        Question q1 = new Question("A is correct","A","B","C","D", 1);
        addQuestion(q1);
        Question q2 = new Question("B is correct","A","B","C","D", 2);
        addQuestion(q2);
        Question q3 = new Question("C is correct","A","B","C","D", 3);
        addQuestion(q3);
        Question q4 = new Question("D is correct","A","B","C","D", 4);
        addQuestion(q4);
    }

    private void addQuestion(Question question)
    {
        ContentValues cv = new ContentValues();
        cv.put(QuestionsTable.COLUMN_QUESTION,question.getFrage());
        cv.put(QuestionsTable.COLUMN_OPTION1,question.getAntwort1());
        cv.put(QuestionsTable.COLUMN_OPTION2,question.getAntwort2());
        cv.put(QuestionsTable.COLUMN_OPTION3,question.getAntwort3());
        cv.put(QuestionsTable.COLUMN_OPTION4,question.getAntwort4());
        cv.put(QuestionsTable.COLUMN_ANSWER_NR,question.getAnswerNr());

        db.insert(QuestionsTable.TABLE_NAME, null, cv);
    }

    public List<Question> getAllQuestions(){
        List<Question> ql = new ArrayList<>();
        db= getReadableDatabase();
        Cursor c = db.rawQuery("SELECT * FROM " + QuestionsTable.TABLE_NAME, null);

        if(c.moveToFirst())
        {
            do{
                Question question = new Question();
                question.setFrage(c.getString(c.getColumnIndex(QuestionsTable.COLUMN_QUESTION)));
                question.setAntwort1(c.getString(c.getColumnIndex(QuestionsTable.COLUMN_OPTION1)));
                question.setAntwort2(c.getString(c.getColumnIndex(QuestionsTable.COLUMN_OPTION2)));
                question.setAntwort3(c.getString(c.getColumnIndex(QuestionsTable.COLUMN_OPTION3)));
                question.setAntwort4(c.getString(c.getColumnIndex(QuestionsTable.COLUMN_OPTION4)));
                question.setAnswerNr(c.getInt(c.getColumnIndex(QuestionsTable.COLUMN_ANSWER_NR)));

                ql.add(question);
            } while(c.moveToNext());
        }
        c.close();

        return ql;
    }
}

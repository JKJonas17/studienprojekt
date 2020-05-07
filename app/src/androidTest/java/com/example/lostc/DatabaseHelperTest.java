package com.example.lostc;

import android.content.Context;
import android.database.Cursor;

import androidx.test.platform.app.InstrumentationRegistry;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;


/**
 * Test für die Datenbank Helper Klasse
 */
public class DatabaseHelperTest {

    Context appContext = InstrumentationRegistry.getInstrumentation().getTargetContext();
    DatabaseHelper databaseHelper = new DatabaseHelper(appContext);

    @Test
    public void getQuestions()
    {
        assertThat(databaseHelper.getQuestions("1"),is(notNullValue()));
    }

    @Before
    public void SetUp()
    {
        databaseHelper.setAnswered("1",true);
        databaseHelper.setAnswered("2",true);
        databaseHelper.setAnswered("3",true);
        databaseHelper.setAnswered("4",true);
        databaseHelper.setAnswered("5",true);
        databaseHelper.setAnswered("6",true);
        databaseHelper.setAnswered("7",true);
        databaseHelper.setAnswered("8",true);
        databaseHelper.setAnswered("9",true);
        databaseHelper.setAnswered("10",true);
        databaseHelper.setAnswered("11",true);
        databaseHelper.setAnswered("12",true);
        databaseHelper.setAnswered("13",true);
        databaseHelper.setAnswered("14",true);

    }

    /**
     * Test der Methode setAnswered
     * Nachdem die Methode mit den Parametern id = 1 und correct = true aufgerufen wurde, soll der Wert in der Spalte answered in der Zeile id = 1, 2 betragen
     */
    @Test
    public void setAnswered() {
        databaseHelper.openDatabase();
        Cursor cursor;
        cursor = databaseHelper.getDb().rawQuery("Select answered from Fragen where id = ?",new String[] {"1"});
        cursor.moveToFirst();

        assertEquals("2",cursor.getString(0));
        cursor.close();
        databaseHelper.closeDatabase();
    }

    /**
     * Test für die Methode levelUp aus DatabaseHelper
     * der Durchschnittswert soll bei 1.0 liegen
     */
    @Test
    public void levelup() {
        double avg = databaseHelper.levelup("1");
        assertEquals(1.0,avg,0);
        assertFalse(avg <1.0);
    }

    /**
     * Test der Methoden resetAnswered und getAvarage, nach dem reset des Scores muss der Durchschnitt der richtigbeantwortetn Fragen bei 0 liegen
     */
    @Test
    public void resetAnswered_getAvarage() {
        databaseHelper.resetAnswered();
        assertEquals(0,databaseHelper.getAvarage(),0);
        assertFalse(databaseHelper.getAvarage()>0);
    }

}

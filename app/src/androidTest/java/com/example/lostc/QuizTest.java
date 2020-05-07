package com.example.lostc;

import android.content.Context;
import androidx.test.platform.app.InstrumentationRegistry;
import org.junit.Before;
import org.junit.Test;


import static org.junit.Assert.*;

/**
 * Testklasse für Elemente des Quizalgorithmus
 */
public class QuizTest {

    Context appContext = InstrumentationRegistry.getInstrumentation().getTargetContext();

    /**
     * Test ob Datenbank kopiert werden kann
     * @throws Exception
     */
  @Test
    public void copyDatabase() throws Exception{
       assertTrue(Quiz.copyDatabase(appContext));
    }

    @Before
    public void setArrayPosition() {
        Quiz.setArrayPosition(appContext,1,"1");
    }

    /**
     * Test ob Array Position korrekt übergeben und abgerufen wird
     */
    @Test
    public void getArrayPosition() {
      assertEquals(1,Quiz.getArrayPosition(appContext,"1"));
    }
}
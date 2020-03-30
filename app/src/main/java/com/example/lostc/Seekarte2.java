package com.example.lostc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

public class Seekarte2 extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seekarte2);

        ImageButton ib_Basics = findViewById(R.id.insel_Basics);
        ImageButton ib_Benutzerinteraktion = findViewById(R.id.insel_Ben);
        ImageButton ib_Variablen = findViewById(R.id.insel_Variablen);
        ImageButton ib_Verzweigung = findViewById(R.id.insel_Verzweigung);
        ImageButton ib_Schleifen = findViewById(R.id.insel_Schleifen);
        ImageButton ib_Arrays = findViewById(R.id.insel_Arrays);
        ImageButton ib_Funktionen = findViewById(R.id.insel_Funktionen);
        ImageButton ib_Zeiger = findViewById(R.id.insel_Zeiger);


        ib_Basics.setOnClickListener(this);
        ib_Benutzerinteraktion.setOnClickListener(this);
        ib_Variablen.setOnClickListener(this);
        ib_Verzweigung.setOnClickListener(this);
        ib_Schleifen.setOnClickListener(this);
        ib_Arrays.setOnClickListener(this);
        ib_Funktionen.setOnClickListener(this);
        ib_Zeiger.setOnClickListener(this);


        //hier muss eine Funktion zur Levelabfrage rein


        /** nur das Schiff des aktuellen Levels soll angezeigt werden **/

        //evtl. alle Schiffe auf invisible und mit Variable aktuelles Schiff freischalten
        ImageView iv_Schiff_Basics = findViewById(R.id.piratenSchiff_Basics);
        iv_Schiff_Basics.setVisibility(View.INVISIBLE);

    }

    /**
     * onClick Methode aus OnClickListener Interface
     * @param v
     **/

    @Override
    public void onClick(View v) {

        /**
         * Abfrage ob Richtiger Button geklickt wurde
         **/
        if(v.getId() == R.id.insel_Basics)
        {
            Toast.makeText(this,"Basics gedückt",Toast.LENGTH_SHORT).show();
             /**
             * öffnen der neuen Aktivität "Logbucheintrag_Basics"
             **/
            openQuiz(); // Value zum Identifizieren der Katogarie

        }
        if(v.getId() == R.id.insel_Variablen)
        {
            Toast.makeText(this,"Variablen gedückt",Toast.LENGTH_SHORT).show();
            openQuiz();
        }
        if(v.getId() == R.id.insel_Ben)
        {
            Toast.makeText(this,"Benutzerinteraktion gedückt",Toast.LENGTH_SHORT).show();
            openQuiz();
        }
        if(v.getId() == R.id.insel_Verzweigung)
        {
            Toast.makeText(this,"Verzweigung gedückt",Toast.LENGTH_SHORT).show();
            openQuiz();
        }
        if(v.getId() == R.id.insel_Schleifen)
        {
            Toast.makeText(this,"Schleifen gedückt",Toast.LENGTH_SHORT).show();
            openQuiz();
        }
        if(v.getId() == R.id.insel_Arrays)
        {
            Toast.makeText(this,"Arrays gedückt",Toast.LENGTH_SHORT).show();
            openQuiz();
        }
        if(v.getId() == R.id.insel_Funktionen)
        {
            Toast.makeText(this,"Funktionen gedückt",Toast.LENGTH_SHORT).show();
            openQuiz();
        }
        if(v.getId() == R.id.insel_Zeiger)
        {
            Toast.makeText(this,"Zeiger gedückt",Toast.LENGTH_SHORT).show();
            openQuiz();
        }

    }

    /**
     * Öffnet den neuen Intent
     */
    public void openQuiz()
    {
        Intent intent = new Intent(this, Quiz.class);
        startActivity(intent);
    }

}


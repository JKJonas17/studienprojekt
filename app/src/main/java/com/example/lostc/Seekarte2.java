package com.example.lostc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

public class Seekarte2 extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seekarte2);

        ImageButton basics = findViewById(R.id.insel_Basics);
        ImageButton ben = findViewById(R.id.insel_Ben);
        ImageButton variablen = findViewById(R.id.insel_Variablen);
        ImageButton verzweigung = findViewById(R.id.insel_Verzweigung);
        ImageButton schleifen = findViewById(R.id.insel_Schleifen);
        ImageButton arrays = findViewById(R.id.insel_Arrays);
        ImageButton funktionen = findViewById(R.id.insel_Funktionen);
        ImageButton zeiger = findViewById(R.id.insel_Zeiger);


        basics.setOnClickListener(this);
        ben.setOnClickListener(this);
        variablen.setOnClickListener(this);
        verzweigung.setOnClickListener(this);
        schleifen.setOnClickListener(this);
        arrays.setOnClickListener(this);
        funktionen.setOnClickListener(this);
        zeiger.setOnClickListener(this);

    }

    /**
     * onClick Methode aus OnClickListener Interface
     * @param v
     */

    @Override
    public void onClick(View v) {

        /**
         * Abfrage ob Richtiger Button geklickt wurde
         */
        if(v.getId() == R.id.insel_Basics)
        {
            Toast.makeText(this,"Basics gedückt",Toast.LENGTH_SHORT).show();
            /**
             * öffnen der neuen Aktivität "Logbucheintrag_Basics"
             */
            openQuiz();

        }
        if(v.getId() == R.id.insel_Variablen)
        {
            Toast.makeText(this,"Variablen gedückt",Toast.LENGTH_SHORT).show();
            /**
             * öffnen der neuen Aktivität "Logbucheintrag_Basics"
             */
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
     * Methode zum öffnen einer bestimmten Aktivität
     */
    public void openQuiz()
    {

        Intent intent = new Intent(this, Quiz.class);
        startActivity(intent);
    }

}


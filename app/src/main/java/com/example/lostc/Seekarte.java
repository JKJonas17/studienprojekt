package com.example.lostc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class Seekarte extends AppCompatActivity implements View.OnClickListener {

    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seekarte);

        ImageButton ib_Grundlagen = findViewById(R.id.ib_insel_grundlagen);
        ImageButton ib_Datentypen = findViewById(R.id.ib_insel_datentypen);
        ImageButton ib_Entscheidungen = findViewById(R.id.ib_insel_entscheidungen);
        ImageButton ib_Schleifen = findViewById(R.id.ib_insel_schleifen);
        ImageButton ib_Funktionen = findViewById(R.id.ib_insel_funktionen);
        ImageButton ib_Arrays = findViewById(R.id.ib_insel_arrays);
        ImageButton ib_Variablen = findViewById(R.id.ib_insel_variablen);
        ImageButton ib_Praeprozessor = findViewById(R.id.ib_insel_praeprozessor);
        ImageButton ib_BackSeekarte = findViewById(R.id.ib_backSeekarte);

        ib_Grundlagen.setOnClickListener(this);
        ib_Datentypen.setOnClickListener(this);
        ib_Entscheidungen.setOnClickListener(this);
        ib_Schleifen.setOnClickListener(this);
        ib_Funktionen.setOnClickListener(this);
        ib_Arrays.setOnClickListener(this);
        ib_Variablen.setOnClickListener(this);
        ib_Praeprozessor.setOnClickListener(this);
        ib_BackSeekarte.setOnClickListener(this);


        //hier muss eine Funktion zur Levelabfrage rein


        /**
         * nur das Schiff des aktuellen Levels soll angezeigt werden
         *
         * **/

        //evtl. alle Schiffe auf invisible und mit Variable aktuelles Schiff freischalten
        // ImageView iv_boot1 = findViewById(R.id.iv_boot1);
        //  iv_boot1.setVisibility(View.INVISIBLE);


    }

    /**
     * onClick Methode aus OnClickListener Interface
     *
     * @param v
     **/

    @Override
    public void onClick(View v) {

        /**
         * Abfrage ob Richtiger Button geklickt wurde
         **/
        if (v.getId() == R.id.ib_insel_grundlagen) {
            Toast.makeText(this, "Grundlagen gedückt", Toast.LENGTH_SHORT).show();
            /**
             * öffnen der neuen Aktivität "Logbucheintrag_Grundlagen"
             **/
            openLogbuch("1"); // Value zum Identifizieren der Katogarie

        }
        if (v.getId() == R.id.ib_insel_datentypen) {
            Toast.makeText(this, "Datentypen gedückt", Toast.LENGTH_SHORT).show();
            openLogbuch("2");
        }
        if (v.getId() == R.id.ib_insel_entscheidungen) {
            Toast.makeText(this, "Entscheidungen gedückt", Toast.LENGTH_SHORT).show();
            openLogbuch("3");
        }
        if (v.getId() == R.id.ib_insel_schleifen) {
            Toast.makeText(this, "Schleifen gedückt", Toast.LENGTH_SHORT).show();
            openLogbuch("4");
        }
        if (v.getId() == R.id.ib_insel_funktionen) {
            Toast.makeText(this, "Funktionen gedückt", Toast.LENGTH_SHORT).show();
            openLogbuch("5");
        }
        if (v.getId() == R.id.ib_insel_arrays) {
            Toast.makeText(this, "Arrays gedückt", Toast.LENGTH_SHORT).show();
            openLogbuch("6");
        }
        if (v.getId() == R.id.ib_insel_variablen) {
            Toast.makeText(this, "Variablen gedückt", Toast.LENGTH_SHORT).show();
            openLogbuch("7");
        }
        if (v.getId() == R.id.ib_insel_praeprozessor) {
            Toast.makeText(this, "Präprozessor gedückt", Toast.LENGTH_SHORT).show();
            openLogbuch("8");
        }

            if (v.getId() == R.id.ib_backSeekarte) {
                Toast.makeText(this, "Back gedrückt", Toast.LENGTH_SHORT).show();
                openMainMenue();

            }

    }

        /**
         * Öffnet den neuen Intent
         */
        private void openLogbuch (String kategorie){
            intent = new Intent(this, Logbuch.class);
            intent.putExtra("Kategorie", kategorie);
            startActivity(intent);
            this.finish();
        }

        /**
         * wenn man wieder ins Main-Menue zurück möchte
         */
        private void openMainMenue () {
            intent = new Intent(this, Main_menue.class);
            startActivity(intent);
            this.finish();
        }


}


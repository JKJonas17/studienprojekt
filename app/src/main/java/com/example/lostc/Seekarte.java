package com.example.lostc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import static com.example.lostc.R.drawable.insel3;
import static com.example.lostc.R.drawable.insel4;
import static com.example.lostc.R.drawable.insel_boot_links1;
import static com.example.lostc.R.drawable.insel_boot_rechts1;
import static com.example.lostc.R.drawable.inselgrau_links;
import static com.example.lostc.R.drawable.inselgrau_rechts;

public class Seekarte extends AppCompatActivity implements View.OnClickListener,HideNavigationBar {

    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seekarte);
        hideNavigationBar();

        ImageButton ib_Grundlagen = findViewById(R.id.ib_insel_grundlagen);
        ImageButton ib_Datentypen = findViewById(R.id.ib_insel_datentypen);
        ImageButton ib_Entscheidungen = findViewById(R.id.ib_insel_entscheidungen);
        ImageButton ib_Schleifen = findViewById(R.id.ib_insel_schleifen);
        ImageButton ib_Funktionen = findViewById(R.id.ib_insel_funktionen);
        ImageButton ib_Arrays = findViewById(R.id.ib_insel_arrays);
        ImageButton ib_Variablen = findViewById(R.id.ib_insel_variablen);
        ImageButton ib_Praeprozessor = findViewById(R.id.ib_insel_praeprozessor);
        ImageButton ib_Pointer = findViewById(R.id.ib_insel_pointer);
        ImageButton ib_Dateizugriff = findViewById(R.id.ib_insel_dateizugriff);
        ImageButton ib_BackSeekarte = findViewById(R.id.ib_backSeekarte);

        ib_Datentypen.setImageResource(inselgrau_links);
        ib_Entscheidungen.setImageResource(inselgrau_rechts);
        ib_Schleifen.setImageResource(inselgrau_links);
        ib_Funktionen.setImageResource(inselgrau_rechts);
        ib_Arrays.setImageResource(inselgrau_links);
        ib_Variablen.setImageResource(inselgrau_rechts);
        ib_Praeprozessor.setImageResource(inselgrau_links);
        ib_Pointer.setImageResource(inselgrau_rechts);
        ib_Dateizugriff.setImageResource(inselgrau_links);

        ib_Grundlagen.setOnClickListener(this);
        ib_BackSeekarte.setOnClickListener(this);


        int level;
        level = User.retriveLevel(this);//müssen wir per shared preferenc speichern und abrufen
        //bei gewonnen um 1s erhöhen

        switch(level){
            case(1):
                ib_Grundlagen.setOnClickListener(this);
                 //alle weg bis auf level 1

                break;
            case(2):

                ib_Grundlagen.setOnClickListener(this);
                ib_Datentypen.setOnClickListener(this);

                ib_Grundlagen.setImageResource(insel3);
                ib_Datentypen.setImageResource(insel_boot_rechts1);

            break;
            case(3):
                ib_Grundlagen.setOnClickListener(this);
                ib_Datentypen.setOnClickListener(this);
                ib_Entscheidungen.setOnClickListener(this);

                ib_Grundlagen.setImageResource(insel3);
                ib_Datentypen.setImageResource(insel4);
                ib_Entscheidungen.setImageResource(insel_boot_links1);

                break;
            case(4):
                ib_Grundlagen.setOnClickListener(this);
                ib_Datentypen.setOnClickListener(this);
                ib_Entscheidungen.setOnClickListener(this);
                ib_Schleifen.setOnClickListener(this);


                ib_Grundlagen.setImageResource(insel3);
                ib_Datentypen.setImageResource(insel4);
                ib_Entscheidungen.setImageResource(insel3);
                ib_Schleifen.setImageResource(insel_boot_rechts1);

                break;
            case(5):
                ib_Grundlagen.setOnClickListener(this);
                ib_Datentypen.setOnClickListener(this);
                ib_Entscheidungen.setOnClickListener(this);
                ib_Schleifen.setOnClickListener(this);
                ib_Funktionen.setOnClickListener(this);

                ib_Grundlagen.setImageResource(insel3);
                ib_Datentypen.setImageResource(insel4);
                ib_Entscheidungen.setImageResource(insel3);
                ib_Schleifen.setImageResource(insel4);
                ib_Funktionen.setImageResource(insel_boot_links1);

                break;
            case(6):
                ib_Grundlagen.setOnClickListener(this);
                ib_Datentypen.setOnClickListener(this);
                ib_Entscheidungen.setOnClickListener(this);
                ib_Schleifen.setOnClickListener(this);
                ib_Funktionen.setOnClickListener(this);
                ib_Arrays.setOnClickListener(this);

                ib_Grundlagen.setImageResource(insel3);
                ib_Datentypen.setImageResource(insel4);
                ib_Entscheidungen.setImageResource(insel3);
                ib_Schleifen.setImageResource(insel4);
                ib_Funktionen.setImageResource(insel3);
                ib_Arrays.setImageResource(insel_boot_rechts1);

                break;
            case(7):
                ib_Grundlagen.setOnClickListener(this);
                ib_Datentypen.setOnClickListener(this);
                ib_Entscheidungen.setOnClickListener(this);
                ib_Schleifen.setOnClickListener(this);
                ib_Funktionen.setOnClickListener(this);
                ib_Arrays.setOnClickListener(this);
                ib_Variablen.setOnClickListener(this);

                ib_Grundlagen.setImageResource(insel3);
                ib_Datentypen.setImageResource(insel4);
                ib_Entscheidungen.setImageResource(insel3);
                ib_Schleifen.setImageResource(insel4);
                ib_Funktionen.setImageResource(insel3);
                ib_Arrays.setImageResource(insel4);
                ib_Variablen.setImageResource(insel_boot_links1);

                break;
            case(8):
                ib_Grundlagen.setOnClickListener(this);
                ib_Datentypen.setOnClickListener(this);
                ib_Entscheidungen.setOnClickListener(this);
                ib_Schleifen.setOnClickListener(this);
                ib_Funktionen.setOnClickListener(this);
                ib_Arrays.setOnClickListener(this);
                ib_Variablen.setOnClickListener(this);
                ib_Praeprozessor.setOnClickListener(this);

                ib_Grundlagen.setImageResource(insel3);
                ib_Datentypen.setImageResource(insel4);
                ib_Entscheidungen.setImageResource(insel3);
                ib_Schleifen.setImageResource(insel4);
                ib_Funktionen.setImageResource(insel3);
                ib_Arrays.setImageResource(insel4);
                ib_Variablen.setImageResource(insel3);
                ib_Praeprozessor.setImageResource(insel_boot_rechts1);

                break;
            case(9):
                ib_Grundlagen.setOnClickListener(this);
                ib_Datentypen.setOnClickListener(this);
                ib_Entscheidungen.setOnClickListener(this);
                ib_Schleifen.setOnClickListener(this);
                ib_Funktionen.setOnClickListener(this);
                ib_Arrays.setOnClickListener(this);
                ib_Variablen.setOnClickListener(this);
                ib_Praeprozessor.setOnClickListener(this);
                ib_Pointer.setOnClickListener(this);

                ib_Grundlagen.setImageResource(insel3);
                ib_Datentypen.setImageResource(insel4);
                ib_Entscheidungen.setImageResource(insel3);
                ib_Schleifen.setImageResource(insel4);
                ib_Funktionen.setImageResource(insel3);
                ib_Arrays.setImageResource(insel4);
                ib_Variablen.setImageResource(insel3);
                ib_Praeprozessor.setImageResource(insel4);
                ib_Pointer.setImageResource(insel_boot_links1);

                break;
            case(10):
                ib_Grundlagen.setOnClickListener(this);
                ib_Datentypen.setOnClickListener(this);
                ib_Entscheidungen.setOnClickListener(this);
                ib_Schleifen.setOnClickListener(this);
                ib_Funktionen.setOnClickListener(this);
                ib_Arrays.setOnClickListener(this);
                ib_Variablen.setOnClickListener(this);
                ib_Praeprozessor.setOnClickListener(this);
                ib_Pointer.setOnClickListener(this);
                ib_Dateizugriff.setOnClickListener(this);

                ib_Grundlagen.setImageResource(insel3);
                ib_Datentypen.setImageResource(insel4);
                ib_Entscheidungen.setImageResource(insel3);
                ib_Schleifen.setImageResource(insel4);
                ib_Funktionen.setImageResource(insel3);
                ib_Arrays.setImageResource(insel4);
                ib_Variablen.setImageResource(insel3);
                ib_Praeprozessor.setImageResource(insel4);
                ib_Pointer.setImageResource(insel3);
                ib_Dateizugriff.setImageResource(insel_boot_rechts1);


                break;
            default:
        }




    }

    /**
     * onClick Methode aus OnClickListener Interface
     *
     * @param v
     **/

    @Override
    public void onClick(View v) {

        /*
         * Abfrage ob Richtiger Button geklickt wurde
         */
        if (v.getId() == R.id.ib_insel_grundlagen) {
            /*
             * öffnen der neuen Aktivität "Logbucheintrag_Grundlagen"
             */
            openLogbuch("1"); // Value zum Identifizieren der Katogarie

        }
        if (v.getId() == R.id.ib_insel_datentypen) {
            openLogbuch("2");
        }
        if (v.getId() == R.id.ib_insel_entscheidungen) {
            openLogbuch("3");
        }
        if (v.getId() == R.id.ib_insel_schleifen) {
            openLogbuch("4");
        }
        if (v.getId() == R.id.ib_insel_funktionen) {
            openLogbuch("5");
        }
        if (v.getId() == R.id.ib_insel_arrays) {
            openLogbuch("6");
        }
        if (v.getId() == R.id.ib_insel_variablen) {
            openLogbuch("7");
        }
        if (v.getId() == R.id.ib_insel_praeprozessor) {
            openLogbuch("8");
        }
        if (v.getId() == R.id.ib_insel_pointer) {
            openLogbuch("9");
        }
        if (v.getId() == R.id.ib_insel_dateizugriff) {
            openLogbuch("10");
        }

            if (v.getId() == R.id.ib_backSeekarte) {
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


    @Override
    protected void onResume() {
        super.onResume();
        hideNavigationBar();
    }

    @Override
    public void hideNavigationBar() {
        this.getWindow().getDecorView().setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_FULLSCREEN|
                        View.SYSTEM_UI_FLAG_HIDE_NAVIGATION |
                        View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY |
                        View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN |
                        View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION|
                        View.SYSTEM_UI_FLAG_LAYOUT_STABLE
        );
    }
}


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

        ImageView iv_boot1 = findViewById(R.id.iv_boot1);
        ImageView iv_boot2 = findViewById(R.id.iv_boot2);
        ImageView iv_boot3 = findViewById(R.id.iv_boot3);
        ImageView iv_boot4 = findViewById(R.id.iv_boot4);
        ImageView iv_boot5 = findViewById(R.id.iv_boot5);
        ImageView iv_boot6 = findViewById(R.id.iv_boot6);
        ImageView iv_boot7 = findViewById(R.id.iv_boot7);
        ImageView iv_boot8 = findViewById(R.id.iv_boot8);

        ImageButton ib_Datentypen_grau = findViewById(R.id.ib_insel_datentypen_grau);
        ImageButton ib_Entscheidungen_grau = findViewById(R.id.ib_insel_entscheidungen_grau);
        ImageButton ib_Schleifen_grau = findViewById(R.id.ib_insel_schleifen_grau);
        ImageButton ib_Funktionen_grau = findViewById(R.id.ib_insel_funktionen_grau);
        ImageButton ib_Arrays_grau = findViewById(R.id.ib_insel_arrays_grau);
        ImageButton ib_Variablen_grau = findViewById(R.id.ib_insel_variablen_grau);
        ImageButton ib_Praeprozessor_grau = findViewById(R.id.ib_insel_praeprozessor_grau);


        ib_Grundlagen.setOnClickListener(this);
        ib_Datentypen.setOnClickListener(this);
        ib_Entscheidungen.setOnClickListener(this);
        ib_Schleifen.setOnClickListener(this);
        ib_Funktionen.setOnClickListener(this);
        ib_Arrays.setOnClickListener(this);
        ib_Variablen.setOnClickListener(this);
        ib_Praeprozessor.setOnClickListener(this);
        ib_BackSeekarte.setOnClickListener(this);

        ib_Datentypen_grau.setVisibility(View.GONE);
        ib_Entscheidungen_grau.setVisibility(View.GONE);
        ib_Schleifen_grau.setVisibility(View.GONE);
        ib_Funktionen_grau.setVisibility(View.GONE);
        ib_Arrays_grau.setVisibility(View.GONE);
        ib_Variablen_grau.setVisibility(View.GONE);
        ib_Praeprozessor_grau.setVisibility(View.GONE);

        //Level abfrage durch if

        int level;
        level = User.retriveLevel(this);//müssen wir per shared preferenc speichern und abrufen
        //bei gewonnen um 1s erhöhen
/*
        switch(level){
            case(1):
                //alle weg bis auf level 1
                iv_boot2.setVisibility(View.GONE);
                iv_boot3.setVisibility(View.GONE);
                iv_boot4.setVisibility(View.GONE);
                iv_boot5.setVisibility(View.GONE);
                iv_boot6.setVisibility(View.GONE);
                iv_boot7.setVisibility(View.GONE);
                iv_boot8.setVisibility(View.GONE);
                break;
            case(2):
                ib_Datentypen_grau.setVisibility(View.GONE);
                //alle weg bis auf level 2
                iv_boot1.setVisibility(View.GONE);

                iv_boot3.setVisibility(View.GONE);
                iv_boot4.setVisibility(View.GONE);
                iv_boot5.setVisibility(View.GONE);
                iv_boot6.setVisibility(View.GONE);
                iv_boot7.setVisibility(View.GONE);
                iv_boot8.setVisibility(View.GONE);
            break;
            case(3):
                ib_Entscheidungen_grau.setVisibility(View.GONE);
                iv_boot1.setVisibility(View.GONE);
                iv_boot2.setVisibility(View.GONE);

                iv_boot4.setVisibility(View.GONE);
                iv_boot5.setVisibility(View.GONE);
                iv_boot6.setVisibility(View.GONE);
                iv_boot7.setVisibility(View.GONE);
                iv_boot8.setVisibility(View.GONE);
                break;
            case(4):
                ib_Schleifen_grau.setVisibility(View.GONE);
                iv_boot1.setVisibility(View.GONE);
                iv_boot2.setVisibility(View.GONE);
                iv_boot3.setVisibility(View.GONE);

                iv_boot5.setVisibility(View.GONE);
                iv_boot6.setVisibility(View.GONE);
                iv_boot7.setVisibility(View.GONE);
                iv_boot8.setVisibility(View.GONE);
                break;
            case(5):
                ib_Funktionen_grau.setVisibility(View.GONE);
                iv_boot1.setVisibility(View.GONE);
                iv_boot2.setVisibility(View.GONE);
                iv_boot3.setVisibility(View.GONE);
                iv_boot4.setVisibility(View.GONE);

                iv_boot6.setVisibility(View.GONE);
                iv_boot7.setVisibility(View.GONE);
                iv_boot8.setVisibility(View.GONE);
                break;
            case(6):
                ib_Arrays_grau.setVisibility(View.GONE);
                iv_boot1.setVisibility(View.GONE);
                iv_boot2.setVisibility(View.GONE);
                iv_boot3.setVisibility(View.GONE);
                iv_boot4.setVisibility(View.GONE);
                iv_boot5.setVisibility(View.GONE);

                iv_boot7.setVisibility(View.GONE);
                iv_boot8.setVisibility(View.GONE);
                break;
            case(7):
                ib_Variablen_grau.setVisibility(View.GONE);
                iv_boot1.setVisibility(View.GONE);
                iv_boot2.setVisibility(View.GONE);
                iv_boot3.setVisibility(View.GONE);
                iv_boot4.setVisibility(View.GONE);
                iv_boot5.setVisibility(View.GONE);
                iv_boot6.setVisibility(View.GONE);

                iv_boot8.setVisibility(View.GONE);
                break;
            case(8):
                ib_Praeprozessor_grau.setVisibility(View.GONE);
                iv_boot1.setVisibility(View.GONE);
                iv_boot2.setVisibility(View.GONE);
                iv_boot3.setVisibility(View.GONE);
                iv_boot4.setVisibility(View.GONE);
                iv_boot5.setVisibility(View.GONE);
                iv_boot6.setVisibility(View.GONE);
                iv_boot7.setVisibility(View.GONE);

                break;
            default:
        }

*/

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
         **/
        if (v.getId() == R.id.ib_insel_grundlagen) {
            Toast.makeText(this, "Grundlagen gedückt", Toast.LENGTH_SHORT).show();
            /*
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


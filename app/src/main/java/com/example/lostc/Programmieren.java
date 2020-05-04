package com.example.lostc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

public class Programmieren extends AppCompatActivity implements View.OnClickListener {

    private String kategorie;

    String basePath = "file:///android_asset/Aufgaben/";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_programmieren);


        TextView tv_ProgrammierAufgabe = findViewById(R.id.tv_ProgrammierAufgabe);
        ImageButton ib_BackProgrammieren = findViewById(R.id.ib_backprogrammieren);
        Button bt_loesung = findViewById(R.id.bt_loesung);

        Bundle bundle = getIntent().getExtras();
        kategorie = bundle.getString("Kategorie");

        WebView webView = findViewById(R.id.wv_Aufgaben);
        webView.setBackgroundColor(0);

        ib_BackProgrammieren.setOnClickListener(this);
        bt_loesung.setOnClickListener(this);

        if (kategorie.equals("1")) {
            tv_ProgrammierAufgabe.setText("Grundlagen");
            webView.loadUrl(basePath + "aufgabegrundlagen.html");
        }
        if(kategorie.equals("2"))
        {
            tv_ProgrammierAufgabe.setText("Datentypen");
            webView.loadUrl(basePath+ "aufgabedatentypen.html");
        }
        if(kategorie.equals("3"))
        {
            tv_ProgrammierAufgabe.setText("Entscheidungen");
            webView.loadUrl(basePath+ "aufgabeentscheidungen.html");
        }
        if(kategorie.equals("4"))
        {
            tv_ProgrammierAufgabe.setText("Schleifen");
            webView.loadUrl(basePath+ "aufgabeschleifen.html");
        }
        if(kategorie.equals("5"))
        {
            tv_ProgrammierAufgabe.setText("Funktionen");
            webView.loadUrl(basePath+ "aufgabefunktionen.html");
        }
        if(kategorie.equals("6"))
        {
            tv_ProgrammierAufgabe.setText("Arrays");
            webView.loadUrl(basePath+ "aufgabearrays.html");
        }
        if(kategorie.equals("7"))
        {
            tv_ProgrammierAufgabe.setText("Variablen");
            webView.loadUrl(basePath+ "aufgabevariablen.html");
        }
        if(kategorie.equals("8"))
        {
            tv_ProgrammierAufgabe.setText("Präprozessor");
            webView.loadUrl(basePath+ "aufgabepräprozessoren.html");
        }
    }

    @Override
    public void onClick(View v) {

        if (v.getId() == R.id.ib_backprogrammieren) {
            openLogbuch(kategorie);
        }
        if (v.getId() == R.id.bt_loesung) {
            openLoesung(kategorie);
        }

    }

    private void openLogbuch(String kategorie) {

        Intent intent = new Intent(this, Logbuch.class);
        intent.putExtra("Kategorie", kategorie);
        startActivity(intent);

    }

    private void openLoesung(String kategorie) {

        Intent intent = new Intent(this, Loesung.class);
        intent.putExtra("Kategorie", kategorie);
        startActivity(intent);

    }


}




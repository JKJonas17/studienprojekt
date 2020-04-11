package com.example.lostc;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Logbuch extends AppCompatActivity implements View.OnClickListener {


    private TextView tv_Kapitel;
    private String kategorie;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logbuch);

        tv_Kapitel = findViewById(R.id.tv_Kapitel);
        Button bt_Bordbuch = findViewById(R.id.bt_Bordbuch);
        Button bt_Abfrage = findViewById(R.id.bt_Abfrage);

        bt_Bordbuch.setOnClickListener(this);
        bt_Abfrage.setOnClickListener(this);

        Bundle bundle = getIntent().getExtras();
        kategorie = bundle.getString("Kategorie");


        /**
         * von der gedrückten Kategorie wird der entsprechende Text in die XML Datei geschrieben
         */
        if(kategorie.equals("1")) //Kapitel müssen noch erweitert werden, Seekarte ebenfalls erweitern Kapitel 9-12
        {
            tv_Kapitel.setText("Grundlagen");
        }
        if(kategorie.equals("2"))
        {
            tv_Kapitel.setText("Datentypen");
        }
        if(kategorie.equals("3"))
        {
            tv_Kapitel.setText("Entscheidungen");
        }
        if(kategorie.equals("4"))
        {
            tv_Kapitel.setText("Schleifen");
        }
        if(kategorie.equals("5"))
        {
            tv_Kapitel.setText("Funktionen");
        }
        if(kategorie.equals("6"))
        {
            tv_Kapitel.setText("Arrays");
        }
        if(kategorie.equals("7"))
        {
            tv_Kapitel.setText("Variablen");
        }
        if(kategorie.equals("8"))
        {
            tv_Kapitel.setText("Präprozessor");
        }
    }


    @Override
    public void onClick(View v) {

        if(v.getId() == R.id.bt_Bordbuch) {
            openBordbuch (kategorie);
        }
        if(v.getId() == R.id.bt_Abfrage) {
            openQuiz(kategorie);
        }

    }

    public void openBordbuch (String kategorie) {
        Intent intent = new Intent (this, Bordbuch.class);
        intent.putExtra("Kategorie", kategorie);
        startActivity(intent);
    }

    public void openQuiz(String kategorie)
    {
        Intent intent = new Intent(this, Quiz.class);
        intent.putExtra("Kategorie",kategorie);
        startActivity(intent);

    }
}

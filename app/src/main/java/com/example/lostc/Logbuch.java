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
        Button bt_Abfrage = findViewById(R.id.bt_Abfrage);

        bt_Abfrage.setOnClickListener(this);


        Bundle bundle = getIntent().getExtras();
        kategorie = bundle.getString("Kategorie");


        /**
         * von der gedrückten Kategorie wird der entsprechende Text in die XML Datei geschrieben
         */
        if(kategorie.equals("1"))
        {
            tv_Kapitel.setText("Grundlagen");
        }
        if(kategorie.equals("2"))
        {
            tv_Kapitel.setText("TBD1");
        }
        if(kategorie.equals("3"))
        {
            tv_Kapitel.setText("TBD2");
        }
        if(kategorie.equals("4"))
        {
            tv_Kapitel.setText("TBD3");
        }
        if(kategorie.equals("5"))
        {
            tv_Kapitel.setText("TBD4");
        }
        if(kategorie.equals("6"))
        {
            tv_Kapitel.setText("TBD5");
        }
        if(kategorie.equals("7"))
        {
            tv_Kapitel.setText("TBD6");
        }
        if(kategorie.equals("8"))
        {
            tv_Kapitel.setText("TBD7");
        }
    }


    @Override
    public void onClick(View v) {

        if(v.getId() == R.id.bt_Abfrage)
        {
            openQuiz(kategorie);
        }

    }

    public void openQuiz(String kategorie)
    {
        Intent intent = new Intent(this, Quiz.class);
        intent.putExtra("Kategorie1",kategorie);
        startActivity(intent);

    }
}

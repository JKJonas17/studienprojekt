package com.example.lostc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Einstellungen extends AppCompatActivity implements View.OnClickListener{

    Button bt_kaptn_kontaktieren, bt_crew;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_einstellungen);

        //Den hier erstellten Variablen werden die Button aus dem layout activity_main_menue zugeordnet
        bt_kaptn_kontaktieren = findViewById(R.id.bt_katain_kontaktieren);
        bt_crew = findViewById(R.id.bt_crew);

        //OnClickListener für jeden Button
        bt_kaptn_kontaktieren.setOnClickListener(this);
        bt_crew.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        //In der onClick Methode, welche hier noch für alle Objekt gilt, wird via Switch_Case Anweisung entschieden, was bei welchen Button geschehen soll
        if(v.getId() == R.id.bt_katain_kontaktieren)
        {
            openKaptnKontaktieren();
        }
        if(v.getId() == R.id.bt_crew)
        {
            openCrew();
        }
    }

    public void openKaptnKontaktieren()
    {
        Intent intent = new Intent(this, Team_kontaktieren.class);
        startActivity(intent);
        this.finish();

    }

    public void openCrew()
    {
        Intent intent = new Intent(this, Crew.class);
        startActivity(intent);
        this.finish();
    }
}

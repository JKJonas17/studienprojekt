package com.example.lostc;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.app.Application;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Main_menue extends AppCompatActivity implements View.OnClickListener {

    Button bt_leinen_los, bt_statistik, bt_einstellungen, bt_beenden;
    TextView tv_willkommen;
    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menue);

        //Den hier erstellten Variablen werden die Button aus dem layout activity_main_menue zugeordnet
        bt_leinen_los = findViewById(R.id.bt_leinen_los);
        bt_statistik = findViewById(R.id.bt_statistik);
        bt_einstellungen = findViewById(R.id.bt_einstellungen);
        bt_beenden = findViewById(R.id.bt_beenden);

        tv_willkommen = findViewById(R.id.tv_willkommen);

        //OnClickListener für jeden Button
        bt_leinen_los.setOnClickListener(this);
        bt_statistik.setOnClickListener(this);
        bt_einstellungen.setOnClickListener(this);
        bt_beenden.setOnClickListener(this);


        tv_willkommen.setText("Willkommen " + User.retriveUsername(this) + "!!");
    }

    @Override
    public void onClick(View v){
        //In der onClick Methode, welche hier noch für alle Objekt gilt, wird via Switch_Case Anweisung entschieden, was bei welchen Button geschehen soll
        if(v.getId() == R.id.bt_leinen_los) {
            openSeekarte();
        }
        if(v.getId() == R.id.bt_statistik) {
            openStatistik();
        }
        if(v.getId() == R.id.bt_einstellungen) {
            openEinstellungen();
        }
        if(v.getId() == R.id.bt_beenden) {
            finish();
            System.exit(0);
        }
    }

    private void openSeekarte() {
        intent = new Intent (this, Seekarte.class);
        startActivity(intent);
        this.finish();
    }

    private void openStatistik() {
        intent = new Intent (this, Statistik.class);
        startActivity(intent);
        this.finish();
    }

    private void openEinstellungen() {
        intent = new Intent (this, Einstellungen.class);
        startActivity(intent);
        this.finish();
    }
}


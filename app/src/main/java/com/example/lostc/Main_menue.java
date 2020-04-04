package com.example.lostc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Main_menue extends AppCompatActivity implements View.OnClickListener {

    Button bt_leinen_los, bt_statistik, bt_einstellungen;
    TextView tv_willkommen, tv_ausgabeuser;
    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menue);

        //Den hier erstellten Variablen werden die Button aus dem layout activity_main_menue zugeordnet
        bt_leinen_los = findViewById(R.id.bt_leinen_los);
        bt_statistik = findViewById(R.id.bt_statistik);
        bt_einstellungen = findViewById(R.id.bt_einstellungen);

        tv_willkommen = findViewById(R.id.tv_willkommen);
        tv_ausgabeuser = findViewById(R.id.tv_ausgabeuser);

        //OnClickListener für jeden Button
        bt_leinen_los.setOnClickListener(this);
        bt_statistik.setOnClickListener(this);
        bt_einstellungen.setOnClickListener(this);

        tv_willkommen.setText("Willkommen " + Choose_name.getNickname() + "!!");
        tv_ausgabeuser.setText(Choose_name.username);
    }
//Test
    @Override
    public void onClick(View v){
        //In der onClick Methode, welche hier noch für alle Objekt gilt, wird via Switch_Case Anweisung entschieden, was bei welchen Button geschehen soll
        switch (v.getId()){

            case R.id.bt_leinen_los:
                intent = new Intent(this, Seekarte2.class);
                startActivity(intent);
                this.finish();
                break;

            case R.id.bt_statistik://JK Hier kannst du noch das Belohnungssystem und den Fortschritt eintragen
                intent = new Intent(this, Statistik.class);
                startActivity(intent);
                this.finish();
                break;

            case R.id.bt_einstellungen:
                intent = new Intent (this, Einstellungen.class);
                startActivity(intent);
                this.finish();
                break;
        }

    }
}

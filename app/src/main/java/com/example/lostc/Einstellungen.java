package com.example.lostc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class Einstellungen extends AppCompatActivity implements ExampleDialog.ExampleDialogListener,ExampleDialog2.ExampleDialogListener2, View.OnClickListener {

    Button bt_namen_aendern, bt_kaptain_kontaktieren, bt_fortschritt_zuruecksetzten, bt_crew;
    TextView tv_username, tv_score;
    ImageButton ib_back_einstellunge;
    private DatabaseHelper db = new DatabaseHelper(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_einstellungen);

        //Den hier erstellten Variablen werden die Button aus dem layout activity_main_menue zugeordnet
        tv_username = findViewById(R.id.tv_username);
        tv_score = findViewById(R.id.tv_score);

        bt_namen_aendern = findViewById(R.id.bt_name_aendern);
        bt_kaptain_kontaktieren = findViewById(R.id.bt_kaptain_kontaktieren);
        bt_fortschritt_zuruecksetzten = findViewById(R.id.bt_fortschritt_zuruecksetzten);
        bt_crew = findViewById(R.id.bt_crew);

        ib_back_einstellunge = findViewById(R.id.ib_back_einstellungen);

        //OnClickListener für jeden Button
        bt_namen_aendern.setOnClickListener(this);
        bt_kaptain_kontaktieren.setOnClickListener(this);
        bt_fortschritt_zuruecksetzten.setOnClickListener(this);
        bt_crew.setOnClickListener(this);
        ib_back_einstellunge.setOnClickListener((this));

        tv_username.setText("Aktueller Name: " + User.retriveUsername(this));
        tv_score.setText("Score: " + User.retriveScore(this));
    }

    @Override
    public void onClick(View v) {
        //In der onClick Methode, welche hier noch für alle Objekt gilt, wird via Switch_Case Anweisung entschieden, was bei welchen Button geschehen soll
        if (v.getId() == R.id.bt_name_aendern) {
            openDialog();
        }
        if (v.getId() == R.id.bt_kaptain_kontaktieren) {
            openKaptnKontaktieren();
        }
        if(v.getId() == R.id.bt_fortschritt_zuruecksetzten) {
            openDialog2();
        }
        if (v.getId() == R.id.bt_crew) {
            openCrew();
            this.finish();
        }
        if (v.getId() == R.id.ib_back_einstellungen) {
            Toast.makeText(this, "Back gedrückt", Toast.LENGTH_SHORT).show();
            openMainMenue();
            this.finish();
        }
    }

    private void openDialog2() {
        ExampleDialog2 exampleDialog2 = new ExampleDialog2();
        exampleDialog2.show(getSupportFragmentManager(), "example dialog");
    }

    @Override
    public void onYesClicked() {
        User.resetScore(this);
        db.resetAnswered();
        //Nach dem Zurücksetzten des Scores muss auch gleich die Score Anzeige akualisiert werden
        tv_score.setText("Score: " + User.retriveScore(this));
    }

    public void openDialog() {
        ExampleDialog exampleDialog = new ExampleDialog();
        exampleDialog.show(getSupportFragmentManager(), "example dialog");
    }

    public void openKaptnKontaktieren() {
        Intent intent = new Intent(this, Team_kontaktieren.class);
        startActivity(intent);
        this.finish();
    }


    public void openCrew() {
        Intent intent = new Intent(this, Crew.class);
        startActivity(intent);
        this.finish();
    }


    @Override
    public void applyText(String username) {
        User.insertUsername(this, username);
        tv_username.setText("Aktueller Name: " + username);
    }

    public void openMainMenue () {
        Intent intent = new Intent(this, Main_menue.class);
        startActivity(intent);
    }


}

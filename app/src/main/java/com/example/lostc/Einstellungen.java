package com.example.lostc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

public class Einstellungen extends AppCompatActivity implements DialogName.ExampleDialogListener, DialogFortschritt.ExampleDialogListener2, View.OnClickListener,HideNavigationBar {

    Button bt_namen_aendern, bt_kaptain_kontaktieren, bt_fortschritt_zuruecksetzten, bt_crew;
    TextView tv_username, tv_score;
    private Intent intent;
    private DatabaseHelper db = new DatabaseHelper(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_einstellungen);
        hideNavigationBar();

        //Den hier erstellten Variablen werden die Button aus dem layout activity_main_menue zugeordnet
        tv_username = findViewById(R.id.tv_username);
        tv_score = findViewById(R.id.tv_score3);
        bt_namen_aendern = findViewById(R.id.bt_name_aendern);
        bt_kaptain_kontaktieren = findViewById(R.id.bt_kaptain_kontaktieren);
        bt_fortschritt_zuruecksetzten = findViewById(R.id.bt_fortschritt_zuruecksetzten);
        bt_crew = findViewById(R.id.bt_crew);
        ImageButton ib_back_einstellungen = findViewById(R.id.ib_back_einstellungen);

        //OnClickListener für jeden Button
        bt_namen_aendern.setOnClickListener(this);
        bt_kaptain_kontaktieren.setOnClickListener(this);
        bt_fortschritt_zuruecksetzten.setOnClickListener(this);
        bt_crew.setOnClickListener(this);
        ib_back_einstellungen.setOnClickListener(this);
        tv_username.setText("Aktueller Name: " + User.retriveUsername(this));
        tv_score.setText(User.retriveScore(this) + "");
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
        if (v.getId() == R.id.bt_fortschritt_zuruecksetzten) {
            openDialog2();
        }
        if (v.getId() == R.id.bt_crew) {
            openCrew();
        }
        if(v.getId()== R.id.ib_back_einstellungen)
        {
            openMainMenue();
        }
    }

    private void openDialog2() {
        DialogFortschritt exampleDialog2 = new DialogFortschritt();
        exampleDialog2.show(getSupportFragmentManager(), "example dialog");
    }

    /**
     *
     */
    @Override
    public void onYesClicked() {

        if(User.retriveScore(this)!=0) {
            db.resetAnswered();
            User.insertScore(this, 0);
            User.insertLevel(this, 1);
            for(int i=1; i<=10; i++) {
                Quiz.setArrayPosition(this, 0, String.valueOf(i));
            }
            User.insertLevel(this,1);
        }
        return;

    }
    @Override
    public void applyText(String username) {
        User.insertUsername(this, username);
        tv_username.setText("Aktueller Name: " + username);
    }

    public void openDialog() {
        DialogName exampleDialog = new DialogName();
        exampleDialog.show(getSupportFragmentManager(), "example dialog");
    }

    private void openKaptnKontaktieren() {
        Intent intent = new Intent(this, Team_kontaktieren.class);
        startActivity(intent);
        this.finish();
    }

    private void openCrew() {
        intent = new Intent(this, Crew.class);
        startActivity(intent);
        this.finish();
    }

    private void openMainMenue () {
        intent = new Intent(this, Main_menue.class);
        startActivity(intent);
        this.finish();
    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        hideNavigationBar();
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

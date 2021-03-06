package com.example.lostc;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Logbuch extends AppCompatActivity implements View.OnClickListener, DialogLogbuchinfo.ExampleDialogListener3,HideNavigationBar {


    private TextView tv_Kapitel;
    private String kategorie;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logbuch);
        hideNavigationBar();

        SharedPreferences prefs = getSharedPreferences("sp_firststart",MODE_PRIVATE);
        boolean firstStart = prefs.getBoolean("firststart",true);

        if(firstStart)
        {
            openDialog();
        }


        tv_Kapitel = findViewById(R.id.tv_Kapitel);
        Button bt_Bordbuch = findViewById(R.id.bt_Bordbuch);
        Button bt_Abfrage = findViewById(R.id.bt_Abfrage);
        Button bt_Programmieren = findViewById(R.id.bt_Programmieren);
        ImageButton ib_BackLogbuch = findViewById(R.id.ib_backLogbuch);

        ib_BackLogbuch.setOnClickListener(this);
        bt_Bordbuch.setOnClickListener(this);
        bt_Abfrage.setOnClickListener(this);
        bt_Programmieren.setOnClickListener(this);

        Bundle bundle = getIntent().getExtras();
        kategorie = bundle.getString("Kategorie");

        /**
         * von der gedrückten Kategorie wird der entsprechende Text in die XML Datei geschrieben
         */
        if (kategorie.equals("1")) {
            tv_Kapitel.setText("Grundlagen");
        }
        if (kategorie.equals("2")) {
            tv_Kapitel.setText("Datentypen");
        }
        if (kategorie.equals("3")) {
            tv_Kapitel.setText("Entscheidungen");
        }
        if (kategorie.equals("4")) {
            tv_Kapitel.setText("Schleifen");
        }
        if (kategorie.equals("5")) {
            tv_Kapitel.setText("Funktionen");
        }
        if (kategorie.equals("6")) {
            tv_Kapitel.setText("Arrays");
        }
        if (kategorie.equals("7")) {
            tv_Kapitel.setText("Variablen");
        }
        if (kategorie.equals("8")) {
            tv_Kapitel.setText("Präprozessor");
        }
        if (kategorie.equals("9")) {
            tv_Kapitel.setText("Pointer");
        }
        if (kategorie.equals("10")) {
            tv_Kapitel.setText("Dateizugriff");
        }
    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        hideNavigationBar();
    }

    @Override
    public void onClick(View v) {

        if (v.getId() == R.id.bt_Bordbuch) {
            openBordbuch(kategorie);
            this.finish();
        }
        if (v.getId() == R.id.bt_Abfrage) {
            openQuiz(kategorie);
            this.finish();
        }
        if (v.getId() == R.id.bt_Programmieren) {
            openProgrammieren(kategorie);
        }
        if (v.getId() == R.id.ib_backLogbuch) {
            openSeekarte();
            this.finish();
        }


    }

    private void openBordbuch(String kategorie) {
        Intent intent = new Intent(this, Bordbuch.class);
        intent.putExtra("Kategorie", kategorie);
        startActivity(intent);
        this.finish();
    }

    private void openQuiz(String kategorie) {
        Intent intent = new Intent(this, Quiz.class);
        intent.putExtra("Kategorie", kategorie);
        startActivity(intent);
        this.finish();
    }

    private void openProgrammieren(String kategorie) {
        Intent intent = new Intent(this, Programmieren.class);
        intent.putExtra("Kategorie", kategorie);
        startActivity(intent);
        this.finish();
    }

    private void openSeekarte() {
        Intent intent = new Intent(this, Seekarte.class);
        startActivity(intent);
        this.finish();
    }


    private void openDialog() {
        DialogLogbuchinfo exampleDialog = new DialogLogbuchinfo();
        exampleDialog.show(getSupportFragmentManager(), "example dialog");
        SharedPreferences prefs = getSharedPreferences("sp_firststart",MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putBoolean("firststart",false);
        editor.apply();
    }

    @Override
    public void onYesClicked() {
        return;
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

package com.example.lostc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import com.airbnb.lottie.LottieAnimationView;

public class Programmieren extends AppCompatActivity implements View.OnClickListener,HideNavigationBar {

    private String kategorie;

    String basePath = "file:///android_asset/Aufgaben/";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_programmieren);
        hideNavigationBar();

        TextView tv_ProgrammierAufgabe = findViewById(R.id.tv_ProgrammierenKapitel);
        ImageButton ib_BackProgrammieren = findViewById(R.id.ib_backProgrammieren);
        LottieAnimationView lottieAnimation2;

        lottieAnimation2 = findViewById(R.id.lottieanimation);
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
        if(kategorie.equals("9"))
        {
            tv_ProgrammierAufgabe.setText("Pointer");
            webView.loadUrl(basePath+ "aufgabepointer.html");
        }
        if(kategorie.equals("10"))
        {
            tv_ProgrammierAufgabe.setText("Dateizugriff");
            webView.loadUrl(basePath+ "aufgabedateizugriff.html");
        }

    }

    @Override
    public void onClick(View v) {

        if (v.getId() == R.id.ib_backProgrammieren) {
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





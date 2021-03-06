package com.example.lostc;

import android.os.Bundle;
import android.view.View;
import android.content.Intent;
import android.webkit.WebView;
import android.widget.ImageButton;
import android.widget.TextView;


import androidx.appcompat.app.AppCompatActivity;

public class Loesung extends AppCompatActivity implements View.OnClickListener,HideNavigationBar{


        private String kategorie;

        String basePath = "file:///android_asset/Aufgabenloesung/";

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_loesung);
            hideNavigationBar();

            TextView tv_ProgrammierAufgabe = findViewById(R.id.tv_LoesungsAufgabe);
            ImageButton ib_BackProgrammieren = findViewById(R.id.ib_backloesung);

            Bundle bundle = getIntent().getExtras();
            kategorie = bundle.getString("Kategorie");

            WebView webView = findViewById(R.id.wv_Aufgabenloesung);
            webView.setBackgroundColor(0);

            ib_BackProgrammieren.setOnClickListener(this);

            if (kategorie.equals("1")) {
                tv_ProgrammierAufgabe.setText("Grundlagen");
                webView.loadUrl(basePath + "loesunggrundlagen.html");
            }
            if(kategorie.equals("2"))
            {
                tv_ProgrammierAufgabe.setText("Datentypen");
                webView.loadUrl(basePath+ "loesungdatentypen.html");
            }
            if(kategorie.equals("3"))
            {
                tv_ProgrammierAufgabe.setText("Entscheidungen");
                webView.loadUrl(basePath+ "loesungentscheidungen.html");
            }
            if(kategorie.equals("4"))
            {
                tv_ProgrammierAufgabe.setText("Schleifen");
                webView.loadUrl(basePath+ "loesungschleifen.html");
            }
            if(kategorie.equals("5"))
            {
                tv_ProgrammierAufgabe.setText("Funktionen");
                webView.loadUrl(basePath+ "loesungfunktionen.html");
            }
            if(kategorie.equals("6"))
            {
                tv_ProgrammierAufgabe.setText("Arrays");
                webView.loadUrl(basePath+ "loesungarrays.html");
            }
            if(kategorie.equals("7"))
            {
                tv_ProgrammierAufgabe.setText("Variablen");
                webView.loadUrl(basePath+ "loesungvariablen.html");
            }
            if(kategorie.equals("8"))
            {
                tv_ProgrammierAufgabe.setText("Präprozessor");
                webView.loadUrl(basePath+ "loesungpräprozessor.html");
            }
            if(kategorie.equals("9"))
            {
                tv_ProgrammierAufgabe.setText("Pointer");
                webView.loadUrl(basePath+ "loesungpointer.html");
            }
            if(kategorie.equals("10"))
            {
                tv_ProgrammierAufgabe.setText("Dateizugriff");
                webView.loadUrl(basePath+ "loesungdateizugriff.html");
            }
        }

        @Override
        public void onClick(View v) {

            if (v.getId() == R.id.ib_backloesung) {
                openProgrammieren(kategorie);
            }
        }

        private void openProgrammieren(String kategorie) {
            Intent intent = new Intent(this, Programmieren.class);
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


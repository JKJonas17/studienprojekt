package com.example.lostc;

import android.os.Bundle;
import android.view.View;
import android.content.Intent;
import android.webkit.WebView;
import android.widget.ImageButton;
import android.widget.TextView;


import androidx.appcompat.app.AppCompatActivity;

public class Bordbuch extends AppCompatActivity implements View.OnClickListener,HideNavigationBar {

    private String kategorie;

    String basePath = "file:///android_asset/Infotexte/";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bordbuch);
        hideNavigationBar();

        TextView tv_BordbuchKapitel = findViewById(R.id.tv_BordbuchKapitel);
        ImageButton ib_BackBordbuch = findViewById(R.id.ib_backBordbuch);

        Bundle bundle = getIntent().getExtras();
        kategorie = bundle.getString("Kategorie");

        WebView webView = findViewById(R.id.wv_infotext);
        webView.setBackgroundColor(0);              // Macht den Hintergrund Transparent

        ib_BackBordbuch.setOnClickListener(this);

        if (kategorie.equals("1")) {
            tv_BordbuchKapitel.setText("Grundlagen");
            webView.loadUrl(basePath + "grundlagen.html");
        }
        if (kategorie.equals("2")) {
            tv_BordbuchKapitel.setText("Datentypen");
            webView.loadUrl(basePath + "datentypen.html");
        }
        if (kategorie.equals("3")) {
            tv_BordbuchKapitel.setText("Entscheidungen");
            webView.loadUrl(basePath + "entscheidungen.html");
        }
        if (kategorie.equals("4")) {
            tv_BordbuchKapitel.setText("Schleifen");
            webView.loadUrl(basePath + "schleifen.html");
        }
        if (kategorie.equals("5")) {
            tv_BordbuchKapitel.setText("Funktionen");
            webView.loadUrl(basePath + "funktionen.html");
        }
        if (kategorie.equals("6")) {
            tv_BordbuchKapitel.setText("Arrays");
            webView.loadUrl(basePath + "array.html");
        }
        if (kategorie.equals("7")) {
            tv_BordbuchKapitel.setText("Variablen");
            webView.loadUrl(basePath + "variablen.html");
        }
        if (kategorie.equals("8")) {
            tv_BordbuchKapitel.setText("Präprozessor");
            webView.loadUrl(basePath + "praeprozessor.html");
        }
        if (kategorie.equals("9")) {
            tv_BordbuchKapitel.setText("Pointer");
            webView.loadUrl(basePath + "pointer.html");
        }
        if (kategorie.equals("10")) {
            tv_BordbuchKapitel.setText("Dateizugriff");
            webView.loadUrl(basePath + "dateizugriff.html");
        }
    }


    @Override
    public void onClick(View v) {

        if (v.getId() == R.id.ib_backBordbuch) {
            openLogbuch(kategorie);
        }

    }

    private void openLogbuch(String kategorie) {

        Intent intent = new Intent(this, Logbuch.class);
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

package com.example.lostc;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.ValueAnimator;
import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.renderscript.Sampler;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Timer;
import java.util.TimerTask;

public class Main_menue extends AppCompatActivity implements View.OnClickListener, HideNavigationBar {

    Button bt_leinen_los, bt_statistik, bt_einstellungen, bt_beenden;
    TextView tv_willkommen, tv_score;
    private Intent intent;
    private DatabaseHelper db = new DatabaseHelper(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menue);
        hideNavigationBar();

        //Den hier erstellten Variablen werden die Button aus dem layout activity_main_menue zugeordnet
        bt_leinen_los = findViewById(R.id.bt_leinen_los);
        bt_statistik = findViewById(R.id.bt_statistik);
        bt_einstellungen = findViewById(R.id.bt_einstellungen);
        bt_beenden = findViewById(R.id.bt_beenden);

        tv_willkommen = findViewById(R.id.tv_willkommen);
        tv_score = findViewById(R.id.tv_score);

        //OnClickListener für jeden Button
        bt_leinen_los.setOnClickListener(this);
        bt_statistik.setOnClickListener(this);
        bt_einstellungen.setOnClickListener(this);
        bt_beenden.setOnClickListener(this);

        tv_willkommen.setText("Willkommen " + User.retriveUsername(this) + "!!");

        tv_score.setText(User.retriveScore(this) + "");

        //Übergibt den Pfad der Datenbank an eine Variable typ File
        File database = getApplicationContext().getDatabasePath(DatabaseHelper.DATABASE_NAME);

        if (!database.exists()) //wenn File nicht existiert
        {
            db.getReadableDatabase(); //erstellt oder öffnet eine Datenbank

            if (copyDatabase(this)) //gibt einen Toast aus wenn Datenbank erfolgreich kopiert wurde
            {
                Log.i("dbcopysuc","erfolgreich");
            } else {
                Log.i("dbcopyfail","nicht erfolgreich");
                return;
            }
        }

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
            android.os.Process.killProcess(android.os.Process.myPid());
        }
    }

    /**
     * Liest Datenbank aus AssetFolder und schreibt diese in den Speicherort des Gerätespeichers
     *
     * @param context wird an DatabaseHelper übergeben um Objekt zu erstellen
     * @return true wenn Kopie der Datenbank erfolgreich erstellt wurde
     */
    public static boolean copyDatabase(Context context) {
        try {
            InputStream inputStream = context.getAssets().open(DatabaseHelper.DATABASE_NAME);
            String file = context.getFilesDir().getParentFile().getPath() + "/databases/" + DatabaseHelper.DATABASE_NAME;
            OutputStream outputStream = new FileOutputStream(file);
            byte[] buff = new byte[1024];
            int length;

            while ((length = inputStream.read(buff)) > 0) {
                outputStream.write(buff, 0, length);
            }
            outputStream.flush();
            outputStream.close();
            Log.w("Quiz", "DBCopied");
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
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


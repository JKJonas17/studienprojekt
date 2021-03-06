package com.example.lostc;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.text.DecimalFormat;

public class Statistik extends AppCompatActivity implements View.OnClickListener,HideNavigationBar {

    ImageButton ib_back_Statitik;
    TextView tv_schatz_des_hollaenders, tv_gesamtfortschritt;
    ImageView iv_schatzkiste;
    private DatabaseHelper db = new DatabaseHelper(this);

    @Override
    protected void onCreate(Bundle savedInstanceState)  {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_statistik);
        hideNavigationBar();
        double fortschritt, prozent_fortschritt;
        double avg = db.getAvarage();

        ImageButton ib_backStatistik = findViewById(R.id.ib_backStatistik);
        TextView tv_schatz_des_hollaenders = findViewById(R.id.tv_schatz_des_hollaenders);
        TextView tv_gesamtfortschritt = findViewById(R.id.tv_gesamtfortschritt);
        TextView tv_gesamt = findViewById(R.id.tv_gesamt);
        TextView tv_level = findViewById(R.id.tv_level);
        ProgressBar pb_Statistik = findViewById(R.id.pb_Statistik);
        ImageView iv_schatzkiste = findViewById(R.id.iv_schatzkiste);
        avg *= 100;
        DecimalFormat f = new DecimalFormat("#0.00");

        pb_Statistik.setMax(100);
        int avginint = (int) avg;
        pb_Statistik.setProgress(avginint);

        //Für die prozentuale Angabe wird noch der Wert für 100% aus der Datenbank benötigt.

        if(avg!= 0) {
            tv_gesamt.setText("Gesamtfortschritt: " + f.format(avg) + "%");
        }
        else
        {
            tv_gesamt.setText("Gesamtfortschritt: 0%");
        }
        tv_level.setText("Aktuelles Level: " + User.retriveLevel(this));
        ib_backStatistik.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.ib_backStatistik) {
            openMainMenue();
            this.finish();
        }
    }

    private void openMainMenue() {
        Intent intent = new Intent(this,Main_menue.class);
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

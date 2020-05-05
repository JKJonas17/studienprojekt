package com.example.lostc;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Statistik extends AppCompatActivity implements View.OnClickListener {

    ImageButton ib_back_Statitik;
    TextView tv_schatz_des_hollaenders, tv_gesamtfortschritt;
    ImageView iv_schatzkiste;
    private DatabaseHelper db = new DatabaseHelper(this);

    @Override
    protected void onCreate(Bundle savedInstanceState)  {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_statistik);
        double fortschritt, prozent_fortschritt;
        double avg = db.getAvarage();

        ImageButton ib_backStatistik = findViewById(R.id.ib_backStatistik);
        TextView tv_schatz_des_hollaenders = findViewById(R.id.tv_schatz_des_hollaenders);
        TextView tv_gesamtfortschritt = findViewById(R.id.tv_gesamtfortschritt);
        TextView tv_gesamt = findViewById(R.id.tv_gesamt);
        TextView tv_level = findViewById(R.id.tv_level);
        ImageView iv_schatzkiste = findViewById(R.id.iv_schatzkiste);
        fortschritt = User.retriveScore(this);
        prozent_fortschritt = fortschritt/250*100;

        //Für die prozentuale Angabe wird noch der Wert für 100% aus der Datenbank benötigt.

        tv_gesamt.setText("Gesamtfortschritt: " + prozent_fortschritt + "%");
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
}

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

    @Override
    protected void onCreate(Bundle savedInstanceState)  {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_statistik);

        ImageButton ib_backStatistik = findViewById(R.id.ib_backStatistik);
        TextView tv_schatz_des_hollaenders = findViewById(R.id.tv_schatz_des_hollaenders);
        TextView tv_gesamtfortschritt = findViewById(R.id.tv_gesamtfortschritt);
        ImageView iv_schatzkiste = findViewById(R.id.iv_schatzkiste);

        ib_backStatistik.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.ib_backStatistik) {
            openMainMenue();
        }
    }

    private void openMainMenue() {
        Intent intent = new Intent(this,Main_menue.class);
        startActivity(intent);
        this.finish();
    }
}

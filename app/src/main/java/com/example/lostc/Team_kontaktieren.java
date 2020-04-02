package com.example.lostc;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Typeface;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

public class Team_kontaktieren extends AppCompatActivity {

    TextView tv_ahoi_piraten;
    Typeface schriftart_geschwungen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_team_kontaktieren);

        tv_ahoi_piraten =(TextView) findViewById(R.id.tv_ahoi);

        schriftart_geschwungen = Typeface.createFromAsset(getAssets(), "schriftarten/geschwungen.ttf");
        tv_ahoi_piraten.setTypeface(schriftart_geschwungen);

    }
}

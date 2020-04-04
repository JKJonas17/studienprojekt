package com.example.lostc;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Typeface;
import android.os.Bundle;
import android.widget.TextView;

public class Team_kontaktieren extends AppCompatActivity {

    private TextView tv_ahoi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_team_kontaktieren);

        tv_ahoi = findViewById(R.id.tv_ahoi);

    }
}

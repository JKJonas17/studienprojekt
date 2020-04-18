package com.example.lostc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Gewonnen extends AppCompatActivity implements View.OnClickListener {

    private Button bt_WeiterSeekarte;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gewonnen);

        bt_WeiterSeekarte = findViewById(R.id.bt_weiterSeekarte);
        bt_WeiterSeekarte.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
             openSeekarte();
    }

    public void openSeekarte()
    {
        Intent intent = new Intent(this,Seekarte.class);
        startActivity(intent);
    }

}

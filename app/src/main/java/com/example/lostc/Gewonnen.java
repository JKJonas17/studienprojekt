package com.example.lostc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Gewonnen extends AppCompatActivity implements View.OnClickListener {

    Button bt_WeiterSeekarte;
    TextView tv_gewonnen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gewonnen);

        bt_WeiterSeekarte = findViewById(R.id.bt_weiterSeekarte);
        tv_gewonnen = findViewById(R.id.tv_gewonnen);

        bt_WeiterSeekarte.setOnClickListener(this);

        tv_gewonnen.setText("Anker lichten " + User.retriveUsername(this) + ".\n" + "Wir stechen in See!");
    }

    @Override
    public void onClick(View v) {
             openSeekarte();
    }

    private void openSeekarte()
    {
        Intent intent = new Intent(this,Seekarte.class);
        startActivity(intent);
        this.finish();
    }

}

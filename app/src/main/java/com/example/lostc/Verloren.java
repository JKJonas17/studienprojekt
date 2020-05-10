package com.example.lostc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.text.DecimalFormat;

public class Verloren extends AppCompatActivity implements View.OnClickListener{

    private String kategorie;
    private double avg;
    private Button bt_nochmalQuiz;
    private TextView tv_verloren;
    private TextView tv_avgLost;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verloren);

        bt_nochmalQuiz = findViewById(R.id.bt_nochmalQuiz);
        tv_verloren = findViewById(R.id.tv_verloren);
        tv_avgLost = findViewById(R.id.tv_avgLost);
        bt_nochmalQuiz.setOnClickListener(this);

        Bundle bundle = getIntent().getExtras();
        kategorie = bundle.getString("Kategorie");
        avg = bundle.getDouble("Avarage");
        avg *= 100;
        DecimalFormat f = new DecimalFormat("#0.00");

        if (avg == 0) {
            tv_avgLost.setText("Du hast: 0 % richtig!");
        }
        else
        {
            tv_avgLost.setText("Du hast nur: "+f.format(avg) +"% richtig");
        }
        tv_verloren.setText("Arrrrrr " + User.retriveUsername(this) + "!\n" + "Beim heiligen Klabautermann!\nMan sollte dich auf dieser Insel aussetzen!");
    }

    @Override
    public void onClick(View v) {
        openQuiz(kategorie);
    }

    private void openQuiz(String kategorie)
    {
        Intent intent = new Intent(this, Quiz.class);
        intent.putExtra("Kategorie", kategorie);
        startActivity(intent);
        this.finish();
    }
}

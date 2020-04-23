package com.example.lostc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Verloren extends AppCompatActivity implements View.OnClickListener{

    private String kategorie;
    Button bt_nochmalQuiz;
    TextView tv_verloren;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verloren);

        bt_nochmalQuiz = findViewById(R.id.bt_nochmalQuiz);
        tv_verloren = findViewById(R.id.tv_verloren);

        bt_nochmalQuiz.setOnClickListener(this);

        Bundle bundle = getIntent().getExtras();
        kategorie = bundle.getString("Kategorie");

        tv_verloren.setText("Arrrrrr " + User.retriveUsername(this) + "!\n" + "Beim heiligen Klabautermann!\n Man sollte dich auf dieser Insel aussetzen!");
    }

    @Override
    public void onClick(View v) {
        openQuiz(kategorie);
    }

    public void openQuiz(String kategorie)
    {
        Intent intent = new Intent(this, Quiz.class);
        intent.putExtra("Kategorie", kategorie);
        startActivity(intent);
    }
}

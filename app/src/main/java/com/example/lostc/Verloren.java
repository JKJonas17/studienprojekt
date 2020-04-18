package com.example.lostc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Verloren extends AppCompatActivity implements View.OnClickListener{

    private String kategorie;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verloren);

        Button bt_nochmalQuiz = findViewById(R.id.bt_nochmalQuiz);
        bt_nochmalQuiz.setOnClickListener(this);

        Bundle bundle = getIntent().getExtras();
        kategorie = bundle.getString("Kategorie");

    }

    @Override
    public void onClick(View v) {
        openQuiz(kategorie);
    }

    public void openQuiz(String kategorie)
    {
        Intent intent = new Intent(this,Quiz.class);
        intent.putExtra("Kategorie", kategorie);
        startActivity(intent);
    }
}

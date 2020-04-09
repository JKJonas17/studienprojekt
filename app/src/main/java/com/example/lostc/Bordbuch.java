package com.example.lostc;

import android.os.Bundle;
import android.view.View;
import android.content.Intent;
import android.widget.ImageButton;
import android.widget.TextView;


import androidx.appcompat.app.AppCompatActivity;

public class Bordbuch extends AppCompatActivity implements View.OnClickListener {

    private String kategorie;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bordbuch_grundlagen);

        Bundle bundle = getIntent().getExtras();
        kategorie = bundle.getString("Kategorie");



        TextView tv_BordbuchKapitel = findViewById(R.id.tv_BordbuchKapitel);
        ImageButton ib_BackBordbuch = findViewById(R.id.ib_backBordbuch);

        ib_BackBordbuch.setOnClickListener(this);

        if(kategorie.equals("1"))
        {
            tv_BordbuchKapitel.setText("Grundlagen");
        }
        if(kategorie.equals("2"))
        {
            tv_BordbuchKapitel.setText("TBD1");
        }
        if(kategorie.equals("3"))
        {
            tv_BordbuchKapitel.setText("TBD2");
        }
        if(kategorie.equals("4"))
        {
            tv_BordbuchKapitel.setText("TBD3");
        }
        if(kategorie.equals("5"))
        {
            tv_BordbuchKapitel.setText("TBD4");
        }
        if(kategorie.equals("6"))
        {
            tv_BordbuchKapitel.setText("TBD5");
        }
        if(kategorie.equals("7"))
        {
            tv_BordbuchKapitel.setText("TBD6");
        }
        if(kategorie.equals("8"))
        {
            tv_BordbuchKapitel.setText("TBD7");
        }

    }


    @Override
    public void onClick(View v) {

        if(v.getId()== R.id.ib_backBordbuch)
        {
            openLogbuch(kategorie);
        }

    }

    public void openLogbuch(String kategorie)
    {

        Intent intent = new Intent(this,Logbuch.class);
        intent.putExtra("Kategorie",kategorie);
        startActivity(intent);

    }


}

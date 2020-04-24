package com.example.lostc;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

public class Crew extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crew);

        ImageButton ib_back_crew = findViewById(R.id.ib_backCrew);

        ib_back_crew.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
      if(v.getId() == R.id.ib_backCrew)
      {
          openEinstellungen();
      }
    }

    private void openEinstellungen()
    {
        Intent intent = new Intent(this,Einstellungen.class);
        startActivity(intent);
        this.finish();
    }
}

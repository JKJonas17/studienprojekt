package com.example.lostc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class Quellen extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quellen);

        ImageButton ib_backQuellen = findViewById(R.id.ib_backQuellen);
        ib_backQuellen.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.ib_backQuellen) {
            openCrew();
            this.finish();
        }
    }

    private void openCrew() {
        Intent intent = new Intent(this, Crew.class);
        startActivity(intent);
        this.finish();
    }
}

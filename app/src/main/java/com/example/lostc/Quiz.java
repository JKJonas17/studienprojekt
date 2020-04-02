package com.example.lostc;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class Quiz extends AppCompatActivity {

    DatabaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        try {
            db = new DatabaseHelper(this);

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

    }
}

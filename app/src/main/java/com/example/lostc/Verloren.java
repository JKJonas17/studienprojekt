package com.example.lostc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Verloren extends AppCompatActivity implements View.OnClickListener{

    private Button bt_nochmalQuiz;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verloren);

        bt_nochmalQuiz = findViewById(R.id.bt_nochmalQuiz);
        bt_nochmalQuiz.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        openQuiz();
    }

    public void openQuiz()
    {
        Intent intent = new Intent(this,Quiz.class);
        startActivity(intent);
    }
}

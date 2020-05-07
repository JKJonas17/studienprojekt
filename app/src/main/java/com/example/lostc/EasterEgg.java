package com.example.lostc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.VideoView;

public class EasterEgg extends AppCompatActivity implements View.OnClickListener{

    private VideoView vv_EasterEgg;
    private Button bt_EasterEgg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_easter_egg);
        vv_EasterEgg = findViewById(R.id.vv_EasterEgg);
        bt_EasterEgg = findViewById(R.id.bt_EasterEgg);

        Uri uri = Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.schatz_des_hollaenders);

        vv_EasterEgg.setVideoURI(uri);
        vv_EasterEgg.start();

        bt_EasterEgg.setOnClickListener(this);
    }

    private void openMainMenue() {
        Intent intent = new Intent(this, Main_menue.class);
        startActivity(intent);
        this.finish();
    }

    @Override
    public void onClick(View v) {
        openMainMenue();
    }
}

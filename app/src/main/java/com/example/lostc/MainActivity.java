package com.example.lostc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;

import com.airbnb.lottie.LottieAnimationView;


public class MainActivity extends AppCompatActivity {

    public final int LOAD_TIME = 13000; //Lässt nach 13 Sekunden den Startbildschirm verschwinden
    LottieAnimationView lottieAnimation;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lottieAnimation = findViewById(R.id.lottieanimation);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(MainActivity.this, Choose_name.class);
                startActivity(intent);
                finish();
            }
        },LOAD_TIME);
    }
}

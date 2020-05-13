package com.example.lostc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;

import com.airbnb.lottie.LottieAnimationView;


public class MainActivity extends AppCompatActivity implements HideNavigationBar{

    public final int LOAD_TIME = 13000; //Lässt nach 13 Sekunden den Startbildschirm verschwinden
    LottieAnimationView lottieAnimation;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        hideNavigationBar();
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

    @Override
    protected void onResume() {
        super.onResume();
        hideNavigationBar();
    }

    @Override
    public void hideNavigationBar() {
        this.getWindow().getDecorView().setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_FULLSCREEN|
                        View.SYSTEM_UI_FLAG_HIDE_NAVIGATION |
                        View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY |
                        View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN |
                        View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION|
                        View.SYSTEM_UI_FLAG_LAYOUT_STABLE
        );
    }
}

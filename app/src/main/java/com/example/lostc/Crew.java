package com.example.lostc;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

public class Crew extends AppCompatActivity implements View.OnClickListener,HideNavigationBar {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        hideNavigationBar();
        setContentView(R.layout.activity_crew);

        ImageButton ib_backCrew = findViewById(R.id.ib_backCrew);
        Button bt_quellen = findViewById(R.id.bt_quellen);

        ib_backCrew.setOnClickListener(this);
        bt_quellen.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.bt_quellen) {
            openQuellen();
        }
        if (v.getId() == R.id.ib_backCrew) {
            openEinstellungen();
        }
    }

    private void openQuellen() {
        Intent intent = new Intent(this, Quellen.class);
        startActivity(intent);
        this.finish();
    }

    private void openEinstellungen() {
        Intent intent = new Intent(this, Einstellungen.class);
        startActivity(intent);
        this.finish();
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

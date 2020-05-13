package com.example.lostc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;

public class Belohnung extends AppCompatActivity implements View.OnClickListener,HideNavigationBar {

    private Button bt_belohnung;
    private WebView wv_belohnung;
    private String basePath = "file:///android_asset/Belohnung/";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_belohnung);
        hideNavigationBar();

        bt_belohnung = findViewById(R.id.bt_belohnung);
        bt_belohnung.setOnClickListener(this);
        wv_belohnung = findViewById(R.id.wv_belohnung);

        wv_belohnung.setBackgroundColor(0);
        wv_belohnung.loadUrl(basePath + "belohnung.html");

    }

    @Override
    public void onClick(View v) {
        openMainMenue();
    }

    private void openMainMenue()
    {
        Intent intent = new Intent(this,Main_menue.class);
        startActivity(intent);
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

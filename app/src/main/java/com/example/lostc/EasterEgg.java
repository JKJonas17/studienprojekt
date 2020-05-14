package com.example.lostc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.VideoView;

public class EasterEgg extends AppCompatActivity implements View.OnClickListener,HideNavigationBar{

    private VideoView vv_EasterEgg;
    private Button bt_EasterEgg;
    private TextView tv_EasterEgg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        hideNavigationBar();
        setContentView(R.layout.activity_easter_egg);
        vv_EasterEgg = findViewById(R.id.vv_EasterEgg);
        bt_EasterEgg = findViewById(R.id.bt_EasterEgg);
        tv_EasterEgg = findViewById(R.id.tv_EasterEgg);

        tv_EasterEgg.setText("Herzlichen Glückwunsch " + User.retriveUsername(this)+ " du hast alle Level geschafft");

        Uri uri = Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.schatz_des_hollaenders);

        vv_EasterEgg.setVideoURI(uri);
        vv_EasterEgg.start();

        bt_EasterEgg.setOnClickListener(this);
    }

    private void openMainMenue() {
        Intent intent = new Intent(this, Belohnung.class);
        startActivity(intent);
        this.finish();
    }

    @Override
    public void onClick(View v) {
        openMainMenue();
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

package com.example.lostc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.text.DecimalFormat;

public class Gewonnen extends AppCompatActivity implements View.OnClickListener,HideNavigationBar {

    private Button bt_WeiterSeekarte;
    private TextView tv_gewonnen;
    private double avg;
    private TextView tv_avgWon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gewonnen);
        hideNavigationBar();

        bt_WeiterSeekarte = findViewById(R.id.bt_weiterSeekarte);
        tv_gewonnen = findViewById(R.id.tv_gewonnen);
        tv_avgWon = findViewById(R.id.tv_avgWon);

        bt_WeiterSeekarte.setOnClickListener(this);
        Bundle bundle = getIntent().getExtras();
        avg = bundle.getDouble("Avarage");
        avg *= 100;
        DecimalFormat f = new DecimalFormat("#0.00");

        tv_avgWon.setText("Du hast: " + f.format(avg) + "% richtig!");


        tv_gewonnen.setText("Anker lichten " + User.retriveUsername(this) + ".\n" + "Wir stechen in See!");
    }

    @Override
    public void onClick(View v) {
        openSeekarte();
    }

    private void openSeekarte() {
        Intent intent = new Intent(this, Seekarte.class);
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

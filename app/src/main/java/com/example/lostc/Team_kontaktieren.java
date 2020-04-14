package com.example.lostc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class Team_kontaktieren extends AppCompatActivity implements View.OnClickListener {

    private TextView tv_ahoi;
    private ImageView iv_karte;
    private ImageView iv_flasche;
    private EditText et_name_aendern;
    private EditText et_semester;
    private EditText et_thema;
    private TextView tv_flaschenpost;
    private Button bt_absenden;
    private ImageButton ib_backTeamKontaktieren;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_team_kontaktieren);

        tv_ahoi = findViewById(R.id.tv_ahoi);
        tv_flaschenpost = findViewById(R.id.tv_Flaschenpost);
        bt_absenden = findViewById(R.id.bt_absenden);
        et_name_aendern = findViewById(R.id.et_name_aendern);
        et_semester = findViewById(R.id.et_Semester);
        et_thema = findViewById(R.id.et_thema);
        ib_backTeamKontaktieren = findViewById(R.id.ib_backTeamKontaktieren);

        ib_backTeamKontaktieren.setOnClickListener(this);
        bt_absenden.setOnClickListener(this);
        et_name_aendern.setOnClickListener(this);
        et_semester.setOnClickListener(this);
        et_thema.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.bt_absenden) {
            //Jackermayer muss noch E-Mail verknüpfen
        }
        if(v.getId() == R.id.ib_backTeamKontaktieren) {
            openMainMenue();
    }

}
    /**
     * wenn man wieder ins Main-Menue zurück möchte
     */
    private void openMainMenue() {
        Intent intent = new Intent(this, Main_menue.class);
        startActivity(intent);
    }
}

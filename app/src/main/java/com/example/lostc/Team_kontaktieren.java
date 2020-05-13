package com.example.lostc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;

public class Team_kontaktieren extends AppCompatActivity implements View.OnClickListener,HideNavigationBar {

    private TextView tv_ahoi;
    private ImageView iv_karte;
    private ImageView iv_flasche;
    private EditText et_name_aendern;
    private EditText et_semester;
    private EditText et_thema;
    private TextView tv_flaschenpost;
    private Button bt_absenden;
    private ImageButton ib_backTeamKontaktieren;
    private TextInputEditText tiet_Inhalt;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_team_kontaktieren);
        hideNavigationBar();

        tv_ahoi = findViewById(R.id.tv_ahoi);
        tv_flaschenpost = findViewById(R.id.tv_Flaschenpost);
        bt_absenden = findViewById(R.id.bt_absenden);
        et_name_aendern = findViewById(R.id.et_name_aendern);
        et_semester = findViewById(R.id.et_Semester);
        et_thema = findViewById(R.id.et_thema);
        tiet_Inhalt = findViewById(R.id.tied_Inhalt);

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
            String to_email="test@.de"; //Hier bräuchten wir dann noch eine Email Adresse wo wir die Nachrichten hinsenden

            Intent intent = new Intent(Intent.ACTION_SENDTO);
            intent.setData(Uri.parse("mailto:"));
            intent.putExtra(Intent.EXTRA_EMAIL,new String[] {to_email});

            //Inhalt der email


            String titel;
            titel = et_thema.getText()+ "";
            intent.putExtra(Intent.EXTRA_SUBJECT, titel);
            String body;
            String name;
            name = "Name: "+ et_name_aendern.getText();
            String semester;
            semester = "Semester: "+ et_semester.getText();

             String inhalt = tiet_Inhalt.getText() +"";
            body = name + " \n" + semester + " \n" + inhalt;
            intent.putExtra(Intent.EXTRA_TEXT, body);

            startActivity(Intent.createChooser(intent, "Wähle eine Applikation"));




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

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        hideNavigationBar();
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

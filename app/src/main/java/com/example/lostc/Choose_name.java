package com.example.lostc;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class Choose_name extends AppCompatActivity implements View.OnClickListener,HideNavigationBar {


    Button bt_bestaetigen;
    EditText et_nickname;
    TextView tv_wie_heißt_du;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_name);
        hideNavigationBar();

        bt_bestaetigen = (Button) findViewById(R.id.bt_bestaetigen);
        et_nickname = (EditText) findViewById(R.id.et_Nickname);
        tv_wie_heißt_du = (TextView) findViewById(R.id.tv_Wie_heißt_du);

        bt_bestaetigen.setOnClickListener(this);
        et_nickname.setOnClickListener(this);
        et_nickname.setOnEditorActionListener(editorListner);

        /**
         * Überprüfen ob bereits ein Username angelegt wurde
         */
        if(User.retriveUsername(this).isEmpty() || User.retriveUsername(this).equals("default_value")){

        }else{
            Intent intent = new Intent(this, Main_menue.class);
            startActivity(intent);
            this.finish();
        }
    }

    /**
     * Bestätigen und weiter durch klicken des Häckchens auf der Tastatur.
     */
    private TextView.OnEditorActionListener editorListner = new TextView.OnEditorActionListener() {
        @Override
        public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
            switch (actionId){
                case EditorInfo.IME_ACTION_DONE:
                    check_and_next();
                    break;
            }
            return false;
        }
    };


    /**
     * Bestätigen und weiter durch klicken des Buttons.
     * @param v
     */
    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.bt_bestaetigen:
                check_and_next();
                break;
                }
        }

    /**
     * Wird aufgerufen um die Gültigkeit des Usernamen zu überprüfen und um zur nächsten Ebene zu wechseln.
     * Eigene Methode, da der Schritt sowohl beim OnClick auf den Button als auch beim Klicken auf den hacken der Tastatur durchgeführt werden soll.
     */
        public void check_and_next() {
            //Überprüfen on name eingegben wurde
            if(String.valueOf(et_nickname.getText()).equals("Nickname hier eingeben")||String.valueOf(et_nickname.getText()).equals("") ){
                Toast.makeText(this,"kein gültiger Benutzername angegeben",Toast.LENGTH_SHORT).show();
            }else{
                User.insertUsername(this, et_nickname.getText().toString());
                Toast.makeText(Choose_name.this, "Registrierung erfolgreich", Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(this, Main_menue.class);
                startActivity(intent);
                this.finish();
        }
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
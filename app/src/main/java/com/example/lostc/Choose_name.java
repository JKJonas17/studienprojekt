package com.example.lostc;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.ButtonBarLayout;


import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class Choose_name extends AppCompatActivity implements View.OnClickListener {


    Button bt_bestaetigen;
    EditText et_nickname;
    TextView tv_wie_heißt_du;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_name);

        bt_bestaetigen = (Button) findViewById(R.id.bt_bestaetigen);
        et_nickname = (EditText) findViewById(R.id.et_Nickname);
        tv_wie_heißt_du = (TextView) findViewById(R.id.tv_Wie_heißt_du);

        bt_bestaetigen.setOnClickListener(this);
        et_nickname.setOnClickListener(this);


        if(User.retriveUsername(this).isEmpty() || User.retriveUsername(this).equals("default_value")){

        }else{
            Intent intent = new Intent(this, Main_menue.class);
            startActivity(intent);
        }
/*
        if(username != "")
        {
            username = username;
            Intent intent = new Intent(this, Main_menue.class);
            startActivity(intent);
        }

 */

    }



    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.bt_bestaetigen:
                //Überprüfen on name eingegben wurde
                if(String.valueOf(et_nickname.getText()).equals("Nickname hier eingeben")||String.valueOf(et_nickname.getText()).equals("") ){

                    //Hier muss eine Fehlermeldung erscheinen, dass man zuerst einen gültigen Nicknamen eingeben muss
                    Toast.makeText(this,"kein gültiger Benutzername angegeben",Toast.LENGTH_SHORT).show();
                }else{


                    User.insertUsername(this, et_nickname.getText().toString());

                    Intent intent = new Intent(this, Main_menue.class);
                    startActivity(intent);
                    this.finish();
                }
                break;

            case R.id.et_Nickname:

                break;
        }



    }
}
package com.example.lostc;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.ButtonBarLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;



public class Choose_name extends AppCompatActivity implements View.OnClickListener {


    Button bt_bestaetigen;
    EditText et_nickname;
    TextView tv_wie_heißt_du;
    public User activeUser;

    //Hier muss sowohl bei der Variable "static" angegeben werden, sonst funktionierts nicht. Aber ist das nicht falsch?
    static String nickname;
    static String username;
    public static String getNickname(){
        return nickname;
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_name);

        bt_bestaetigen = (Button) findViewById(R.id.bt_bestaetigen);
        et_nickname = (EditText) findViewById(R.id.et_Nickname);
        tv_wie_heißt_du = (TextView) findViewById(R.id.tv_Wie_heißt_du);

        bt_bestaetigen.setOnClickListener(this);
        et_nickname.setOnClickListener(this);

    }



    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.bt_bestaetigen:
                if(String.valueOf(et_nickname.getText()).equals("Nickname hier eingeben") ){

                    //Hier muss eine Fehlermeldung erscheinen, dass man zuerst einen gültigen Nicknamen eingeben muss

                }else{

                    nickname = String.valueOf(et_nickname.getText());
                    User activeUser = new User(nickname);
                    tv_wie_heißt_du.setText(activeUser.toString());
                    username = activeUser.toString();





                    Intent intent = new Intent(this, Main_menue.class);
                    startActivity(intent);
                    this.finish();
                }
                break;

            case R.id.et_Nickname:
                    //et_nickname.setText(null);
                break;
        }



    }
}

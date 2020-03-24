package com.example.lostc;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.util.List;

public class Quiz extends AppCompatActivity {

    private DBHelper myDB;
    private TextView tv_Question;
    private TextView tv_Score;
    private TextView tv_QuestionCount;
    private TextView tv_CountDown;
    private RadioGroup rb_Group;
    private RadioButton rb1;
    private RadioButton rb2;
    private RadioButton rb3;
    private RadioButton rb4;
    private Button buttonConfirmNext;

    private List<Question> questionList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        myDB = new DBHelper(this);

        tv_Question = findViewById(R.id.text_view_frage);
        tv_Score = findViewById(R.id.text_view_score);
        tv_QuestionCount = findViewById(R.id.text_view_countdown);
        tv_CountDown = findViewById(R.id.text_view_countdown);
        rb_Group = findViewById(R.id.radio_group);
        rb1 = findViewById(R.id.radio_button1);
        rb2 = findViewById(R.id.radio_button2);
        rb3 = findViewById(R.id.radio_button3);
        rb4 = findViewById(R.id.radio_button4);
        buttonConfirmNext = findViewById(R.id.button_confirm_next);



    }
}

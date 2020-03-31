package com.example.lostc;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

public class Quiz extends AppCompatActivity {

   private TextView tv_Frage;
   private RadioGroup rg_Group;
   private RadioButton rb_Option1 ;
   private RadioButton rb_Option2;
   private RadioButton rb_Option3;
   private RadioButton rb_Option4;
   private Button button_Confirm;
   private ColorStateList csl_DefaultRb;
   private static int counter = 0;
   private static int total = 0;
   private boolean answered = false;
   private static ArrayList <Question> questions = new ArrayList<>();
   private DatabaseHelper db;



    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        tv_Frage = findViewById(R.id.text_view_question);
        rg_Group = findViewById(R.id.radio_group);
        rb_Option1 = findViewById(R.id.radio_button1);
        rb_Option2 = findViewById(R.id.radio_button2);
        rb_Option3 = findViewById(R.id.radio_button3);
        rb_Option4 = findViewById(R.id.radio_button4);
        button_Confirm = findViewById(R.id.button_confirm_next);
        csl_DefaultRb = rb_Option1.getTextColors();


        db = new DatabaseHelper(this);
        File database = getApplicationContext().getDatabasePath(DatabaseHelper.DATABASE_NAME);

        if(!database.exists())
        {
            db.getReadableDatabase();

            if(copyDatabase(this))
            {
                Toast.makeText(this,"Copy database succes",Toast.LENGTH_SHORT).show();
            }
            else
            {
                Toast.makeText(this,"Copy data error",Toast.LENGTH_SHORT).show();
                return;
            }
        }

        questions = db.getQuestions();
        total = questions.size();
        showNextQuestion();

    }

    private boolean copyDatabase(Context context)
    {
        try
        {
            InputStream inputStream = context.getAssets().open(DatabaseHelper.DATABASE_NAME);
            String File = DatabaseHelper.DBLOCATION + DatabaseHelper.DATABASE_NAME;
            OutputStream outputStream = new FileOutputStream(File);
            byte[] buff = new byte[1024];
            int length = 0;

            while((length = inputStream.read(buff))> 0)
            {
                outputStream.write(buff, 0,length);
            }
            outputStream.flush();
            outputStream.close();
            Log.w("Quiz","DBCopied");
            return true;
        }
        catch(Exception e)
        {
            e.printStackTrace();
            return false;
        }

    }


    /**
     *
     */

    public void checkAnswer()
    {
        setAnswered(true);
        this.showSolution();
    }

    /**
     *
     *
     */
    public void showNextQuestion()
    {
        rb_Option1.setTextColor(csl_DefaultRb);
        rb_Option2.setTextColor(csl_DefaultRb);
        rb_Option3.setTextColor(csl_DefaultRb);
        rb_Option4.setTextColor(csl_DefaultRb);
        rg_Group.clearCheck();


                tv_Frage.setText(questions.get(counter).getQuestion());
                rb_Option1.setText(questions.get(counter).getOption1());
                rb_Option2.setText(questions.get(counter).getOption2());
                rb_Option3.setText(questions.get(counter).getOption3());
                rb_Option4.setText(questions.get(counter).getOption4());

                counter++;

        button_Confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                        if (rb_Option1.isChecked() || rb_Option2.isChecked() || rb_Option3.isChecked() || rb_Option4.isChecked()) {
                            setAnswered(true);
                            showSolution();
                        } else {
                            showNextQuestion();
                        }
                    }


        });


        }

    private void finishQuiz() {
        this.finish();
    }

    /**
     *
     */

    @SuppressLint("SetTextI18n")
    private void showSolution() {
        rb_Option1.setTextColor(Color.RED);
        rb_Option2.setTextColor(Color.RED);
        rb_Option3.setTextColor(Color.RED);
        rb_Option4.setTextColor(Color.RED);
                 int antwort_Nr = Integer.parseInt(questions.get(counter).getAnswerNr());

            switch (antwort_Nr) {
                case 1:
                    rb_Option1.setTextColor(Color.GREEN);
                    break;
                case 2:
                    rb_Option2.setTextColor(Color.GREEN);
                    break;
                case 3:
                    rb_Option3.setTextColor(Color.GREEN);
                    break;
                case 4:
                    rb_Option4.setTextColor(Color.GREEN);
                    break;
            }
            if (counter < total) {
                button_Confirm.setText("Next");
                showNextQuestion();
            } else {
                button_Confirm.setText("Finish");
            }
    }

        public void setAnswered(boolean answered)
        {
            this.answered = answered;
        }
}





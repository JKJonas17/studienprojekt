package com.example.lostc;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
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

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
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
   //final String dbname = "datenbank.db";
    //final String TABLE_NAME = "Fragen";


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

        csvToArray();
        total = questions.size();
        for(int i=0; i < questions.size();i++)
        {
            Log.wtf("questions",questions.get(i).toString());
        }

        showNextQuestion();

        button_Confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(!answered)
                {
                    if(rb_Option1.isChecked() || rb_Option2.isChecked() || rb_Option3.isChecked() || rb_Option4.isChecked())
                    {
                     checkAnswer();
                    }
                    else{

                     showNextQuestion();
                    }
                }
            }

        });

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

            if (total < questions.size())
            {
                tv_Frage.setText(questions.get(counter).getQuestion());
                rb_Option1.setText(questions.get(counter).getOption1());
                rb_Option2.setText(questions.get(counter).getOption2());
                rb_Option3.setText(questions.get(counter).getOption3());
                rb_Option4.setText(questions.get(counter).getOption4());

                counter++;

            }
            else
            {
                this.finishQuiz();
            }


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
            } else {
                button_Confirm.setText("Finish");
            }
    }

    /*
        public boolean firstStart()
        {
            boolean first = false;
            SharedPreferences sharedPreferences = getSharedPreferences("firstStart",MODE_PRIVATE);
            SharedPreferences.Editor sp_Editor =sharedPreferences.edit();
            if(sharedPreferences.getBoolean("firstStart",false) == false)
            {
                first = true;
                sp_Editor.putBoolean("firstStart",true);
                sp_Editor.commit();

            }

            return first;
        }

        */

    /**
     * erstellt die Datenbank schreibt Einträge in eine Liste
     */
    /*
    public void createDb()
        {
            try
            {
            String line = "";
            String columns = "FRAGE, A1, A2, A3, A4, A_Nr, K_Nr";
            String [] col = {"FRAGE", "A1", "A2", "A3", "A4", "A_Nr", "K_Nr"};
            String str1 = "INSERT INTO "+ TABLE_NAME + " (" + columns + ") VALUES(";
            SQLiteDatabase db = getBaseContext().openOrCreateDatabase(dbname, MODE_PRIVATE,null);
            db.execSQL("CREATE TABLE " + TABLE_NAME+ "(ID INTEGER PRIMARY KEY AUTOINCREMENT, FRAGE TEXT, A1 TEXT, A2 TEXT,A3 TEXT, A4 TEXT, A_Nr INTEGER,K_Nr INTEGER)" );
            int i = 0;

                db.beginTransaction();
                InputStream is = getAssets().open("raw/test.csv");
                BufferedReader csvReader = new BufferedReader(new InputStreamReader(is));
                while((line = csvReader.readLine()) != null)
                {
                    StringBuilder sb = new StringBuilder(str1);
                    String[] data = line.split(",");
                    sb.append("'"+data[0] + "', ");
                    sb.append("'"+data[1] + "', ");
                    sb.append("'"+data[2] + "', ");
                    sb.append("'"+data[3] + "', ");
                    sb.append("'"+data[4] + "', ");
                    sb.append(data[5] + ", ");
                    sb.append(data[6]);
                    sb.append(");");

                    db.execSQL(sb.toString());
                }

                db.setTransactionSuccessful();
                db.endTransaction();

                db.beginTransaction();

               Cursor c = db.query("FRAGEN",col,null,null,null,null,null);

                while(c.moveToNext())
                {
                    Question q = new Question();
                    q.setQuestion(c.getString(1));
                    q.setOption1(c.getString(2));
                    q.setOption2(c.getString(3));
                    q.setOption3(c.getString(4));
                    q.setOption4(c.getString(5));
                    q.setAnswerNr(c.getString(6));
                    q.setKategorieNr(c.getString(7));

                    this.questions.add(q);
                }

                c.close();
                is.close();
                csvReader.close();
                db.close();

            }
            catch(Exception e)
            {
                e.printStackTrace();
            }

        }
        */

        @SuppressLint("WrongConstant")
        @RequiresApi(api = Build.VERSION_CODES.KITKAT)
        public void csvToArray () {


            try
            {
            InputStream is =  getResources().openRawResource(R.raw.test);
            BufferedReader reader = new BufferedReader(new InputStreamReader(is, StandardCharsets.UTF_8));
            String line;

               while ((line = reader.readLine()) != null)
               {
                String [] data = line.split(",");
                Question q = new Question();
                q.setQuestion(data[0]);
                Log.println(1,"daten",data[0]);
                q.setOption1(data[1]);
                q.setOption2(data[2]);
                q.setOption3(data[3]);
                q.setOption4(data[4]);
                q.setAnswerNr(data[5]);
                q.setKategorieNr(data[6]);

                questions.add(q);
               }


                is.close();
                reader.close();

           }
           catch(IOException e)
           {
               Log.wtf("Quiz","Error beim File Lesen");
               e.printStackTrace();
           }


        }

        public void setAnswered(boolean answered)
        {
            this.answered = answered;
        }
}





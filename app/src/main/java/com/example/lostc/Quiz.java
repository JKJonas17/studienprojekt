package com.example.lostc;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;

public class Quiz extends AppCompatActivity {

    private TextView tv_Frage;
    private RadioGroup rg_Group;
    private RadioButton rb_Option1;
    private RadioButton rb_Option2;
    private RadioButton rb_Option3;
    private RadioButton rb_Option4;
    private Button button_Confirm;
    private static int counter = 0;
    private static int total = 0;
    private static ArrayList<Question> questions = new ArrayList<>();
    private DatabaseHelper db = new DatabaseHelper(this);
    private boolean counterIsRunning = false;
    private ProgressBar pb_Quiz;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        tv_Frage = findViewById(R.id.text_view_question);
        rg_Group = findViewById(R.id.radio_group);
        rb_Option1 = findViewById(R.id.radio_button1);
        rb_Option2 = findViewById(R.id.radio_button2);
        rb_Option3 = findViewById(R.id.radio_button3);
        rb_Option4 = findViewById(R.id.radio_button4);
        pb_Quiz = findViewById(R.id.pb_Quiz);
        button_Confirm = findViewById(R.id.button_confirm_next);

        rb_Option1.setOnClickListener(new View.OnClickListener() {
                                          @Override
                                          public void onClick(View v) {

                                              if(!counterIsRunning) {
                                                  startCounter();
                                                  counterIsRunning = true;
                                              }
                                          }

                                      }
        );

        rb_Option2.setOnClickListener(new View.OnClickListener() {
                                          @Override
                                          public void onClick(View v) {


                                              if(!counterIsRunning) {
                                                  startCounter();
                                                  counterIsRunning = true;
                                              }

                                          }


                                      }
        );
        rb_Option3.setOnClickListener(new View.OnClickListener() {
                                          @Override
                                          public void onClick(View v) {


                                              if(!counterIsRunning) {
                                                  startCounter();
                                                  counterIsRunning = true;
                                              }

                                          }


                                      }
        );

        rb_Option4.setOnClickListener(new View.OnClickListener() {
                                          @Override
                                          public void onClick(View v) {


                                              if(!counterIsRunning) {
                                                  startCounter();
                                                  counterIsRunning = true;
                                              }

                                          }


                                      }
        );

        button_Confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                    showNextQuestion();

            }


        });

        //String der aus Seekarte übergeben wurde wird in String kategorie übergeben
        Bundle bundle = getIntent().getExtras();
        String kategorie = bundle.getString("Kategorie");

        //Übergibt den Pfad der Datenbank an das eine Variable typ File
        File database = getApplicationContext().getDatabasePath(DatabaseHelper.DATABASE_NAME);

        if (!database.exists()) //wenn File nicht existiert
        {
            db.getReadableDatabase(); //erstellt oder öffnet eine Datenbank

            if (copyDatabase(this)) //gibt einen Toast aus wenn Datenbank erfolgreich kopiert wurde
            {
                Toast.makeText(this, "Copy database succes", Toast.LENGTH_SHORT).show();
            }
            else
            {
                Toast.makeText(this, "Copy data error", Toast.LENGTH_SHORT).show();
                return;
            }
        }

        //ArrayList mit Fragen der bestimmten Kategorie, String kategorie aus Seekarte wird übergeben
        questions = db.getQuestions(kategorie);
        total = questions.size();
        showNextQuestion();


    }

    /**
     * Liest Datenbank aus AssetFolder und schreibt diese in den Speicherort des Gerätespeichers
     * @param context wird an DatabaseHelper übergeben um Objekt zu erstellen
     * @return true wenn Kopie der Datenbank erfolgreich erstellt wurde
     */
    private boolean copyDatabase(Context context) {
        try {
            InputStream inputStream = context.getAssets().open(DatabaseHelper.DATABASE_NAME);
            String File = DatabaseHelper.DBLOCATION + DatabaseHelper.DATABASE_NAME;
            OutputStream outputStream = new FileOutputStream(File);
            byte[] buff = new byte[1024];
            int length;

            while ((length = inputStream.read(buff)) > 0) {
                outputStream.write(buff, 0, length);
            }
            outputStream.flush();
            outputStream.close();
            Log.w("Quiz", "DBCopied");
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

    }

    /**
     *Setzt alle RadioButton im Layout auf Transparent
     *Setzt Texte aus der Liste "question" in die TextView und in die RadioButtons
     * RadioButton onClickListener rufen Methode startCounter auf um den Progressbar zu starten
     *
     */
    public void showNextQuestion() {
        rb_Option1.setBackgroundColor(Color.TRANSPARENT);
        rb_Option2.setBackgroundColor(Color.TRANSPARENT);
        rb_Option3.setBackgroundColor(Color.TRANSPARENT);
        rb_Option4.setBackgroundColor(Color.TRANSPARENT);
        rg_Group.clearCheck();


        tv_Frage.setText(questions.get(counter).getQuestion());
        rb_Option1.setText(questions.get(counter).getOption1());
        rb_Option2.setText(questions.get(counter).getOption2());
        rb_Option3.setText(questions.get(counter).getOption3());
        rb_Option4.setText(questions.get(counter).getOption4());

        counterIsRunning = false;

        counter++;
        }


    private void finishQuiz() {
        button_Confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }


        });
    }

    /**
     *setzt die Zeit, die die Progressbar bis zum ende braucht
     * wird onFinish() aufgerufen wird showSolution() aufgerufen und die Lösungen angezeigt
     */
    private void startCounter() {
        pb_Quiz.setMax(3000);
        pb_Quiz.setProgress(0);
        new CountDownTimer(3000, 100) {

            public void onTick(long millisUntilFinished) {
                pb_Quiz.setProgress((int) millisUntilFinished);
            }

            public void onFinish() {
                showSolution();

            }
        }.start();
    }

    /**
     *Wenn richtige Antwort gecheckt wird => Hintergrund grün
     *sonst hintergrund rot und richtige Antwort grün
     *
     */
    @SuppressLint("SetTextI18n")
    private void showSolution() {

        int index = counter -1;
        int antwort_Nr = Integer.parseInt(questions.get(index).getAnswerNr()); // In DB steht ein String der geparset werden muss

        if (rb_Option1.isChecked()) {

            if(antwort_Nr == 1)
            {
                rb_Option1.setBackgroundColor(Color.GREEN);
            }
            if(antwort_Nr == 2)
            {
                rb_Option2.setBackgroundColor(Color.GREEN);
                rb_Option1.setBackgroundColor(Color.RED);
            }
            if(antwort_Nr == 3)
            {
                rb_Option3.setBackgroundColor(Color.GREEN);
                rb_Option1.setBackgroundColor(Color.RED);
            }
            if(antwort_Nr == 4)
            {
                rb_Option4.setBackgroundColor(Color.GREEN);
                rb_Option1.setBackgroundColor(Color.RED);
            }
        }

        if (rb_Option2.isChecked()) {

            if(antwort_Nr == 1)
                {
                    rb_Option1.setBackgroundColor(Color.GREEN);
                    rb_Option2.setBackgroundColor(Color.RED);
                }
            if(antwort_Nr == 2)
                {
                    rb_Option2.setBackgroundColor(Color.GREEN);
                }
            if(antwort_Nr == 3)
                {
                    rb_Option3.setBackgroundColor(Color.GREEN);
                    rb_Option2.setBackgroundColor(Color.RED);
                }
            if(antwort_Nr == 4)
                {
                    rb_Option4.setBackgroundColor(Color.GREEN);
                    rb_Option2.setBackgroundColor(Color.RED);
                }

                }

        if (rb_Option3.isChecked()) {
            if(antwort_Nr == 1)
                    {
                        rb_Option1.setBackgroundColor(Color.GREEN);
                        rb_Option3.setBackgroundColor(Color.RED);
                    }
            if(antwort_Nr == 2)
                    {
                        rb_Option2.setBackgroundColor(Color.GREEN);
                        rb_Option3.setBackgroundColor(Color.RED);
                    }
            if(antwort_Nr == 3)
                    {
                        rb_Option3.setBackgroundColor(Color.GREEN);
                    }
            if(antwort_Nr == 4)
                    {
                        rb_Option4.setBackgroundColor(Color.GREEN);
                        rb_Option3.setBackgroundColor(Color.RED);
                    }


                }
        if (rb_Option4.isChecked()) {
            if(antwort_Nr == 1)
                        {
                            rb_Option1.setBackgroundColor(Color.GREEN);
                            rb_Option4.setBackgroundColor(Color.RED);
                        }
            if(antwort_Nr == 2)
                        {
                            rb_Option2.setBackgroundColor(Color.GREEN);
                            rb_Option4.setBackgroundColor(Color.RED);
                        }
            if(antwort_Nr == 3)
                        {
                            rb_Option3.setBackgroundColor(Color.GREEN);
                            rb_Option4.setBackgroundColor(Color.RED);
                        }
            if(antwort_Nr == 4)
                        {
                            rb_Option4.setBackgroundColor(Color.GREEN);
                        }

                        }

            if (counter < total) {
                            button_Confirm.setText("Next");


            } else {
                            button_Confirm.setText("Finish");
                            finishQuiz();// in dieser Methode soll die nächste Aktivität geöffnet werden

                        }
    }

}




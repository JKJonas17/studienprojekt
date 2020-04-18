package com.example.lostc;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
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

    private String kategorie;
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
    private TextView tv_Score;
    private Intent intent;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);


        ImageButton ib_Button = findViewById(R.id.ib_backQuiz);
        tv_Frage = findViewById(R.id.text_view_question);
        rg_Group = findViewById(R.id.radio_group);
        rb_Option1 = findViewById(R.id.radio_button1);
        rb_Option2 = findViewById(R.id.radio_button2);
        rb_Option3 = findViewById(R.id.radio_button3);
        rb_Option4 = findViewById(R.id.radio_button4);
        pb_Quiz = findViewById(R.id.pb_Quiz);
        button_Confirm = findViewById(R.id.button_confirm_next);
        tv_Score = findViewById(R.id.tv_Score);

        tv_Score.setText("Score " + User.retriveScore(this));

        ib_Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openLogbuch(kategorie);

            }
        });

        rb_Option1.setOnClickListener(new View.OnClickListener() {
                                          @Override
                                          public void onClick(View v) {

                                              if (!counterIsRunning) {
                                                  startCounter();
                                                  counterIsRunning = true;
                                              }
                                          }

                                      }
        );

        rb_Option2.setOnClickListener(new View.OnClickListener() {
                                          @Override
                                          public void onClick(View v) {


                                              if (!counterIsRunning) {
                                                  startCounter();
                                                  counterIsRunning = true;
                                              }

                                          }


                                      }
        );
        rb_Option3.setOnClickListener(new View.OnClickListener() {
                                          @Override
                                          public void onClick(View v) {


                                              if (!counterIsRunning) {
                                                  startCounter();
                                                  counterIsRunning = true;
                                              }

                                          }


                                      }
        );

        rb_Option4.setOnClickListener(new View.OnClickListener() {
                                          @Override
                                          public void onClick(View v) {


                                              if (!counterIsRunning) {
                                                  startCounter();
                                                  counterIsRunning = true;
                                              }

                                          }


                                      }
        );


        button_Confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (total > counter) {
                    showNextQuestion();
                } else {
                    finishQuiz();// in dieser Methode soll die nächste Aktivität geöffnet werden
                }

            }


        });


        //String der aus Seekarte übergeben wurde wird in String kategorie übergeben
        Bundle bundle = getIntent().getExtras();
        kategorie = bundle.getString("Kategorie");

        //Übergibt den Pfad der Datenbank an eine Variable typ File
        File database = getApplicationContext().getDatabasePath(DatabaseHelper.DATABASE_NAME);

        if (!database.exists()) //wenn File nicht existiert
        {
            db.getReadableDatabase(); //erstellt oder öffnet eine Datenbank

            if (copyDatabase(this)) //gibt einen Toast aus wenn Datenbank erfolgreich kopiert wurde
            {
                Toast.makeText(this, "Copy database succes", Toast.LENGTH_SHORT).show();
            } else {
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
     *
     * @param context wird an DatabaseHelper übergeben um Objekt zu erstellen
     * @return true wenn Kopie der Datenbank erfolgreich erstellt wurde
     */
    private boolean copyDatabase(Context context) {
        try {
            InputStream inputStream = context.getAssets().open(DatabaseHelper.DATABASE_NAME);
            String file = context.getFilesDir().getParentFile().getPath() + "/databases/" + DatabaseHelper.DATABASE_NAME; // Traue dieser Änderung noch nicht doch es scheint zu funktionieren
            //   String file = DatabaseHelper.DBLOCATION + DatabaseHelper.DATABASE_NAME;
            OutputStream outputStream = new FileOutputStream(file);
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
     * Setzt alle RadioButton im Layout auf Transparent
     * Setzt Texte aus der Liste "question" in die TextView und in die RadioButtons
     * RadioButton onClickListener rufen Methode startCounter auf um den Progressbar zu starten
     */
    public void showNextQuestion() {

        rg_Group.clearCheck();
        if (questions.get(counter).getOption4().equals("-")) {
            rb_Option1.setBackgroundColor(Color.TRANSPARENT);
            rb_Option2.setBackgroundColor(Color.TRANSPARENT);
            rb_Option3.setBackgroundColor(Color.TRANSPARENT);
            rb_Option4.setVisibility(View.GONE);

            tv_Frage.setText(questions.get(counter).getQuestion());
            rb_Option1.setText(questions.get(counter).getOption1());
            rb_Option2.setText(questions.get(counter).getOption2());
            rb_Option3.setText(questions.get(counter).getOption3());
        }
        if (questions.get(counter).getOption3().equals("-")) {
            rb_Option1.setBackgroundColor(Color.TRANSPARENT);
            rb_Option2.setBackgroundColor(Color.TRANSPARENT);
            rb_Option3.setVisibility(View.GONE);
            rb_Option4.setVisibility(View.GONE);
            tv_Frage.setText(questions.get(counter).getQuestion());
            rb_Option1.setText(questions.get(counter).getOption1());
            rb_Option2.setText(questions.get(counter).getOption2());
        } else {
            rb_Option1.setBackgroundColor(Color.TRANSPARENT);
            rb_Option2.setBackgroundColor(Color.TRANSPARENT);
            rb_Option3.setBackgroundColor(Color.TRANSPARENT);
            rb_Option4.setBackgroundColor(Color.TRANSPARENT);

            tv_Frage.setText(questions.get(counter).getQuestion());
            rb_Option1.setText(questions.get(counter).getOption1());
            rb_Option2.setText(questions.get(counter).getOption2());
            rb_Option3.setText(questions.get(counter).getOption3());
            rb_Option4.setText(questions.get(counter).getOption4());
        }
        counterIsRunning = false;

        counter++;
    }


    private void finishQuiz() {

        if (db.levelup(kategorie) > 0.8) { //80% der Fragen müssen richtig beantwortet werden um ein Level auf zu steigen
            openGewonnen();
        } else {
            openVerloren();
        }

        button_Confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


            }


        });
    }

    /**
     * setzt die Zeit, die die Progressbar bis zum ende braucht
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
     * Wenn richtige Antwort gecheckt wird => Hintergrund grün
     * sonst hintergrund rot und richtige Antwort grün
     */
    @SuppressLint("SetTextI18n")
    private void showSolution() {

        int index = counter - 1;
        int antwort_Nr = Integer.parseInt(questions.get(index).getAnswerNr()); // In DB steht ein String der geparset werden muss
        boolean correct = false;

        if (rb_Option1.isChecked()) {

            if (antwort_Nr == 1) {
                rb_Option1.setBackgroundColor(Color.GREEN);
                correct = true;
            }
            if (antwort_Nr == 2) {
                rb_Option2.setBackgroundColor(Color.GREEN);
                rb_Option1.setBackgroundColor(Color.RED);
            }
            if (antwort_Nr == 3) {
                rb_Option3.setBackgroundColor(Color.GREEN);
                rb_Option1.setBackgroundColor(Color.RED);
            }
            if (antwort_Nr == 4) {
                rb_Option4.setBackgroundColor(Color.GREEN);
                rb_Option1.setBackgroundColor(Color.RED);
            }
        }

        if (rb_Option2.isChecked()) {

            if (antwort_Nr == 1) {
                rb_Option1.setBackgroundColor(Color.GREEN);
                rb_Option2.setBackgroundColor(Color.RED);
            }
            if (antwort_Nr == 2) {
                rb_Option2.setBackgroundColor(Color.GREEN);
                correct = true;
            }
            if (antwort_Nr == 3) {
                rb_Option3.setBackgroundColor(Color.GREEN);
                rb_Option2.setBackgroundColor(Color.RED);
            }
            if (antwort_Nr == 4) {
                rb_Option4.setBackgroundColor(Color.GREEN);
                rb_Option2.setBackgroundColor(Color.RED);
            }

        }

        if (rb_Option3.isChecked()) {
            if (antwort_Nr == 1) {
                rb_Option1.setBackgroundColor(Color.GREEN);
                rb_Option3.setBackgroundColor(Color.RED);
            }
            if (antwort_Nr == 2) {
                rb_Option2.setBackgroundColor(Color.GREEN);
                rb_Option3.setBackgroundColor(Color.RED);
            }
            if (antwort_Nr == 3) {
                rb_Option3.setBackgroundColor(Color.GREEN);
                correct = true;
            }
            if (antwort_Nr == 4) {
                rb_Option4.setBackgroundColor(Color.GREEN);
                rb_Option3.setBackgroundColor(Color.RED);
            }


        }
        if (rb_Option4.isChecked()) {
            if (antwort_Nr == 1) {
                rb_Option1.setBackgroundColor(Color.GREEN);
                rb_Option4.setBackgroundColor(Color.RED);
            }
            if (antwort_Nr == 2) {
                rb_Option2.setBackgroundColor(Color.GREEN);
                rb_Option4.setBackgroundColor(Color.RED);
            }
            if (antwort_Nr == 3) {
                rb_Option3.setBackgroundColor(Color.GREEN);
                rb_Option4.setBackgroundColor(Color.RED);
            }
            if (antwort_Nr == 4) {
                rb_Option4.setBackgroundColor(Color.GREEN);
                correct = true;
            }

        }
        // Wenn correct true ist und der Wert in der DB für "Answered" 0(unbeantwortet) oder 1(letztes mal falsch beantwortet) beträgt
        if (correct && (questions.get(index).getAnswered().equals("0") || questions.get(index).getAnswered().equals("1"))) {
            setPoints();
            tv_Score.setText("Score " + User.retriveScore(this));

        }
        db.setAnswered(questions.get(index).getId(), correct);

        if (counter < total) {
            button_Confirm.setText("Next");

        } else {
            button_Confirm.setText("Finish");


        }
    }

    private void setPoints() {
        if (kategorie.equals("1") || kategorie.equals("2")) {
            User.insertScore(this, User.retriveScore(this) + 10);
        }
        if (kategorie.equals("3") || kategorie.equals("4")) {
            User.insertScore(this, User.retriveScore(this) + 15);
        }
        if (kategorie.equals("5") || kategorie.equals("6")) {
            User.insertScore(this, User.retriveScore(this) + 20);
        }
        if (kategorie.equals("7") || kategorie.equals("8")) {
            User.insertScore(this, User.retriveScore(this) + 25);
        }
    }

    /**
     * Methode für das öffnen der vorhergehenden Aktivität
     *
     * @param kategorie
     */
    public void openLogbuch(String kategorie) {
        intent = new Intent(this, Logbuch.class);
        intent.putExtra("Kategorie", kategorie);
        startActivity(intent);
    }

    public void openVerloren() {
        intent = new Intent(this, Verloren.class);
        startActivity(intent);
    }

    public void openGewonnen() {
        intent = new Intent(this, Gewonnen.class);
        startActivity(intent);
    }


}




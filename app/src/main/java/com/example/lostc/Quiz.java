package com.example.lostc;

import androidx.appcompat.app.AppCompatActivity;

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
import java.util.ArrayList;

import static com.example.lostc.User.getPrefs;

/**
 * diese Klasse beinhaltet den Quiz Algorithmus
 */

public class Quiz extends AppCompatActivity {

    /*Layout Variablen*/
    private RadioGroup rg_Group;
    private RadioButton rb_Option1;
    private RadioButton rb_Option2;
    private RadioButton rb_Option3;
    private RadioButton rb_Option4;
    private Button button_Confirm;
    private ImageButton ib_backQuiz;
    private TextView tv_Frage;
    private ProgressBar pb_Quiz;
    private TextView tv_Score;
    private Intent intent;
    private TextView tv_QuizKapitel;
    private TextView tv_FragenAnzahl;
    private TextView tv_Info;

    /*Algorithmus Variablen*/
    private String kategorie;
    private static int counter = 0;
    private static int total = 0;
    private boolean counterIsRunning = false;
    private static boolean answered = false;

    /*Datenbank Variablen*/
    private static ArrayList<Question> questions = new ArrayList<>();
    private DatabaseHelper db = new DatabaseHelper(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        /*Layout Variablen */
        ib_backQuiz = findViewById(R.id.ib_backQuiz);
        tv_Frage = findViewById(R.id.text_view_question);
        rg_Group = findViewById(R.id.radio_group);
        rb_Option1 = findViewById(R.id.radio_button1);
        rb_Option2 = findViewById(R.id.radio_button2);
        rb_Option3 = findViewById(R.id.radio_button3);
        rb_Option4 = findViewById(R.id.radio_button4);
        pb_Quiz = findViewById(R.id.pb_Quiz);
        button_Confirm = findViewById(R.id.button_confirm_next);
        tv_Score = findViewById(R.id.tv_Score);
        tv_QuizKapitel = findViewById(R.id.tv_QuizKapitel);
        tv_FragenAnzahl = findViewById(R.id.tv_FragenAnzahl);
        tv_Info = findViewById(R.id.tv_Info);

        //Setzt den aktuellen Score
        tv_Score.setText(""+User.retriveScore(this));

        //String der aus Seekarte übergeben wurde wird in String kategorie übergeben
        Bundle bundle = getIntent().getExtras();
        kategorie = bundle.getString("Kategorie");

        tv_QuizKapitel.setText(this.getKapitelbyKat(kategorie));

        // Info das Spieler über 80 % der Fragen beantworten muss, wird nur im ersten Level angezeigt

        ib_backQuiz.setOnClickListener(new View.OnClickListener() {
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

        /*
         * Confirm-Button um Frage zu überspringen, nächste Frage anzeigen zu lassen oder Quiz zu beenden
         * wenn counter die Größe des Array nicht überschritten
         * und wenn die Frage noch nicht beantwortet wurde
         * dann wir der counter inkrementiert , der ArrayState auf den counter stand gesetzt und die nächste Frage angezeigt
         * sonst methode finishQuiz() aufgerufen um das quiz zu beenden
         */
        button_Confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (counter < (total - 1) ) {
                    if(counter == (total-2))
                    {
                        button_Confirm.setText(R.string.beenden);
                    }
                        counter++;
                    if(!answered) {
                        setArrayPosition(Quiz.this, counter, kategorie); // ArrayState wird an counter angepasst
                    }
                        int val = getArrayPosition(Quiz.this, kategorie);
                    showNextQuestion();

                }
                else {
                    counter = 0;
                    setArrayPosition(Quiz.this, 0, kategorie);
                    finishQuiz();// in dieser Methode soll die nächste Aktivität geöffnet werden
                }
            }

        });

        //ArrayList mit Fragen der bestimmten Kategorie, String kategorie aus Seekarte wird übergeben
        questions = db.getQuestions(kategorie);
        total = questions.size();
        counter = getArrayPosition(this, kategorie);
        int val = getArrayPosition(this, kategorie);
        showNextQuestion();
    }

    /**
     * gibt für die jeweiligen Kategorie den dazugehörigen String für die Kapitelüberschrift zurück
     * @param kategorie String aus putExtra
     * @return String der in tv_QuizKapitel verwendet wird
     */
    public String getKapitelbyKat(String kategorie)
    {
        String kapitel ="";
        if(kategorie.equals("1"))
        {
            kapitel = "Grundlagen";
        }
       else if(kategorie.equals("2"))
        {
            kapitel = "Datentypen";
        }
      else  if(kategorie.equals("3"))
        {
            kapitel = "Entscheidungen";
        }
       else if(kategorie.equals("4"))
        {
            kapitel = "Schleifen";
        }
      else  if(kategorie.equals("5"))
        {
            kapitel = "Funktionen";
        }
       else if(kategorie.equals("6"))
        {
            kapitel = "Arrays";
        }
       else if(kategorie.equals("7"))
        {
            kapitel = "Variablen";
        }
       else if(kategorie.equals("8"))
        {
            kapitel = "Präprozessor";
        }
        else if(kategorie.equals("9"))
        {
            kapitel = "Pointer";
        }
        else if(kategorie.equals("10"))
        {
            kapitel = "Dateizugriff";
        }

       return kapitel;
    }

    /**
     * Setzt alle RadioButton im Layout auf Transparent
     * Setzt Texte aus der Liste "question" in die TextView und in die RadioButtons
     * RadioButton onClickListener rufen Methode startCounter auf um den Progressbar zu starten
     */
    public void showNextQuestion() {

        if(counter!=0)
        {
            tv_Info.setVisibility(View.GONE);
        }
        answered = false;
        int anzahl = counter +1;
        tv_FragenAnzahl.setText("Frage: "+anzahl+"/"+total);
        rb_Option1.setVisibility(View.VISIBLE);
        rb_Option2.setVisibility(View.VISIBLE);
        rb_Option3.setVisibility(View.VISIBLE);
        rb_Option4.setVisibility(View.VISIBLE);

        rg_Group.clearCheck();
        if (questions.get(counter).getOption4().equals("-")) {
            rb_Option4.setVisibility(View.GONE);
            rb_Option1.setBackgroundColor(Color.TRANSPARENT);
            rb_Option2.setBackgroundColor(Color.TRANSPARENT);
            rb_Option3.setBackgroundColor(Color.TRANSPARENT);

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

    }

    /**
     * setzt die Zeit, die die Progressbar bis zum ende braucht
     * wird onFinish() aufgerufen wird showSolution() aufgerufen und die Lösungen angezeigt
     */
    public void startCounter() {
        pb_Quiz.setMax(3000);
        pb_Quiz.setProgress(0);
        new CountDownTimer(3000, 100) {

            public void onTick(long millisUntilFinished) {
                pb_Quiz.setProgress((int) millisUntilFinished);
                button_Confirm.setVisibility(View.GONE);
                ib_backQuiz.setOnClickListener(null); // während der Timer läuft soll der backbutton nicht clickbar sein

            }

            public void onFinish() {
                button_Confirm.setVisibility(View.VISIBLE);
                pb_Quiz.setProgress(0);
                ib_backQuiz.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        openLogbuch(kategorie);
                    }
                });

                showSolution();
            }
        }.start();
    }

    /**
     * Wenn richtige Antwort gecheckt wird => Hintergrund grün
     * sonst hintergrund rot und richtige Antwort grün
     */
    public void showSolution() {

        int antwort_Nr = Integer.parseInt(questions.get(counter).getAnswerNr()); // In DB steht ein String der geparset werden muss
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
        if (correct && (questions.get(counter).getAnswered().equals("0") || questions.get(counter).getAnswered().equals("1"))) {
            setPoints();
            tv_Score.setText(""+User.retriveScore(this));
        }
        answered = true;
        int pos = counter +1;
        if(getArrayPosition(this,kategorie)<(total-1)) {
            setArrayPosition(this, pos, kategorie);
        }
        int val = getArrayPosition(this, kategorie);
        Log.i("counter4","stateshow: "+val);

        //Toast.makeText(this, "correct " + correct, Toast.LENGTH_SHORT).show();
        db.setAnswered(questions.get(counter).getId(), correct);
    }

    /**
     * setzt den Score des Users abhängig von der Kategorie
     */
    public void setPoints() {
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
        if (kategorie.equals("9") || kategorie.equals("10")) {
            User.insertScore(this, User.retriveScore(this) + 30);
        }
    }

    /**
     * Gibt die Postion der zuletzt aufgerufenen Frage zurück
     *
     * @param context   dieser Context
     * @param state     die Position im Array der Frage
     * @param kategorie abhängig von der Kategorie in der der User sich befindet
     */
    public static void setArrayPosition(Context context, int state, String kategorie) {
        SharedPreferences.Editor editor = getPrefs(context).edit();

        if (kategorie.equals("1")) {
            editor.putInt("1", state); //Grundlagen
            editor.commit();
        }
        if (kategorie.equals("2")) {
            editor.putInt("2", state); //Datentypen
            editor.commit();
        }
        if (kategorie.equals("3")) {
            editor.putInt("3", state); //Entscheidungen
            editor.commit();
        }
        if (kategorie.equals("4")) {
            editor.putInt("4", state); //Schleifen
            editor.commit();
        }
        if (kategorie.equals("5")) {
            editor.putInt("5", state); //Funktionen
            editor.commit();
        }
        if (kategorie.equals("6")) {
            editor.putInt("6", state); //Arrays
            editor.commit();
        }
        if (kategorie.equals("7")) {
            editor.putInt("7", state); //Variablen
            editor.commit();
        }
        if (kategorie.equals("8")) {
            editor.putInt("8", state); //Präprozessor
            editor.commit();
        }
        if (kategorie.equals("9")) { //Pointer
            editor.putInt("9", state);
            editor.commit();
        }
        if (kategorie.equals("10")) { //Dateizugriff
            editor.putInt("10", state);
            editor.commit();
        }


    }

    /**
     * Gibt die Aktuelle Position zurück
     *
     * @param context   dieser context
     * @param kategorie aktuelle Kategorie aus Seekarte
     * @return int Position im Array
     */
    public static int getArrayPosition(Context context, String kategorie) {
        return getPrefs(context).getInt(kategorie, 0);
    }

    /**
     * Öffnet Aktivität Gewonnen wenn User mehr als 80% der Fragen richtig hat
     * Verloren sonst
     */
    public void finishQuiz() {
        int val = getArrayPosition(this, kategorie);
        double avg = db.levelup(kategorie);
        double lvlup = 0.8;
        if (avg >= lvlup) { //80% der Fragen müssen richtig beantwortet werden um ein Level auf zu steigen
            if(kategorie.equals("10")) {
               openEasterEgg();
            }
            else {
                openGewonnen(avg, kategorie);
            }

        } else{
            openVerloren(kategorie,avg);
        }
    }

    /**
     * Methode für das öffnen der vorhergehenden Aktivität
     *
     * @param kategorie übergibt die aktuelle Kategorie aus Seekarte
     */
    private void openLogbuch(String kategorie) {
        intent = new Intent(this, Logbuch.class);
        intent.putExtra("Kategorie", kategorie);
        startActivity(intent);
        this.finish();
    }

    /**
     * wird geöffnet falls User weniger als 80% der Fragen richtig beantwortet hat
     *
     * @param kategorie übergibt die aktuelle Kategorie aus Seekarte um das richtige Quiz wieder zu öffnen
     * @param avg übergibt den prozentualen Anteil der Richtig beantworteten Fragen
     *
     */
    private void openVerloren(String kategorie, double avg) {
        intent = new Intent(this, Verloren.class);
        intent.putExtra("Kategorie", kategorie);
        intent.putExtra("Avarage",avg);
        startActivity(intent);
        this.finish();
    }

    /**
     * wird geöffnet falls der User über 80% der Fragen richtig beantwortet hat
     *  @param avg übergibt den prozentualen Anteil der Richtig beantworteten Fragen
     */
    private void openGewonnen(double avg, String kategorie) {
        int kat = Integer.parseInt(kategorie);
        int level = User.retriveLevel(this);
       if(kat == level && level < 10) {
            User.insertLevel(this, User.retriveLevel(this) + 1);
        }
        intent = new Intent(this, Gewonnen.class);
        intent.putExtra("Avarage",avg);
        startActivity(intent);
        this.finish();
    }

    /**
     * öffnet die Ebene EasterEgg wenn der Spieler alle Level durchgespielt hat
     */
    private void openEasterEgg()
    {
        intent = new Intent(this,EasterEgg.class);
        startActivity(intent);
        this.finish();
    }

}




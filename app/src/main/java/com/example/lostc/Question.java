package com.example.lostc;

public class Question {

    private String frage;
    private String antwort1;
    private String antwort2;
    private String antwort3;
    private String antwort4;
    private int answerNr;

    public Question()
    {
    }

    public Question(String frage, String antwort1, String antwort2, String antwort3, String antwort4, int answerNr)
    {
        this.frage = frage;
        this.antwort1 = antwort1;
        this.antwort2 = antwort2;
        this.antwort3 = antwort3;
        this.antwort4 = antwort4;
        this.answerNr = answerNr;
    }

    public String getFrage() {
        return frage;
    }

    public void setFrage(String frage) {
        this.frage = frage;
    }

    public String getAntwort1() {
        return antwort1;
    }

    public void setAntwort1(String antwort1) {
        this.antwort1 = antwort1;
    }

    public String getAntwort2() {
        return antwort2;
    }

    public void setAntwort2(String antwort2) {
        this.antwort2 = antwort2;
    }

    public String getAntwort3() {
        return antwort3;
    }

    public void setAntwort3(String antwort3) {
        this.antwort3 = antwort3;
    }

    public String getAntwort4() {
        return antwort4;
    }

    public void setAntwort4(String antwort4) {
        this.antwort4 = antwort4;
    }

    public int getAnswerNr() {
        return answerNr;
    }

    public void setAnswerNr(int answerNr) {
        this.answerNr = answerNr;
    }
}

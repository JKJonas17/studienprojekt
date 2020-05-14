package com.example.lostc;

import android.content.Context;
import android.content.SharedPreferences;

public class User {
    /**
     * Die Methode muss erstellt werden, damit man SharedPreferences als "static" verwenden kann.
     * Beim Aufrufen der Methode ist es hier in den meisten Fällen ausreichend "this" zu verwenden.
     * @param context
     * @return
     */
    public static SharedPreferences getPrefs(Context context){
        return context.getSharedPreferences("user_configuration",Context.MODE_PRIVATE);
    }
    //Öffnen bzw Erstellen der Shared Preferences Datei, Editor wird gebraucht zum verändern

    /**
     * Spezifische Key-values in den SharedPreferences können erstellt, bzw verändert werden.
     * @param context
     * @param key
     * @param value
     */
    public static void insertUserData(Context context,String key, String value){
        SharedPreferences.Editor editor = getPrefs(context).edit();
        editor.putString(key, value);
        editor.apply();
    }

    /**
     * Schreibt den übergebenen String in die Shared Pref Datei in die Spalte "username"
     * @param context
     * @param username_value
     */
    public static void insertUsername(Context context, String username_value){
        SharedPreferences.Editor editor = getPrefs(context).edit();
        editor.putString("username", username_value);
        editor.apply();
    }

    /**
     * Schreibt den übergebenen Integer in die Shared Pref Datei in die Spalte "score"
     * @param context
     * @param score_value
     */
    public static void insertScore(Context context, int score_value){
        SharedPreferences.Editor editor = getPrefs(context).edit();
        editor.putInt("score", score_value);
        editor.apply();
    }

    public static void insertLevel(Context context, int level_value){
        SharedPreferences.Editor editor = getPrefs(context).edit();
        editor.putInt("current_level", level_value);
        editor.apply();
    }

    /**
     * Gibt den Wert der "Spalte" username aus.
     * @param context
     * @return
     */
    public static String retriveUsername(Context context){
        return getPrefs(context).getString("username", "default_value");
    }

    /**
     * Gibt den Wert der "Spalte" score aus.
     * @param context
     * @return
     */
    public static int retriveScore(Context context){
        return getPrefs(context).getInt("score", 0);
    }

    public static int retriveLevel(Context context){
        return getPrefs(context).getInt("current_level", 1);
    }

    /**
     * Löscht username und score aus der SharedPreferences-Datei
     * @param context
     */
    //Setzt den score zurück
    public static void resetScore(Context context){
        SharedPreferences.Editor editor = getPrefs(context).edit();
        editor.remove("score");
        editor.apply();
    }


    /*Gibt true zurück, wenn es bereits einen eintrag bei user_config gibt
    public boolean checkUser(){
        return mySPR.contains("user_config");
    }*/


}

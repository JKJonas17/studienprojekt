package com.example.lostc;

import android.content.Context;
import android.content.SharedPreferences;



public class User {

    public static SharedPreferences getPrefs(Context context){
        return context.getSharedPreferences("user_configuration",Context.MODE_PRIVATE);
    }
    //Öffnen bzw Erstellen der Shared Preferences Datei, Editor wird gebraucht zum verändern

    public static void insertUserData(Context context,String key, String value){
        SharedPreferences.Editor editor = getPrefs(context).edit();
        editor.putString(key, value);
        editor.commit();
    }

    //Schreibt den übergebenen String in die Shared Pref Datei in die Spalte "username"
    public static void insertUsername(Context context, String username_value){
        SharedPreferences.Editor editor = getPrefs(context).edit();
        editor.putString("username", username_value);
        editor.commit();
    }

    public static void insertScore(Context context, int score_value){
        SharedPreferences.Editor editor = getPrefs(context).edit();
        editor.putInt("score", score_value);
        editor.commit();
    }


    //Gibt "Spalte" username aus
    public static String retriveUsername(Context context){
        return getPrefs(context).getString("username", "default_value");
    }

    public static int retriveScore(Context context){
        return getPrefs(context).getInt("score", 0);
    }

    //Setzt den gesamten user (username und score) zurück
    public static void resetUser(Context context){
        SharedPreferences.Editor editor = getPrefs(context).edit();
        editor.remove("username");
        editor.remove("score");
        editor.commit();
    }



    /*Gibt true zurück, wenn es bereits einen eintrag bei user_config gibt
    public boolean checkUser(){
        return mySPR.contains("user_config");
    }*/


}

package com.example.lostc;

import androidx.annotation.NonNull;

public class User {

    private static int userID = 999;
    private String nickname;
    private int punktekonto;


    public User(String n){
        this.setNickname(n);
        this.setUserID(userID + 1);
    }
    public static int getUserID() {
        return userID;
    }

    public String getNickname() {
        return nickname;
    }


    public static void setUserID(int userID) {
        User.userID = userID;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public int getPunktekonto() {
        return punktekonto;
    }

    public void setPunktekonto(int punktekonto) {
        this.punktekonto = punktekonto;
    }

    @NonNull
    @Override
    public String toString() {
        return "Name: " + this.getNickname() + ", UserID: " + this.getUserID();
    }
}

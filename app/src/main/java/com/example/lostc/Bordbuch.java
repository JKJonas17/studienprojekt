package com.example.lostc;

import android.graphics.Typeface;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.StyleSpan;
import android.text.style.UnderlineSpan;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Bordbuch extends AppCompatActivity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bordbuch_grundlagen);

        TextView tv_txt_bordbuch_grundlagen = findViewById(R.id.tv_txt_bordbuch_grundlagen);

        String Grundlagen = "@string/large_text_grundlagen";
        SpannableString ss = new SpannableString(Grundlagen);

        StyleSpan italicSpan = new StyleSpan(Typeface.ITALIC);
        UnderlineSpan underlineSpan = new UnderlineSpan();

        ss.setSpan(italicSpan, 1, 40, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        ss.setSpan(italicSpan, 60, 100, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        tv_txt_bordbuch_grundlagen.setText(ss);
    }
}

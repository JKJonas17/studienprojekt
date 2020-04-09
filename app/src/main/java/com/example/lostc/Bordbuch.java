package com.example.lostc;

import android.content.Context;
import android.graphics.Typeface;
import android.os.Bundle;
import android.text.Html;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.StyleSpan;
import android.text.style.UnderlineSpan;
import android.webkit.WebView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Bordbuch extends AppCompatActivity {

 String basePath = "file:///android_asset/Infotexte/";

 protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bordbuch_grundlagen);

        WebView webView = findViewById(R.id.wv_infotext);
        webView.setBackgroundColor(0);              // Macht den Hintergrund Transparent
        webView.loadUrl(basePath+ "grundlagen.html");

    }
}

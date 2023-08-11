package com.omkardhage4535.math_master;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class WebViewActivity extends AppCompatActivity {


    private WebView webView;

    @SuppressLint("SetJavaScriptEnabled")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view);

        String url = getIntent().getStringExtra("url");

        webView = findViewById(R.id.webview);
        webView.getSettings().setJavaScriptEnabled(true);  // Enable JavaScript if needed
        webView.setWebViewClient(new WebViewClient());
        webView.loadUrl(url);
    }
}
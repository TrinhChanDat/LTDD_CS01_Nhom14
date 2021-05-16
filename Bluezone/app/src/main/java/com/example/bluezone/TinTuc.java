package com.example.bluezone;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;

public class TinTuc extends AppCompatActivity {

    private WebView Web;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tin_tuc);


        Web = (WebView)findViewById(R.id.webTinTuc);
        Web.setWebViewClient(new MyWebViewClient());
        WebSettings webSettings = Web.getSettings();
        webSettings.setBuiltInZoomControls(true);
        webSettings.setDomStorageEnabled(true);
        webSettings.setJavaScriptEnabled(true);
        Web.loadUrl("https://ncov.moh.gov.vn/web/guest/tin-tuc");
    }


    @Override
    public void onBackPressed() {
        if(Web.canGoBack()){
            Web.goBack();
        }
        else{
            super.onBackPressed();
        }

    }
}
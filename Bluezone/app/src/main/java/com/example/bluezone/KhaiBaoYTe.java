package com.example.bluezone;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;

public class KhaiBaoYTe extends AppCompatActivity {

    private WebView web;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_khai_bao_yte);

        web = (WebView)findViewById(R.id.webKBYT);
        web.setWebViewClient(new MyWebViewClient());
        web.loadUrl("https://tokhaiyte.vn/");
    }

    @Override
    public void onBackPressed() {
        if(web.canGoBack()){
            web.goBack();
        }
        else{
            super.onBackPressed();
        }
    }
}
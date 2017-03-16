package com.example.emillemartins.agendinha;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.EditText;



public class SiteActivity extends AppCompatActivity {

    private EditText etURL;
    private WebView webview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_site);

        etURL = (EditText) findViewById(R.id.etURL);

        webview = (WebView) findViewById(R.id.webview);
        webview.setWebViewClient(new CustomWebClient());
        webview.getSettings().setLoadsImagesAutomatically(true);
        webview.getSettings().setJavaScriptEnabled(true);
        webview.getSettings().setSupportZoom(true);

    }

    public void openURL(View v) {
        webview.loadUrl(etURL.getText().toString());
    }

    private class CustomWebClient extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);
            return false;
        }
    }
}

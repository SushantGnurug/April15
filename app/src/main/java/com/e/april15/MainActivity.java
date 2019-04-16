package com.e.april15;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;

public class MainActivity extends AppCompatActivity {
AutoCompleteTextView autoOccupation;
String [] occupations;
WebView webView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        autoOccupation = findViewById(R.id.atv);
        occupations = getResources().getStringArray(R.array.occupations);
        autoOccupation.setAdapter(new ArrayAdapter<String>(
                this,android.R.layout.select_dialog_item
                ,occupations
        ));
        webView = findViewById(R.id.web);
        webView.setWebViewClient(new MyBrowser());
        webView.loadUrl("https://lms.softwarica.edu.np");
        webView.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
        webView.getSettings().setLoadsImagesAutomatically(true);
        webView.setScrollBarStyle(webView.SCROLLBARS_INSIDE_OVERLAY);
    }
    public class MyBrowser extends WebViewClient{
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
           view.loadUrl(request.getUrl().toString());
            return super.shouldOverrideUrlLoading(view, request);
        }
    }
}

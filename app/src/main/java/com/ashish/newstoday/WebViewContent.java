package com.ashish.newstoday;

import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;

import androidx.activity.EdgeToEdge;
import androidx.activity.OnBackPressedCallback;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class WebViewContent extends AppCompatActivity {

    String contentUrl;
    private WebView idWVContent;
    private ProgressBar idWVProgressBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_web_view_content);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        contentUrl = getIntent().getStringExtra("ContentUrl");
        idWVContent = findViewById(R.id.idWVContent);
        idWVProgressBar = findViewById(R.id.idWVProgressBar);
        idWVContent.getSettings().setJavaScriptEnabled(true);
        idWVContent.loadUrl(contentUrl);
        idWVContent.setWebViewClient(new WebViewClient(){
            @Override
            public void onPageStarted(WebView view, String url, android.graphics.Bitmap favicon) {
                idWVProgressBar.setVisibility(View.VISIBLE);
                super.onPageStarted(view, url, favicon);
            }

            @Override
            public void onPageFinished(WebView view, String url) {
                idWVProgressBar.setVisibility(View.INVISIBLE);
                super.onPageFinished(view, url);
            }
        });
        OnBackPressedCallback callback = new OnBackPressedCallback(true) {
            @Override
            public void handleOnBackPressed() {
                if (idWVContent.canGoBack()) {
                    idWVContent.goBack();
                } else {
                    // If the WebView cannot go back, use the default back behavior
                    finish();
                }
            }
        };
        getOnBackPressedDispatcher().addCallback(this, callback);
    }
}
package com.family.aitutor;

import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.webkit.WebResourceRequest;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        WebView webView = findViewById(R.id.webView);

        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }

        webView.getSettings().setJavaScriptEnabled(true);
        webView.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
                String url = request.getUrl().toString();
                // 只允许局域网 IP 访问，其余外部链接统统静默拦截
                if (url.startsWith("http://192.168.1.32:8080")) {
                    return false;
                }
                return true;
            }
        });
        webView.loadUrl("http://192.168.1.32:8080");
    }
}

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

        // 直接动态创建一个 WebView，不需要找布局文件了
        WebView webView = new WebView(this);
        setContentView(webView);

        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }

        webView.getSettings().setJavaScriptEnabled(true);
        webView.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
                String url = request.getUrl().toString();
                if (url.startsWith("http://192.168.1.32:8080")) {
                    return false;
                }
                return true;
            }
        });
        webView.loadUrl("http://192.168.1.32:8080");
    }
}

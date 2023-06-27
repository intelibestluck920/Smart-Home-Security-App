package com.example.admin.loginsignupapp;



        import android.graphics.Bitmap;
        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.webkit.WebView;
        import android.webkit.WebViewClient;

public class WebMainActivity extends AppCompatActivity {

    private WebView webView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_web);

        webView = (WebView) findViewById(R.id.webView);
        webView.setWebViewClient(new myWebClient());
        webView.getSettings().setJavaScriptEnabled(true);
        webView.loadUrl("http://192.168.4.1");

    }

    public class myWebClient extends WebViewClient
    {
        @Override
        public void onPageStarted(WebView view, String url, Bitmap favicon) {
            super.onPageStarted(view, url, favicon);
        }

        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {

            view.loadUrl(url);
            return true;

        }
    }

    @Override
    // This method is used to detect back button
    public void onBackPressed() {
        if(webView.canGoBack()) {
            webView.goBack();
        } else {
            // Let the system handle the back button
            super.onBackPressed();
        }
    }
}
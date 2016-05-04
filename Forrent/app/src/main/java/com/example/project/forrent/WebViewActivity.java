package com.example.project.forrent;

/**
 * Created by Rex M Henzie on 5/4/2016.
 * Credit due: Chris Scaffidi Webview Tutorial
 */

import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ViewGroup;
import android.view.Window;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.FrameLayout;
import android.view.ViewGroup.LayoutParams;
import android.webkit.WebViewClient;

public class WebViewActivity extends AppCompatActivity {

    private WebView webView;
    private FrameLayout layout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        layout = new FrameLayout(this);
        setContentView(layout);
        initUI(savedInstanceState);
    }

    private void initUI(Bundle savedInstanceState) {
        boolean bInitWebview = webView == null;
        if (bInitWebview) {
            webView = new WebView(this);
            webView.setLayoutParams(new ViewGroup.LayoutParams(
                    LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT));
            webView.getSettings().setSupportZoom(true);
            webView.getSettings().setBuiltInZoomControls(true);
            webView.setScrollBarStyle(WebView.SCROLLBARS_OUTSIDE_OVERLAY);
            webView.setScrollbarFadingEnabled(true);
            webView.getSettings().setLoadsImagesAutomatically(true);
            webView.getSettings().setJavaScriptEnabled(true);
            webView.getSettings().setDomStorageEnabled(true);
            webView.setWebChromeClient(new WebChromeClient());
            webView.setWebViewClient(new ExternalLinkWebViewClient());
            String website = getIntent().getStringExtra("link");
            webView.loadUrl(website);
        } else {
            if (savedInstanceState != null)
                webView.restoreState(savedInstanceState);
        }

        layout.addView(webView);
    }

    public class ExternalLinkWebViewClient extends WebViewClient {

        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            // if we wanted to, we could filter out the links that should be handled internally
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
            view.getContext().startActivity(intent);
            return true;
        }
    }

}
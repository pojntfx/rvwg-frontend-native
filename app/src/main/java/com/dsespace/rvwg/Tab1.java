package com.dsespace.rvwg;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.customtabs.CustomTabsClient;
import android.support.customtabs.CustomTabsIntent;
import android.support.customtabs.CustomTabsServiceConnection;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

import static android.R.attr.duration;

/**
 * Created by Felix Pojtinger on 20.05.2017.
 */

public class Tab1 extends Fragment {
    private static WebView WebView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.tab1, container, false);

        //load WebView
        WebView WebView = (WebView) view.findViewById(R.id.webview_news);
        WebView.loadUrl("http://www.hp.rvwg-web.de/webviews/neuigkeiten/");

        //make opening links inside the webview possible
        //WebView.setWebViewClient(new WebViewClient());

        /** WIP: Open Links in Chrome Custom Tab
         * WebView.setWebViewClient(new WebViewClient() {
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                if (url != null && url.startsWith("http://")) {

                    return true;
                } else {
                    return false;
                }
            }
        }); **/

        //make it possible to run JavaScript
        WebSettings webSettings = WebView.getSettings();
        webSettings.setJavaScriptEnabled(true);

        //clear cache to prevent the webview from not getting the newest content
        WebView.clearCache(true);

        //Display WebView
        return view;
    }
}